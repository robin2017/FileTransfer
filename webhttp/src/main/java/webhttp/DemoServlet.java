package webhttp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/demo.do"})
public class DemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        PrintWriter pw = response.getWriter();
        pw.print("您使用GET方式请求该Servlet。<br />" + "name = " + name + ",age = " + age);
        System.out.println("您使用GET方式请求该Servlet。<br />" + "name = " + name + ",age = " + age);
        pw.flush();
        pw.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        PrintWriter pw = response.getWriter();
        pw.print("您使用POST方式请求该Servlet。<br />" + "name = " + name + ",age = " + age);
        System.out.print("您使用POST方式请求该Servlet。<br />" + "name = " + name + ",age = " + age);
        pw.flush();
        pw.close();
    }

}
