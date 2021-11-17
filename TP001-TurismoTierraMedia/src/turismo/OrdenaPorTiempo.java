package turismo;

import java.util.Comparator;

public class OrdenaPorTiempo implements Comparator<Producto> {
	
	@Override
	public int compare (Producto p1, Producto p2) {
		return Double.valueOf(p1.getTiempo()).compareTo(p2.getTiempo());
	}
}
