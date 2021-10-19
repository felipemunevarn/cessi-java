package turismo;

import java.util.Comparator;

public class OrdenaPorCosto implements Comparator<Producto> {
	
	@Override
	public int compare (Producto p1, Producto p2) {
		return Integer.valueOf(p1.getCosto()).compareTo(p2.getCosto());
	}
}
