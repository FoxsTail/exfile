<%--
  Created by IntelliJ IDEA.
  User: Енот
  Date: 31.05.2016
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Files</title>
</head>
<body>
<table>
    <c:forEach items="${files}" var="file">
        <tr>
            <td> ${file.about}</td>
        </tr>
        <tr>
            <td> ${file.size}</td>
        </tr>
        <tr>
            <td> ${file.sender_department.name}</td>
        </tr>
        <tr>
            <td><c:forEach items="${file.getter_subdivisions}" var="sub">
                ${sub.name}
            </c:forEach></td>
        </tr>
        <tr>
            <td><c:forEach items="${file.getter_category}" var="cat">
                ${cat.name}
            </c:forEach></td>
        </tr>
        <tr>
            <td><c:forEach items="${file.getter_departments}" var="dep">
                ${dep.name}
            </c:forEach></td>

        </tr>
       <tr><td>-------------------------------------------------------</td></tr>
    </c:forEach>
</table>
</body>
</html>
