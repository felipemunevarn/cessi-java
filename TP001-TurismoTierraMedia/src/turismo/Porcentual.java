package turismo;

import java.util.List;

public class Porcentual extends Promocion {
	private int porcentajeDescuento;

	public Porcentual(String nombre, int porcentajeDescuento, List<Atraccion> atraccionesList) {
		super(nombre, atraccionesList);
		this.porcentajeDescuento = porcentajeDescuento;
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
	}
	
	public int calcularCosto() {
		int costoFinal = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			costoFinal += atraccionesList.get(i).costo;
		}
		return costoFinal * (1 - getPorcentajeDescuento() / 100);
	}
	
	public double calcularTiempo() {
		double tiempoTotal = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			tiempoTotal += atraccionesList.get(i).tiempo;
		}
		return tiempoTotal;
	}
	
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	
}
