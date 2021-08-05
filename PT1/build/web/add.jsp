<%-- 
    Document   : add
    Created on : Feb 6, 2021, 11:45:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <h1>Add a Employee</h1>

        <form action="add" method="post">
            Enter ID: <input type="text"  name="id"><br/>
            Enter Name: <input type="text"  name="name" ><br/>
            Enter DOB: <input type="text"  name="dob" ><br/>
            Enter Gender: <input type="radio"  name="gender" />Male
            <input type="radio"  name="gender" value="0"/>Female
            <br/>
            Select Department:
            <select name="did">
                <jsp:useBean id="d" class="dal.DepartmentDAO"/>
                <c:forEach items="${d.all}" var="l">
                <option   value="${l.id}">${l.name}</option>
            </c:forEach>

            </select>
                            <br/>

            <input type="submit" value="Update"/>
        </form>    </body>
</html>
