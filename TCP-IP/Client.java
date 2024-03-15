
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
// import org.junit.jupiter.api.Test;
import java.net.UnknownHostException;

public class Client {
  private String nome;
  private String colore;
  private Socket s;

  public Client(String nome, String colore) {
    this.nome = nome;
    this.colore = colore;
  }

  public void connetti(String nomeServer, int portaServer) {
    try {
      s = new Socket(nomeServer, portaServer);
      System.out.println("C1 - Connessione avvenuta con il server");
    } catch (ConnectException co) {
      System.err.println(co.getMessage());
      System.err.println("Server non disponibile");
    } catch (UnknownHostException oh) {
      System.err.println(oh.getMessage());
      System.err.println("Errore DNS");
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.err.println("Errore nella fase di connessione con il server");
    }
  }

  public void scrivi() {
  }

  public void leggi() {
  }

  public void chiudi() {
  }
}