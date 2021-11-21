/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.electronicdao;

import model.electronic.Electronic;

/**
 *
 * @author Admin
 */
public interface ElectronicsDAO {
    void addElectronics(Electronic electronic);
    boolean deleteElectronics(int id);
    boolean updateElectronics(Electronic electronic);
}
