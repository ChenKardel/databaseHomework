package Controller;

import Table.TableWrapper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;

import javax.management.AttributeList;

public class DbToJson
{
    static class Wrapper
    {
        private int draw = 1;
        private int recordsTotal;
        private int recordsFiltered;
        private ArrayList<?> data;

        Wrapper(int draw, int recordsFiltered, ArrayList<?> data)
        {
            this.draw = draw;
            this.recordsTotal = data.size();
            this.recordsFiltered = recordsFiltered;
            ArrayList<ArrayList<Object>> arrayLists = new ArrayList<>();
            for (Object datum : data)
            {
                ArrayList<Object> attrs = new ArrayList<>();

                Field[] fields = datum.getClass().getFields();
                for (Field field : fields)
                {
                    try
                    {
                        Object o = field.get(datum);
                        attrs.add(o);
                    }
                    catch (IllegalAccessException e)
                    {
                        e.printStackTrace();
                    }

                }
                arrayLists.add(attrs);
            }
            this.data = arrayLists;

        }
        Wrapper(int draw, ArrayList<?> data)
        {
            this(draw, data.size(), data);
        }
        Wrapper(ArrayList<?> data)
        {
            this(1, data);
        }
    }
    public static String databaseToJson(String tablename)
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("this is some thing wrong with the conn");
        }
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##kardel", "alksdj1029a");
            Selector operation = new Selector();
            TableWrapper<?> tableWrapper = operation.queryTable(connection, tablename);
            ArrayList<?> entities = tableWrapper.getEntities();
            Wrapper wrapper = new Wrapper(entities);
            Gson gson = new Gson();
            return gson.toJson(wrapper);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }



        return  null;
    }

    public static void main(String[] args)
    {
        System.out.println(DbToJson.databaseToJson("LESSON"));
    }
}
