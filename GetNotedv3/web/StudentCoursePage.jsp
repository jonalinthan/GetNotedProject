<%-- 
    Document   : StudentCoursePage
    Created on : Dec 5, 2012, 3:10:48 AM
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
        <p>${numOfCourses}</p>
        <table>
            <tr>
                <td>Currently Taking</td><td>Username</td><td>Course Code</td> <td>Semester</td>
            </tr>
        <c:forEach var ="course" items ="${courseTaken}">
            <tr>
                <c:forEach var = "p" items = "${course}">
                    <td> ${p}</td>
                </c:forEach>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
