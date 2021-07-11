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

    static void DeleteData(String tableName, String condition) throws SQLException
    {
        String sql = "delete from " + tableName +
                " where " + condition;
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
//            InsertInto("employees", new String[]{"last_name", "first_name", "email"}, new String[]{"'Public'","'Mary'","'mary.public@foo.com'"});
//            UpdateInfo("employees", "email", "'demo@luv2code.com'", "id=1");
//            DeleteData("employees", "last_name='Brown'");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
