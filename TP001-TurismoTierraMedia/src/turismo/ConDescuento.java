package turismo;

import java.util.List;

public class ConDescuento extends Promocion{
	
	public ConDescuento(String nombre, int costo, String[] atraccionesList) {
		super(nombre, atraccionesList);
		this.costo = costo;
		this.tiempo = calcularTiempo();
	}
	
	public double calcularTiempo() {
		double tiempoTotal = 0;
		for (int i = 0; i < atraccionesList.length; i++) {
			String temp = atraccionesList[i];
			turismo.Atraccion a1 = turismo.Sistema.getAtraccionesList().stream()
			.filter(e -> (e.getNombre().equalsIgnoreCase(temp)))
			.findFirst()
			.get();
			tiempoTotal += a1.tiempo;
		}
		return tiempoTotal;
	}	
}
