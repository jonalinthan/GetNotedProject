<%-- 
    Document   : AverageNoteClasses
    Created on : Dec 5, 2012, 7:17:08 AM
    Author     : aaronmeltzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Average note: </h1>
        <c:forEach var="p" items="${avgnotes}">
               <p> ${p}<br></p>
        </c:forEach>        
    </body>
</html>
