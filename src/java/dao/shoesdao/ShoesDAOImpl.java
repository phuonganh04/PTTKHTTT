/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shoesdao;
import dao.DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Shoes;
/**
 *
 * @author abc
 */
public class ShoesDAOImpl extends DAO implements ShoesDAO{
    private final String ADD_SHOES = "insert into shoes (brandname, size, color, meterial, style) values (?,?,?,?,?);";
    private static final String DELETE_SHOES = "delete from shoes where id = ?;";
    private static final String UPDATE_SHOES = "update shoes set brandname = ?,size= ?,color =?, meterial =?, style=? where id = ?;";
    @Override
    public void addShoes(Shoes shoes) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_SHOES)){
            preparedStatement.setInt(1, shoes.getId());
            preparedStatement.setString(2, shoes.getBrandname());
            preparedStatement.setString(3, shoes.getSize());
            preparedStatement.setString(4, shoes.getColor());
            preparedStatement.setString(5, shoes.getMeterial());
            preparedStatement.setString(6, shoes.getStyle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteShoes(int id) {
        boolean rowDeleted;
        try( PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SHOES);) {
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
    public boolean updateShoes(Shoes shoes) {
        boolean rowUpdated;
        try (PreparedStatement preparedStatement  = connection.prepareStatement(UPDATE_SHOES);) {
            preparedStatement.setString(1, shoes.getBrandname());
            preparedStatement.setString(2, shoes.getSize());
            preparedStatement.setString(3, shoes.getColor());
            preparedStatement.setString(4, shoes.getMeterial());
            preparedStatement.setString(5, shoes.getStyle());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (Exception e) {
            // TODO: handle exception
            rowUpdated = false;
        }
        return rowUpdated;
    }
}
