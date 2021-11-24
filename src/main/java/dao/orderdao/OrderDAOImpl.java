/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orderdao;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectDatabase;
import model.customer.Customer;
import model.order.Order;


/**
 *
 * @author Admin
 */
public class OrderDAOImpl  implements OrderDAO{
	private Connection connection;
    public OrderDAOImpl(){
        connection = ConnectDatabase.getInstance().getConnection();
        try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public boolean delete(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} 
