<%-- 
    Document   : login
    Created on : Jul 30, 2019, 10:06:31 PM
    Author     : duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login !</h1>
        <form action="LoginServlet" method="POST">
            Username:<input type="text" name="username" /><br/>
            Password:<input type="password" name="password" /><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>

