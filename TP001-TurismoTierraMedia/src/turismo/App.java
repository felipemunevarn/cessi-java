package turismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Sistema s1 = new Sistema();
		s1.crearUsuarios();
		s1.crearAtracciones();
		s1.crearPromociones();
		for (int i = 0; i < s1.getUsuariosList().size(); i++) {
			Usuario u1 = s1.getUsuariosList().get(i);
			System.out.println("Hola " + u1.getNombre() + "!!!");
			
		}
		List<Producto> p1 = new ArrayList<Producto>();
		p1.addAll(s1.getAtraccionesList());
		p1.addAll(s1.getPromosList());
		Collections.sort(p1, Collections.reverseOrder(new OrdenaPorCosto()));
		for (int i = 0; i < p1.size(); i++) {
			System.out.println(p1.get(i));
		}
		
	}

}
