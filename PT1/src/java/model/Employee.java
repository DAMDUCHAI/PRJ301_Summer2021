/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Employee {
    private int id;
    private String name,dob;
    private boolean gender;
    private Department department;
    private int dep;

    public Employee() {
    }

 

 

    public Employee(int id, String name, String dob, 
            boolean gender, Department d) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.department = d;
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
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    

    

    
    
}
