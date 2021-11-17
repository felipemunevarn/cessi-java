package turismo.model;

import java.sql.SQLException;
import java.util.List;

import turismo.DAO.AtraccionDAO;
import turismo.DAO.ConnectionProvider;
import turismo.DAO.ItinerarioDAO;
import turismo.DAO.UsuarioDAO;

public class App {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> users = udao.findAll();
		System.out.println(users);
		
		AtraccionDAO adao = new AtraccionDAO();
		List<Atraccion> parks = adao.findAll();
		System.out.println(parks);		
		
		List<Atraccion> parksCupoArriba13 = adao.findByCupo(13);
		System.out.println(parksCupoArriba13);
		
		ItinerarioDAO idao = new ItinerarioDAO();
		idao.insert(1, 0, 1);
		
		ConnectionProvider.close();
	}
}
