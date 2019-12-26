package org.student.servlet;

import org.student.entity.Page;
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

@WebServlet("/QueryStudentsByPageServlet")
public class QueryStudentsByPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStudentService studentService = new StudentServiceImpl();
        int count = studentService.getTotalCount();//数据总数
        //将分页所需的5个字段(实际4个，1个自动计算)，组装到page对象中
        Page page = new Page();
        String cPage = req.getParameter("currentPage");

        if(cPage == null){
            cPage="1";
        }
        int currentPage = Integer.parseInt(cPage);
        page.setCurrentPage(currentPage);
//        int currentPage =2;
        /*currentPage 当前页
        * students 当前页的数据集合
        *
        *
        * */
        int totalCount = studentService.getTotalCount();
        page.setTotalCount(totalCount);
        int pageSize = 3;
        page.setPageSize(pageSize);
        List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize);
        System.out.println(students);
        System.out.println(count);
        page.setStudents(students);


        req.setAttribute("page",page);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
