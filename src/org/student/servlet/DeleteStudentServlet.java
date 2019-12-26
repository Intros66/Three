package org.student.servlet;

import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //接收前端传来的学号
        int no =Integer.parseInt (request.getParameter("sno"));
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.deleteStudentBySno(no);
      /*  if(result){
//            response.getWriter().println("删除成功！");
            response.sendRedirect("QueryAllStudentsServlet");//删除后重新查询所有
        }else {
            response.getWriter().println("删除失败！");
        }*/
        if(!result){
            request.setAttribute("errorDel","DelError");
        }else {
            //删除成功
            request.setAttribute("errorDel","noDelError");
        }
        request.getRequestDispatcher("QueryAllStudentsServlet").forward(request,response);
    }
}
