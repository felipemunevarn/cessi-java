package turismo;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion extends Producto {
	protected List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	
	public Promocion(String nombre, List<Atraccion> atraccionesList) {
		super(nombre);
		this.atraccionesList = atraccionesList;
		
	}

	@Override
	public String toString() {
		return super.toString() + " Promocion [atraccionesList=" + atraccionesList + "]";
	}
}
