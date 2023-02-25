package java.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int step = 1;
    public static void main(String[] args) {
	    System.out.println("Добрый день! Введите одну из следующих команд:");
        help();

        boolean isCommand = false;
        String line;
        Commands command;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                line = reader.readLine();
                command = Commands.getCommand(line);
                isCommand = command.ordinal() < 5;
            } while (!isCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void help() {
        for (Commands c : Commands.values()) {
            if (c.isAvailable(step)) {
                System.out.println(c.getName() + " - " + c.getDescription());
            }
        }
    }
}
