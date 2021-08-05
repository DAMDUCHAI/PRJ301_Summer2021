package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add New Product</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Update Product</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form   action=\"updateProduct\" method=\"post\"> \n");
      out.write("\n");
      out.write("            ID Product  :  <input type=\"text\"  name=\"idp\" \n");
      out.write("                                  required  />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Input Name Product  :  <input type=\"text\" name=\"name\" \n");
      out.write("                                          required />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Input ID Category :  <input type=\"text\" name=\"idc\" \n");
      out.write("                                        readonly/>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Image  :  <input type=\"text\"  name=\"img\" \n");
      out.write("                             required />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Price  :  <input type=\"text\"  name=\"price\" \n");
      out.write("                             required />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Quantity  :  <input type=\"text\"  name=\"quantity\" \n");
      out.write("                                required  />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Describe  :  <input type=\"text\"  name=\"describe\" \n");
      out.write("                                required  />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Status  :  <input type=\"text\"  name=\"status\" \n");
      out.write("                              required  />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Add Date  :  <input type=\"text\"  name=\"date\" \n");
      out.write("                                required  />\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Add Product\"/>\n");
      out.write("        </form>   \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
