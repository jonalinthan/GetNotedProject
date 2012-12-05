<%-- 
    Document   : GetNotes
    Created on : Dec 4, 2012, 11:48:17 PM
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
        <button type="button" action ="sortVotesServlet">Sort on Net Votes</button>
        <button type="button" action ="sortIdServlet">Sort on Note Id</button>

        <table>
            <tr>
                <td>Name on Note</td>
                <td>User</td>
                <td>Topic</td>
                <td>Class</td>
                <td>Content</td>
                <td>Net Votes</td>
                <td>Rating</td>
            </tr>
            <c:forEach var="p" items="$(notes)">
                <tr>
                     <c:forEach var="q" items="p">
                         <td> ${q}</td>
                     </c:forEach>
                 </tr>
            </c:forEach>   
        </table>
    </body>
</html>
