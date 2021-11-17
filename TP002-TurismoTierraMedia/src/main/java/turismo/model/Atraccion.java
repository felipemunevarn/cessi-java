package turismo.model;

public class Atraccion extends Producto {
	private int cupo;

	public Atraccion(String nombre, double costo, double tiempo, int cupo) {
		super(nombre, costo, tiempo);
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [cupo=" + cupo + ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + "]";
	}

	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
