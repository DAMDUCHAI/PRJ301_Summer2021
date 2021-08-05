/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Product;

import DAO.DAOCategory;
import DAO.DAOProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categories;
import model.Product;

/**
 *
 * @author Admin
 */
public class addProduct extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        
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
            DAOCategory daoc = new DAOCategory();
            Vector<Categories> list =daoc.getAll();
            request.setAttribute("dtc", list);
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            DAOProduct dao = new DAOProduct();                        
            String ID=request.getParameter("idp");
            String name=request.getParameter("name");
            String cat_ID=request.getParameter("idc");
            String image=request.getParameter("img");
            float price=Float.parseFloat(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            String describe=request.getParameter("describe");
            String status=request.getParameter("status");
            String adddate=request.getParameter("date");
            request.setAttribute("dt", cat_ID);
            Product p = new Product(ID, name, cat_ID, image, price, quantity, describe, status, adddate);
            dao.addProduct(p);
            response.sendRedirect("showProduct?id="+request.getParameter("idc"));
            //request.getRequestDispatcher("showProduct?id="+request.getParameter("idc")).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
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
