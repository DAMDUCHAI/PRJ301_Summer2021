<%-- 
    Document   : load
    Created on : Dec 23, 2020, 7:12:00 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="d" class="dao.DAO"></jsp:useBean>
        </head>
        <body>
            <table border="1px solid black">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date</th>
                    <th>Skills</th>
                </tr>
            <c:forEach items="${d.allCharacter}" var="o">
                <tr>
                    <td>${o.cid}</td>
                    <td>${o.name}</td>
                    <td>${o.gender}</td>
                    <td>${o.createDate}</td>
                    <td>
                        <c:forEach items="${o.listS}" var="x">
                            ${x.name}<br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
