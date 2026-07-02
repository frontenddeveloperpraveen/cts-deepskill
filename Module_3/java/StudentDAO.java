import java.sql.*;

public class StudentDAO {

  public void insertStudent(String name, String email) throws SQLException {
    String sql = "INSERT INTO Users (full_name, email, city, registration_date) VALUES (?, ?, ?, CURDATE())";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/community_portal", "root", "password");
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, name);
      ps.setString(2, email);
      ps.setString(3, "Unknown");
      ps.executeUpdate();
      System.out.println("Student inserted.");
    }
  }

  public void updateStudentEmail(int id, String newEmail) throws SQLException {
    String sql = "UPDATE Users SET email = ? WHERE user_id = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/community_portal", "root", "password");
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, newEmail);
      ps.setInt(2, id);
      int rows = ps.executeUpdate();
      System.out.println(rows + " row(s) updated.");
    }
  }

  public static void main(String[] args) throws SQLException {
    StudentDAO dao = new StudentDAO();
    dao.insertStudent("Test User", "test@example.com");
    dao.updateStudentEmail(1, "updated@example.com");
  }
}
