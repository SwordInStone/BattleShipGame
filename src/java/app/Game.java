package java.app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Game {
/*
    class Main - класс на котором мы будем запускать приложение
    class Desk - описана логика прорисовки доски
    class Ship - описана логика взаимодействия с кораблем: узнать состояние, изменить состояние
    class Game - описана логика самой игры, правила
    class Multiplayer - описана логика подключения двух игроков к игре.
    class DBConnection - описано подключение к БД
*/
    private class Desk {

    }

    private class Ship {

    }

    private class Multiplayer{
        public void clientSocket() throws IOException {
            Socket socket = new Socket("localhost", 7777);

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);

            String str = scan.nextLine();
            writer.println(str);
            scan.close();
            writer.flush();
        }

        public void serverSocket() throws IOException {
            ServerSocket serverSocket = new ServerSocket( 7777);
            Socket socket = serverSocket.accept();

            System.out.println("Client successfully connected by port "+ socket.getPort());

            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            Scanner scan = new Scanner(System.in);

            String str = scan.nextLine();
            System.out.println("Client wrote " + str);
            scan.close();
        }

    }

    private class DBConnection {

    }

}


