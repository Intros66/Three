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
import java.io.PrintWriter;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int no = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        Student student = new Student(no,name,age,address);

        //接口 xx = new 实现类();
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.addStudent(student);
        /**
         * out request response session application
         *
         * out : PrintWriter out = response.getWriter();
         * session : request.getSession()
         * application : request.getServletContext()
         *
         */
        PrintWriter out = response.getWriter();
       /* if(result){

            out.println("增加成功！");

        }else {
            out.println("增加失败！");
        }*/
        if(!result){
            //如果增加失败，给reuqest放入一条数据error
            request.setAttribute("errorAdd","addError");
        }else {
            //增加成功
            request.setAttribute("errorAdd","noAddError");

        }
//        response.sendRedirect("QueryAllStudentsServlet");
        request.getRequestDispatcher("QueryAllStudentsServlet").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
