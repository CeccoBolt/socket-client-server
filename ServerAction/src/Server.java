import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        final int PORT = 7777;
        try {
            ServerSocket ss = new ServerSocket(PORT);
            System.out.println("In attesa di connessioni...");
            Socket c = ss.accept();
            System.out.println("Connessione stabilita.");
            OutputStream os;
            PrintWriter pw;
            while (true) {
                os = c.getOutputStream();
                pw = new PrintWriter(os);
                DataInputStream dos=new DataInputStream(c.getInputStream());
                String psw=dos.readUTF();
                System.out.println(psw);
                pw.println("password ricevuta");
                pw.close();
                //c.close();
                System.out.println("Connessione chiusa.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
