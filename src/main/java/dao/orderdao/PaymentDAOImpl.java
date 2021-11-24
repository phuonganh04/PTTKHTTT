/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orderdao;

import dao.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.order.Cart;
import model.order.Order;
import model.order.Payment;

/**
 *
 * @author Admin
 */
public class PaymentDAOImpl implements PaymentDAO{
	private Connection connection;
    public PaymentDAOImpl(){
        connection = ConnectDatabase.getInstance().getConnection();
        try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    public boolean creat(Payment p) {
        String sql = "insert into payment ( OrderID , ShipmentID,method,CartID ) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ps.setInt(1, p.getOrderID());
			ps.setInt(2, p.getShipmentID());
			ps.setString(3, String.valueOf(p.getMethod()));
			ps.setInt(4, p.getCartID());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
    }

    @Override
    public Cart getCart(Cart Cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(Order Order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
