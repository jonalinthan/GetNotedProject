<%-- 
    Document   : removeUserSearch
    Created on : Dec 6, 2012, 2:30:18 AM
    Author     : Jonathan
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
                <c:forEach var="removeTarget" items="${users}">
                    <form method="post" action="RemoveUserServlet">
                        <input type="hidden" name="removeID" value="${removeTarget.userID}" />
                        <span>User ID: ${removeTarget.userID}</span><br />
                        <span>Username: ${removeTarget.username}</span><br />
                        <span>First Name: ${removeTarget.firstName}</span><br />
                        <span>Last Name: ${removeTarget.lastName}</span><br />
                        <input type="submit" name="checkout" value="Remove" />
                    </form>
                </c:forEach>
            </div>
    </body>
</html>
