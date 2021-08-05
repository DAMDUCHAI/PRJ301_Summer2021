<%-- 
    Document   : addProduct
    Created on : Jan 18, 2021, 12:31:38 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Product</title>
    </head>
    <body>
        <h1>Add new Product</h1>


        <form   action="addProduct" method="post"> 

            ID Product  :  <input type="text"  name="idp" 
                                  required  />
            <br/>
            <br/>
            Input Name Product  :  <input type="text" name="name" 
                                          required />
            <br/>
            <br/>
            ID Category : <select name="idc">
                <c:forEach items="${requestScope.dtc}" var="l">
                    <option value="${l.ID}">${l.name}</option>
                </c:forEach>
            </select>
            <br/>
            <br/>
            Image  :  <input type="text"  name="img" 
                             required />
            <br/>
            <br/>
            Price  :  <input type="text"  name="price" 
                             required />
            <br/>
            <br/>
            Quantity  :  <input type="text"  name="quantity" 
                                required  />
            <br/>
            <br/>
            Describe  :  <input type="text"  name="describe" 
                                required  />
            <br/>
            <br/>
            Status  :  <input type="text"  name="status" 
                              required  />
            <br/>
            <br/>
            Add Date  :  <input type="text"  name="date" 
                                required  />
            <br/>
            <br/>
            <input type="submit" value="Add Product"/>
        </form>   

    </body>
</html>
