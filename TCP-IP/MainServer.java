import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
  public static void main(String[] args) {
    MultiServer s = new MultiServer();
    s.start();
  }
}