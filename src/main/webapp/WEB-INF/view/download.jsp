<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 04.06.2016
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="container">
<%@include file="menu.jsp" %>
<br>
<form:form action="/web/downloadPerDate" method="post">
    <table>
        <tr>
            <td>Enter the date in format dd\mm\yyyy:</td>
            <td><input type="text" name="date"></td>
            <td><button type="submit">Search</button></td>
            <br>
        </tr>
    </table>
</form:form>
<c:if test="${empty files}">
    <p>There are no files in database</p>
</c:if>
<c:if test="${not empty files}">
    <table>
        <tr>
            <th>Files</th>
        </tr>
        <c:forEach items="${files}" var="file">
            <tr>
                <td>
                        ${file.name}<br>
                        ${file.sender_subdivision.name}<br>
                        ${file.sender_department.name}<br>
                    <c:forEach var="cat" items="${file.getter_category}">
                        ${cat.name}
                    </c:forEach> <br>
                        ${file.about}<br>
                    -----------------------------
                </td>
                <td>
                    <a href="/web/load/${file.id}">Download</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<a href="/web/send">
    <button>Back</button>
</a>
    </div>
</body>
</html>
