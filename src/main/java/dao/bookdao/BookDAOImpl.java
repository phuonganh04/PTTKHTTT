/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bookdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.ConnectDatabase;

import model.book.*;
import utils.Usage;

/**
 *
 * @author Admin
 */
public class BookDAOImpl implements BookDAO{
    private Connection connection;
	
    public BookDAOImpl() {
		connection = ConnectDatabase.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemBook> getAllItemBook() {
		List<ItemBook> listItemBook = new ArrayList<>();
		Author author = null;
		Book book=null;
		Publisher publisher=null;
		Category category=null;
		ItemBook itemBook = null;
		try {
			PreparedStatement ps = connection.prepareStatement(Usage.getAllItemBook);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idItem = rs.getInt("ID");
				int bookID = rs.getInt("BookID");
				double price = rs.getDouble("Price");
				String barcode = rs.getString("Barcode");
				String populartype = rs.getString("Populartype");
				String discount = rs.getString("Discount");
				
				PreparedStatement ps5 = connection.prepareStatement(Usage.getCategoryByBookID);
				ps5.setInt(1,bookID );
				ResultSet rs5 = ps5.executeQuery();
				while(rs5.next()) {
					String type = rs5.getString("Type");
					int id = rs5.getInt("ID");
					category = new Category(id,type);
				}
				
				PreparedStatement ps1 = connection.prepareStatement(Usage.getBookByID);
				ps1.setInt(1, bookID);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					int publisherID = rs1.getInt("PublisherID");
					String ISBN = rs1.getString("ISBN");
					String publicationdate = rs1.getString("Publicationdate");
					int numberofpage = rs1.getInt("Numberofpage");
					String language = rs1.getString("Language");
					String title = rs1.getString("Title");
					String image = rs1.getString("Image");
					
					
					PreparedStatement ps2 = connection.prepareStatement(Usage.getAuthorIDByBookID);
					ps2.setInt(1,bookID );
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						int authorID= rs2.getInt("AuthorID");
						PreparedStatement ps3 = connection.prepareStatement(Usage.getAuthorByID);
						ps3.setInt(1,authorID );
						ResultSet rs3 = ps3.executeQuery();
						while(rs3.next()) {
							String name = rs3.getString("Name");
							String biography = rs3.getString("Biography");
							author = new Author(authorID,name,biography);
						}
					}
					PreparedStatement ps4 = connection.prepareStatement(Usage.getPublisherByID);
					ps4.setInt(1, publisherID);
					ResultSet rs4 = ps4.executeQuery();
					while(rs4.next()) {
						String address = rs4.getString("Address");
						String name = rs4.getString("Name");
						publisher = new Publisher(publisherID, name, address);
					}
					
					
					book = new Book(bookID, ISBN, language, title, publicationdate, numberofpage, author, publisher, category,image);
					itemBook = new ItemBook(idItem, price, barcode, populartype, discount,book);
					listItemBook.add(itemBook);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listItemBook;
	}

	@Override
	public ItemBook getItemBookByID(int id) {
		Author author = null;
		Book book=null;
		Publisher publisher=null;
		Category category=null;
		ItemBook itemBook = null;
		try {
			PreparedStatement ps = connection.prepareStatement(Usage.getItemBookByID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idItem = rs.getInt("ID");
				int bookID = rs.getInt("BookID");
				double price = rs.getDouble("Price");
				String barcode = rs.getString("Barcode");
				String populartype = rs.getString("Populartype");
				String discount = rs.getString("Discount");
				
				PreparedStatement ps5 = connection.prepareStatement(Usage.getCategoryByBookID);
				ps5.setInt(1,bookID );
				ResultSet rs5 = ps5.executeQuery();
				while(rs5.next()) {
					String type = rs5.getString("Type");
					int idCategory = rs5.getInt("ID");
					category = new Category(idCategory,type);
				}
				
				PreparedStatement ps1 = connection.prepareStatement(Usage.getBookByID);
				ps1.setInt(1, bookID);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					int publisherID = rs1.getInt("PublisherID");
					String ISBN = rs1.getString("ISBN");
					String publicationdate = rs1.getString("Publicationdate");
					int numberofpage = rs1.getInt("Numberofpage");
					String language = rs1.getString("Language");
					String title = rs1.getString("Title");
					String image = rs1.getString("Image");
					
					
					PreparedStatement ps2 = connection.prepareStatement(Usage.getAuthorIDByBookID);
					ps2.setInt(1,bookID );
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						int authorID= rs2.getInt("AuthorID");
						PreparedStatement ps3 = connection.prepareStatement(Usage.getAuthorByID);
						ps3.setInt(1,authorID );
						ResultSet rs3 = ps3.executeQuery();
						while(rs3.next()) {
							String name = rs3.getString("Name");
							String biography = rs3.getString("Biography");
							author = new Author(authorID,name,biography);
						}
					}
					PreparedStatement ps4 = connection.prepareStatement(Usage.getPublisherByID);
					ps4.setInt(1, publisherID);
					ResultSet rs4 = ps4.executeQuery();
					while(rs4.next()) {
						String address = rs4.getString("Address");
						String name = rs4.getString("Name");
						publisher = new Publisher(publisherID, name, address);
					}		
					book = new Book(bookID, ISBN, language, title, publicationdate, numberofpage, author, publisher, category,image);
					itemBook = new ItemBook(idItem, price, barcode, populartype, discount,book);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemBook;
	}
    
}

