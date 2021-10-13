package turismo;

import java.util.List;

public class ConDescuento extends Promocion{
	private int descuento;

	public ConDescuento(String nombre, int descuento, List<Atraccion> atraccionesList, int descuento) {
		super(nombre, atraccionesList);
		this.descuento = descuento;
	}
	
}
