
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.ConnectException;
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
    try {
      OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
      out.write("Ciao server" + "\n");
      out.flush();
      System.out.println("Messaggio inviato al server");
    } catch (IOException e) {
      System.err.println("Errore durante l'invio del messaggio al server: " + e.getMessage());
    }
  }

  public void leggi() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      String message = in.readLine();
      System.out.println("Messaggio ricevuto dal server: " + message);
    } catch (IOException e) {
      System.err.println("Errore durante la lettura del messaggio dal server: " + e.getMessage());
    }
  }

  public void chiudi() {
    try {
      s.close();
      System.out.println("Connessione chiusa con successo");
    } catch (IOException e) {
      System.err.println("Errore durante la chiusura della connessione: " + e.getMessage());
    }
  }
}