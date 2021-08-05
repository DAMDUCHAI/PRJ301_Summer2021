<%-- 
    Document   : list
    Created on : Jun 10, 2021, 9:24:49 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>
        <form action="search" method="POST">
            
        
            ID :<input name="id" type="number">
        <br>
Name :<input name="name" type="text">
 <br>
        Departments <select name="dep" >
                    <option value="0" >-----All-----</option>
                    <c:forEach items="${listD}" var="d">
           
            <option  ${did==d.id?"selected":""} value="${d.id}">${d.name}</option>
            </c:forEach>
                
           
        </select>
         <br>
            <input type="submit" value="search">
             <table border="1px">
                <tr>
                      <th>
                        Id
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Gender
                    </th>   
                    <th>
                        DOB 
                    </th>
                      <th>
                        Department
                    </th>
                </tr>


            <c:forEach items="${listE}" var="e">
                <tr>
                    <td> ${e.id}</td>
                    <td> ${e.name}</td>
                    <td> ${e.dob}</td>
                    <td> ${e.gender} </td>
                    <td> ${e.dept.name}</td>
                     
                </tr>
            </c:forEach>

        </table>
            </form>
    </body>
</html>
