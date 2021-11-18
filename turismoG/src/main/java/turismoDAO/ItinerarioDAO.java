package turismoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItinerarioDAO {
	public int insert(int usuarioID, int promocionID, int atraccionID) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario (usuarioID, promocionID, atraccionID) VALUES (?, ?, ?)";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, usuarioID);
		sta.setLong(2, promocionID);
		sta.setLong(3, atraccionID);
		
		int rows = sta.executeUpdate();
		
		return rows;
	}
}

