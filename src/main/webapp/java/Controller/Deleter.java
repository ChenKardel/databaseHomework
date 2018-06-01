package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Deleter implements IDatabaseOperation
{
    public void delete(Connection connection, String tablename, String condition) throws SQLException
    {
        Statement statement = connection.createStatement();
        if(condition == null){
            statement.executeUpdate("DELETE FROM " + tablename);
        }
        else
        {
            statement.executeUpdate("DELTE FROM " + tablename + " WHERE " + condition);
        }
        connection.commit();
    }
    public void delete(Connection connection, String tablename) throws SQLException
    {
        delete(connection, tablename, null);
    }

}
