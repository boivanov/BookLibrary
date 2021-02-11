import book.info.Book;
import book.info.BookUtils;
import file.operations.*;
import manage.input.*;
import menu.UserMenuOptions;
import utils.ConstantValues;

import java.io.*;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) throws IOException {

        NameAndPassword userPass = new NameAndPassword();

        //Set the user name if it is valid
        userPass.setName();
        //Set the password if it is valid
        userPass.setPassword();

        //If user exists then check if password is correct, else create a new user.
        if (UserOperations.userExists(userPass.getName())) {
            while (true) {
                if (NameAndPassword.validatePassword(userPass.getName(), userPass.getPassword())) {
                    System.out.printf("Hi %s, you have successfully logged in.%n", userPass.getName());
                    break;
                } else {
                    System.out.println("Password incorrect, please try again!");
                    userPass.setPassword();
                }
            }
        } else {
            UserOperations.createUserFile(userPass.getName(), userPass.getPassword());
        }

        //Load current library
        HashMap<String, Book> books = LibraryOperations.readLibrary();

        main_loop:
        while (true) {

            UserMenuOptions.mainMenu();

            byte num = ConstantValues.SC.nextByte();
            ConstantValues.SC.nextLine();

            switch (num) {
                case 0:
                    System.out.println("Thank you for using the library, " + userPass.getName() + " :)");
                    break main_loop;
                case 1:
                    BookUtils.addBook(books);
                    break;
                case 2:
                    System.out.println("You pressed 2");
                    break;
                case 3:
                    System.out.println("You pressed 3");
                    break;
                case 4:
                    System.out.println("You pressed 4");
                    break;
                case 5:
                    BookUtils.rateBook(books, userPass.getName());
                    break;
                case 6:
                    BookUtils.listAllBooks(books);
                    break;
                default:
                    System.out.println("Please enter valid number");
            }
        }

        //Write the current state of the library.
        LibraryOperations.writeLibrary(books);


    }
}
