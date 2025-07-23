import java.sql.*;

class DeleteOperation {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = " DELETE FROM products_jerusha where expiry_date<=?; ";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDate(1, Date.valueOf("2025-04-01"));

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.executeQuery("Select * from products_jerusha");
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
