<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/31
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--
            request.setAttribute("name","zhangsan");
        --%>
        <c:set var="name" value="zhangsan" scope="request"/>
        ${requestScope.name}
        <br/>
        -----给普通对象的属性赋值--------<br/>
        ${requestScope.student.sname}<br/>

        <c:set target="${requestScope.student}" property="sname" value="张三" />
        ${requestScope.student.sname}<br/>

        ------给map对象赋值--------<br/>
        ${requestScope.countries.cn}<br/>
        <c:set target="${requestScope.countries}" property="cn" value="China" />
        ${requestScope.countries.cn}<br/>


        -----给不存在的变量赋值<br/>
        <c:set var="x" value="y" scope="request"/>
        ${requestScope.x}<br/>

        <br/>
        <br/>
        <br/>
        -------c:out-----<br/>
        传统EL：${requestScope.student}<br/>
        JSTL表达式：<c:out value="${requestScope.student}"/><br/>
        c：out显示不存在的数据：<c:out value="${requestScope.stu}" default="zs233"/><br/>
        <a href="https://www.baidu.com">百度</a><br/>
        true：<c:out value='<a href="https://www.baidu.com">百度</a>' default="当value为空时显示的默认值" escapeXml="true"/><br/>
        false：<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="false"/><br/>

        <c:set var="a" value="b" scope="request" />
        显示：${a}
        <br/>
        <c:remove var="a" scope="request"/>
        删除后显示：${a}



</body>
</html>
