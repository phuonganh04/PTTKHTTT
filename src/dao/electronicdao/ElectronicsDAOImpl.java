/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.electronicdao;


import static dao.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Electronic;

/**
 *
 * @author Admin
 */
public class ElectronicsDAOImpl {
     private final String ADD_ELECTRONICS = "insert into electronic (name, type, productiondate, producer, weight) values (?,?,?,?,?);";
    private static final String DELETE_ELECTRONICS = "delete from electronic where id = ?;";
    private static final String UPDATE_ELECTRONICS = "update book set name = ?,type= ?,productiondate =?, producer =?, weight=? where id = ?;";
    
    public void addElectronics(Electronic electronic){
       try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_ELECTRONICS)){
            preparedStatement.setInt(1, electronic.getId());
            preparedStatement.setString(2, electronic.getName());
             preparedStatement.setString(3, electronic.getType());
            preparedStatement.setString(4, electronic.getProductiondate());
            preparedStatement.setString(5, electronic.getProducer());
            preparedStatement.setString(6, electronic.getWeight());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean deleteElectronics(int id){
         boolean rowDeleted;
        try( PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ELECTRONICS);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowDeleted = false;
        }
        return rowDeleted;
    }
    
    public boolean updateElectonics(Electronic electronic){
         boolean rowUpdated;
        try (PreparedStatement preparedStatement  = connection.prepareStatement(UPDATE_ELECTRONICS);) {
            preparedStatement.setString(1, electronic.getName());
            preparedStatement.setString(2, electronic.getType());
            preparedStatement.setString(3, electronic.getProductiondate());
            preparedStatement.setString(4, electronic.getProducer());
            preparedStatement.setString(5, electronic.getWeight());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowUpdated = false;
        }
        return rowUpdated;
    }
}
