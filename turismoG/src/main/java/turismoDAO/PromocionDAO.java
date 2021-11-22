package turismoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismoModel.Absoluto;
import turismoModel.Atraccion;
import turismoModel.AxB;
import turismoModel.Descuento;

public class PromocionDAO {

	public List<AxB> findAllAxB() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, precio, tiempo FROM promocion WHERE tipo = 'AxB'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<AxB> todas = new LinkedList<AxB>();
		
		while (res.next()) {
			createNewAxB(res, todas);
		}
		return todas;
	}

	public static void createNewAxB(ResultSet res, List<AxB> todas) throws SQLException {
		List<Atraccion> atracciones = findAtraccionesByPromo(res.getInt("id"));
		List<Atraccion> gratis = findGratisByPromo(res.getInt("id"));
		todas.add(new AxB(res.getString("nombre"), atracciones, gratis));
	}
	
	public List<Absoluto> findAllAbsoluto() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, precio, tiempo FROM promocion WHERE tipo = 'ConDcto'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<Absoluto> todas = new LinkedList<Absoluto>();
		
		while (res.next()) {
			createNewAbs(res, todas);
		}
		return todas;
	}

	public static void createNewAbs(ResultSet res, List<Absoluto> todas) throws SQLException {
		List<Atraccion> atracciones = findAtraccionesByPromo(res.getInt("id"));
		todas.add(new Absoluto(res.getString("nombre"), atracciones, res.getInt("precio")));
	}

	public List<Descuento> findAllDescuento() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id, nombre, descuento FROM promocion WHERE tipo = 'Porcentual'";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
				
		List<Descuento> todas = new LinkedList<Descuento>();
		
		while (res.next()) {
			createNewDcto(res, todas);
		}
		return todas;
	}

	public static void createNewDcto(ResultSet res, List<Descuento> todas) throws SQLException {
		List<Atraccion> atracciones = findAtraccionesByPromo(res.getInt("id"));
		todas.add(new Descuento(res.getString("nombre"), res.getInt("descuento"), atracciones));
	}
	
	private static List<Atraccion> findGratisByPromo(int promoID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT atraccionID FROM promoAxB_gratuita WHERE promocionID = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, promoID);
		ResultSet res = sta.executeQuery();
		
		List<Atraccion> gratis = new LinkedList<Atraccion>();
		
		while (res.next()) {
			gratis.add(AtraccionDAO.findByID(res.getInt("atraccionID")));
		}
		return gratis;
	}

	private static List<Atraccion> findAtraccionesByPromo(int promoID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT atraccionID FROM promo_atraccion WHERE promocionID = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, promoID);
		ResultSet res = sta.executeQuery();
		
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		
		while (res.next()) {
			atracciones.add(AtraccionDAO.findByID(res.getInt("atraccionID")));
		}
		return atracciones;
	}
	
	public static int findIdByName(String name) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id FROM promocion WHERE nombre = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setString(1, name);
		ResultSet res = sta.executeQuery();
		res.next();
		return res.getInt("id");
	}
	
	public static void updateCupo(int promoID, int nuevoCupo) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "UPDATE atraccion SET cupo = ? WHERE id = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, nuevoCupo);
		sta.setDouble(2, promoID);
		sta.executeUpdate();
	}
}