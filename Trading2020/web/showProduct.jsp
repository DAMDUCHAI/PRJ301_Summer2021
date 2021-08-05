<%-- 
    Document   : showProduct
    Created on : Jan 17, 2021, 12:04:39 PM
    Author     : Admin
--%>
<%@page import="model.Product"%>
<%@page import="java.util.Vector"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Product Page</title>
    </head>
    <body>
        <a href="addProduct">Add New Product</a>
<br/>
        <a href="showAll">All Product</a>
<!--        <form  method="post" action="showProduct"> -->
            <table border="1px">
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        Name
                    </th>   
                    <th>
                        cat ID 
                    </th>
                    <th>
                        image
                    </th>
                    <th>
                        price
                    </th>
                    <th>
                        quantity
                    </th>
                    <th>
                        describe
                    </th>
                    <th>
                        status 
                    </th>
                    <th>
                        add Date
                    </th>

                </tr>


                <c:forEach items="${requestScope.dt}" var="l">
                    <tr>
                        <td> ${l.getID()}</td>
                        <td> ${l.getName()}</td>
                        <td> ${l.getCat_ID()}</td>
                        <td> ${l.getImage()}</td>
                        <td> ${l.getPrice()}</td>
                        <td> ${l.getQuantity()}</td>
                        <td> ${l.getDescribe()}</td>
                        <td> ${l.getStatus()}</td>
                        <td> ${l.getAdddate()}</td>


                        <td>   <a href="deleteProduct?pid=${l.getID()}&&id=${l.getCat_ID()}">Delete</a>   </td> 
                        <td></td>
                        <td>   <a href="updateProduct?pid=${l.getID()}">Update</a>   </td> 
                        <td></td>

                    </tr>
                </c:forEach>

            </table>
<!--        </form>-->
    </body>
</html>
