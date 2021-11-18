/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Book {
    private int id;
    private int publisherid;
    private String ISBN, language, title;
    private Date publicationdate;
    private int numberofpage;
    private Author author;
    private Publisher publisher;
    private Category category;

    public Book(){
        
    }

    public Book(int id, int publisherid, String ISBN, String language, String title, Date publicationdate, int numberofpage, Author author, Publisher publisher, Category category) {
        this.id = id;
        this.publisherid = publisherid;
        this.ISBN = ISBN;
        this.language = language;
        this.title = title;
        this.publicationdate = publicationdate;
        this.numberofpage = numberofpage;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
