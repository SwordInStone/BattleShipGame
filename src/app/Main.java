package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int step = 1;
    static Commands command;
    public static void main(String[] args) {


	    System.out.println("Добрый день! Введите одну из следующих команд:");
        help();
        //host or client
        printCommand();
        /*
            Здесь будет подключение двух игроков.
            Для хоста запускается метод becomeHost и ожидает подключение игрока.
            Для клиента запускается метод becomePlayer и ожидается ответ от хоста: сгенерированные доски двух игроков.
        */
        //connect
        printCommand();
        //play
        while (command != Commands.END) {
            printCommand();
        }
        System.out.println("Игра завершена!");
    }

    private static void help() {
        for (Commands c : Commands.values()) {
            if (c.isAvailable(step)) {
                System.out.println(c.getName() + " - " + c.getDescription());
            }
        }
    }

    private static void printCommand() {
        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            boolean isCommand;
            do {
                line = reader.readLine();
                command = Commands.getCommand(line);
                isCommand = command != Commands.UNKNOWN;
                if (!isCommand) {
                    System.out.println("Неизвестная команда!");
                    System.out.println("Введите одну из следующих команд:");
                    help();
                }
            } while (!isCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
