package turismoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import turismoModel.Absoluto;
import turismoModel.Atraccion;
import turismoModel.AxB;
import turismoModel.Descuento;
import turismoModel.Promocion;

public class ItinerarioDAO {
	public void insert(int usuarioID, int promocionID, int atraccionID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario (usuarioID, promocionID, atraccionID) VALUES (?, ?, ?)";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, usuarioID);
		sta.setLong(2, promocionID);
		sta.setLong(3, atraccionID);
		
		sta.executeUpdate();
	}
	
	public List<Atraccion> findAtracByUserId(int userId) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT atraccion.id, nombre, costo, duracion, cupo\n"
				+ "FROM atraccion\n"
				+ "INNER JOIN itinerario ON atraccion.id = itinerario.atraccionID\n"
				+ "WHERE itinerario.usuarioID = ?;";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setInt(1, userId);
		ResultSet res = sta.executeQuery();
		
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		
		while (res.next()){
			atracciones.add(AtraccionDAO.toAtraccion(res));
		}
			return atracciones;
	}
	
	public List<Promocion> findPromoByUserId(int userId) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT promocion.id, nombre, tipo, descuento, precio, tiempo\n"
				+ "FROM promocion\n"
				+ "INNER JOIN itinerario ON promocion.id = itinerario.promocionID\n"
				+ "WHERE itinerario.usuarioID = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setInt(1, userId);
		ResultSet res = sta.executeQuery();
		
		List<Promocion> promos = new ArrayList<Promocion>();
		List<AxB> todasAxB = new LinkedList<AxB>();
		List<Absoluto> todasAbs = new LinkedList<Absoluto>();
		List<Descuento> todasDcto = new LinkedList<Descuento>();
		
		while (res.next()) {
			if (res.getString("tipo").equalsIgnoreCase("AxB")) {
				PromocionDAO.createNewAxB(res, todasAxB);
			}
			if (res.getString("tipo").equalsIgnoreCase("Porcentual")) {
				PromocionDAO.createNewDcto(res, todasDcto);
			}
			if (res.getString("tipo").equalsIgnoreCase("ConDcto")) {
				PromocionDAO.createNewAbs(res, todasAbs);
			}
		}
		promos.addAll(todasAxB);
		promos.addAll(todasAbs);
		promos.addAll(todasDcto);
		
		return promos;
	}
}

