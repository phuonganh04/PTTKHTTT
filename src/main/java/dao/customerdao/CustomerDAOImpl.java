package dao.customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDatabase;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import model.order.Order;
import utils.Usage;

public class CustomerDAOImpl implements CustomerDAO {
	private Connection connection;
	
    public CustomerDAOImpl() {
		connection = ConnectDatabase.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean isSuccess = false;
		try {
			PreparedStatement ps = connection.prepareStatement(Usage.findAccountByUsername);
			ps.setString(1,customer.getAccount().getUsername());
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				//insert customer
				ps = connection.prepareStatement(Usage.insertCustomer,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,customer.getTel());
				ps.setString(2, (customer.getFullName().getFisrtName()+customer.getFullName().getLastName()));
				ps.setString(3, customer.getEmail());
				ps.executeUpdate();
				ResultSet rs1 = ps.getGeneratedKeys();
				int id = 0;
				if(rs1.next()) id = rs1.getInt(1);
				
			//insert account
				ps = connection.prepareStatement(Usage.insertAccount);
				ps.setInt(1, id);
				ps.setString(2, customer.getAccount().getUsername());
				ps.setString(3, customer.getAccount().getPassword());
				ps.executeUpdate();
				
			//insert address
				ps = connection.prepareStatement(Usage.insertAddress);
				ps.setInt(1, id);
				ps.setInt(2, customer.getAddress().getNoHome());
				ps.setString(3, customer.getAddress().getCity());
				ps.setString(4, customer.getAddress().getStreet());
				ps.setString(5, customer.getAddress().getDistrict());
				ps.executeUpdate();
			//insert fullname
				ps = connection.prepareStatement(Usage.insertFullname);
				ps.setInt(1, id);
				ps.setString(2, customer.getFullName().getFisrtName());
				ps.setString(3, customer.getFullName().getLastName());
				ps.executeUpdate();
				
				isSuccess = true;
				connection.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	@Override
	public Customer getCustomer(String username, String password) {
		Customer customer = null ;
		try {
			PreparedStatement ps = connection.prepareStatement(Usage.findAccount);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int custID = rs.getInt("CustomerID");
				PreparedStatement ps1 = connection.prepareStatement(Usage.getCustomerByAccount);
				ps1.setInt(1,custID);
				ps1.setInt(2,custID);
				ps1.setInt(3,custID);
				ps1.setInt(4,custID);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					String tel = rs1.getString("customer.Tel");
					String email = rs1.getString("customer.Email");
					String firstname = rs1.getString("fullname.Firstname");
					String lastname = rs1.getString("fullname.Lastname");
					String city = rs1.getString("address.City");
					String district = rs1.getString("address.District");
					String street = rs1.getString("address.Street");
					int noHome = rs1.getInt("address.NoHome");
					
					Address address = new Address(city, district, noHome, street, custID);
					Account account = new Account(username, password,custID);
					FullName fullname = new FullName(firstname,lastname);
					
					customer = new Customer(tel, fullname, email, address, account);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	

}
