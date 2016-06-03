<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 31.05.2016
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
It was hard, but you did it!<br>
<%--${message};--%>
${files.name};
${files.path};
${files.date};
${files.sender_subdivision.name};

<c:forEach var="cat" items="${files.getter_category}">
  ${cat.name}
--------------
</c:forEach>

<a href="/web/send"><button>Back</button></a>
</body>



</html>
