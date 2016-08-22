<%--
  Created by IntelliJ IDEA.
  User: duyot
  Date: 8/19/2016
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User managerment page</title>
</head>
<body>
    <h3>List of User: </h3>
        <c:forEach items="${listUser}" var="user">
            <h2>Username: <c:out value="${user.username}"/>, password: <c:out value="${user.password}"/></h2>
        </c:forEach>
</body>
</html>
