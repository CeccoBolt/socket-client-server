import java.io.*;
import java.net.*;
import java.util.Scanner;

public class IntServer {
    public static void main(String[] args) {
        // Crea il server
        try {
            ServerSocket ss = new ServerSocket(11200);
            while (true) {
                // Accetta connessioni dal client
                Socket s = ss.accept();
                // Leggere i dati passati
                // System.out.println("Server: " + s.getInputStream().read());

                DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
                // read the message from the socket
                String msg = dataInputStream.readUTF();

                System.out.println(msg);
                //Scanner sc = new Scanner(System.in);
                //DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
                //do {
                    // dataOutputStream.writeUTF(sc.nextLine());
                    s.getOutputStream().write(12);
                //} while (true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
