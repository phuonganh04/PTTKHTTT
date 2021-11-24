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
    private String ISBN, language, title;
    private String publicationdate;
    private int numberofpage;
    private Author author;
    private Publisher publisher;
    private Category category;
    private String image;

    public Book(){
        
    }

    public Book(int id, String ISBN, String language, String title, String publicationdate, int numberofpage,
			Author author, Publisher publisher, Category category, String image) {
		super();
		this.id = id;
		this.ISBN = ISBN;
		this.language = language;
		this.title = title;
		this.publicationdate = publicationdate;
		this.numberofpage = numberofpage;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.image = image;
	}

	public Book(String ISBN, String language, String title, String publicationdate, int numberofpage2, Author author,
			Publisher publisher, Category category, String image) {
		this.ISBN = ISBN;
		this.language = language;
		this.title = title;
		this.publicationdate = publicationdate;
		this.numberofpage = numberofpage2;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.image = image;
	}

	public Book(int id, int publisherid, String ISBN, String language, String title, String publicationdate, 
    		int numberofpage, Author author, Publisher publisher, Category category, String image) {
        this.id = id;
        this.ISBN = ISBN;
        this.language = language;
        this.title = title;
        this.publicationdate = publicationdate;
        this.numberofpage = numberofpage;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.image = image;
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

    public String getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate;
    }

    public int getNumberofpage() {
        return numberofpage;
    }

    public void setNumberofpage(int numberofpage) {
        this.numberofpage = numberofpage;
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	@Override
	public String toString() {
		return "Book [id=" + id +  ", ISBN=" + ISBN + ", language=" + language
				+ ", title=" + title + ", publicationdate=" + publicationdate + ", numberofpage=" + numberofpage
				+ ", author=" + author + ", publisher=" + publisher + ", category=" + category + ", image=" + image
				+ "]";
	}

    
}
