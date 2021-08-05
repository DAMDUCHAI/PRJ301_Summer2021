<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : forminsert
    Created on : Mar 24, 2021, 10:38:32 PM
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
        <form action="add" method="POST">
        <table>
            <tr>
            <td>Name:</td>
            <td> <input type="text" name="name" value="" /></td>
        </tr>
        <tr>
        <td>Date:</td>
        <td><input type="text" name="dob" value="" placeholder="dd/mm/yyyy" /> (yyyy-MM-dd)</td>
    </tr>
<tr>
   <td> Gender:</td>
   <td> <input type="radio" name="gender" value="" />Male <input type="radio" name="gender" value="" />Female</td>
    </tr>
    <tr>
    <td>Departments:</td> 
    <td><select name="dp">
        <c:forEach var="d" items="${listD}">
            <option value="${d.did}">${d.dname}</option>

        </c:forEach>
       
    </select></td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input type="submit" value="Save" />
        </td>
    </tr>
</table>
            
            </form>
</body>
</html>
