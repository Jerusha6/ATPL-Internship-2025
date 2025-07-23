import java.sql.*;
import java.util.Scanner;

class SqlInjectionPrevention {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE admin_jerusha (user_name VARCHAR(50), password VARCHAR(50))");
            stmt.execute("INSERT INTO admin_jerusha VALUES ('admin', 'admin123')");

            // Take input from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String inputUser = scanner.nextLine();

            System.out.print("Enter password: ");
            String inputPass = scanner.nextLine();

            System.out.println("\nUsing Statement (Unsafe):");
            loginWithStatement(conn, inputUser, inputPass);

            System.out.println("\nUsing PreparedStatement (Safe):");
            loginWithPreparedStatement(conn, inputUser, inputPass);
            conn.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("error "+e.getMessage());
        }
    }
    // Vulnerable login using Statement
    public static void loginWithStatement(Connection conn, String username, String password) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM admin_jerusha WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Executing query: " + query);
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            System.out.println("Login successful (via Statement)");
        } else {
            System.out.println("Login failed (via Statement)");
        }
        rs.close();
    }

    // Secure login using PreparedStatement
    public static void loginWithPreparedStatement(Connection conn, String username, String password) throws SQLException {
        String query = "SELECT * FROM admin_jerusha WHERE username = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("Login successful (via PreparedStatement)");
        } else {
            System.out.println("Login failed (via PreparedStatement)");
        }
        rs.close();
    }
}
