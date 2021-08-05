/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ACER
 */
public class Employee {
    private int id;
    private String name;
    private Date dob;
    private int gender;
    private Department d;

    public Employee() {
    }

    public Employee(int id, String name, Date dob, int gender, Department d) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        return df.format(dob);
//        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Department getD() {
        return d;
    }

    public void setD(Department d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", d=" + d + '}';
    }

    
    
}
