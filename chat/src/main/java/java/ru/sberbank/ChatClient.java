package java.ru.sberbank;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("95.29.239.177", 8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String input = "";

            do {
                input = scanner.nextLine();
                dos.writeUTF(input);
                dos.flush();

            } while (!"end!".equals(input));

            dos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
