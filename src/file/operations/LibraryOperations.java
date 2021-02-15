package file.operations;

import book.info.Book;
import utils.ConstantValues;

import java.io.*;
import java.util.*;

public class LibraryOperations {

    public static HashMap<String, Book> readLibrary() throws IOException {

        if (!ConstantValues.DIR_LIBRARY.exists()) {
            ConstantValues.DIR_LIBRARY.mkdirs();
        }

        HashMap<String, Book> h = new HashMap<>();

        for (String x : Objects.requireNonNull(new File(String.valueOf(ConstantValues.DIR_LIBRARY)).list())) {

            Book b = new Book();
            double sumVotes;
            double numVoters;

            BufferedReader bufferreader =
                    new BufferedReader(new FileReader(ConstantValues.DIR_LIBRARY.toString() + "\\" + x));
            b.setIsbn(bufferreader.readLine());
            b.setTitle(bufferreader.readLine());
            b.setAuthor(bufferreader.readLine());
            b.setResume(bufferreader.readLine());
            sumVotes = Double.parseDouble(bufferreader.readLine());
            numVoters = Double.parseDouble(bufferreader.readLine());
            if (sumVotes == 0 || numVoters == 0) {
                b.setRating(0.00);
            } else {
                b.setRating(sumVotes / numVoters);
            }
            b.setVoters(new HashSet<>(Arrays.asList(bufferreader.readLine().split(","))));
            b.setFavorites(new HashSet<>(Arrays.asList(bufferreader.readLine().split(","))));
            b.setPersonal(new HashSet<>(Arrays.asList(bufferreader.readLine().split(","))));
            b.setOwner(bufferreader.readLine());
            b.setReviews(new HashSet<>(Arrays.asList(bufferreader.readLine().split("\0"))));

            h.put(b.getIsbn(), b);
        }

        return h;

    }

    public static void writeLibrary(HashMap<String, Book> books) throws IOException {

        if (!ConstantValues.DIR_LIBRARY.exists()) {
            ConstantValues.DIR_LIBRARY.mkdirs();
        }

        for (String isbn : books.keySet()) {
            File tmp = new File(ConstantValues.DIR_LIBRARY, String.format("%s.txt", isbn));

            if (!tmp.exists()) {
                tmp.createNewFile();
            }

            FileWriter myWriter = new FileWriter(tmp.getPath());
            myWriter.write(isbn + "\n");
            myWriter.write(books.get(isbn).getTitle() + "\n");
            myWriter.write(books.get(isbn).getAuthor() + "\n");
            myWriter.write(books.get(isbn).getResume() + "\n");
            myWriter.write(books.get(isbn).getRating().split("\\|")[0] + "\n");
            myWriter.write(books.get(isbn).getRating().split("\\|")[1] + "\n");
            if (books.get(isbn).getVoters().isEmpty()) {
                myWriter.write(" " + "\n");
            } else {
                myWriter.write(String.join(",", books.get(isbn).getVoters()) + "\n");
            }
            if (books.get(isbn).getFavorites().isEmpty()) {
                myWriter.write(" " + "\n");
            } else {
                myWriter.write(String.join(",", books.get(isbn).getFavorites()) + "\n");
            }
            if (books.get(isbn).getPersonal().isEmpty()) {
                myWriter.write(" " + "\n");
            } else {
                myWriter.write(String.join(",", books.get(isbn).getPersonal()) + "\n");
            }
            myWriter.write(books.get(isbn).getOwner() + "\n");
            if (books.get(isbn).getReviews().isEmpty()) {
                myWriter.write(" " + "\n");
            } else {
                myWriter.write(String.join("\0", books.get(isbn).getReviews()) + "\n");
            }
            myWriter.close();
        }

    }

}
