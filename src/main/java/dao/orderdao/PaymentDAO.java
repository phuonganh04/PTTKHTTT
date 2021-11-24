/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orderdao;

import model.order.Cart;
import model.order.Order;
import model.order.Payment;

/**
 *
 * @author Admin
 */
public interface PaymentDAO {
    boolean creat(Payment payment);
    Cart getCart(Cart Cart);
    Order getOrder(Order Order);
}
