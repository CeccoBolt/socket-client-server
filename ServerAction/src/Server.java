import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        final int port = 7777;
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("In attesa di connessioni...");
            Socket c = ss.accept();
            System.out.println("Connessione stabilita.");
            OutputStream os;
            PrintWriter pw;
            while (true) {
                os = c.getOutputStream();
                pw = new PrintWriter(os);
                DataInputStream dis = new DataInputStream(c.getInputStream());
                String msg = dis.readUTF();
                System.out.println(msg);
                pw.println("messaggio ricevuto");
                pw.close();
                // c.close();
                System.out.println("Connessione chiusa.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
