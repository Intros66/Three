<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/31
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${范围.xx}
       <c:if test="${10>2}" var="result" scope="request">
            真
           ${resquest.result}
       </c:if>

    <c:set var="role" value="学生" scope="request"></c:set>
    <c:choose>
        <c:when test="${requestScope.role == '老师'}">
            老师代码..
        </c:when>
    <c:when test="${requestScope.role == '学生'}">
            学生代码..
    </c:when>
    <c:otherwise>
        管理员...
    </c:otherwise>
    </c:choose>

    =============
    <c:forEach begin="0" end="5" step="1" varStatus="status">
        ${status.index}
        test....
    </c:forEach>



    <c:forEach var="name" items="${requestScope.names}" >
        ${name}----
    </c:forEach>

</body>
</html>
