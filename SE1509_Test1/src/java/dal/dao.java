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
import model.Department;
import model.Employee;

/**
 *
 * @author Admin
 */
public class dao {

    public List<Department> getAllDepts() throws Exception {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Department";
        try {
            PreparedStatement st = new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Department d = new Department(rs.getInt(1), rs.getString(2));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Employee> search(Integer id, String name, int did) throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "select e.id,e.name,e.gender,e.dob,e.did,d.name as dname  \n"
                + "   from  Employee e inner join Department d on (d.id=e.did)\n"
                + "where (1=1)";
       
        try {
            if (id != null) {
                sql += " AND e.id = " + id;
                
            }
            if (name != null && !name.equals("")) {
                sql += " AND e.name LIKE '%" + name + "%'";
            }
            if (did > 0) {
                sql += " AND e.did = " + did;
            }
            PreparedStatement st = new DBContext().getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Department d = new Department(rs.getInt(5), rs.getString(6));
                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(4), rs.getBoolean(3), d);
                list.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public static void main(String[] args) throws Exception {
        dao d = new dao();
         List<Employee> liste = d.search(null,"",0);
         for (Employee e : liste) {
            System.out.println(e);
        }
    }
}
