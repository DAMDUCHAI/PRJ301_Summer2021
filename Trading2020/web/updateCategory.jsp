<%-- 
    Document   : updateCategory
    Created on : Jan 16, 2021, 10:35:03 PM
    Author     : Admin
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Page</title>
    </head>
    <body>
        <h1>Update Category</h1>

        <form  method="post" action="update"> 

           ID Category  :  <input type="text"  name="id" 
                                  placeholder="ID" value="${requestScope.dt.ID} " readonly  />
            <br/>
            <br/>
            Input Name Category to Update :  <input type="text" name="name" 
                                                    placeholder="Name " value="${requestScope.dt.name}" required />
            <br/>
            <br/>
            Input describe  Category to Update:  <input type="text" name="describe" 
                                                        placeholder="describe" value="${requestScope.dt.describe}" required />
            <br/>
            <input type="submit" value="Update"/>
            </form>    
  </body>
</html>
