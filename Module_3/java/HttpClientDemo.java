import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo {
  public static void main(String[] args) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder()
      .uri(URI.create("https://api.github.com"))
      .GET()
      .build();
    HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println("Status: " + res.statusCode());
    System.out.println("Body: " + res.body().substring(0, 200) + "...");
  }
}
