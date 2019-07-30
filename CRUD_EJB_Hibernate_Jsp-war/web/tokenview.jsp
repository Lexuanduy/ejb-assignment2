<%-- 
    Document   : tokenview
    Created on : Jul 30, 2019, 10:08:26 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${not empty welcome}">
            Welcome:<font color="red"> ${sessionScope.welcome}</font>
            <a href="LoginServlet"><input type="button" value="Logout" /></a>
        </c:when>
        <c:otherwise>
            <a href="login.jsp"><input type="button" value="Login" /></a>
        </c:otherwise>
    </c:choose>

    <c:if test="${not empty ERROR}">
        ${requestScope.ERROR}
    </c:if>
</body>
</html>
