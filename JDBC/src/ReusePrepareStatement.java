import java.sql.*;

class ReusePrepareStatement {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query1 = "Select * from users_jerusha where user_name = ?";
        String query2 = "Select * from products_jerusha where product_id = ?";
        try{

            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query1);
            //Executing query1
            preparedStatement.setString(1, "jerusha");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getString(3)+" ");
                System.out.print(rs.getInt(4)+" ");
                System.out.println();
            }


            System.out.println();

            //Reusing preparedStatement and Executing query2
            preparedStatement = conn.prepareStatement(query2);
            preparedStatement.setString(1, "p101");
            rs = preparedStatement.executeQuery();
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
            System.out.println("error "+e.getMessage());
        }
    }
}
