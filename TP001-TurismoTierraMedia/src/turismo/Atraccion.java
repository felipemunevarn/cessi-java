package turismo;

public class Atraccion extends Producto {
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, int cupo) {
		super(nombre, costo, tiempo);
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + super.nombre + ", costo=" + super.costo + ", tiempo=" + super.tiempo + "]";
	}
}
