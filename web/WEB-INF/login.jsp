<%-- 
    Document   : login
    Created on : 5-Oct-2017, 8:43:46 AM
    Author     : 709317
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
        <div>
            <form action="Login" method="POST">
                Username: <input type="text" name="uname" value=""><br>
                Password: <input type="password" name="password" value=""><br>
                
                <input type="submit" value="Login"><br>
                
                
            </form>
        </div>
        ${message}
    </body>
</html>
