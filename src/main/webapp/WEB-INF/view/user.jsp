<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 03.06.2016
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="../../resources/styles/css/bootstrap.css"/>
</head>
<body>
<div id="container">
    <%@include file="menu.jsp" %>
<br>
    <h2>${user.name} profile</h2>
    <hr/>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    <c:if test="${not empty user}">
    <form:form action="/web/users/${user.id}" method="post" commandName="user">
        <table>
            <tr>
                <td>
                    <form:label for="login" path="login">Login</form:label>
                </td>
                <td>
                    <form:input type="text" name="login" path="login" placeholder="login"/>
                    <br/><form:errors path="login" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="password" path="password">Password</form:label>
                </td>
                <td>
                    <form:input type="password" name="password" placeholder="password" path="password"/>
                    <br/><form:errors path="password" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="name" path="name">Name</form:label>
                </td>
                <td>
                    <form:input type="text" name="name" placeholder="name" path="name"/>
                    <br/><form:errors path="name" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="surname" path="surname">Surname</form:label>
                </td>
                <td>
                    <form:input type="text" name="surname" placeholder="surname" path="surname"/>
                    <br/><form:errors path="surname" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="patronymic" path="patronymic">Patronymic</form:label>
                </td>
                <td>
                    <form:input type="text" name="patronymic" placeholder="patronymic" path="patronymic"/>
                    <br/><form:errors path="patronymic" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="inn" path="inn">INN</form:label>
                </td>
                <td>
                    <form:input type="text" name="inn" placeholder="inn" path="inn"/>
                    <br/><form:errors path="inn" cssClass="errorMessage"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label for="email" path="email">E-mail</form:label>
                </td>
                <td>
                    <form:input type="text" name="email" placeholder="e-mail" path="email"/>
                    <br/><form:errors path="email" cssClass="errorMessage"/>
                </td>
            </tr>
            <sec:authorize access="hasAuthority('ADMIN')">
                <td>
                 <a href="/web/users/${user.id}/delete"> <button type="button" class="great_btn">Delete user</button></a>
                </td>
                </tr>
            </sec:authorize>
            <tr></tr>
            <tr>
                <td >
                    <button class="great_btn" type="reset">Cancel</button>
                </td>
                <td align="right">
                    <button class="great_btn" type="submit">Update</button>
                </td>

            </tr>
        </table>
    </form:form>
    </c:if>
</div>
</body>
</html>
