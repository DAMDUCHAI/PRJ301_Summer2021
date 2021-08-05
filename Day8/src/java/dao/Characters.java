/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Characters {
    private String cid;
    private String name;
    private int gender;
    private Date createDate;
    private List<Skill> listS;

    public Characters() {
    }

    public Characters(String cid, String name, int gender, Date createDate, List<Skill> listS) {
        this.cid = cid;
        this.name = name;
        this.gender = gender;
        this.createDate = createDate;
        this.listS = listS;
    }



    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Skill> getListS() {
        return listS;
    }

    public void setListS(List<Skill> listS) {
        this.listS = listS;
    }

    @Override
    public String toString() {
        return "Characters{" + "cid=" + cid + ", name=" + name + ", gender=" + gender + ", createDate=" + createDate + ", listS=" + listS + '}';
    }

    
}
