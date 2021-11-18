/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.clothesdao;
import dao.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.clothes.Clothes;
/**
 *
 * @author abc
 */
public class ClothesDAOImpl extends DAO implements ClothesDAO{
    private final String ADD_CLOTHES = "insert into clothes (brandname, size, color, meterial, style, type, pattern) values (?,?,?,?,?,?,?);";
    private static final String DELETE_CLOTHES = "delete from clothes where id = ?;";
    private static final String UPDATE_CLOTHES = "update clothes set brandname = ?,size= ?,color =?, meterial =?, style=?, type =?, pattern =? where id = ?;";
    @Override
    public void addClothes(Clothes clothes) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_CLOTHES)){
            preparedStatement.setInt(1, clothes.getId());
            preparedStatement.setString(2, clothes.getBrandname());
            preparedStatement.setString(3, clothes.getSize());
            preparedStatement.setString(4, clothes.getColor());
            preparedStatement.setString(5, clothes.getMeterial());
            preparedStatement.setString(6, clothes.getStyle());
            preparedStatement.setString(7, clothes.getType());
            preparedStatement.setString(6, clothes.getPattern());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteClothes(int id) {
        boolean rowDeleted;
        try( PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLOTHES);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowDeleted = false;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateClothes(Clothes clothes) {
        boolean rowUpdated;
        try (PreparedStatement preparedStatement  = connection.prepareStatement(UPDATE_CLOTHES);) {
            preparedStatement.setString(1, clothes.getBrandname());
            preparedStatement.setString(2, clothes.getSize());
            preparedStatement.setString(3, clothes.getColor());
            preparedStatement.setString(4, clothes.getMeterial());
            preparedStatement.setString(5, clothes.getStyle());
            preparedStatement.setString(6, clothes.getType());
            preparedStatement.setString(5, clothes.getPattern());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowUpdated = false;
        }
        return rowUpdated;
    }  
}
