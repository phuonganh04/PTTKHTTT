/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.cartdao;

import dao.orderdao.*;
import dao.DAO;
import model.order.Cart;

/**
 *
 * @author Admin
 */
public class CartDAOImpl extends DAO implements CartDAO{
    
    public CartDAOImpl(){
        super();
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
