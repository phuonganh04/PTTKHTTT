/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Book {
    protected int id;
    protected String ISBN, language, title;
    protected Date publicationdate;
    protected int numberofpage;

    public Book(){
        
    }

    public Book(int id, String ISBN, String language, String title, Date publicationdate, int numberofpage) {
        this.id = id;
        this.ISBN = ISBN;
        this.language = language;
        this.title = title;
        this.publicationdate = publicationdate;
        this.numberofpage = numberofpage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }

    public int getNumberofpage() {
        return numberofpage;
    }

    public void setNumberofpage(int numberofpage) {
        this.numberofpage = numberofpage;
    }
   
     
}
