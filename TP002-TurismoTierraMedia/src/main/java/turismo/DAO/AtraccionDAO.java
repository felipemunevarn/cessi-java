package turismo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import turismo.model.Atraccion;

public class AtraccionDAO {

	public List<Atraccion> findAll() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM atraccion";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
		
		List<Atraccion> todas = new LinkedList<Atraccion>();
		
		while (res.next()) {
			todas.add(toAtraccion(res));
		}
		return todas;
	}
	
	public List<Atraccion> findByCupo(int limite) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM atraccion WHERE cupo >= ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, limite);
		ResultSet res = sta.executeQuery();
		
		List<Atraccion> filtradas = new LinkedList<Atraccion>();
		
		while (res.next()) {
			filtradas.add(toAtraccion(res));
		}
		return filtradas;
	}

	private Atraccion toAtraccion(ResultSet res) throws SQLException {
		String nombre = res.getString("nombre");
		double costo = res.getDouble("costo");
		double duracion = res.getDouble("duracion");
		int cupo = res.getInt("cupo");
		return new Atraccion(nombre, costo, duracion, cupo);
	}
	
	public static double getTiempoTotal(List<Integer> atraccionesID) throws SQLException {
		double tiempo = 0;
		Connection con = ConnectionProvider.getConnection();
		
		for (Integer atraccionID : atraccionesID) {
			String sql = "SELECT duracion FROM atraccion WHERE id = ?";
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setLong(1, atraccionID);
			ResultSet res = sta.executeQuery();
			tiempo += res.getDouble("duracion");
		}		
		
		return tiempo;
	}
	
	public static double getCostoTotal(List<Integer> atraccionesID) throws SQLException {
		double costo = 0;
		Connection con = ConnectionProvider.getConnection();
		
		for (Integer atraccionID : atraccionesID) {
			String sql = "SELECT costo FROM atraccion WHERE id = ?";
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setLong(1, atraccionID);
			ResultSet res = sta.executeQuery();
			costo += res.getDouble("costo");
		}		
		
		return costo;
	}
}
