import java.sql.*;

public class TransactionDemo {

  public static void transferFunds(int fromId, int toId, double amount) {
    String url = "jdbc:mysql://localhost:3306/community_portal";
    String user = "root";
    String pass = "password";
    String debit = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
    String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
      conn.setAutoCommit(false);
      try (PreparedStatement ps1 = conn.prepareStatement(debit);
           PreparedStatement ps2 = conn.prepareStatement(credit)) {
        ps1.setDouble(1, amount);
        ps1.setInt(2, fromId);
        ps1.executeUpdate();

        ps2.setDouble(1, amount);
        ps2.setInt(2, toId);
        ps2.executeUpdate();

        conn.commit();
        System.out.println("Transfer successful.");
      } catch (SQLException e) {
        conn.rollback();
        System.out.println("Transfer failed. Rolled back.");
      }
    } catch (SQLException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    transferFunds(1, 2, 100.0);
  }
}
