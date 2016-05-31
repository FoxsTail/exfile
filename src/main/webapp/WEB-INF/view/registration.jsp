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

<%--
<script type="text/javascript">
    $('button[type!=submit]').click(function(){
        // code to cancel changes
        return false;
    });
</script>--%>

<html>
<head>
    <title>Registration</title>
</head>

<body>
<form:form action="/auth/register" method="post" commandName="user">
    <table>
        <tr>
            <td><form:input type="text" name="login" path="login" placeholder="Login" /></td>
        </tr>
        <tr>
            <td><form:input type="password" name="password" path="password" placeholder="Password"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="name" path="name" placeholder="Name"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="surname" path="surname" placeholder="Surname"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="patronymic" path="patronymic" placeholder="Patronymic"/></td>
        </tr>
        <tr>
            <td><form:input type="text" name="email" path="email" placeholder="Email"/></td>
        </tr>

        <tr>
            <td><form:input type="text" name="inn" path="inn" placeholder="INN"/></td>
        </tr>
        <tr>
                <%-- TODO:сделать, чтобы деп и саб подгружались из реальности, а не хранились на вьюшке--%>
                    <td><form:select path="subdivision_trans" >
                        <form:option value="0" label="Choose a subdivision: "/>
                        <form:option value="1" label="Right" />
                        <form:option value="2" label="Left" />
                    </form:select></td>
        </tr>
        <tr>
            <td><form:select path="department_trans">
                <form:option value="0" label="Choose a department:" />
                <form:option value="1" label="Finance" />
                <form:option value="2" label="Law" />
            </form:select></td>
        </tr>

        <tr>
            <td><button type="submit">Register</button></td>
        </tr>
    </table>
</form:form>
<td><a href="/auth/login"><button>Back</button></a> </td>
</body>
</html>
