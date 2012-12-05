<%-- 
    Document   : professorPage
    Created on : Dec 4, 2012, 3:27:19 AM
    Author     : aaronmeltzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor Page</title>
    </head>
    <body>
        <h1>Professor Page</h1>
        <form method="post" name="professorsettings" action="ProfessorSettingsServlet" >
                    <input type="submit" value="Settings" />
        </form>
        <form method="post" name="questionBanksettings" action="ListQuestionBankServlet" >
                    <input type="submit" value="List Question Bank Questions" />
        </form>
    </body>
</html>
