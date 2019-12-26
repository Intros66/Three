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

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //待修改人的学号
        int no = Integer.parseInt(request.getParameter("sno"));
        //修改后的内容
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        //将修改后的内容封装到一个实体类中
        Student student = new Student(name,age,address);
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.updateStudentBySno(no, student);
        /*if(result){
            response.getWriter().println("修改成功！");
            response.sendRedirect("QueryAllStudentsServlet");//修改完毕后，再次重新跳转到查询全部
        }else {
            response.getWriter().println("修改失败！");
        }*/
        if(!result){
            request.setAttribute("errorUp","UpdateError");
        }else {
            //修改成功
            request.setAttribute("errorUp","noUpError");
        }
        request.getRequestDispatcher("QueryAllStudentsServlet").forward(request,response);
    }
}
