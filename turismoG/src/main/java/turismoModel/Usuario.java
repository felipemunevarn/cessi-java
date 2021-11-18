package turismoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempo;
	private List<Ofertable> itinerario = new ArrayList<Ofertable>();

	public Usuario(String nombre, int presupuesto, double tiempo) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo=" + tiempo + "]";
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo() {
		return tiempo;
	}
	
	public void restarTiempo(double tiempo) {
		this.tiempo-=tiempo;
	}

	public void restarPresupuesto(double dineroGastado) {
		this.presupuesto -= dineroGastado;
	}

	public List<Ofertable> getItinerario() {
		return itinerario;
	}
	
	public void setItinerario(List<Ofertable> itinerarioDado) {
		itinerario = itinerarioDado;
	}

	public boolean aceptaOferta(Ofertable ofertable) throws IOException {
			ofertable.imprimirOferta();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String respuesta = null;
			do {
				System.out.println("Acepta sugerencia? Ingrese S o N");
				respuesta = br.readLine();
			} while (!(respuesta.equalsIgnoreCase("S")  || respuesta.equalsIgnoreCase("N")));
			if (respuesta.equalsIgnoreCase("S")) {
				return true;
			}
			return false;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
}
