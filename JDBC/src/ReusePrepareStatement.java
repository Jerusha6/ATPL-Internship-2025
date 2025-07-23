import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

class ReusePrepareStatement {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query1 = "Select * from users_jerusha";
        String query2 = "Select * from products_jerusha";
        try{

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            //          Executing query1
            ResultSet rs = stmt.executeQuery(query1);
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getString(3)+" ");
                System.out.print(rs.getInt(4)+" ");
                System.out.println();
            }

            System.out.println();

            //          Reusing preparedStatement and Executing query2
            rs = stmt.executeQuery(query2);
            while(rs.next()){
                System.out.print(rs.getString(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getDate(3)+" ");
                System.out.print(rs.getDouble(4)+" ");
                System.out.println();
            }

            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("error "+e.getMessage());
        }
    }
}
