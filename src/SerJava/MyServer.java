package SerJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public void goMyServer() {
        try (ServerSocket serSocket = new ServerSocket(5001)) {
            System.out.print("START SERVER");

            while (true) {
                Socket sock = serSocket.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                writer.println("Hello bro");
                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
