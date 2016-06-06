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
    <title></title>
</head>
<body>
<div id="container">
    <%@include file="menu.jsp" %>

    <h2>User profile</h2>
    <hr/>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
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
                    <form:label for="blocked_Y_N" path="blocked_Y_N">Block this user</form:label>
                </td>
                <td>
                    <form:checkbox name="blocked_Y_N" path="blocked_Y_N" value="false"/>
                </td>
                </tr>
            </sec:authorize>
            <tr>
                <td>
                    <button type="submit">Update</button>
                </td>
                <td>
                    <button type="reset">Cancel</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
