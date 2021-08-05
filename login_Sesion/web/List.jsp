<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : List
    Created on : Mar 17, 2021, 6:30:46 PM
    Author     : trinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.acc.user}</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${listE}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.gender}</td>
                        <td>${o.dob}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
