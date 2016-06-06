<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 04.06.2016
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File</title>
    <link rel="stylesheet" type="text/css" href="../../resources/styles/css/bootstrap.css"/>
</head>
<body>
<div id="container">
<table>


    <tr>
        <td>File name:</td>
        <td>${file.name}</td>
    </tr>
    <tr>
        <td>Sender subdivision: <br> and department</td>
        <td>${file.sender_subdivision.name},
       ${file.sender_department.name}</td>
    </tr>
    <tr>
        <td>File category:</td>
        <td><c:forEach var="cat" items="${file.getter_category}">
            ${cat.name}
        </c:forEach> <br></td>
    </tr>
    <tr>
        <td>What this file about:</td>
        <td>${file.about}</td>
    </tr>
    <tr>
        <td>The file was saved in:</td>
        <td>${file.path}</td>
    </tr>
    <tr>
        <td>Do you wand to download this file?</td>
        <td>
            <a href="/web/load/${file.id}">Download</a>
        </td>

    </tr>
</table>
<a href="/web/files">
    <button>Back</button>
</a>
    </div>
</body>
</html>
