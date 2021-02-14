package utils;

import java.io.IOException;

public class ConsoleOperations {
    public static void clearConsole() {

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ignored) {
        }

    }
}
