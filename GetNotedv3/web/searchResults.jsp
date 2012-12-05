<%-- 
    Document   : searchResults
    Created on : Dec 5, 2012, 5:55:45 AM
    Author     : aaronmeltzer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Browse for Books</h2>
             <p>Please choose a criteria. Keyword is optional.</p>
                    <form name="BrowseForm" method="post" action="SearchServlet" onSubmit=" return validateForm()">
                        Browse by:
                        <select name="criteria"> 
                            <option value="notes">Note</option>
                            <option value="user">Username</option>
                        </select>
                        &nbsp; For: &nbsp;
                        <input type="text" name="searchString"/>
                        <input type="submit" value="Search" />
                    </form>
    </body>
</html>

