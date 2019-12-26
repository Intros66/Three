<%@ page import="org.student.listener.BeanListener2" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/3
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            BeanListener2 bean = new BeanListener2();
            bean.setNum(10);
            bean.setUser("zd");
            session.setAttribute("bean",bean);
        %>
</body>
</html>
