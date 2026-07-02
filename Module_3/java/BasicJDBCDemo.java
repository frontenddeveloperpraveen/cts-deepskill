import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCDemo {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/community_portal";
    String user = "root";
    String pass = "password";
    try (Connection conn = DriverManager.getConnection(url, user, pass);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Users")) {
      while (rs.next()) {
        System.out.println(rs.getInt("user_id") + " - " + rs.getString("full_name"));
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
