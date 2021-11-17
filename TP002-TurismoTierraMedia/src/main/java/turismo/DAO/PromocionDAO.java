package turismo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismo.model.Promocion;

public class PromocionDAO {

	public List<Promocion> findAll() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM pormocion";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
		
		List<Promocion> todas = new LinkedList<Promocion>();
		
		while (res.next()) {
			todas.add(toPromocion(res));
		}
		return todas;
	}

	private Promocion toPromocion(ResultSet res) throws SQLException {
		String nombre = res.getString("nombre");
		double costo = res.getDouble("costo");
		double duracion = res.getDouble("duracion");
		int cupo = res.getInt("cupo");
		return new Promocion(nombre, costo, duracion, cupo);
	}
}

public class PromocionDAO {

}
