package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlExecutor implements IDatabaseOperation
{
    public void executeUpdate(Connection connection, String sql) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.commit();
    }
    public ResultSet executeQuery(Connection connection, String sql) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        statement.close();
        return resultSet;
    }

}
