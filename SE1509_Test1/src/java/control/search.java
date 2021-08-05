/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dal.dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import model.Employee;

/**
 *
 * @author Admin
 */
public class search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao db = new dao();
            List<Department> listd = db.getAllDepts();
            List<Employee> liste = db.search(null, null, 0);

            request.setAttribute("listD", listd);
            request.setAttribute("listE", liste);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            dao db = new dao();
            Integer id = null;
            String ide = request.getParameter("id").trim();
            String name = request.getParameter("name").trim();
            String dep = request.getParameter("dep").trim();
            if (ide == null || ide.trim().equals("")) {
                id = null;
            } else {
                id = Integer.parseInt(ide);
            }
            if (name == null || name.trim().equals("")) {
                name = "";
            }
            List<Employee> liste= new ArrayList<>();
            int depart = Integer.parseInt(ide);
            if(depart==0){
             liste = db.search(id, name, 0);

            }
            else{
                            liste = db.search(id, name, depart);

            }
      
            List<Department> listd = db.getAllDepts();

            request.setAttribute("did", dep);
            request.setAttribute("listD", listd);
            request.setAttribute("listE", liste);
            request.getRequestDispatcher("list.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
