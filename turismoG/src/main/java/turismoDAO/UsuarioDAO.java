package turismoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismo.DAO.ConnectionProvider;
import turismoModel.Usuario;

public class UsuarioDAO {
	public List<Usuario> findAll() throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM usuario";
		PreparedStatement sta = con.prepareStatement(sql);
		ResultSet res = sta.executeQuery();
		
		List<Usuario> todos = new LinkedList<Usuario>();
		
		while (res.next()) {
			todos.add(toUsuario(res));
		}
		return todos;
	}

	private Usuario toUsuario(ResultSet res) throws SQLException {
		String nombre = res.getString("nombre");
		int presupuesto = res.getInt("presupuesto");
		double tiempoDisponible = res.getDouble("tiempoDisponible");
		return new Usuario(nombre, presupuesto, tiempoDisponible);
	}
	
	public int findIdByName(String name) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "SELECT id FROM usuario WHERE nombre = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setString(1, name);
		ResultSet res = sta.executeQuery();
		res.next();
		return res.getInt("id");
	}

	public void updatePresupuestoYTiempo(int userID, int presupuesto, double tiempo) throws SQLException {
		Connection con = ConnectionProvider.getConnection();
		String sql = "UPDATE usuario SET presupuesto = ?, tiempoDisponible = ? WHERE id = ?";
		PreparedStatement sta = con.prepareStatement(sql);
		sta.setLong(1, presupuesto);
		sta.setDouble(2, tiempo);
		sta.setLong(3, userID);		
		sta.executeUpdate();
	}
		
}
