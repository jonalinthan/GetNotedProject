<%-- 
    Document   : removeUser
    Created on : Dec 6, 2012, 2:26:36 AM
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Search for User to Remove</h2>
                    <p>Please choose a criteria. Keyword is optional.</p>
                    <form name="BrowseForm" method="post" action="RemoveUserSearchServlet" onSubmit=" return validateForm()">
                        Browse by:
                        <select name="criteria"> 
                            <option value="all">All</option>
                            <option value="student">Student</option>
                            <option value="professor">Professor</option>
                        </select>
                        &nbsp; For: &nbsp;
                        <input type="text" name="searchString"/>
                        <input type="submit" value="Search" />
                    </form>

    </body>
</html>
