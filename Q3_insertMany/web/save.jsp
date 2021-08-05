<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : save
    Created on : Mar 16, 2021, 4:03:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="POST" >
            ID<input type="text" name="id" value="" />
            <br>
            Name<input type="text" name="name" value="" />
            <br>
            Gender<input type="radio" name="gender" value="1" />Male
            <input type="radio" name="gender" value="0" />Female
            <br>
            Dob<input type="text" name="dob" value="" />

            <br>
            Skills:
            <br>
            <c:forEach items="${listSk}" var="sk">
                <input type="checkbox" name="skill" value="${sk.id}" />${sk.name}
                <br>

            </c:forEach>
            <br>
            <input type="submit" value="Insert" />
        </form>
    </body>
</html>
