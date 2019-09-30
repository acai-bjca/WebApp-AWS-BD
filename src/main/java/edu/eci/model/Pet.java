/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.model;

/**
 *
 * @author cristian
 */
public class Pet {
    private String name;
    private String owner;
    private int age;
    private String phone;
    
    public Pet(){}
    
    public Pet(String name, String owner, int age, String phone){
        this.name=name;
        this.owner=owner;
        this.age=age;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    } 

    public boolean containsKey(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
