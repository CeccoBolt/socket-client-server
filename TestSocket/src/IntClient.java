import java.io.*;
import java.net.*;

public class IntClient {
    public static void main(String[] args) {
        // Crea connessione con server
        // try {
        // Socket s = new Socket("localhost", 9999);
        // s.getOutputStream().write(0);

        // s.close();
        // } catch (UnknownHostException uhe) {
        // uhe.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        try {
            Socket s = new Socket("79.52.11.132", 6666);
            // Invia il numero
            System.out.println("DS");
            s.getOutputStream().write((int) (Math.random() * 10));
            s.close();
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
