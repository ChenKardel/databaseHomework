package Controller;

import Table.FkInformation;
import Table.PkInformation;
import Table.TableWrapper;
import com.bestvike.linq.IEnumerable;
import com.bestvike.linq.Linq;
import com.bestvike.linq.function.Func1;
import entity.*;
import org.apache.ibatis.jdbc.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Selector implements IDatabaseOperation
{
//    public String[] tableNames = {"LEAVE_APPLY", "LESSON", "MESSAGE", "STU_CHOOSE_LESSON", "STUDENT", "TEACHER"};
//    Predicate<String> predicate = new Predicate<String>()
    public TableWrapper<IEntity> queryTable(Connection connection, String tablename, Func1<IEntity, Boolean> predicate) throws SQLException
    {
        TableWrapper<?> tableWrapper = queryTable(connection, tablename);
        ArrayList<IEntity> entities = (ArrayList<IEntity>) tableWrapper.getEntities();
        IEnumerable<IEntity> iEntities = Linq.asEnumerable(entities);
        IEnumerable<IEntity> where = iEntities.where(predicate);
        ArrayList<IEntity> arrayList = (ArrayList<IEntity>) where.toList();
        return new TableWrapper<>(arrayList
                , tableWrapper.getPkInformations(), tableWrapper.getFkInformations());
    }

    public TableWrapper<?> queryTable(Connection connection, String tablename) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tablename);
        TableWrapper<?> tableWrapper = null;
        switch (tablename)
        {
            case "LEAVE_APPLY":
                tableWrapper = queryLeaveApply(resultSet, connection);
                break;
            case "LESSON":
                tableWrapper = queryLesson(resultSet, connection);
                break;
            case "MESSAGE":
                tableWrapper = queryMessage(resultSet, connection);
                break;
            case "STU_CHOOSE_LESSON":
                tableWrapper = queryStuChooseLesson(resultSet, connection);
                break;
            case "STUDENT":
                tableWrapper = queryStudent(resultSet, connection);
                break;
            case "TEACHER":
                tableWrapper = queryTeacher(resultSet, connection);
                break;
        }
        statement.close();
        return tableWrapper;
    }

    private TableWrapper<Teacher> queryTeacher(ResultSet resultSet, Connection connection) throws SQLException
    {
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (resultSet.next())
        {
            String teachernum = resultSet.getString("TEACHERNUM");
            String teachername = resultSet.getString("TEACHERNAME");
            String password = resultSet.getString("PASSWORD");
            String title = resultSet.getString("TITLE");
            String sex = resultSet.getString("SEX");
            Teacher teacher = new Teacher(teachernum, teachername, password, title, sex);
            teachers.add(teacher);
        }
        DatabaseMetaData metaData = connection.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "TEACHER");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "TEACHER");
        return new TableWrapper<>(teachers, pkInformations, fkInformations);
    }

    private TableWrapper<Student> queryStudent(ResultSet resultSet, Connection connection) throws SQLException
    {
        ArrayList<Student> students = new ArrayList<>();
        while (resultSet.next())
        {
            String studentnum = resultSet.getString("STUDENTNUM");
            String studentname = resultSet.getString("STUDENTNAME");
            String sex = resultSet.getString("SEX");
            int aClass = resultSet.getInt("CLASS");
            String password = resultSet.getString("PASSWORD");
            long idcard = resultSet.getLong("IDCARD");
            Student student = new Student(studentnum, studentname, sex, aClass, password, idcard);
            students.add(student);
        }

        DatabaseMetaData metaData = connection.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "STUDENT");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "STUDENT");
        return new TableWrapper<>(students, pkInformations, fkInformations);
    }

    private TableWrapper<StuChooseLesson> queryStuChooseLesson(ResultSet resultSet, Connection connection) throws SQLException
    {
        ArrayList<StuChooseLesson> stuChooseLessons = new ArrayList<>();
        while (resultSet.next())
        {
            String studentnum = resultSet.getString("STUDENTNUM");
            String lessonnum = resultSet.getString("LESSONNUM");
            StuChooseLesson stuChooseLesson = new StuChooseLesson(studentnum, lessonnum);
            stuChooseLessons.add(stuChooseLesson);
        }
        DatabaseMetaData metaData = connection.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "STU_CHOOSE_LESSON");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "STU_CHOOSE_LESSON");
        return new TableWrapper<>(stuChooseLessons, pkInformations, fkInformations);
    }

    private TableWrapper<Message> queryMessage(ResultSet resultSet, Connection connection) throws SQLException
    {
        ArrayList<Message> messages = new ArrayList<>();
        while (resultSet.next())
        {
            long messagenum = resultSet.getInt("MESSAGENUM");
            String content = resultSet.getString("CONTENT");
            long applynum = resultSet.getInt("APPLYNUM");
            String studentnum = resultSet.getString("STUDENTNUM");
            Date time = resultSet.getDate("TIME");
            Message message = new Message(messagenum, content, applynum, studentnum, time);
            messages.add(message);
        }

        DatabaseMetaData metaData = connection.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "MESSAGE");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "MESSAGE");
        return new TableWrapper<>(messages, pkInformations, fkInformations);
    }

    private TableWrapper<Lesson> queryLesson(ResultSet resultSet, Connection connection) throws SQLException
    {
        ArrayList<Lesson> lessons = new ArrayList<>();
        while (resultSet.next())
        {
            String lessonnum = resultSet.getString("LESSONNUM");
            String lessonname = resultSet.getString("LESSONNAME");
            String year = resultSet.getString("YEAR");
            String term = resultSet.getString("TERM");
            int credit = resultSet.getInt("CREDIT");
            String teachernum = resultSet.getString("TEACHERNUM");
            String beforelessonnum = resultSet.getString("BEFORELESSONNUM");
            Lesson lesson = new Lesson(lessonnum, lessonname, year, term, credit, teachernum, beforelessonnum);
            lessons.add(lesson);
        }

        DatabaseMetaData metaData = connection.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "LESSON");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "LESSON");
        return new TableWrapper<>(lessons, pkInformations, fkInformations);
    }

    private TableWrapper<LeaveApply> queryLeaveApply(ResultSet resultSet, Connection conn) throws SQLException
    {
        DatabaseMetaData dbMeta = conn.getMetaData();
        dbMeta.getPrimaryKeys(null, null, "LEAVE_APPLY");

        ArrayList<LeaveApply> leaveApplies = new ArrayList<>();
        boolean next = resultSet.next();
        while (next)
        {
            long applynum = resultSet.getInt("APPLYNUM");
            Date applytime = resultSet.getDate("APPLYTIME");
            String reason = resultSet.getString("REASON");
            String state = resultSet.getString("STATE");
            String studentnum = resultSet.getString("STUDENTNUM");
            String lessonnum = resultSet.getString("LESSONNUM");
            String teachernum = resultSet.getString("TEACHERNUM");
            next = resultSet.next();
            LeaveApply leaveApply = new LeaveApply(applynum,
                                                   applytime,
                                                   reason,
                                                   state,
                                                   studentnum,
                                                   lessonnum,
                                                   teachernum);
            leaveApplies.add(leaveApply);

        }

        DatabaseMetaData metaData = conn.getMetaData();
        ArrayList<PkInformation> pkInformations = getPkInformations(metaData, "LEAVE_APPLY");
        ArrayList<FkInformation> fkInformations = getFkInformations(metaData, "LEAVE_APPLY");
        return new TableWrapper<>(leaveApplies, pkInformations, fkInformations);
    }


    private ArrayList<PkInformation> getPkInformations(DatabaseMetaData metaData, String tablename)
    {
        ArrayList<PkInformation> pkInformations = new ArrayList<>();
        try
        {
            ResultSet pkRset = metaData.getPrimaryKeys(null, null, "LEAVE_APPLY");
            while (pkRset.next())
            {

                String pkName = pkRset.getString("PK_NAME");
                String columnName = pkRset.getString("COLUMN_NAME");
                String tableName = pkRset.getString("TABLE_NAME");
                PkInformation pkInformation = new PkInformation(columnName, tableName, pkName);
                pkInformations.add(pkInformation);
            }
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return pkInformations;
    }

    private ArrayList<FkInformation> getFkInformations(DatabaseMetaData metaData, String tablename)
    {
        ArrayList<FkInformation> fkInformations = new ArrayList<>();

        ResultSet fkRset = null;
        try
        {
            fkRset = metaData.getImportedKeys(null, null, tablename);

            while (fkRset.next())
            {
                String fkName = fkRset.getString("FK_NAME");
                String pkName = fkRset.getString("PK_NAME");
                String pktableName = fkRset.getString("PKTABLE_NAME");
                String pkcolumnName = fkRset.getString("PKCOLUMN_NAME");
                String fktableName = fkRset.getString("FKTABLE_NAME");
                String fkcolumnName = fkRset.getString("FKCOLUMN_NAME");
                FkInformation fkInformation = new FkInformation(fkName,
                                                                pkName,
                                                                pktableName,
                                                                pkcolumnName,
                                                                fktableName,
                                                                fkcolumnName);
                fkInformations.add(fkInformation);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return fkInformations;
    }

    public static void main(String[] args)
    {
        Statement statement = null;
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##kardel", "alksdj1029a");
            statement = conn.createStatement();
            DatabaseMetaData dbMeta = conn.getMetaData();

            ResultSet fkRSet = dbMeta.getImportedKeys(null, null, "LEAVE_APPLY");

            while (fkRSet.next())
            {
                for (int i = 1; i <= fkRSet.getMetaData().getColumnCount(); i++)
                {
                    System.out.print(fkRSet.getMetaData().getColumnName(i));
                    System.out.print(": ");
                    System.out.println(fkRSet.getString(i));
                    System.out.println("**********");
                }
                System.out.println("???");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
