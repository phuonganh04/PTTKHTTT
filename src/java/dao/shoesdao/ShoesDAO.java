/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shoesdao;
import model.Shoes;
/**
 *
 * @author abc
 */
public interface ShoesDAO {
    void addShoes(Shoes shoes);
    boolean deleteShoes(int id);
    boolean updateShoes(Shoes shoes);
}
