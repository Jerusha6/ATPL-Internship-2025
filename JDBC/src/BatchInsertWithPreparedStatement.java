import java.sql.*;

class BatchInsertWithPreparedStatement {
    public static void main(String[] args){
        String url = "jdbc:mysql://192.168.71.15:3306/intern";

        String username = "intern2025";
        String password = "intern2025";

        String query = " INSERT INTO users_jerusha (user_id, user_name, email) VALUES (?, ?, ?); ";
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            conn.setAutoCommit(false);

            // 1st record
            preparedStatement.setInt(1, 105);
            preparedStatement.setString(2, "Roja");
            preparedStatement.setString(3, "roja@gmail.com");
            preparedStatement.addBatch();

            // 2nd record
            preparedStatement.setInt(1, 106);
            preparedStatement.setString(2, "anand");
            preparedStatement.setString(3, "anand@gmail.com");
            preparedStatement.addBatch();

            // 3rd record
            preparedStatement.setInt(1, 107);
            preparedStatement.setString(2, "Bharani");
            preparedStatement.setString(3, "bharani@gmail.com");
            preparedStatement.addBatch();


            int[] result = preparedStatement.executeBatch();

            conn.commit();

            System.out.println("Inserted rows: " + result.length);


            ResultSet rs = preparedStatement.executeQuery("Select * from users_jerusha");
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getString(3)+" ");
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
