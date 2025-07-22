import java.sql.*;

class Update_Statement {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = " update users_jerusha set email=? where user_id=?; ";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, "jerusharani@gmail.com");
            preparedStatement.setInt(2,101);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.executeQuery("Select * from users_jerusha");
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getString(3)+" ");
                System.out.print(rs.getInt(4)+" ");
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
