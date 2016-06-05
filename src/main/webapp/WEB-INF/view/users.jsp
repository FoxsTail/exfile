<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 27.05.2016
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<sec:authentication var="principal" property="principal"/>
<div id="container">
  <h2>Users</h2>
  <hr/>
  <c:if test="${empty users}">
    <p>There are no users in database</p>
  </c:if>
  <c:if test="${not empty users}">
    <table>
      <tr>
        <th>Full Name</th>
      </tr>


      <c:forEach items="${users}" var="user">
        <c:if test='${principal.username}'>
          <c:set value="authUser" var="authUser"/>
        </c:if>
        <tr>
          <td><a href="/web/users/${user.id}" class="${authUser}">
              ${user.name} ${user.surname} ${user.patronymic}
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
</div>
</body>
</html>
