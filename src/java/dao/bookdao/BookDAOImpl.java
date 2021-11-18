/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bookdao;

import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.book.Book;

/**
 *
 * @author Admin
 */
public class BookDAOImpl {
    private final String ADD_BOOK = "insert into book (ISBN, language, title, publicationdate, numberofpage,bookid) values (?,?,?,?,?,?);";
    private static final String DELETE_BOOK = "delete from book where id = ?;";
    private static final String UPDATE_BOOK = "update book set ISBN = ?,language= ?,title =?, publicationdate =?, numberofpage=?,bookid=? where id = ?;";
    
    public void addBook(Book book){
       try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK)){
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getISBN());
             preparedStatement.setString(3, book.getLanguage());
            preparedStatement.setString(4, book.getTitle());
            preparedStatement.setDate(5, book.getPublicationdate());
            preparedStatement.setInt(6, book.getNumberofpage());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteBook(int id){
         boolean rowDeleted;
        try( PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowDeleted = false;
        }
        return rowDeleted;
    }
    
    public boolean updateBook(Book book){
         boolean rowUpdated;
        try (PreparedStatement preparedStatement  = connection.prepareStatement(UPDATE_BOOK);) {
            preparedStatement.setString(1, book.getISBN());
            preparedStatement.setString(2, book.getLanguage());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setDate(4, book.getPublicationdate());
            preparedStatement.setInt(5, book.getNumberofpage());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowUpdated = false;
        }
        return rowUpdated;
    }
}

