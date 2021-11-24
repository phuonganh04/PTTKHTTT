package dao.orderdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectDatabase;
import model.order.Shipment;

public class ShipmentDAOImpl  implements ShipmentDAO{
	private Connection connection;
    public ShipmentDAOImpl(){
        connection = ConnectDatabase.getInstance().getConnection();
        try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public List<Shipment> findAll() {
		List<Shipment> list = new ArrayList<>();
		String sql = "SELECT * FROM shipment";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Shipment(rs.getString("address"), rs.getString("shipmethod"), rs.getDouble("cost"),rs.getInt("id"),rs.getInt("orderId")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Shipment findById(int id) {
		Shipment shipment = null;
		String sql = "SELECT * FROM shipment WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				shipment = new Shipment(rs.getString("address"), rs.getString("shipmethod"), rs.getDouble("cost"),rs.getInt("id"),rs.getInt("orderId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return shipment;
	}

}
