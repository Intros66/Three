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
import java.util.List;

@WebServlet("/QueryAllStudentsServlet")
public class QueryAllStudentsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        IStudentService studentService =new StudentServiceImpl();
        List<Student> students = studentService.queryAllStudents();
        System.out.println(students);
        //pageConext<request<session<application
        request.setAttribute("students",students);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
