<%--
  Created by IntelliJ IDEA.
  User: Лис
  Date: 05.06.2016
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="default-menu">
  <a href="/web/profile/">Profile</a> |
  <a href="/web/send">Send File</a>  |
  <a href="/web/download">Download File</a>
  <sec:authorize access="hasAuthority('ADMIN')">
   | <a href="/web/users">Users</a> |
    <a href="/web/files">Files</a>
  </sec:authorize>
  <a href="/web/logout" style="float: right">Log out</a>
</div>