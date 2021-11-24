/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.cartdao;

import dao.orderdao.*;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectDatabase;
import model.order.Cart;

/**
 *
 * @author Admin
 */
public class CartDAOImpl implements CartDAO{
    private Connection connection;
    public CartDAOImpl(){
        connection = ConnectDatabase.getInstance().getConnection();
        try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    public float calcPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
