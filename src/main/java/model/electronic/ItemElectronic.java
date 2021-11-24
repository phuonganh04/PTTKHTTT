/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.electronic;

import model.*;

/**
 *
 * @author Admin
 */
public class ItemElectronic {
    private int id;
    private double price;
    private String barcode;

    public ItemElectronic(int id, double price, String barcode) {
        this.id = id;
        this.price = price;
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    
    
}
