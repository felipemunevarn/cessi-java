package turismo;

public abstract class Producto {
	protected String nombre;
	protected int costo;
	protected double tiempo;
	
	public Producto(String nombre, int costo, double tiempo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
	}

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + "]";
	}

	public void ordenarProductos() {
		
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
