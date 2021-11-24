/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import model.book.ItemBook;

/**
 *
 * @author Admin
 */
public class Cart {
    private int id;
    private float totalprice;
    private List<ItemBook> itemBook;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setItemBook(List<ItemBook> listItemBook) {
        this.itemBook = listItemBook;
    }
    
 
}
