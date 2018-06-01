package Servlet;

import Controller.DbToJson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChineseRectifier
{
    public static void adaptChina(String text, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");;
        out.println(text);
    }

}
