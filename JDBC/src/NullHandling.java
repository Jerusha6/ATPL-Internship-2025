import java.sql.*;

class NullHandling {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = "INSERT INTO products_jerusha (product_ID, product_name, price, product_description) VALUES (?, ?, ?, ?) ";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 108);
            preparedStatement.setString(2, "Body Wash");
            preparedStatement.setString(3, "499");
            preparedStatement.setNull(4, java.sql.Types.VARCHAR);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.executeQuery("Select * from products_jerusha");
            while(rs.next()){
                System.out.print(rs.getString(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getDate(3)+" ");
                System.out.print(rs.getDouble(4)+" ");
                System.out.print(rs.getString(5)+" ");
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
