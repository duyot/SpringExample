<%@ page import="com.vivas.springmvc.utils.Constants" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: duyot
  Date: 8/19/2016
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String listOfUserSM = Constants.SEVERLET_MAPPING.USER_CP.LIST_OF_USER;
    String registerSM = Constants.SEVERLET_MAPPING.USER_CP.REGISTER;
%>
<html>
<head>
    <title>User managerment page</title>
</head>
<body>
    <h3>User information page</h3>
    <a href="<c:url value="<%=listOfUserSM%>" />">List of user</a>
    <a href="<c:url value="<%=registerSM%>" />">Register</a>
</body>
</html>
