package dao.customerdao;

import java.util.List;

import model.customer.Account;
import model.customer.Customer;
import model.order.Order;

public interface CustomerDAO {
	public boolean addCustomer(Customer customer);
	public Customer getCustomer(String username, String password);
	public List<Customer> findAll();
	public Customer findCustomerByUsername(String username);
        public boolean updateCustomer(Customer customer);
        public void viewOrder(Order order);

}
