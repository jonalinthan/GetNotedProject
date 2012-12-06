<%-- 
    Document   : addUserSearch
    Created on : Dec 6, 2012, 9:44:00 AM
    Author     : quantumDrop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <div>
                <c:forEach var="AddTarget" items="${users4}">
                    <form method="post" action="AddUserServlet">
                        <input type="hidden" name="AddID" value="${AddTarget.userID}" />
                        <span>User ID: ${AddTarget.userID}</span><br />
                        <span>Username: ${AddTarget.username}</span><br />
                        <span>First Name: ${AddTarget.firstName}</span><br />
                        <span>Last Name: ${AddTarget.lastName}</span><br />
                        <input type="submit" name="checkout" value="Add" />
                    </form>
                </c:forEach>
            </div>
    </body>
</html>