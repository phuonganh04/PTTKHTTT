/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orderdao;

import model.customer.Customer;
import model.order.Order;

/**
 *
 * @author Admin
 */
public interface OrderDAO {
    public boolean delete(Order order);
    public void viewCustomer(Customer customer);
    public boolean update(Order order);
    public boolean insertOrder(Order order);
}
