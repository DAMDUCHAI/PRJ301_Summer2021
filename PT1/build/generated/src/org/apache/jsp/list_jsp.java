package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Department;
import java.util.List;
import model.Employee;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form id=\"f1\" action=\"list\" method=\"get\">\n");
      out.write("            ");
 
               Integer ddid=(Integer)request.getAttribute("did");
            
      out.write("\n");
      out.write("        <h2>Department:    \n");
      out.write("            <select name=\"did\" \n");
      out.write("                    onchange=\"document.getElementById('f1').submit();\">\n");
      out.write("                <option value=\"0\">---------ALL--------</option>\n");
      out.write("            ");
      dal.DepartmentDAO d = null;
      synchronized (_jspx_page_context) {
        d = (dal.DepartmentDAO) _jspx_page_context.getAttribute("d", PageContext.PAGE_SCOPE);
        if (d == null){
          d = new dal.DepartmentDAO();
          _jspx_page_context.setAttribute("d", d, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("            ");
 
               for (Department i:d.getAll()) { 
                     int did=i.getId();
                     String name=i.getName();
            
      out.write("\n");
      out.write("            <option ");
      out.print( ddid==did?"selected":"" );
      out.write("\n");
      out.write("                value=\"");
      out.print( did );
      out.write('"');
      out.write('>');
      out.print( did );
      out.write('-');
      out.print( name );
      out.write("</option>\n");
      out.write("            ");
            
                }
            
      out.write("\n");
      out.write("        </select>\n");
      out.write("        </h2>\n");
      out.write("        </form> \n");
      out.write("        <h1>List of employees</h1>\n");
      out.write("        <table border=\"1px\" width=\"40%\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>DOB</th>\n");
      out.write("                <th>Gender</th>\n");
      out.write("                <th>Department</th>\n");
      out.write("                <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                List<Employee> list=(List<Employee>)request.getAttribute("data");
                for(Employee i:list){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( i.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( i.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( i.getDob());
      out.write("</td>\n");
      out.write("                <td><img src=\"");
      out.print( i.isGender()?"images/male-icon.png":
                        "images/female-icon.png");
      out.write("\" /></td>\n");
      out.write("                <td>");
      out.print( i.getDepartment().getName());
      out.write("</td>\n");
      out.write("                <td><a href=\"edit?id=");
      out.print( i.getId() );
      out.write("\">Edit</a> &nbsp;&nbsp;&nbsp;\n");
      out.write("                    <a href=\"#\" onclick=\"doDelete('");
      out.print( i.getId() );
      out.write("');\">Delete</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<script>\n");
      out.write("    function doDelete(id) {\n");
      out.write("            if (confirm(\"Are you sure to delete Employee ID= \"+id+\"?\")) {\n");
      out.write("                window.location=\"delete?id=\"+id;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("</script>    \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
