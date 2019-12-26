<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/3
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            //ServletContext:application
            application.setAttribute("name","zs");//增加application
            application.setAttribute("name","ls");//替换
            application.removeAttribute("name");

            session.setAttribute("user","user01");
            session.setAttribute("user","user02");
            session.removeAttribute("user");

            request.setAttribute("school","kq");
            request.setAttribute("school","kq1");
            request.removeAttribute("school");

        %>
</body>
</html>
