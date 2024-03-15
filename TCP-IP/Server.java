
// import static org.junit.jupiter.api.Assertions.assertEquals;
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

  }

  public void leggi() {

  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}