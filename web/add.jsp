<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">
    <script type="text/javascript">
        function check() { //retrun true;表单正常提交，return false 终止提交

            var sno = $("#sno").val();
            var sname = $("#sname").val();
            var sage = $("#sage").val();
            var saddress = $("#saddress").val();
            if(!(sno>0 && sno<101)){
                alert("学号有误，必须是1-100")
                return false;

            }
            if(!(sname.length > 1 && sname.length<5)){
                alert("姓名长度有误，必须是2-4位")
                return false;
            }
            //if(...) return false;
            return true;
        }
    </script>
    <title>Title</title>
</head>
<body>

        <form action="${pageContext.request.contextPath}/AddStudentServlet" method="post" onsubmit="return check()">
            学号：<input type="text" name="sno" id="sno"><br/>
            姓名：<input type="text" name="sname" id="sname"/><br/>
            年龄：<input type="text" name="sage" id="sage"/><br/>
            地址：<input type="text" name="saddress" id="saddress"/><br/>
            <input type="submit" value="新增">
            <a href="${pageContext.request.contextPath}/QueryAllStudentsServlet">返回</a>
        </form>
</body>
</html>
