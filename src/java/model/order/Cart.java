/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.util.List;
import model.book.ItemBook;

/**
 *
 * @author Admin
 */
public class Cart {
    private int id;
    private int amount;
    private float totalprice;
    private List<ItemBook> itemBook;
    private Payment payment;

    public Cart() {
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    

    public List<ItemBook> getItemBook() {
        return itemBook;
    }

    public void setItemBook(List<ItemBook> itemBook) {
        this.itemBook = itemBook;
    }
    
    
}
