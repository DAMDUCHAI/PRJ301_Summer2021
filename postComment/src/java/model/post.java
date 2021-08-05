/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.dao;
import java.util.List;

/**
 *
 * @author Admin
 */
public class post {
     private int idPost;
    private String contentPost ;

    public post() {
    }
    public post(int idPost, String contentPost) {
        this.idPost = idPost;
        this.contentPost = contentPost;
    }
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }
    public List<comment> getCommentByPost() throws Exception{
        return  dao.getCommentByIdPost(idPost);
        
    }

   
    


}
