/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.cartdao;

import dao.orderdao.*;
import model.order.Cart;

/**
 *
 * @author Admin
 */
public interface CartDAO {
    public float calcPrice();
    public boolean update(Cart cart);
}
