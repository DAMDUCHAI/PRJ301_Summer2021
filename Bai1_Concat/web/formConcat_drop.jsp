<%-- 
    Document   : formConcat
    Created on : Mar 25, 2021, 11:10:34 PM
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
        <form action="a">
        First:<input type="text" name="f" value="" />
        <br>
        Second:<input type="text" name="s" value="" />
        <br>
        Operator :<select name="o">
            <option value="1">Concats</option>
            <option value="2">Contains</option>
        </select>
         <br>
         <input type="submit" value="Submit" />
         </form>
    </body>
</html>
