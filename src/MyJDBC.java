import java.sql.*;

public class MyJDBC {

    static String url = "jdbc:mysql://localhost:3306/jdbc-demo";
    static String user = "root";
    static String password = "1231";
    static Connection connection;
    static Statement statement;

    static void ShowTable(String tableName, String colName)
    {
        String sql = "select " + colName + " from " + tableName;
    }

    static void ShowTable(String tableName)
    {
        String sql = "select * from " + tableName;
    }

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
            // Create the prepared statement
            // Set parameter values for type and position
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where salary > ? and department=?");

            preparedStatement.setDouble(1, 80000);
            preparedStatement.setString(2, "Legal");

            // now execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            display(resultSet);

            preparedStatement.setDouble(1, 50000);
            preparedStatement.setString(2, "HR");

            // now execute the query
            resultSet = preparedStatement.executeQuery();

            display(resultSet);
//            InsertInto("employees", new String[]{"last_name", "first_name", "email", "department", "salary"}, new String[]{"'Public'","'Mary'","'mary.public@foo.com'", "'HR'", "55000.00"});
//            UpdateInfo("employees", "email", "'demo@luv2code.com'", "id=1");
//            DeleteData("employees", "last_name='Brown'");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void display(ResultSet resultSet) throws SQLException {
        while (resultSet.next())
            System.out.println(resultSet.getString("last_name"));
    }
}
