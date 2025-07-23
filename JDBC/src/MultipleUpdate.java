import java.sql.*;

class MultipleUpdate {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = " Update products_jerusha set product_name = ? , price = ? where product_id = ?";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "Advance fomula serum");
            preparedStatement.setDouble(2, 424);
            preparedStatement.setString(3, "P101");
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery("Select * from Products_jerusha");
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
