package turismo.model;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private Producto itinerarioList;
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo=" + tiempo + "]";
	}

	public Usuario(String nombre, double presupuesto, double tiempo) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}

	public Producto getItinerarioList() {
		return itinerarioList;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public String getNombre() {
		return nombre;
	}	
	
	public void comprar(Producto producto) {
		setPresupuesto(presupuesto - producto.costo);
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
}
