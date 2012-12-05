<%-- 
    Document   : login
    Created on : Nov 28, 2012, 7:37:02 PM
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery/jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form method="post" name="login" action="login" >
            <fieldset>
                <legend>Login</legend>
                    <label for="username">Username:</label>
                    <input name="username" /><br />
                    <label for="password">Password:</label>
                    <input type="password" name="password" /><br />
                    <input type="submit" value="Login" />
            </fieldset>
        </form>
    </body>
</html>
