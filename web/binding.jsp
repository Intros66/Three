<%@ page import="org.student.listener.BeanListener" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/3
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            /*
            * 监听：session对象
            * */
            BeanListener bean = new BeanListener();
            session.setAttribute("bean",bean);
        %>
</body>
</html>
