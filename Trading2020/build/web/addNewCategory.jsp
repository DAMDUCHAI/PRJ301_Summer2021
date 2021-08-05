<%-- 
    Document   : addNewCategory
    Created on : Jan 16, 2021, 12:11:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Add New Category</title>
    </head>
    <body>
        <h1>Add New Category</h1>

        <form name="f1" method="post" action="add"> 

            Input ID Category  :  <input type="text"  name="id" 
                                         placeholder="ID" value="" required  />
            <br/>
            <br/>
            Input Name Category :  <input type="text" name="name" 
                                          placeholder="Name " value="" required />
            <br/>
            <br/>
            Input describe  Category :  <input type="text" name="describe" 
                                               placeholder="describe" value="" required />
            <br/>
            <input type="submit" value="Add New"/>
            <form/>

    </body>
</html>
