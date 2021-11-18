package turismoModel;

import java.util.List;

public class Absoluto extends Promocion {
	private int precioAbsoluto;

	public Absoluto(String nombre, List<Atraccion> atraccionesList, int precioAbsoluto) {
		super(nombre, atraccionesList);
		this.precioAbsoluto = precioAbsoluto;
	}

	@Override
	public Integer getCosto() {
		return precioAbsoluto;
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
		System.out.println("Duraci�n: " + this.getTiempo());
		System.out.println("Precio original: " + this.getCostoSinDescuento());
		System.out.println("Precio con descuento: " + this.getCosto());
		System.out.println("-----------------------------------------------------------------");
	}

}
