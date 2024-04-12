
// import static org.junit.jupiter.api.Assertions.assertEquals;
// @Test
// void addition() {
// assertEquals(2, 1 + 1);
// }
import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;
// import org.junit.jupiter.api.Test;

public class Server extends Thread {

  private ServerSocket server = null;
  private Socket client = null;

  public Server(ServerSocket server) {
    this.server = server;
  }

  public synchronized Socket attendi() {
    try {
      client = server.accept();
      System.out.println("S2 - Connessione stabilita con il client");
      leggi();
      scrivi();
      wait(10000);
      System.out.println("S2 - Connessione chiusa con il client");
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.err.println("Errore nella fase di accettazione della connessione con il client");
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
      System.err.println("Errore nella fase di accettazione della connessione con il client");
    }
    return client;
  }

  public void scrivi() {
    try {
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      out.println("Ciao client");
      System.out.println("Messaggio inviato al client");
    } catch (IOException e) {
      System.err.println("Errore durante l'invio del messaggio al client: " + e.getMessage());
    }

  }

  public void leggi() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      String message = in.readLine();
      System.out.println("Messaggio ricevuto dal client: " + message);
    } catch (IOException e) {
      System.err.println("Errore durante la lettura del messaggio dal client: " + e.getMessage());
    }

  }
}