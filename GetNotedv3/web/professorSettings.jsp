<%-- 
    Document   : professorSettings
    Created on : Dec 3, 2012, 9:45:08 PM
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="settingsProf" action="" method="post">
            <fieldset>
                <legend>Change Student Info</legend>
                    <label for="username">Username:</label>
                    <input type="text" name="username" value=""><br />
                    <label for="password">Password:</label>
                    <input type="text" name="password" value=""><br />
                    <label for="firstName">First Name:</label>
                    <input type="text" name="firstName" value=""><br />
                    <label for="lastName">Last Name:</label>
                    <input type="text" name="lastName" value=""><br />
                    <label for="school">School:</label>
                    <select name="school">
                        <c:forEach>
                            <!-- SCHOOL: Must be populated from Database in Alphabetical Order-->
                        </c:forEach>
                    </select><br />
                    <label for="email">E-Mail:</label>
                    <input type="text" name="email" value=""><br />
            </fieldset>
            <fieldset>
                <div class="professor">
                        <label for="department">Department:</label>
                        <select name="department">
                            <c:forEach>
                            <!-- DEPARTMENT: Must be populated from Database in Alphabetical Order-->
                        </c:forEach>
                        </select>
                        <br /><br />
                        <input type="submit" value="Submit" /><br />
                    </div> 
            </fieldset>
        </form>
    </body>
</html>
