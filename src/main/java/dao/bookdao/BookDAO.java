/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bookdao;

import java.util.List;

import model.book.Book;
import model.book.ItemBook;

/**
 *
 * @author Admin
 */
public interface BookDAO {
    void addBook(Book book);
    boolean deleteBook(int id);
    boolean updateBook(Book book);
    List<ItemBook> getAllItemBook();
    ItemBook getItemBookByID(int id);
}
