package MyClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Myclient {
    public void goMyClient() {
        try (Socket clienrSocket = new Socket("127.0.0.1", 5001)) {
            System.out.println("START CLIENT");

            InputStreamReader streamReader = new InputStreamReader(clienrSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String message = reader.readLine();
            System.out.println("Мы тебя ждали, " + message);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}
