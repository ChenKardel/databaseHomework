package Controller;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Procedurer implements IDatabaseOperation
{
    public void callProcedurer(Connection connection, String procName, Object... parameters) throws SQLException
    {
        StringBuilder proc_ins_dept = new StringBuilder(String.format("{call %s{", procName));
        for (Object parameter : parameters)
        {
            proc_ins_dept.append("?,");
        }
        String substring = proc_ins_dept.toString().substring(0, proc_ins_dept.length() - 1);
        CallableStatement cs = connection.prepareCall(substring);
        for (int i = 1; i <= parameters.length; i++)
        {
            cs.setObject(i, parameters[i - 1]);
        }
        cs.execute();
        cs.close();
    }

    public void createProcedurer(Connection connection, String procedureStatement) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.execute(procedureStatement);
        statement.close();
        connection.commit();
    }
}
