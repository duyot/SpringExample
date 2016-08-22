<%@ page import="com.vivas.springmvc.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: duyot
  Date: 8/22/2016
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String submitRegisterSM = Constants.SEVERLET_MAPPING.USER_CP.SUBMIT_REGISTER;
%>
<html>
<head>
    <title>Register Form</title>
</head>
<body>
    <form method="post" >
        Username: <input type="text" name="Username" /><br/>
        Passwords: <input type="password" name="Password" /><br/>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>
