package NameAndPassword;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NameAndPassword {

    private String name;
    private String password;
    Scanner sc = new Scanner(System.in);

    boolean validateNameOrPass(String name) {
        return name.length() < 4 || name.length() > 8 || !Pattern.matches("[a-zA-Z0-9]+", name);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        //Read user name and check if it is valid, if not, reread.
        while (true) {
            System.out.println("Please enter user name:");
            String a = sc.nextLine();
            if (validateNameOrPass(a)) {
                System.out.println("User name should be between 4-8 symbols long, having letters or numbers only.");
            } else {
                this.name = a;
                break;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        //Read password and check if it is valid, if not, reread.
        while (true) {
            System.out.println("Please enter password:");
            String b = sc.nextLine();
            if (validateNameOrPass(b)) {
                System.out.println("Password should be between 4-8 symbols long, having letters or numbers only.");
            } else {
                this.password = b;
                break;
            }
        }
    }
}
