import book_info.Book;
import book_info.BookUtils;
import file_operations.CreateWriteRead;
import manage_input.*;
import menu.UserMenuOptions;
import utils.ConstantValues;

import java.io.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException {

        NameAndPassword userPass = new NameAndPassword();

        //Set the user name if it is valid
        userPass.setName();
        //Set the password if it is valid
        userPass.setPassword();

        //If user exists then check if password is correct, else create a new user.
        if (CreateWriteRead.userExists(userPass.getName())) {
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
            CreateWriteRead.CreateUserFile(userPass.getName(), userPass.getPassword());
        }

        //Load current library
        ArrayList<Book> books = new ArrayList<>();


        UserMenuOptions.mainMenu();

        byte num = ConstantValues.sc.nextByte();

        switch (num){
            case 1:
                BookUtils.addBook(books);
                break;
            case 2:
                System.out.println("You pressed 2");
                break;
            default:
                System.out.println("Please enter valid number");
        }

        BookUtils.addBook(books);

        BookUtils.rateBook(books);
        BookUtils.listAllBooks(books);
        BookUtils.rateBook(books);
        BookUtils.listAllBooks(books);
        BookUtils.rateBook(books);
        BookUtils.listAllBooks(books);

    }
}
