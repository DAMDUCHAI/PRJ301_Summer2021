/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
//  ID varchar(6) primary key,
//   [name] nvarchar(30) ,
//   describe nvarchar(50), 
public class Categories {
    private String ID;
    private String name;
    private String describe;

    public Categories() {
    }

    public Categories(String ID, String name, String describe) {
        this.ID = ID;
        this.name = name;
        this.describe = describe;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
}
