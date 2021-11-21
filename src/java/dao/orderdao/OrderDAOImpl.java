/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orderdao;

import dao.DAO;
import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import model.book.ItemBook;
import model.customer.Customer;
import model.order.Order;


/**
 *
 * @author Admin
 */
public class OrderDAOImpl extends DAO implements OrderDAO{
    public OrderDAOImpl(){
        super();
    }
    @Override
    public boolean insertOrder(Order order) {
        //To change body of generated methods, choose Tools | Templates.
        boolean isSuccess=true;
		String sqlOrder = "INSERT INTO shoponline.order (totalPrice, tax, shipcost) VALUES (?,?,?)";
		String sqlPayment = "INSERT INTO payment (paymentMethod,totalMoney) VALUES (?,?)";
		String sqlCart = "INSERT INTO cart (paymentid) VALUES (?)";
		String sqlItemBook = "INSERT INTO itembook (cartid, bookid, barcode) VALUES (?,?,?)";
		//String sqlBookItem = "UPDATE bookitem SET amountStock=? WHERE bookId=?";
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(sqlPayment, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getPayment().getMethod());
			ps.setDouble(2, order.getPayment().getTotalMoney());
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				order.getPayment().setId(keys.getInt(1));
			}
			
			ps = connection.prepareStatement(sqlCart, Statement.RETURN_GENERATED_KEYS);
			//Timestamp date = new Timestamp(order.getCart().getDateCreate().getTime());
			ps.setInt(1, order.getPayment().getId());
			ps.executeUpdate();
			keys = ps.getGeneratedKeys();
			if(keys.next()) {
				order.getCart().setId(keys.getInt(1));
			}
			
			for (ItemBook boughtBookItem : order.getCart().getItemBook()) {
				ps = connection.prepareStatement(sqlItemBook, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, boughtBookItem.getId());
				ps.setInt(2, keys.getInt(1));
				ps.setString(3, boughtBookItem.getDiscount());
				ps.executeUpdate();
				
			}
			
			ps = connection.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getCustomer().getId());
			ps.setDouble(2, order.getShipCost());
			ps.setFloat(3, order.getTotalprice());
			ps.setString(4, order.getTax());
			ps.executeUpdate();
			

		} catch (SQLException e) {
			isSuccess=false;
			try {
				connection.rollback();
				isSuccess=false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				isSuccess=false;
				e.printStackTrace();
			}
		}
		return isSuccess;
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
