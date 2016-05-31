<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 27.05.2016
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Users</h2>
<table>
  <c:forEach var="user" items="${users}">
    <tr><td>${user.name}</td></tr>
    <tr><td>${user.login}</td></tr>
    <tr><td>${user.department.name}</td></tr>
    <tr><td>--------------</td></tr>
  </c:forEach>
</table>
</body>
</html>
