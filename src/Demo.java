import book.info.Book;
import book.info.BookUtils;
import file.operations.*;
import manage.input.*;
import menu.UserMenuOptions;
import utils.ConsoleOperations;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args){

        byte choice;

        choice = UserMenuOptions.logInMenu();

        NameAndPassword userPass = new NameAndPassword();

        //Set the user name and password if they are valid
        userPass.setName();
        userPass.setPassword();

        byte cnt;
        switch (choice) {
            case 1:
                cnt = 3;
                while (true) {
                    cnt--;
                    try {
                        if (UserOperations.userExists(userPass.getName())
                                && NameAndPassword.validatePassword(userPass.getName(), userPass.getPassword())) {
                            ConsoleOperations.clearConsole();
                            System.out.printf("Hello, %s! You have successfully logged in.", userPass.getName());
                            System.out.println("");
                            break;
                        } else {
                            if (cnt == 0) {
                                ConsoleOperations.clearConsole();
                                System.out.println("Please try again later!");
                                System.exit(0);
                            }
                            System.out.println("User name or password is incorrect, please try again!");
                            System.out.println(cnt + " retries left.");
                            userPass.setName();
                            userPass.setPassword();
                        }
                    } catch (IOException e) {
                        System.out.println("Something went wrong!");
                    }
                }
                break;
            case 2:
                while (true) {
                    if (UserOperations.userExists(userPass.getName())) {
                        System.out.println("User name is already taken.");
                        userPass.setName();
                        userPass.setPassword();
                    } else {
                        try {
                            UserOperations.createUserFile(userPass.getName(), userPass.getPassword());
                        } catch (IOException e) {
                            System.out.println("Something went wrong!");
                        }
                        System.out.println("You registration has been successful.\n");
                        break;
                    }
                }

                break;
            default:
                System.out.println("");
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong!");
        }

        //Load current library
        HashMap<String, Book> books = null;
        try {
            books = LibraryOperations.readLibrary();
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            System.out.println("Exiting the library...");
            System.exit(0);
        }

        main_loop:
        while (true) {

            choice = UserMenuOptions.mainMenu();

            switch (choice) {
                case 0:
                    ConsoleOperations.clearConsole();
                    System.out.println("\n Thank you for using the library, " + userPass.getName() + " :)");
                    break main_loop;
                case 1:
                    BookUtils.addBook(books, userPass.getName());
                    if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                        break main_loop;
                    }
                    break;
                case 2:
                    System.out.println("You are now in the reviews menu");

                    review_loop:
                    while (true) {

                        choice = UserMenuOptions.reviewMenu();

                        switch (choice) {
                            case 0:
                                break review_loop;
                            case 1:
                                BookUtils.listReviews(books);
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 2:
                                BookUtils.writeReview(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            default:
                                System.out.println("Please enter valid number.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("You are now in the edit book menu.");

                    edit_loop:
                    while (true) {

                        choice = UserMenuOptions.editMenu();

                        switch (choice) {
                            case 0:
                                break edit_loop;
                            case 1:
                                BookUtils.editBook(books, userPass.getName(), (byte) 1);
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 2:
                                BookUtils.editBook(books, userPass.getName(), (byte) 2);
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            default:
                                System.out.println("Please enter valid number.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("You are now in the favorites menu.");

                    favorites_loop:
                    while (true) {

                        choice = UserMenuOptions.favoritesMenu();

                        switch (choice) {
                            case 0:
                                break favorites_loop;
                            case 1:
                                BookUtils.showFavorites(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 2:
                                BookUtils.addToFavorites(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 3:
                                BookUtils.removeBookFavorites(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            default:
                                System.out.println("Please enter valid number.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("You are now in the personal menu.");

                    personal_loop:
                    while (true) {
                        choice = UserMenuOptions.personalMenu();

                        switch (choice) {
                            case 0:
                                break personal_loop;
                            case 1:
                                BookUtils.showPersonal(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 2:
                                BookUtils.addToPersonal(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            case 3:
                                BookUtils.removeBookPersonal(books, userPass.getName());
                                if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                                    break main_loop;
                                }
                                break;
                            default:
                                System.out.println("Please enter valid number.");
                        }
                    }
                    break;
                case 6:
                    BookUtils.rateBook(books, userPass.getName());
                    if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                        break main_loop;
                    }
                    break;
                case 7:
                    BookUtils.listAllBooks(books);
                    if (!UserMenuOptions.wouldYouContinue(userPass.getName())) {
                        break main_loop;
                    }
                    break;
                default:
                    System.out.println("Please enter valid number");
            }
        }

        //Write the current state of the library.
        try {
            LibraryOperations.writeLibrary(books);
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }


    }
}
