<%-- 
    Document   : questionBankSearch
    Created on : Dec 5, 2012, 12:06:25 AM
    Author     : quantumDrop
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery/jquery.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QB Results</title>
    </head>
    <body>
        <h1>Question Bank Search Results</h1>
        <form method="post" name="login" action="login" >
            <fieldset>
                <legend>QB Search</legend>
                    <label for="qbSearchField">qbSearchField</label>
                    <input name="qbSearchField" /><br />
                    <input type="submit" value="Search" />
            </fieldset>
        </form>
    </body>
</html>