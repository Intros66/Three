<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/3
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            out.print("session销毁");
            System.out.println("===============session销毁页面");
            session.invalidate();
        %>
</body>
</html>
