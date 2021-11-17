package turismo.model;

import java.util.Arrays;

public abstract class Promocion extends Producto {
	protected String[] atraccionesList;
	
	public Promocion(String nombre, String[] atraccionesList) {
		super(nombre);
		this.atraccionesList = atraccionesList;
		
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + "] atraccionesList=" + Arrays.toString(atraccionesList);
	}




}
