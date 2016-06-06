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
<div id="container">
    <%@include file="menu.jsp" %>
    <table>
        <sec:authentication var="principal" property="principal"/>

        <h2>Files</h2>
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
                                ${file.name}\ ${file.sender_subdivision.name}\ ${file.sender_department.name}\<c:forEach
                                var="cat" items="${file.getter_category}">
                            ${cat.name}\
                        </c:forEach> <br> ${file.about}</a></td>
                    </tr>
                    <c:set value="" var="authUser"/>
                </c:forEach>

            </table>
        </c:if>
    </table>
</div>
</body>
</html>
