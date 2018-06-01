package Servlet;

import Controller.DbToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="LeaveApply", value = "/leaveApply")
public class LeaveApplyServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        super.doGet(req, resp);
        ChineseRectifier.adaptChina(DbToJson.databaseToJson("LEAVE_APPLY"), resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        super.doPost(req, resp);
    }
}
