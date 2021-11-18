package turismo.model;

import java.sql.SQLException;
import java.util.List;

import turismo.DAO.AtraccionDAO;

public class Porcentual extends Promocion {
	private double porcentajeDescuento;

	public Porcentual(String nombre, double porcentajeDescuento, List<Integer> atraccionesList) throws SQLException {
		super(nombre, atraccionesList);
		this.porcentajeDescuento = porcentajeDescuento;
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
	}
	
	public double calcularCosto() throws SQLException {
		double costoFinal = AtraccionDAO.getCostoTotal(atraccionesList);
		return costoFinal * (1 - getPorcentajeDescuento() / 100);
	}
	
	public double calcularTiempo() throws SQLException {
		return AtraccionDAO.getTiempoTotal(atraccionesList);
	}	
	
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
