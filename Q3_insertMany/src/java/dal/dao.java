/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modal.Skill;

/**
 *
 * @author Admin
 */
public class dao extends DBContext {

    public List<Skill> getAllSkills() throws Exception {
        List<Skill> list = new ArrayList<>();

        ResultSet rs = null;

        Statement state = null;
        try {
            state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery("select * from Skill");

            while (rs.next()) {
                Skill sk = new Skill(rs.getString(1), rs.getString(2));

                list.add(sk);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void insertEmployee(String id, String name, String dob, String gender)  {

        try {
            String sql = "INSERT INTO dbo.Employee ( id, name, dob, gender) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
        public void insertEmployee_Skill(String eid, String sid)  {

        try {
            String sql = "INSERT INTO dbo.Employee_Skill (eid,sid) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, eid);
            ps.setString(2, sid);
           
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

}
