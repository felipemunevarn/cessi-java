package turismo.model;

import java.util.Arrays;
import java.util.List;

public abstract class Promocion extends Producto {
	protected List<Integer> atraccionesList;
	
	public Promocion(String nombre, List<Integer> atraccionesList) {
		super(nombre);
		this.atraccionesList = atraccionesList;
		
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + "] atraccionesList=" + atraccionesList;
	}




}
