<%-- 
    Document   : DepartmentAverage
    Created on : Dec 5, 2012, 6:36:15 AM
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
    <c:forEach var= "k" items="${dptavg}">
        <p> ${k}<br /></p>
    </c:forEach>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
