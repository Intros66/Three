package org.student.servlet;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        int no = Integer.parseInt(request.getParameter("sno"));
        IStudentService studentService =new StudentServiceImpl();
        Student student = studentService.queryStudentBySno(no);
        System.out.println(student.toString());
        //将此人的数据通过前台jsp显示：studentInfo.jsp
        request.setAttribute("student",student);
        //如果request域中没有数据，使用重定向跳转
        //如果有数据，使用请求转发
        request.getRequestDispatcher("studentInfo.jsp").forward(request,response);

    }
}
