package org.student.servlet;

import org.student.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ElUnitServlet")
public class ElUnitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setSno(20);
        student.setSname("zs");
        student.setSage(18);
        student.setSaddress("bj");

        //将student放入request域
        request.setAttribute("student",student);
        request.setAttribute("my-name","sssp");
        String[] hobbies = new String[]{"football","basketball"};
        request.setAttribute("hobbies",hobbies);
        Map<String,Object> map= new HashMap<>();
        map.put("cn","中国");
        map.put("us","美国");
        request.setAttribute("countries",map);

        request.getSession().setAttribute("sessionKey","sessionValue");
        String[] names = new String[]{"aa","bb","cc"};
        request.setAttribute("names",names);

        request.getRequestDispatcher("jstl2.jsp").forward(request,response);
    }
}
