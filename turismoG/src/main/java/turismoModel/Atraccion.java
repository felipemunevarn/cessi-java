package turismoModel;

import java.util.List;

public class Atraccion implements Ofertable {
	private int cupo, costo;
	private String nombre;
	private double tiempo;

	public Atraccion(String nombre, int costo, double tiempo, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

	public Atraccion() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getCosto() {
		return this.costo;
	}

	public Double getTiempo() {
		return this.tiempo;
	}

	public int getCupo() {
		return this.cupo;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return this.cupo > 0;
	}

	@Override
	public void reservarCupo() {
		// TODO Auto-generated method stub
		this.cupo--;
	}

	@Override
	public boolean esPromocion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void imprimirOferta() {
		System.out.println("Nombre de la atracci�n: " + this.getNombre() + ".");
		System.out.println("Costo: " + this.getCosto() + " monedas.");
		System.out.println("Duraci�n: " + this.getTiempo() + " horas.");
		System.out.println("-----------------------------------------------------------------");
	}

	@Override
	public List<Atraccion> getAtraccionesList() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void agregarAtraccionesALista(Ofertable ofertable, List<Atraccion> listaAtracciones) {
//		listaAtracciones.add((Atraccion) ofertable);
//	}

}
