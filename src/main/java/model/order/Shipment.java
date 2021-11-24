/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

/**
 *
 * @author Admin
 */
public class Shipment {

    private String address;
    private String shipmethod;
    private double cost;
    private int id;
    private int orderId;

    public Shipment() {
    }

    public Shipment(String address, String shipmethod, double cost, int id, int orderId) {
        this.address = address;
        this.shipmethod = shipmethod;
        this.cost = cost;
        this.id = id;
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipmethod() {
        return shipmethod;
    }

    public void setShipmethod(String shipmethod) {
        this.shipmethod = shipmethod;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
