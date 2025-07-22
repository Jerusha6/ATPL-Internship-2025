import java.sql.*;

public class DynamicRangeQuery {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";
        String query = "Select * from products_jerusha where product_id = ?; ";

        try{
            Connection conn = DriverManager.getConnection(url, username, password);


            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,"P102");
           // preparedStatement.setDouble(2,5000);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getDate(3)+" ");
                System.out.print(rs.getDouble(4)+" ");
                System.out.println();
            }
            conn.close();
            preparedStatement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error "+e.getMessage());
        }
    }
}
