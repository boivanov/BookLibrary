package book.info;

import utils.ConstantValues;

import java.util.HashMap;
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

    public static void rateBook(HashMap<String, Book> books) {
        System.out.println("Please enter ISBN number of the book you want to rate:");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {

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
        } else {
            System.out.println("Book doesn't exist!");
        }
    }

    public static void writeResume(HashMap<String, Book> books) {
        System.out.println("Please enter ISBN number of the book you want to write a resume to:");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {
            System.out.println("asd");
        } else {
            System.out.println("Book doesn't exist!");
        }
    }
}
