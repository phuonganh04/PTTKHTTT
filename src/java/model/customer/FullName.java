/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.customer;

/**
 *
 * @author Admin
 */
public class FullName {
    private String fisrtName;
    private String lastName;
    private int id;
    private int customerid;
    

    public FullName() {
    }

    public FullName(String fisrtName, String lastName, int id, int customerid) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.id = id;
        this.customerid = customerid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

   

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return fisrtName + " " + lastName;
    }
}
