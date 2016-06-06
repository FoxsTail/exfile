<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 03.06.2016
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send file</title>
    <link rel="stylesheet" type="text/css" href="../../resources/styles/css/bootstrap.css"/>
</head>
<body>
<div id="container">
    <%@include file="menu.jsp" %>
    <table>
        <form:form method="post" action="/web/sendF" modelAttribute="uploadForm" enctype="multipart/form-data">
            <tr>
                <td>
                    Sender subdivision:
                </td>
                <td>
                        ${uploadForm.user.subdivision.name}
                </td>
            </tr>
            <tr>
                <td>Sender department:</td>
                <td>
                        ${uploadForm.user.department.name}
                </td>
            </tr>

            <tr>
                <td>Document category:</td>
                <td><form:select path="value_categories" multiple="multiple">
                    <form:option value="0" label="Choose your category" disabled="true"/>
                    <form:options items="${cat}"/>
                </form:select>
                </td>
            </tr>

            <tr>
                <td>Document subdivision:</td>
                <td><form:select path="value_subdivisions" multiple="multiple">
                    <form:option value="0" label="Choose your subdivision" disabled="true"/>
                    <form:options items="${sub}"/>
                </form:select>
                </td>
            </tr>
            <tr>
                <td>Document departments:</td>
                <td><form:select path="value_departments" multiple="multiple">
                    <form:option value="0" label="Choose your department" disabled="true"/>
                    <form:options items="${dep}"/>
                </form:select>
                </td>
            </tr>
            <tr>
                <td> Please select a file to upload :</td>
                <td><form:input type="file" name="multipartFilefile" path="multipartFilefile"/></td>
            </tr>
            <tr>
                <td><span><form:errors path="multipartFilefile" cssClass="error"/>
		</span></td>
            </tr>
            <tr>
                <td>Enter file about</td>
                <td><form:input type="text" name="about" path="about" placeholder="File About"/>
                    <br> <form:errors path="about" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Upload"/></td>
            </tr>
        </form:form>

    </table>
</div>
</body>
</html>
