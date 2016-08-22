<%@ page import="com.vivas.springmvc.utils.Constants" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: duyot
  Date: 8/18/2016
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String usercpSM = Constants.SEVERLET_MAPPING.HOME_SUBS.USERCP;
%>
<html>
<head>
    <title>This is page from Spring MVC</title>
</head>
<body>
    <h1>duyot</h1>
    <a href="<c:url value="/home/duyot" />">Go to child page</a>
    <a href="<c:url value="<%=usercpSM%>" />">Go to user managerment page</a>
</body>
</html>
