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
import model.comment;
import model.post;

/**
 *
 * @author Admin
 */
public class dao {
        public static List<post> getAllPost() throws Exception{
        List<post> list=new ArrayList<>();
        String sql="select id,content from Post order by id asc";
        try{
            PreparedStatement st=new DBcontext().connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                post p=new post(rs.getInt(1),rs.getString(2));
                
                list.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
                public static List<comment> getCommentByIdPost(int idPost) throws Exception{
        List<comment> list=new ArrayList<>();
        String sql="select * from Comment  where pid =? order by id asc";
        try{
            PreparedStatement st=new DBcontext().connection.prepareStatement(sql);
            st.setInt(1, idPost);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                comment c=new comment(rs.getInt(1),rs.getString(2),rs.getInt(3));
                
                list.add(c);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return list;
    }
                    public static int insertCommnet(String content, int pid) {
        String sql = "insert [Comment] ([content],[pid]) values(?,?)";
        try {
            PreparedStatement st = new DBcontext().connection.prepareStatement(sql);
            st.setString(1, content);
            st.setInt(2, pid);
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
                    public static void main(String[] args) throws Exception {
        List<post> listP= dao.getAllPost();
                        for (post p : listP) {
                            System.out.println(p);
                        }
    }
}
