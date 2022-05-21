package java.ru.sberbank;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            do {
                Socket accepted = serverSocket.accept();

                DataInputStream dis = new DataInputStream(accepted.getInputStream());
                String input = "";

                do {
                    input = dis.readUTF();
                    System.out.println(input);
                } while (!"end!".equals(input));

                dis.close();
                accepted.close();

                String cmd = "";
                if (cmd.equals("exit")) break;

            } while (true);
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
