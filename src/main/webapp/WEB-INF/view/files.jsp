<%--
  Created by IntelliJ IDEA.
  User: Енот
  Date: 31.05.2016
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Files</title>
</head>
<body>
<c:forEach items="${files}" var="file">
  ${file.about}
  ${file.size}
  ${file.sender_department.name}
</c:forEach>
</body>
</html>
