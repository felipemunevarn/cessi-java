package turismo;

import java.util.List;

public class ConDescuento extends Promocion{
	
	public ConDescuento(String nombre, int costo, List<Atraccion> atraccionesList) {
		super(nombre, atraccionesList);
		this.costo = costo;
		this.tiempo = calcularTiempo();
	}
	
	public double calcularTiempo() {
		double tiempoTotal = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			tiempoTotal += atraccionesList.get(i).tiempo;
		}
		return tiempoTotal;
	}	
}
