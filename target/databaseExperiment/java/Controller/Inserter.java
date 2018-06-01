package Controller;


import entity.IEntity;
import entity.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Inserter implements IDatabaseOperation
{
    public void insert(Connection connection, IEntity entity) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate(createSql(entity));
        statement.close();
        connection.commit();
    }
    public String createSql(IEntity entity)
    {
        StringBuilder statement = new StringBuilder("INSERT INTO ");
        String simpleName = entity.getClass().getSimpleName();
        System.out.println(simpleName);
        StringBuffer buffer = new StringBuffer();
        buffer.append(simpleName.charAt(0));
        for (int i = 1; i < simpleName.length(); i++)
        {
            System.out.println(1);
            char c = simpleName.charAt(i);
            if(c < 'Z' && c > 'A')
            {
                buffer.append("_" + c);
            }
            else
            {
                buffer.append(c);
            }
        }
        simpleName = buffer.toString();
        simpleName = simpleName.toUpperCase();
        statement.append(simpleName).append(" VALUES(");
        Field[] fields = entity.getClass().getFields();
        for (Field field : fields)
        {
            String name = field.getName();
            Object value = null;
            try
            {
                value = field.get(entity);
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            Class<?> type = field.getType();
            String typeSimpleName = type.getSimpleName();
            if(typeSimpleName.equals("String") || typeSimpleName.equals("Date"))
            {
                if(value != null)
                {
                    value = "'" + value.toString() + "'";
                }
            }
            statement.append(value).append(", ");
        }
        return statement.toString().substring(0, statement.length() - 2) + ")";
    }
}
