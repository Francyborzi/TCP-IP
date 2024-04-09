import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @author: Francesco Borzuola
 * @version:   29-02-2024
 */

public class MainClient {
  public static void main(String[] args) {
    Client c = new Client("Francesco", "verde");
    c.connetti("127.0.0.1", 2000);
    c.scrivi();
    c.leggi();
    c.chiudi();
  }
}