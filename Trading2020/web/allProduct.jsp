<%-- 
    Document   : allProduct
    Created on : Jan 19, 2021, 9:01:17 AM
    Author     : Admin
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>all Product</title>
    </head>
    <body>

        <form   action="showAll"> 
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
                        <td> ${l.ID}</td>
                        <td> ${l.name}</td>
                        <td> ${l.cat_ID}</td>
                        <td> ${l.image}</td>
                        <td> ${l.price}</td>
                        <td> ${l.quantity}</td>
                        <td> ${l.describe}</td>
                        <td> ${l.status}</td>
                        <td> ${l.adddate}</td>

                        <td>   <a href="deleteProduct?pid=${l.getID()}" name="delete" value="a""">Delete</a>   </td> 
                        <td></td>
                        <td>   <a href="updateProduct?pid=${l.getID()}" name="update">Update</a>   </td> 
                        <td></td>


                    </tr>
                </c:forEach>

            </table>
        </form>
    </body>
</html>
