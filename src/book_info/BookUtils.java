package book_info;

import utils.ConstantValues;

import java.util.ArrayList;

public class BookUtils {

    public static void addBook(ArrayList<Book> books){

        Book x = new Book();

        System.out.println("Please enter ISBN");
        int isbn = ConstantValues.sc.nextInt();
        ConstantValues.sc.nextLine();
        x.setIsbn(isbn);

        System.out.println("Please enter name");
        String name = ConstantValues.sc.nextLine();
        x.setTitle(name);

        System.out.println("Please enter resume");
        String resume = ConstantValues.sc.nextLine();
        x.setResume(resume);

        System.out.println("Please enter author");
        String author = ConstantValues.sc.nextLine();
        x.setAuthor(author);

        books.add(x);
        System.out.println("The following book has been added successfully.");
        System.out.printf("ISBN: %s%n", x.getIsbn());
        System.out.printf("Title: %s%n", x.getTitle());
        System.out.printf("Author: %s%n", x.getAuthor());
        System.out.printf("Resume: %s%n", x.getResume());

    }

    public static void listAllBooks(ArrayList<Book> books){

        for (Book book: books) {
            System.out.println(book);
        }

    }

    public static void rateBook(ArrayList<Book> books){
        System.out.println("Please enter ISBN number:");
        int bookisbn = ConstantValues.sc.nextInt();
        for (int i = 0; i < books.size(); i++){
            if(books.get(i).getIsbn() == bookisbn){
                System.out.println("Please enter the rating from 1 to 5:");
                int currentVote = ConstantValues.sc.nextInt();
                books.get(i).setRating(currentVote);
                break;
            }
            else if (i==books.size()-1){
                 System.out.println("Book not found!");
            }
        }
    }

}
