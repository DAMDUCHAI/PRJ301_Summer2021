<%-- 
    Document   : updateProduct
    Created on : Jan 17, 2021, 9:29:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Product</title>
    </head>
    <body>

        <h1>Update Product</h1>

      
        <form   action="updateProduct" method="post"> 

            ID Product  :  <input type="text"  name="idp" 
                                  value="${requestScope.dt.ID}" readonly  />
            <br/>
            <br/>
            Input Name Product  :  <input type="text" name="name" 
                                          " value="${requestScope.dt.name}" required />
            <br/>
            <br/>
            Input ID Category :  <input type="text" name="idc" 
                                        value="${requestScope.dt.cat_ID}"  readonly/>
            <br/>
            <br/>
            Image  :  <input type="text"  name="img" 
                             value="${requestScope.dt.image}"  required />
            <br/>
            <br/>
            Price  :  <input type="text"  name="price" 
                             value="${requestScope.dt.price}"  required />
            <br/>
            <br/>
            Quantity  :  <input type="text"  name="quantity" 
                                value="${requestScope.dt.quantity}" required  />
            <br/>
            <br/>
            Describe  :  <input type="text"  name="describe" 
                                value="${requestScope.dt.describe}" required  />
            <br/>
            <br/>
            Status  :  <input type="text"  name="status" 
                              value="${requestScope.dt.status}" required  />
            <br/>
            <br/>
            Add Date  :  <input type="text"  name="date" 
                                value="${requestScope.dt.adddate}" required  />
            <br/>
            <br/>
            <input type="submit" value="Update Product"/>
        </form>   
    </body>
</html>
