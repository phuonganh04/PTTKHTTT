/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

/**
 *
 * @author Admin
 */
public class ItemBook {
    private int id;
    private double price;
    private String barcode, populartype, discount;
    private Book book;
    private int amount;
    public ItemBook(double price, String barcode, String populartype, String discount, Book book) {
		super();
		this.price = price;
		this.barcode = barcode;
		this.populartype = populartype;
		this.discount = discount;
		this.book = book;
	}

	public ItemBook(double price, String barcode, String populartype, String discount) {
		super();
		this.price = price;
		this.barcode = barcode;
		this.populartype = populartype;
		this.discount = discount;
	}

	public ItemBook(int id, double price, String barcode, String populartype, String discount,Book book) {
		super();
        this.id = id;
        this.price = price;
        this.barcode = barcode;
        this.populartype = populartype;
        this.discount = discount;
        this.book = book;
    }

    public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
