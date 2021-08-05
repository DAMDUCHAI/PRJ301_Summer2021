<%-- 
    Document   : Home
    Created on : Jan 16, 2021, 12:32:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="d" class="DAO.DAOCategory" scope="request"></jsp:useBean>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home Page</title>
        </head>
        <body>
            <h1>The List of Categories</h1>
                    <a href="showAll">All Product</a>
                    <br/>
                    
            <a href="addNewCategory.jsp">AddNew</a>
              <br/>
            <a href="sort">Sort by price increment</a>
            <table border="1px">
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        Name
                    </th>   
                    <th>
                        Describe 
                    </th>
                    
                </tr>


            <c:forEach items="${d.getAll()}" var="l">
                <tr>
                    <td> ${l.getID()}</td>
                    <td> ${l.getName()}</td>
                    <td> ${l.getDescribe()}</td>
                    <td> 
                    <td>   <a href="delete?id=${l.getID()}">Delete</a>   </td> 

                    <td>   <a href="update?id=${l.getID()}">Edit</a></td> 
                    <td><td>
                      <td>   <a href="showProduct?id=${l.getID()}">Show Product</a></td> 
                    </td>   
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
