<%-- 
    Document   : listBuddies
    Created on : Dec 4, 2012, 12:59:54 AM
    Author     : aaronmeltzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <c:forEach var="p" items="${buddyList}">
        <p>
            ${p}<br>
        </p>
        </c:forEach>
    </head>
    <body>
        
    </body>
</html>
