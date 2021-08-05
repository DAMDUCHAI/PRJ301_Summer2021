/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Product {

    private String ID;
    private String name;
    private String cat_ID;
    private String image;
    private float price;
    private int quantity;
    private String describe;
    private String status;
    private String adddate;

    public Product(String ID, String name, String cat_ID, String image, float price, int quantity, String describe, String status, String adddate) {
        this.ID = ID;
        this.name = name;
        this.cat_ID = cat_ID;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.status = status;
        this.adddate = adddate;
    }

    public Product() {
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

    public String getCat_ID() {
        return cat_ID;
    }

    public void setCat_ID(String cat_ID) {
        this.cat_ID = cat_ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", name=" + name + ", cat_ID=" + cat_ID + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", describe=" + describe + ", status=" + status + ", adddate=" + adddate + '}';
    }


    

}
