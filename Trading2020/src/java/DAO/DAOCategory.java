/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
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
public class DAOCategory {

    static ResultSet rs = null;
    static DAOConnection db = new DAOConnection();
    Connection conn = null;

    public Vector<Categories> getAll() throws Exception {
        Vector<Categories> list = new Vector<>();

        db.getConnection();
        ResultSet rs = null;

        Statement state = null;
        try {
            state = db.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("select * from dbo.Categories");

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String describe = rs.getString(3);

                Categories c = new Categories(id, name, describe);
                list.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addCategory(Categories c) throws Exception {

        try {
            String sql = "INSERT INTO dbo.Categories(ID,name,describe)VALUES(?,?,?)";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, c.getID());
            ps.setString(2, c.getName());
            ps.setString(3, c.getDescribe());

            ps.executeUpdate();

        } catch (SQLException ex) {
        }

    }

    public void delete(String id) throws Exception {

        String sql = "DELETE dbo.Categories WHERE ID = ?";
        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Categories SelectById(String id) throws Exception {

        conn = db.getConnection();
        ResultSet rs = null;
        Categories c = new Categories();
        Statement state = null;
        try {
            state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("SELECT * FROM dbo.Categories WHERE ID = '" + id + "'");

            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                String describe = rs.getString(3);

                c = new Categories(pid, pname, describe);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public void update(Categories c) throws Exception {

        String sql = "UPDATE dbo.Categories SET name=?,describe=? WHERE id =?";
        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getDescribe());
            ps.setString(3, c.getID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Vector<Product> getProductsById(String id) throws Exception {
        Vector<Product> list = new Vector<>();

        conn = db.getConnection();
        ResultSet rs = null;

        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement("SELECT * FROM dbo.products WHERE cat_ID= ?");
            ps.setString(1, id);

            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

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

            Product p = new Product(ID, name, cat_ID, image, price, quantity, describe, status, adddate);
            
            list.add(p);
        }

        return list;
    }


}
