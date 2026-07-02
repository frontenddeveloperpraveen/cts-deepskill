import java.io.*;
import java.net.*;

public class TCPServer {
  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(6789);
    System.out.println("Server listening on port 6789...");
    Socket s = ss.accept();
    System.out.println("Client connected.");
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    out.println("Hello from server!");
    System.out.println("Client says: " + in.readLine());
    s.close();
    ss.close();
  }
}
