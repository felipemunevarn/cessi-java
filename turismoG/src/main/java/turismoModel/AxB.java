package turismoModel;

import java.util.ArrayList;
import java.util.List;

public class AxB extends Promocion {
	private List<Atraccion> atraccionesGratis = new ArrayList<Atraccion>();

	public AxB(String nombre, List<Atraccion> atraccionesList, List<Atraccion> atraccionesGratis) {
		super(nombre, atraccionesList);
		this.atraccionesGratis = atraccionesGratis;
	}

	public List<Atraccion> getAtraccionesGratis() {
		return atraccionesGratis;
	}

	@Override
	public Integer getCosto() {
		int costoAtraccionesGratis = 0;
		for (int i = 0; i < atraccionesGratis.size(); i++) {
			costoAtraccionesGratis += atraccionesGratis.get(i).getCosto();
		}
		return this.getCostoSinDescuento() - costoAtraccionesGratis;
	}
	
	@Override
	public Integer getCostoSinDescuento() {
		int costoTotal = 0;
		int costoAtraccionesGratis = 0;
		for (int i = 0; i < atraccionesList.size(); i++) {
			costoTotal += atraccionesList.get(i).getCosto();
		}
		for (int i = 0; i < atraccionesGratis.size(); i++) {
			costoAtraccionesGratis += atraccionesGratis.get(i).getCosto();
		}
		return costoTotal + costoAtraccionesGratis;
	}

	public String getNombre() {
		return this.nombre;
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
		System.out.println("Atracciones gratis: ");
		for (Atraccion atraccion : atraccionesGratis) {
			System.out.println(atraccion.getNombre());
		}
		System.out.println("Duración: " + this.getTiempo());
		System.out.println("Precio original: " + this.getCostoSinDescuento());
		System.out.println("Precio con descuento: " + this.getCosto());
		System.out.println("-----------------------------------------------------------------");
	}
}
