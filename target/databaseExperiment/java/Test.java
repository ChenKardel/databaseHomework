import Controller.Selector;
import Controller.Updater;
import Table.TableWrapper;
import com.bestvike.linq.function.Func1;
import entity.IEntity;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test
{
    public static void main(String[] args) throws SQLException
    {
        Updater updater = new Updater();
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("this is some thing wrong with the conn");
        }
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##kardel", "alksdj1029a");
        updater.update(connection, "STUDENT", "STUDENTNUM", "200130", "STUDENTNUM = 200103");

    }
}
