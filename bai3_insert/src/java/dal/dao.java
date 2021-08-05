/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Department;


/**
 *
 * @author Admin
 */
public class dao {
     public List<Department> getAll() throws Exception{
        List<Department> list=new ArrayList<>();
        String sql="select * from Departments";
        try{
            PreparedStatement st=new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Department d=new Department(rs.getInt(1),rs.getString(2));
                list.add(d);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
       public boolean insertEmployee(String name,String dob,String gender,String did) throws Exception {
        try {
            String sql = "INSERT INTO [dbo].[Employees]([ename] ,[edob],[egender] ,[did]) VALUES (?,?,?,?)";
            PreparedStatement st = new DBContext().getConnection().prepareStatement(sql);
            st.setString(1, name);
            st.setString(2,dob);
            st.setString(3, gender);
            st.setString(4, did);
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex);        }
        return false;
    }
    
    
  
}