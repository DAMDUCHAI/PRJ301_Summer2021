

<%@page import="model.Employee"%>
<%@page import="model.Department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a Employee</h1>
        <%
                    Employee e=(Employee) request.getAttribute("e");
                    int id=e.getId();
                    String name=e.getName();
                    String dob=e.getDob();
                    boolean g=e.isGender();
                    int did=e.getDepartment().getId();
        %>            
        <form action="edit" method="post">
            Enter ID: <input type="text" readonly name="id" value="<%= id %>"/><br/>
            Enter Name: <input type="text"  name="name" value="<%= name %>"/><br/>
            Enter DOB: <input type="text"  name="dob" value="<%= dob %>"/><br/>
            Enter Gender: <input type="radio" <%= (g?"checked":"")%> name="gender" value="1"/>Male
                          <input type="radio" <%= (g?"":"checked")%> name="gender" value="0"/>Female
            <br/>
            Select Department:
            <select name="did">
                <jsp:useBean id="d" class="dal.DepartmentDAO"/>
                <%
                    for(Department i:d.getAll()){      
                %>
                <option <%= (i.getId()==did?"selected":"")  %>  value="<%= i.getId() %>"><%= i.getId() %>- <%= i.getName()%></option>
                <% }
                %>
                
            </select>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
