<%-- 
    Document   : insert
    Created on : Jul 30, 2019, 11:03:32 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Insert</title>
    </head>
    <body>

        <form method="POST" action="CUDServlet">
            <td><input type="text" name="userId" /> </td>
            <td><input type="text" name="tokenString"  /> </td>
            <td colspan="2"> <input type="submit" value="Insert" name="action"/></td>
        </form>
    </body>
</html>
