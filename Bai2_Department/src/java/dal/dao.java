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
import modal.Department;
import modal.Employee;
import org.hibernate.validator.constraints.Email;

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
    
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String query = "select e.*,d.dname from Employees e join Departments d\n"
                + "on e.did = d.did"
                ;
        try {
          PreparedStatement st=new DBContext().getConnection().prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Department d = new Department(rs.getInt(5), rs.getString(6));
                list.add(new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getInt(4), 
                        d));
            }
        } catch (Exception e) {
        }
        return list;
    }
           public List<Employee> getEmployeeByDid(String did) {
        List<Employee> list = new ArrayList<>();
        String query = "select e.*,d.dname from Employees e join Departments d\n"
                + "on e.did = d.did\n"
                + "where e.did = ?";
        try {
            PreparedStatement st=new DBContext().getConnection().prepareStatement(query);
            st.setString(1,did);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Department d = new Department(rs.getInt(5), rs.getString(6));
                list.add(new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getInt(4), 
                        d));
            }
        } catch (Exception e) {
        }
        return list;
    }
          public static void main(String[] args) throws Exception {
              dao db = new dao();
        List<Employee> list  =db.getAllEmployee();
             
              for (Employee e : list) {
                  System.out.println(e);              }
              
    }
}