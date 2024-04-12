import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
  public MultiServer() {}
  public void start(){
    try {
      ServerSocket s1 = new ServerSocket(2000);
      for (int i = 0; i < 10; i++) {
        System.out.println("S1 - Il server è in ascolto");
        Server server = new Server(s1);
        server.start();
        server.attendi();
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.err.println("Errore nella fase di apertura e ascolto");
    }
  }
}