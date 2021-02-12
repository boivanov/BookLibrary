package book.info;

import utils.ConstantValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class BookUtils {

    public static void addBook(HashMap<String, Book> books) {

        Book x = new Book();

        System.out.println("Please enter the ISBN:");
        String isbn = ConstantValues.SC.nextLine();
        x.setIsbn(isbn);

        System.out.println("Please enter the title:");
        String name = ConstantValues.SC.nextLine();
        x.setTitle(name);

        System.out.println("Please enter the author:");
        String author = ConstantValues.SC.nextLine();
        x.setAuthor(author);

        System.out.println("Please enter the resume:");
        String resume = ConstantValues.SC.nextLine();
        x.setResume(resume);

        books.put(isbn, x);
        System.out.println("The following book has been added successfully.");
        System.out.printf("ISBN: %s%n", x.getIsbn());
        System.out.printf("Title: %s%n", x.getTitle());
        System.out.printf("Author: %s%n", x.getAuthor());
        System.out.printf("Resume: %s%n", x.getResume());

    }

    public static void listAllBooks(HashMap<String, Book> books) {

        System.out.println("The following books are in the library:\n");

        for (Book book : books.values()) {
            System.out.println(book);
        }

    }

    public static void rateBook(HashMap<String, Book> books, String user) {
        System.out.println("Please enter ISBN number of the book you want to rate:");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {

            if (books.get(bookisbn).getVoters().contains(user)) {
                System.out.println("You have already voted!");
                return;
            }

            int currentVote;
            while (true) {
                System.out.println("Please enter the rating from 1 to 5:");
                currentVote = ConstantValues.SC.nextInt();
                if (!Pattern.matches("[0-9]", Integer.toString(currentVote))) {
                    System.out.println("Invalid number!");
                } else {
                    break;
                }
            }

            Book b = books.get(bookisbn);
            b.setRating(currentVote);
            b.addVoter(user);
            System.out.println("You have successfully rated the book.");
        } else {
            System.out.println("Book doesn't exist!");
        }
    }

    public static void writeReview(HashMap<String, Book> books) {
        System.out.println("Please enter ISBN number of the book you want to write a resume to:");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {
            System.out.println("asd");
        } else {
            System.out.println("Book doesn't exist!");
        }
    }

    public static void addToFavorites(HashMap<String, Book> books, String user) {

        System.out.println("Please enter ISBN number of the book you want to add to favorites:");
        String bookisbn = ConstantValues.SC.nextLine();

        byte count = 0;
        for (Book a : books.values()){
            if(a.getFavorites().contains(user)){
                count++;
            }
        }
        if (count >= 10){
            System.out.println("You already have 10 favorite books.");
            return;
        }

        if (books.containsKey(bookisbn)) {

            if (Arrays.asList(books.get(bookisbn).getFavorites().split(",")).contains(user)){
                System.out.println("This book is already in your favorites!");
                return;
            }

            Book b = books.get(bookisbn);
            b.addFavorite(user);
            System.out.println("You have successfully added the book to your favorites.");

        } else {
            System.out.println("Book doesn't exist!");
        }
    }
}
