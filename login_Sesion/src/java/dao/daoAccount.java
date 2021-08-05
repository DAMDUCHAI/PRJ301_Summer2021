/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.account;
import modal.employee;

/**
 *
 * @author Admin
 */
public class daoAccount {

    public account getAccount(String name, String pass) throws Exception {
        List<account> list = new ArrayList<>();
        String sql = "select * from Account where username=? and [password] =?";
        try {
            PreparedStatement st = new DBContext().getConnection().prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new account(rs.getString(1), rs.getString(2));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }

    public List<employee> getEmployeeByCreate(String created) throws Exception {
        List<employee> list = new ArrayList<>();
        String sql = "select * from Employee where createdby =?";
        try {
            PreparedStatement st = new DBContext().getConnection().prepareStatement(sql);
            st.setString(1, created);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
                list.add(new employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }

  
}
