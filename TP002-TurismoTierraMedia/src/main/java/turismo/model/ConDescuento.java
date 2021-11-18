package turismo.model;

import java.sql.SQLException;
import java.util.List;

import turismo.DAO.AtraccionDAO;

public class ConDescuento extends Promocion{
	
	public ConDescuento(String nombre, double d, List<Integer> atracciones) throws SQLException {
		super(nombre, atracciones);
		this.costo = d;
		this.tiempo = calcularTiempo();
	}
	
	public double calcularTiempo() throws SQLException {

		return AtraccionDAO.getTiempoTotal(atraccionesList);
	}

	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return 0;
	}	
}
