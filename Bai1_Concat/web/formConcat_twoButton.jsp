<%-- 
    Document   : formConcat_twoButton
    Created on : Mar 26, 2021, 12:24:53 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script type="text/javascript">
    function run(id){
       document.f.action="b?id="+id;
       document.f.submit();
    }
    </script>    
    </head>
    <body>
        <form name="f" action="" method="POST">
        First:<input type="text" name="f" value="" />
        <br>
        Second:<input type="text" name="s" value="" />
        <br>
        Operator :<input type="submit" value="Concat" onclick="run('concat')" />
        <input type="submit" value="Contains" onclick="run('contains')"/>
         <br>
      
         </form>
    </body>
</html>
