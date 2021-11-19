package turismoModel;

import java.util.List;

public class Descuento extends Promocion {
	private int porcentaje;
	private int costo;

	public Descuento(String nombre, int porcentaje, List<Atraccion> atraccionesList) {
		super(nombre, atraccionesList);
		this.porcentaje = porcentaje;
		this.costo = costoFinal();
	}
	
	public int getPorcentajeDescuento() {
		return porcentaje;
	}

	public Integer getCosto() {
		return costo;
	}

	public int costoFinal() {
		return this.getCostoSinDescuento() - this.getCostoSinDescuento() * porcentaje / 100;
	}

	@Override
	public void imprimirOferta() {
		System.out.println("");
		System.out.print("PROMOCION: ");
		System.out.println(getNombre());
		System.out.println("Atracciones Incluidas: ");
		for (Atraccion atraccion : atraccionesList) {
			System.out.println(atraccion.getNombre());
		}
		System.out.println("Duración: " + this.getTiempo());
		System.out.println("Precio original: " + this.getCostoSinDescuento());
		System.out.println("Precio con descuento: " + this.getCosto());
		System.out.println("Descuento: " + this.porcentaje + " %");
		System.out.println("-----------------------------------------------------------------");
	}
}
