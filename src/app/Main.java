package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int step = 1;
    static Commands command;
    public static void main(String[] args) {


	    System.out.println("������ ����! ������� ���� �� ��������� ������:");
        help();
        //host or client
        printCommand();
        /*
            ����� ����� ����������� ���� �������.
            ��� ����� ����������� ����� becomeHost � ������� ����������� ������.
            ��� ������� ����������� ����� becomePlayer � ��������� ����� �� �����: ��������������� ����� ���� �������.
        */
        //connect
        printCommand();
        //play
        while (command != Commands.END) {
            printCommand();
        }
        System.out.println("���� ���������!");
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
                    System.out.println("����������� �������!");
                    System.out.println("������� ���� �� ��������� ������:");
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
