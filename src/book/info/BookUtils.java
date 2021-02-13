package book.info;

import utils.ConstantValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class BookUtils {

    public static void addBook(HashMap<String, Book> books, String user) {

        Book x = new Book();

        System.out.print("Please enter the ISBN: ");
        String isbn = ConstantValues.SC.nextLine();
        if (books.containsKey(isbn)) {
            System.out.println("A book with ISBN: " + isbn + " already exists.");
            return;
        }
        x.setIsbn(isbn);

        System.out.print("Please enter the title: ");
        String name = ConstantValues.SC.nextLine();
        x.setTitle(name);

        System.out.print("Please enter the author: ");
        String author = ConstantValues.SC.nextLine();
        x.setAuthor(author);

        System.out.print("Please enter the resume: ");
        String resume = ConstantValues.SC.nextLine();
        x.setResume(resume);

        x.setOwner(user);

        books.put(isbn, x);
        System.out.println("The following book has been added successfully.");
        System.out.printf("ISBN: %s%n", x.getIsbn());
        System.out.printf("Title: %s%n", x.getTitle());
        System.out.printf("Author: %s%n", x.getAuthor());
        System.out.printf("Resume: %s%n", x.getResume());

    }

    public static void listAllBooks(HashMap<String, Book> books) {

        if (!books.isEmpty()) {

            System.out.println("The following books are in the library:\n");

            for (Book book : books.values()) {
                System.out.println(book);
            }
        } else {
            System.out.println("There are no books in the library.");
        }


    }

    public static void rateBook(HashMap<String, Book> books, String user) {
        System.out.print("Please enter ISBN number of the book you want to rate: ");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {

            if (books.get(bookisbn).getVoters().contains(user)) {
                System.out.println("You have already voted!");
                return;
            }

            String currentVote;
            while (true) {
                System.out.print("Please enter the rating from 1 to 5: ");
                currentVote = ConstantValues.SC.nextLine();
                if (!Pattern.matches("[1-5]", currentVote)) {
                    System.out.print("Invalid number! ");
                } else {
                    break;
                }
            }

            Book b = books.get(bookisbn);
            b.setRating(Double.parseDouble(currentVote));
            b.addVoter(user);
            System.out.println("You have successfully rated the book.");
        } else {
            System.out.println("Book doesn't exist!");
        }
    }

    public static void writeReview(HashMap<String, Book> books) {
        System.out.print("Please enter ISBN number of the book you want to write a resume to: ");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {
            System.out.println("asd");
        } else {
            System.out.println("Book doesn't exist!");
        }
    }

    public static void addToFavorites(HashMap<String, Book> books, String user) {

        byte count = 0;
        for (Book a : books.values()) {
            if (a.getFavorites().contains(user)) {
                count++;
            }
        }
        if (count >= 10) {
            System.out.println("You already have 10 favorite books.");
            return;
        }

        System.out.print("Please enter ISBN number of the book you want to add to favorites: ");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn)) {

            if (books.get(bookisbn).getFavorites().contains(user)) {
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

    public static void showFavorites(HashMap<String, Book> books, String user) {

        ArrayList<Book> arr = new ArrayList<>();

        for (Book a : books.values()) {
            if (a.getFavorites().contains(user)) {
                arr.add(a);
            }
        }

        if (!arr.isEmpty()) {
            for (Book a : arr) {
                System.out.println(a);
            }
        } else {
            System.out.println("You do not have any books in favorites.");
        }
    }

    public static void removeBookFavorites(HashMap<String, Book> books, String user) {
        System.out.print("Please enter ISBN number of the book you want to remove from favorites: ");
        String bookisbn = ConstantValues.SC.nextLine();

        if (books.containsKey(bookisbn) && books.get(bookisbn).getFavorites().contains(user)) {
            books.get(bookisbn).removeFavorite(user);
            System.out.println("The book with ISBN: " + bookisbn + " has been removed from your favorites");
        } else if (books.containsKey(bookisbn)) {
            System.out.println("The book with ISBN: " + bookisbn + " is not in your favorites.");
        } else {
            System.out.println("Book with ISBN: " + bookisbn + " does not exist in the library.");
        }
    }

    public static void editBook(HashMap<String, Book> books, String user, byte choice) {

        System.out.print("Please enter the ISBN of the book you want to edit: ");
        String isbn = ConstantValues.SC.nextLine();

        if (!books.containsKey(isbn)) {
            System.out.println("The book with ISBN: " + isbn + " does not exist!");
        } else if (books.containsKey(isbn) && !books.get(isbn).getOwner().equals(user)) {
            System.out.println("You cannot edit the book with ISBN: " + isbn);
        } else {
            if (choice == 1) {
                System.out.print("Please enter the new author: ");
                String author = ConstantValues.SC.nextLine();

                books.get(isbn).setAuthor(author);
                System.out.print("You have successfully updated the author for book with ISBN: " + isbn);
            } else if (choice == 2) {
                System.out.print("Please enter the new resume: ");
                String resume = ConstantValues.SC.nextLine();

                books.get(isbn).setResume(resume);
                System.out.print("You have successfully updated the resume for book with ISBN: " + isbn);
            }

        }

    }
}
