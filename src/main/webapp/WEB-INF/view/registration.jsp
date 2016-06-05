<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Енот
  Date: 11.05.2016
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--TODO: добавить связку дэп и саб в селектах, убрать баг: при ошибке валидации исчезают значения в селектах дэп и саб--%>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<form:form action="/auth/register" name="form1" method="post" commandName="user">
    <table>
        <tr>
            <td><form:input type="text" name="login" path="login" placeholder="Login"/>
                <br/><form:errors path="login" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:input type="password" name="password" path="password" placeholder="Password"/>
                <br/><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="name" path="name" placeholder="Name"/>
                <br/><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="surname" path="surname" placeholder="Surname"/>
                <br/><form:errors path="surname" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="patronymic" path="patronymic" placeholder="Patronymic"/>
                <br/><form:errors path="patronymic" cssClass="error"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="email" path="email" placeholder="Email"/>
                <br/><form:errors path="email" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:input type="text" name="inn" path="inn" placeholder="INN"/>
                <br/><form:errors path="inn" cssClass="error"/></td>
        </tr>

        <tr>
        <td><form:select path="subdivision_trans" name="selectSub">
            <form:option value="0" label="--- Select subdivision---"/>
            <form:options items="${sub}"/>
        </form:select>
            <br/><form:errors path="subdivision_trans" cssClass="error"/>
        </td>
    </tr>

        <tr>
            <td><form:select path="department_trans" name="dep">
                <form:option value="0" label="--- Select department---"/>
                <form:options items="${dep}"/>
            </form:select>
                <br/><form:errors path="department_trans" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td>
                <button type="submit">Register</button>
            </td>
        </tr>
    </table>
</form:form>
<td><a href="/auth/login">
    <button>Back</button>
</a></td>
</body>
</html>
