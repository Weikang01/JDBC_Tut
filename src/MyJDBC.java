import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc-demo";
        String user = "root";
        String password = "1231";
        
        try
        {
            // 1. Get a connection to database
            Connection connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute SQL query
            String sql = "insert into employees " +
                    " (last_name, first_name, e-mail)" +
                    " values ('Brown', 'David', 'david.brown@foo.com')";

            statement.executeQuery(sql);

            System.out.println("Insert Complete.");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
