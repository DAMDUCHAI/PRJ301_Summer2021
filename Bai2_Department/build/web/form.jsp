<%-- 
    Document   : form
    Created on : Mar 24, 2021, 3:23:40 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="list" method="POST">
        Departments <select name="d" onchange="this.form.submit()">
                    <option value="0" >-----------</option>
            <c:forEach items="${listD}" var="d">
           
        <br>     <option ${did==d.did?"selected":""} value="${d.did}">${d.dname}</option>
            </c:forEach>
                
           
        </select>
        Students :
        <table border="1px">
                <tr>
                      <th>
                        Id
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        Dob
                    </th>   
                    <th>
                        Gender 
                    </th>
                      <th>
                        Department_Name 
                    </th>
                </tr>


            <c:forEach items="${listE}" var="e">
                <tr>
                    <td> ${e.id}</td>
                    <td> ${e.name}</td>
                    <td> ${e.dob}</td>
                    <td> 
                       
                        <c:if test="${e.gender==1}">
                            <img src="images/male-icon.png" alt="">
                        </c:if>
                               <c:if test="${e.gender==0}">
                            <img src="images/female-icon.png" alt="">
                        </c:if>
                    </td>
                    <td> ${e.d.dname}</td>
                     
                </tr>
            </c:forEach>

        </table>
        </form>
    </body>
</html>
