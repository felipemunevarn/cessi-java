package turismo;

public abstract class Producto implements Comparable<Producto> {
	protected String nombre;
	protected int costo;
	protected double tiempo;
	
	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public Producto(String nombre, int costo, double tiempo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + "]";
	}
	
}
