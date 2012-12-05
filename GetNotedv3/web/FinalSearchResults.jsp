<%-- 
    Document   : FinalSearchResults
    Created on : Dec 5, 2012, 6:16:11 AM
    Author     : quantumDrop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:forEach var="p" items="$(searchResult)">
               <p> ${p}<br></p>
        </c:forEach>  
    </body>
</html>
