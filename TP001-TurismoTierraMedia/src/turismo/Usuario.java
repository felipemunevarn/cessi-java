package turismo;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempo;
	private Producto itinerarioList;
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo=" + tiempo + "]";
	}

	public Usuario(String nombre, int presupuesto, double tiempo) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}

	public Producto getItinerarioList() {
		return itinerarioList;
	}

	public String getNombre() {
		return nombre;
	}	
	
}
