package turismo;

public class Porcentual extends Promocion {
	private int porcentajeDescuento;

	public Porcentual(String nombre, int porcentajeDescuento, String[] atraccionesList) {
		super(nombre, atraccionesList);
		this.porcentajeDescuento = porcentajeDescuento;
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
		return costoFinal * (1 - getPorcentajeDescuento() / 100);
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
	
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	
	
}
