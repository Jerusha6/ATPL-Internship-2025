import java.sql.*;
import java.util.Scanner;

public class SQLInjectionPrevention {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";


        System.out.println("Enter username:");
        String user_name = scanner.nextLine();

        System.out.println("Enter password:");
        String pass = scanner.nextLine();

        String unsafeQuery = "select * from admin_jerusha where user_name  = '"+ user_name+"' and password = '"+ pass+"'";
        String safeQuery = "select * from admin_jerusha where user_name  = ? and password = ?";

        //Executing unsafe query here

        System.out.println("Result of unsafe statement: ");

        try{
            try(Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(unsafeQuery);
                ){
                while(rs.next()){
                    System.out.print(rs.getString(1)+" ");
                    System.out.println(rs.getString(2)+" ");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        //Executing safe query here
        System.out.println("Result of safe statement: ");


        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(safeQuery);
            pstmt.setString(1,user_name);
            pstmt.setString(2,pass);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString(1)+" ");
                System.out.println(rs.getString(2)+" ");
            }
            conn.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
