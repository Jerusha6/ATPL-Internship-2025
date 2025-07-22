import java.sql.*;

class PreparedStatement_Demo {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = " insert into users_jerusha values(?,?,?,?); ";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,102);
            preparedStatement.setString(2, "Elisha");
            preparedStatement.setString(3, "elisha@gmail.com");
            preparedStatement.setInt(4, 987654321);

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
