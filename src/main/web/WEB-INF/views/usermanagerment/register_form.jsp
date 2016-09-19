<%@ page import="com.vivas.springmvc.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: duyot
  Date: 8/22/2016
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String submitRegisterSM = Constants.SEVERLET_MAPPING.USER_CP.SUBMIT_REGISTER;
%>
<html>
<head>
    <title>Register Form</title>
</head>
<body>
    <sf:form method="post" modelAttribute="adminUserDTO" >
        Username:<sf:input path="username"/><br/>
                 <sf:errors path="username"/>
        Password:<sf:input path="password"/><br/>
                 <sf:errors path="password"/>
        <input type="submit" value="Submit" />
    </sf:form>
</body>
</html>
