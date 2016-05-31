<%--  Created by IntelliJ IDEA.
  User: Лис
  Date: 26.05.2016
  Time: 17:44
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<form:form action="/auth/login" commandName="user">
  ${user.login}, your registration was successful!<br />

  <hr> Name : ${user.name} <br />
  Surname : ${user.surname} <br />
  Patronymic : ${user.patronymic} <br />
  Department : ${user.department.name} <br />
  Subdivision : ${user.subdivision.name}<br />
  INN :  ${user.inn}<br />
  Login : ${user.login} <br />
  Password : ${user.password}<br />


    <button type="submit">Ok=)</button>

</form:form>

</body>
</html>
