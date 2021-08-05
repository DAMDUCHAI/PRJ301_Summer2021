
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categories;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Test {

 
//select * from dbo.Categories
    public static void main(String[] args) throws Exception {
            DBContext db = new DBContext();
       
            Connection conn=db.getConnection();
        ResultSet rs=null;
       
            Statement state=null;
            try {
                state = conn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                                rs=state.executeQuery("select * from dbo.Categories");

            while (rs.next()) {
                String pid = rs.getString(1);
                String pname = rs.getString(2);
                String describe = rs.getString(3);

                Categories c = new Categories(pid, pname, describe);
                System.out.println(c.getID() + "       " + c.getName() + "       " + c.getDescribe());
            }

        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
