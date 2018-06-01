package Servlet;

import Controller.DbToJson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StuChooseLessonServlet", value = "/stuChooseLesson")
public class StuChooseLessonServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ChineseRectifier.adaptChina(DbToJson.databaseToJson("STU_CHOOSE_LESSON"), response);

    }
}
