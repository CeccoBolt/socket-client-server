import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        int porta = 7777;
        String host = "10.205.16.85";
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        try (Socket s = new Socket(host, porta)) {
            System.out.println("d");
            // Creazione reader per leggere il flusso in ingresso
            InputStream i = s.getInputStream();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            System.out.print("Inserisci messaggio: ");
            String msg = "0";
            System.out.println("inserisci 0 per uscire, altro per inviare il messaggio");
            do {
                msg = sc.next();
                dos.writeUTF(msg != "0" ? msg : "n/a");
            } while (msg != "0");

            // Inizio lettura del testo in input (usando il buffered reader)
            String stringa;
            while ((stringa = br.readLine()) != null) {
                System.out.println("---------------");
                System.out.println(stringa);
            }
            dos.flush(); // send the message
            dos.close(); // close the output stream when we're done.
            // s.close();
        } catch (IOException e) {
            System.out.println("Errore I/O: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}