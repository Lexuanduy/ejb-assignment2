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
        <title>JSP view</title>
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
        <c:if test="${not empty items}">
            <table border="1">
                <tr>
                    <th>UserId</th>
                    <th>TokenString</th>
                    <th colspan="2"> <a href="insert.jsp"><input type="button" value="Insert" /></a> </th>
                </tr>
                <!--Update - Delete-->
                <c:forEach items="${items}" var="it">
                    <form method="POST" action="CUDServlet">
                        <tr>
                            <td><input type="text" name="userId" value="${it.userId}" /></td>
                            <td><input type="text" name="tokenString" value="${it.tokenString}" /> </td>
                            <td><input type="submit" value="Update" name="action" /></td>
                            <td> <input type="submit" value="Delete" name="action" /></td>
                        </tr>
                    </form>
                </c:forEach>
                <!--Insert-->
                <td colspan="4">
                    <form action="CUDServlet">
                        <input type="text" name="searchToken" value="${it.tokenString}" size="55"/>
                        <input type="submit" value="Search"/>
                    </form>
                </td>
            </table>
        </c:if>
    </body>
</html>
