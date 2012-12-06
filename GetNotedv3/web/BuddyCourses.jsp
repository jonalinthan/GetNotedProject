<%-- 
    Document   : BuddyCourses
    Created on : Dec 5, 2012, 4:21:14 AM
    Author     : aaronmeltzer
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
        <table>
            <tr>
                <td>Buddy Name</td><td>Buddy Course</td>
            </tr>
        <c:forEach var="p" items="${buddyCourses}">
            <tr>
                <c:forEach var="q" items ="${p}">
                    <td>${q}</td>
                </c:forEach>
            </tr>
        </c:forEach>  
        </table>
    </body>
</html>
