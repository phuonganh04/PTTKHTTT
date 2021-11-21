/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bookdao;

import model.Book;

/**
 *
 * @author Admin
 */
public interface BookDAO {
    void addBook(Book book);
    boolean deleteBook(int id);
    boolean updateBook(Book book);
}
