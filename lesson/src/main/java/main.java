import java.sql.*;

public class main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234576";
    private static final String URL = "jdbc:mysql://localhost:3306/java?useSSL=false";

    public static void main(String[] args)  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next())
                System.out.println(resultSet.getLong("id") + resultSet.getString("name") + resultSet.getString("second_name"));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}