
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;


public class DepartmentDAO extends DBContext{
    public List<Department> getAll(){
        List<Department> list=new ArrayList<>();
        String sql="select * from Department";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
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
    public Department getDepByID(int id){
        
        String sql="select * from Department where id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                return new Department(rs.getInt(1),rs.getString(2));
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
}
