<%@ page import="org.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/31
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--<%
            Student student = (Student)request.getAttribute("student");
            out.print(student+"---<br>");
            out.print(student.getSno()+"---<br>");
            out.print(student.getSname()+"---<br>");
            out.print(student.getSage()+"---<br>");
            out.print(student.getSaddress()+"---<br>");
            out.print("--------<br/>");
        %>--%>
        ------点操作符<br/>
        ${requestScope.student}<br/>
        ${requestScope.student.sno}<br/>
        ${requestScope.student.sname}<br/>
        ${requestScope.student.sage}<br/>
        ${requestScope.student.saddress}<br/>
        ------[""]操作符 单双引号都可<br/>
        ${requestScope.student['sno']}<br/>
        --hobbies<br/>
        ${requestScope.hobbies[0]}<br/>
        ${requestScope.hobbies[1]}<br/>
        -----map<br/>
        ${requestScope.countries.cn}<br/>
        ${requestScope.countries["us"]}<br/>
        -----运算<br/>
        ${3>2}、${3 gt 2}<br>
        ${3>2 || 3<2},${3>2 or 3<2}<br/>
        -----emp<br/>
        ${empty requestScope["my-name"]}<br/>
        ${empty requestScope["hello"]}<br/>
        ----session<br>
        ${sessionScope.sessionKey}

        --------参数对象<br/>
        ${param.uname}<br/>
        ${paramValues.hobbies[0]}<br/>
        ${paramValues.hobbies[1]}<br/>
        ${paramValues.hobbies[2]}<br/>
</body>
</html>
