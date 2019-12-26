<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/31
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="el.jsp">
       用户名： <input name="uname" type="text"><br/>
       兴趣：<br/>
       乒乓球 <input name="hobbies" type="checkbox" value="pingpang"><br/>
       足球 <input name="hobbies" type="checkbox" value="football"><br/>
       篮球 <input name="hobbies" type="checkbox" value="basketball"><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
