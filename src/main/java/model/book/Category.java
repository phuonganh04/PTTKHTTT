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
public class Category {
    private String type;
    private int id;
    private int boookid;

    public Category() {
    }

    public Category( int id ,String type) {
		super();
		this.type = type;
		this.id = id;
	}

	public Category(String type, int id, int boookid) {
        this.type = type;
        this.id = id;
        this.boookid = boookid;
    }

    public int getBoookid() {
        return boookid;
    }

    public void setBoookid(int boookid) {
        this.boookid = boookid;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
