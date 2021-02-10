package file.operations;

import book.info.Book;
import utils.ConstantValues;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class LibraryOperations {

    public static HashMap<String, Book> readLibrary() throws IOException {

        if (!ConstantValues.DIR_LIBRARY.exists()) {
            ConstantValues.DIR_LIBRARY.mkdirs();
        }

        HashMap<String, Book> h = new HashMap<>();

        for (String x : Objects.requireNonNull(new File(String.valueOf(ConstantValues.DIR_LIBRARY)).list())) {

            Book b = new Book();

            BufferedReader bufferreader =
                    new BufferedReader(new FileReader(ConstantValues.DIR_LIBRARY.toString() + "\\" + x));
            b.setIsbn(bufferreader.readLine());
            b.setTitle(bufferreader.readLine());
            b.setAuthor(bufferreader.readLine());
            b.setResume(bufferreader.readLine());
            b.setRating(Double.parseDouble(bufferreader.readLine()) / Double.parseDouble(bufferreader.readLine()));

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
                FileWriter myWriter = new FileWriter(tmp.getPath());
                myWriter.write(isbn + "\n");
                myWriter.write(books.get(isbn).getTitle() + "\n");
                myWriter.write(books.get(isbn).getAuthor() + "\n");
                myWriter.write(books.get(isbn).getResume() + "\n");
                myWriter.write(books.get(isbn).getRating().split("\\|")[0] + "\n");
                myWriter.write(books.get(isbn).getRating().split("\\|")[1]);
                myWriter.close();
            }
            else {
                FileWriter myWriter = new FileWriter(tmp.getPath());
                myWriter.write(isbn + "\n");
                myWriter.write(books.get(isbn).getTitle() + "\n");
                myWriter.write(books.get(isbn).getAuthor() + "\n");
                myWriter.write(books.get(isbn).getResume() + "\n");
                myWriter.write(books.get(isbn).getRating().split("\\|")[0] + "\n");
                myWriter.write(books.get(isbn).getRating().split("\\|")[1]);
                myWriter.close();
            }
        }

    }

}
