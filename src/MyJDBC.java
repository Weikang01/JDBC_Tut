import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {

    static String url = "jdbc:mysql://localhost:3306/jdbc-demo";
    static String user = "root";
    static String password = "1231";
    static Connection connection;
    static Statement statement;

    static void InsertInto(String tableName, String[] varNames, String[] varValues) throws SQLException
    {
        String varNameStr = String.join(", ", varNames);
        String varValueStr = String.join(", ", varValues);

        String sql = "insert into " + tableName +
                " (" +String.join(", ", varNames) + ")" +
                " values (" + String.join(", ", varValues) +")";
        statement.executeUpdate(sql);
    }

    static void UpdateInfo(String tableName, String varName, String varValue, String condition) throws SQLException
    {
        String sql = "update " + tableName +
                " set " + varName + "=" + varValue + " where " + condition;
        statement.executeUpdate(sql);
    }

    public static void main(String[] args) {

        try
        {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            UpdateInfo("employees", "email", "'demo@luv2code.com'", "id=1");
//            statement.executeUpdate(sql);

//            System.out.println("Insert Complete.");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
