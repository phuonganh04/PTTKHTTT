/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.clothesdao;

import model.clothes.Clothes;

/**
 *
 * @author abc
 */
public interface ClothesDAO {
    void addClothes(Clothes clothes);
    boolean deleteClothes(int id);
    boolean updateClothes(Clothes clothes);
}
