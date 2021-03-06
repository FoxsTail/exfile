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

<html>
<head>
    <title>Registration</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../resources/styles/css/bootstrap.css"/>
</head>
<body>
<div id="container" align="center">
    <form:form action="/auth/login/register" name="form1" method="post" commandName="user">
        <h2>Registration</h2>
        <hr>
        <table>
            <tr>
                <td>
                    <form:label for="login" path="Login">Login</form:label>
                </td>
                <td><form:input type="text" name="login" path="login" placeholder="Login"/>
                    <br/><form:errors path="login" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <form:label for="password" path="password">Password</form:label>
                </td>
                <td><form:input type="password" name="password" path="password" placeholder="Password"/>
                    <br/><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <form:label for="name" path="name">Name</form:label>
                </td>
                <td><form:input type="text" name="name" path="name" placeholder="Name"/>
                    <br/><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <form:label for="surname" path="surname">Surname</form:label>
                </td>
                <td><form:input type="text" name="surname" path="surname" placeholder="Surname"/>
                    <br/><form:errors path="surname" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <form:label for="patronymic" path="patronymic">Patronymic</form:label>
                </td>
                <td><form:input type="text" name="patronymic" path="patronymic" placeholder="Patronymic"/>
                    <br/><form:errors path="patronymic" cssClass="error"/></td>
            </tr>
            <tr>
                <td>
                    <form:label for="email" path="email">E-mail</form:label>
                </td>
                <td><form:input type="text" name="email" path="email" placeholder="Email"/>
                    <br/><form:errors path="email" cssClass="error"/></td>
            </tr>

            <tr>
                <td>
                    <form:label for="inn" path="inn">INN</form:label>
                </td>
                <td><form:input type="text" name="inn" path="inn" placeholder="INN"/>
                    <br/><form:errors path="inn" cssClass="error"/></td>
            </tr>

            <tr>
                <td>
                    <form:label for="selectSub" path="subdivision_trans">Subdivision</form:label>
                </td>
                <td><form:select path="subdivision_trans" name="selectSub">
                    <form:option value="0" label="--- Select subdivision---"/>
                    <form:options items="${sub}"/>
                </form:select>
                    <br/><form:errors path="subdivision_trans" cssClass="error"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label for="dep" path="department_trans">Department</form:label>
                </td>
                <td><form:select disabled="true" path="department_trans" name="dep">
                    <form:option value="0" label="--- Select department---"/>
                    <%--     <form:options items="${dep}"/>--%>
                </form:select>
                    <br/><form:errors path="department_trans" cssClass="error"/>
                </td>
            </tr>

            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr>

                <td>
                    <button type="submit" class="great_btn">Register</button>

                </td>
                <td>  <div align="right">
                    <a href="/auth/login">
                        <button type="button" class="great_btn">Back</button>
                    </a></div></td>
            </tr>
        </table>

    </form:form>

    <script type="text/javascript">
        $(function () {
            var sub = "${sub}"
            <%--var dep = "${subDep}"--%>

            var dep = {
                1: {
                    1: 'Finance',
                    2: 'Law',
                    3: 'Minister'
                },
                2: {
                    1: 'Finance',
                    2: 'Law'
                }
            };
            console.log('1212121', sub)

            $('#subdivision_trans').on('change', function () {
                if (this.value != 0 && dep && typeof dep == 'object' && dep[this.value] && Object.keys(dep[this.value]).length) {
                    $('#department_trans').prop("disabled", false);
                    $('.optionalDeps').detach();
                    for (var i in dep[this.value]) {
                        if (dep[this.value].hasOwnProperty(i)) {
                            $('#department_trans').append('<option class=\"optionalDeps\" value=\"' + i + '\">' + dep[this.value][i] + '</option>')
                        }
                    }
                } else {
                    $('#department_trans').prop("disabled", true);
                }
            })
        })
    </script>
</div>
</body>
</html>
