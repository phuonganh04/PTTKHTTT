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
public class ItemBook {
    protected int id;
    protected double price;
    protected String barcode, populartype, discount;

    public ItemBook(int id, double price, String barcode, String populartype, String discount) {
        this.id = id;
        this.price = price;
        this.barcode = barcode;
        this.populartype = populartype;
        this.discount = discount;
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

    public String getPopulartype() {
        return populartype;
    }

    public void setPopulartype(String populartype) {
        this.populartype = populartype;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

   
}
