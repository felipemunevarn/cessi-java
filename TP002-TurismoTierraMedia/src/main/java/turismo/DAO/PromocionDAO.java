package turismo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismo.model.AxB;
import turismo.model.ConDescuento;
import turismo.model.Porcentual;

public class PromocionDAO {

	public List<AxB> findAllAxB() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, precio, tiempo FROM promocion WHERE tipo = 'AxB'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<AxB> todas = new LinkedList<AxB>();
		
		while (res.next()) {
			List<Integer> atracciones = findAtraccionesByPromo(res.getInt("id"));
			List<Integer> gratis = findGratisByPromo(res.getInt("id"));
			todas.add(new AxB(res.getString("nombre"), atracciones, gratis));
		}
		return todas;
	}
	
	public List<ConDescuento> findAllConDescuento() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, precio, tiempo FROM promocion WHERE tipo = 'ConDcto'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<ConDescuento> todas = new LinkedList<ConDescuento>();
		
		while (res.next()) {
			List<Integer> atracciones = findAtraccionesByPromo(res.getInt("id"));
			todas.add(new ConDescuento(res.getString("nombre"), res.getDouble("precio"), atracciones));
		}
		return todas;
	}

	public List<Porcentual> findAllPorcentual() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, descuento FROM promocion WHERE tipo = 'Porcentual'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<Porcentual> todas = new LinkedList<Porcentual>();
		
		while (res.next()) {
			List<Integer> atracciones = findAtraccionesByPromo(res.getInt("id"));
			todas.add(new Porcentual(res.getString("nombre"), res.getDouble("descuento"), atracciones));
		}
		return todas;
	}
	
	private List<Integer> findGratisByPromo(int promoID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT atraccionID FROM promoAxB_gratuita WHERE promocionID = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, promoID);
		ResultSet res = sta.executeQuery();
		
		List<Integer> gratis = new LinkedList<Integer>();
		
		while (res.next()) {
			gratis.add(res.getInt("atraccionID"));
		}
		return gratis;
	}

	private List<Integer> findAtraccionesByPromo(int promoID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT atraccionID FROM promo_atraccion WHERE promocionID = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, promoID);
		ResultSet res = sta.executeQuery();
		
		List<Integer> atracciones = new LinkedList<Integer>();
		
		while (res.next()) {
			atracciones.add(res.getInt("atraccionID"));
		}
		return atracciones;
	}
}