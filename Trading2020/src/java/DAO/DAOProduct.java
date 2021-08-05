/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAOCategory.db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import model.Categories;
import model.Product;

/**
 *
 * @author Admin
 */
public class DAOProduct {
     public Vector<Product> getAllProduct() throws Exception {
        Vector<Product> list = new Vector<>();

        db.getConnection();
        ResultSet rs = null;

        Statement state = null;
        try {
            state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("SELECT * FROM dbo.products");

            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String cat_ID = rs.getString(3);
                String image = rs.getString(4);
                float price = rs.getFloat(5);
                int quantity = rs.getInt(6);
                String describe = rs.getString(7);
                String status = rs.getString(8);
                String adddate = rs.getString(9);

Product p= new Product(ID, name, cat_ID, image, price, quantity, describe, status, adddate);
        list.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addProduct(Product p) throws Exception {

        try {
            String sql = "INSERT INTO dbo.products ( ID,name, cat_ID, image, price, quantity, describe, status, adddate) VALUES(?, ?, ?,?, ?, ?,?,?,? )";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, p.getID());
            ps.setString(2, p.getName());
            ps.setString(3, p.getCat_ID());
            ps.setString(4, p.getImage());
            ps.setFloat(5, p.getPrice());
            ps.setInt(6, p.getQuantity());
            ps.setString(7, p.getDescribe());
            ps.setString(8, p.getStatus());
            ps.setString(9, p.getAdddate());

            ps.executeUpdate();

        } catch (SQLException ex) {
        }

    }

    public void deleteProduct(String id) throws Exception {

        String sql = "DELETE dbo.products WHERE ID= ?";
        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Product selectProductById(String id) throws Exception {
        ResultSet rs = null;
        Product p = new Product();
        Statement state = null;
        try {
            state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("SELECT * FROM dbo.products WHERE ID = '" + id + "'");

            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String cat_ID = rs.getString(3);
                String image = rs.getString(4);
                float price = rs.getFloat(5);
                int quantity = rs.getInt(6);
                String describe = rs.getString(7);
                String status = rs.getString(8);
                String adddate = rs.getString(9);

                p = new Product(ID, name, cat_ID, image, price, quantity, describe, status, adddate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public void updateProduct(Product p) throws Exception {

        String sql = "UPDATE dbo.products SET name=?,cat_ID=?,image=?,price=?,quantity=?,describe=?,status=?,adddate=? WHERE ID=?";
        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setString(2, p.getCat_ID());
            ps.setString(3, p.getImage());
            ps.setFloat(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setString(6, p.getDescribe());
            ps.setString(7, p.getStatus());
            ps.setString(8, p.getAdddate());
            ps.setString(9, p.getID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
     public Vector<Product> sortProductByPrice() throws Exception {
        Vector<Product> list = new Vector<>();

        db.getConnection();
        ResultSet rs = null;

        Statement state = null;
        try {
            state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("SELECT * FROM dbo.products ORDER BY price");

            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String cat_ID = rs.getString(3);
                String image = rs.getString(4);
                float price = rs.getFloat(5);
                int quantity = rs.getInt(6);
                String describe = rs.getString(7);
                String status = rs.getString(8);
                String adddate = rs.getString(9);

Product p= new Product(ID, name, cat_ID, image, price, quantity, describe, status, adddate);
        list.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        DAOProduct dp = new DAOProduct();
       Vector<Product> list = dp.sortProductByPrice();
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
