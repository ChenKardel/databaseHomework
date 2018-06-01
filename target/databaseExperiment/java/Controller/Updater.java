package Controller;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Updater implements IDatabaseOperation
{
    public void update(Connection connection, String tablename, String column, String newValue, String condition) throws SQLException
    {

        Statement statement = connection.createStatement();
        if(condition == null)
        {
            statement.executeUpdate("UPDATE " + tablename + " SET " + column + "=" + newValue );
        }
        statement.executeUpdate("UPDATE " + tablename + " SET " + column + "=" + newValue + " WHERE " + condition);
        statement.close();
        connection.commit();
    }
    public void update(Connection connection, String tablename, String column, String newValue) throws SQLException
    {
        update(connection, tablename, column, newValue,null);
    }
}
