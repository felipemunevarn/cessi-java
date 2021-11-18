package turismo.model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import turismo.DAO.AtraccionDAO;

public class AxB extends Promocion{
	private List<Integer> atraccionesGratis;	
	
	public AxB(String nombre, List<Integer> atraccionesList, List<Integer> atraccionesGratis) throws SQLException {
		super(nombre, atraccionesList);
		this.atraccionesGratis = atraccionesGratis;
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
	}

	public double calcularCosto() throws SQLException {
		return AtraccionDAO.getCostoTotal(atraccionesList);
	}
	
	public double calcularTiempo() throws SQLException {
		List<Integer> todasAtrac = new LinkedList<Integer>();
		todasAtrac.addAll(atraccionesList);
		todasAtrac.addAll(atraccionesGratis);
		return AtraccionDAO.getTiempoTotal(todasAtrac);
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo
				+ "] atracciones=" + atraccionesList
				+ "] atraccionesGratis=" + atraccionesGratis + "]"; 
	}

	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
