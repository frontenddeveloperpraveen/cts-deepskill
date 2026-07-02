import java.io.*;
import java.net.*;

public class TCPClient {
  public static void main(String[] args) throws IOException {
    Socket s = new Socket("localhost", 6789);
    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    System.out.println("Server says: " + in.readLine());
    out.println("Hello from client!");
    s.close();
  }
}
