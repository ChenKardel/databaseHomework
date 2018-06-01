package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Trigger
{
    public void createTrigger(Connection connection, String triggerName, String triggerTime, String event, String tablename,String body) throws SQLException
    {
        String[] events = {event};
        createTrigger(connection, triggerName, triggerTime, events, tablename, body);
    }
    public void createTrigger(Connection connection, String triggerName, String triggerTime, String[] events, String tablename, String body) throws SQLException
    {
        StringBuilder formerFormat = new StringBuilder(String.format("CREATE OR REPLACE TRIGGER %s %s ",
                                                                     triggerName,
                                                                     triggerTime));
        if(events.length == 0)
        {
            throw new SQLException("be serious, sir!");
        }
        formerFormat.append(events[0]);
        for (int i = 1; i < events.length; i++)
        {
            formerFormat.append(events[i]).append(" OR ");
        }
        StringBuilder latterFormat = new StringBuilder(String.format("ON %s %s", tablename, body));
        String s = formerFormat.append(latterFormat).toString();
        Statement statement = connection.createStatement();
        statement.execute(s);
        statement.close();
        connection.commit();
    }
}
