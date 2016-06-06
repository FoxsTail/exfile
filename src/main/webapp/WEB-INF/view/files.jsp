<%--
  Created by IntelliJ IDEA.
  User: Енот
  Date: 31.05.2016
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Files</title>
</head>
<body>
<%@include file="menu.jsp"%>
<table>
    <sec:authentication var="principal" property="principal"/>
    <div id="container">
        <h2>Users</h2>
        <hr/>
        <c:if test="${empty files}">
        <p>There are no users in database</p>
        </c:if>
        <c:if test="${not empty files}">
        <table>
            <tr>
                <th>Full Name</th>
            </tr>
            <c:forEach items="${files}" var="file">
                <c:if test='${principal.username}'>
                    <c:set value="authUser" var="authUser"/>
                </c:if>
                <tr>
                    <td><a href="/web/files/${file.id}" class="${authUser}">
                            ${file.name} ${file.about} ${file.sender_subdivision.name}
                    </a></td>
                        <%--<c:if test="${student.room != null}">
                          <td><a href="/web/rooms/${student.room.number}">
                              ${student.room.number}
                          </a></td>
                        </c:if>--%>
                </tr>
                <c:set value="" var="authUser"/>
            </c:forEach>
        </table>
        </c:if>
</table>
</body>
</html>
