<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <button type="button">Download</button>
                </td>
            </tr>

        </c:forEach>
    </table>
</c:if>
</body>
</html>
