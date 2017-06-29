<%--
  Created by IntelliJ IDEA.
  User: rihai
  Date: 6/21/2017
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>users</title>
</head>
<body>
user列表
<ul>
    <c:forEach items ="${users}" var="user">
        <li><span>${user.id}</span>,<span>${user.name}</span></li>
    </c:forEach>
</ul>
<%
    String contextPath = request.getContextPath();
%>
新user
<form action="<%=contextPath%>/user/addUser" method="get">
    id：<input name="id"/>
    用户名：<input name="name"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
