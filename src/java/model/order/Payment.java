/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Payment {

    private int id;
    private String method;
    private int shipmentID;
    private int orderID;
    private int cartID;
    private String name;
    private String Bankid;
    private int number;
    private String type;
    private Date expdate;

    public Payment() {
    }

    public Payment(int id, String method, int shipmentID, int orderID, int cartID, String name, String Bankid, int number, String type, Date expdate) {
        this.id = id;
        this.method = method;
        this.shipmentID = shipmentID;
        this.orderID = orderID;
        this.cartID = cartID;
        this.name = name;
        this.Bankid = Bankid;
        this.number = number;
        this.type = type;
        this.expdate = expdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankid() {
        return Bankid;
    }

    public void setBankid(String Bankid) {
        this.Bankid = Bankid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }
    
    
}
