

<%@page import="model.Department"%>
<%@page import="java.util.List"%>
<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form id="f1" action="list" method="get">
            <% 
               Integer ddid=(Integer)request.getAttribute("did");
            %>
        <h2>Department:    
            <select name="did" 
                    onchange="document.getElementById('f1').submit();">
                <option value="0">---------ALL--------</option>
            <jsp:useBean id="d" class="dal.DepartmentDAO"/>
            <% 
               for (Department i:d.getAll()) { 
                     int did=i.getId();
                     String name=i.getName();
            %>
            <option <%= ddid==did?"selected":"" %>
                value="<%= did %>"><%= did %>-<%= name %></option>
            <%            
                }
            %>
        </select>
        </h2>
        </form>
                                    <a  onclick="doAdd();">Add a Employee</a>

        <h1>List of employees</h1>
        <table border="1px" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Action</th>
            </tr>
            <%
                List<Employee> list=(List<Employee>)request.getAttribute("data");
                for(Employee i:list){
            %>
            <tr>
                <td><%= i.getId() %></td>
                <td><%= i.getName()%></td>
                <td><%= i.getDob()%></td>
                <td><img src="<%= i.isGender()?"images/male-icon.png":
                        "images/female-icon.png"%>" /></td>
                <td><%= i.getDepartment().getName()%></td>
                <td><a href="edit?id=<%= i.getId() %>">Edit</a> &nbsp;&nbsp;&nbsp;
                    <a  onclick="doDelete('<%= i.getId() %>');">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
<script>
    function doAdd() {
                window.location="add.jsp";
           
        }
</script>    
<script>
    function doDelete(id) {
            if (confirm("Are you sure to delete Employee ID= "+id+"?")) {
                window.location.r="delete?id="+id;
            }
        }
</script>    
