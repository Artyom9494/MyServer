package SerJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    String [] citi = {"Краснодар", "Москва", "Тверь", "Казань", "Резань", "Уфа", "Питер", "Грозный"};

    public void goMyServer() {
        try (ServerSocket serSocket = new ServerSocket(5001)) {
            System.out.print("START SERVER");

            while (true) {
                Socket sock = serSocket.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                writer.println("Hello bro");

                String rCiti = randomCiti();
                writer.println(rCiti);

                int temp = tempRandom();
                writer.println(temp);

                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    private String randomCiti() {
        int random = (int) (Math.random() * citi.length);
        return citi [random];
    }
    private int tempRandom() {
        int t = (int) (Math.random() * 10 - 1);
        return t;
    }
}
