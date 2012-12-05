<%-- 
    Document   : questionBank.jsp
    Created on : Dec 4, 2012, 3:21:08 AM
    Author     : quantumDrop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Bank</title>
    </head>
    <body>
    <c:forEach var="qb" items="$(questionBankquestions)">
        <p> ${qb}<br></p>
    </c:forEach>
    </body>
</html>