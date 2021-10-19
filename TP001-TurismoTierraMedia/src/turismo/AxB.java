package turismo;

import java.util.Arrays;

public class AxB extends Promocion{
	private String[] atraccionesGratis;	
	
	public AxB(String nombre, String[] atraccionesList, String[] atraccionesGratis) {
		super(nombre, atraccionesList);
		this.atraccionesGratis = atraccionesGratis;
		this.costo = calcularCosto();
		this.tiempo = calcularTiempo();
	}

	public int calcularCosto() {
		int costoFinal = 0;
		for (int i = 0; i < atraccionesList.length; i++) {
			String temp = atraccionesList[i];
			turismo.Atraccion a1 = turismo.Sistema.getAtraccionesList().stream()
			.filter(e -> (e.getNombre().equalsIgnoreCase(temp)))
			.findFirst()
			.get();
			costoFinal += a1.costo;
		}
		return costoFinal;
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
		for (int i = 0; i < atraccionesGratis.length; i++) {
			String temp = atraccionesGratis[i];
			turismo.Atraccion a1 = turismo.Sistema.getAtraccionesList().stream()
			.filter(e -> (e.getNombre().equalsIgnoreCase(temp)))
			.findFirst()
			.get();
			tiempoTotal += a1.tiempo;
		}
		return tiempoTotal;
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo
				+ "] atraccionesList=" + Arrays.toString(atraccionesList) +
				Arrays.toString(atraccionesGratis)+ "]"; 
	}
	
}
