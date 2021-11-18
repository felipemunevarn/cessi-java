package turismo.model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismo.DAO.AtraccionDAO;
import turismo.DAO.ConnectionProvider;
import turismo.DAO.PromocionDAO;
import turismo.DAO.UsuarioDAO;

public class App {

	public static void main(String[] args) throws SQLException {
//		Crea usuarios
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> users = udao.findAll();
		
//		Crea atracciones
		AtraccionDAO adao = new AtraccionDAO();
		List<Atraccion> parks = adao.findAll();		
		
//		Crea promos
		PromocionDAO pdao = new PromocionDAO();
		List<AxB> promoAxB = pdao.findAllAxB();
		List<ConDescuento> promoConDcto = pdao.findAllConDescuento();
		List<Porcentual> promoPorcentual = pdao.findAllPorcentual();

//		Crea ofertables
		List<Producto> ofertables = new LinkedList<Producto>();
		ofertables.addAll(parks);
		ofertables.addAll(promoAxB);
		ofertables.addAll(promoConDcto);
		ofertables.addAll(promoPorcentual);
		
		System.out.println(ofertables);
		
		ConnectionProvider.close();
	}
}
