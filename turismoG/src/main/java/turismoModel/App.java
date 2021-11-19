package turismoModel;

import java.io.IOException;
import java.sql.SQLException;

import turismoDAO.ConnectionProvider;

public class App {

	public static void main(String[] args) throws IOException, SQLException {

		Parque sistema = new Parque();

		sistema.crearUsuarios();
		sistema.crearAtracciones();
		sistema.crearPromociones();

		sistema.ordenarSugerencias();
		sistema.listaSugerencias();
		
		sistema.ofertarMientrasHayaOroYtiempoAtodosLosUsuarios();
		
		ConnectionProvider.close();
	}

}

