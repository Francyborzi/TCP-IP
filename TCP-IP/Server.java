
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

public class Server {

  private ServerSocket server = null;
  private Socket client = null;
  private int porta;

  public Server(int porta) {
    try {
      this.porta = porta;
      server = new ServerSocket(porta);
      System.out.println("S1 - Il server è in ascolto sulla porta " + porta);
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.err.println("Errore nella fase di apertura e ascolto");
    }
  }

  public Socket attendi() {
    try {
      client = server.accept();
      System.out.println("S2 - Connessione stabilita con il client");
    } catch (IOException e) {
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