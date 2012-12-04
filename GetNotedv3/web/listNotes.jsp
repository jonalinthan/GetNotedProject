<%-- 
    Document   : listNotes
    Created on : Dec 4, 2012, 2:47:01 AM
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
        <c:forEach var="p" items="$(profCourses)">
               <p> ${p}<br></p>
        </c:forEach>  
    </body>
</html>
