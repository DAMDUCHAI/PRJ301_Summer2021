/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Skill> getAllSkill(String cid){
        List<Skill> list = new ArrayList<>();
        String query = "SELECT skills.* FROM Character_Skill INNER JOIN Skills ON \n" +
"Skills.[sid] = Character_Skill.[sid] WHERE cid=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Skill(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Characters> getAllCharacter(){
        List<Characters> list = new ArrayList<>();
        String query = "SELECT * FROM Characters ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                String cid = rs.getString(1);
                String name= rs.getString(2);
                int gender= rs.getInt(3);
                Date date= rs.getDate(4);
                DAO dao = new DAO();
                List<Skill> listS = dao.getAllSkill(cid);
                list.add(new Characters(cid, name, gender, date, listS));
            }
        } catch (Exception e) {
        }
        return list;
  
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Skill> list = dao.getAllSkill("superman");
//        List<Skill> list = dao.getAll("superman"));
List<Characters> listS= dao.getAllCharacter();
        for (Characters characters : listS) {
            System.out.println(listS);
        }
    }
}
