<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 27.05.2016
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form action="/web/sendfile" method="post" commandName="file">
    <table>
        <tr>
            <td>Enter file name</td>
            <td><form:input type = "text" name = "name" path="name" placeholder = "File Name"/> </td>
        </tr>

        <tr>
            <td>Enter file size</td>
            <td><form:input type = "number" name = "size" path="size" placeholder = "File Size"/> </td>
        </tr>

        <tr>
            <td>Enter file about</td>
            <td><form:input type = "text" name = "about" path="about" placeholder = "File About"/> </td>
        </tr>
        <tr>
                <%-- TODO:сделать, чтобы деп и саб подгружались из реальности, а не хранились на вьюшке--%>
                    <td>Sender subdivision:</td>
            <td><form:select path="sender_subdivision_trans" >
                <form:option value="0" label="Choose a subdivision: "/>
                <form:option value="1" label="Right" />
                <form:option value="2" label="Left" />
            </form:select></td>
        </tr>
        <tr>
            <td>Sender department:</td>
            <td><form:select path="sender_department_trans">
                <form:option value="0" label="Choose a department:" />
                <form:option value="1" label="Finance" />
                <form:option value="2" label="Law" />
            </form:select></td>
        </tr>

        <tr>
            <td>Document category:</td>
          <td><form:select path="value_categories" multiple="multiple">
               <form:option value="0" label="Choose your category" disabled="true"/>
               <form:option value="1" label="One" selected = "selected"/>
               <form:option value="2" label="Two"/>
               <form:option value="3" label="Three"/>
           </form:select></td>
        </tr>


        <tr>
            <td>Document subdivision:</td>
            <td><form:select path="value_subdivisions" multiple="multiple">
                <form:option value="0" label="Choose your subdivision" disabled="true"/>
                <form:option value="1" label="Right" selected = "selected"/>
                <form:option value="2" label="Left"/>
            </form:select></td>
        </tr>

        <tr>
            <td>Document subdivision:</td>
            <td><form:select path="value_departments" multiple="multiple">
                <form:option value="0" label="Choose your department" disabled="true"/>
                <form:option value="1" label="Finance" selected = "selected"/>
                <form:option value="2" label="Law"/>
            </form:select></td>
        </tr>

        <tr>
            <td>Info about document:</td>
                <%--  <td><form:input type="text" name="about" path="about" placeholder="About" /></td>
                --%></tr>
    </table>

    <button type="button">Add File</button>
    <button type="submit">Send</button>

</form:form>

<td><a href="/web/files"><button>See all files</button></a> </td>
<td><a href="/web/users"><button>See all users</button></a> </td>
</body>
</html>
