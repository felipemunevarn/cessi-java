package turismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sun.source.tree.WhileLoopTree;

public class App {

	public static void main(String[] args) {
		Sistema s1 = new Sistema();
		s1.crearUsuarios();
		s1.crearAtracciones();
		s1.crearPromociones();
		for (int i = 0; i < s1.getUsuariosList().size(); i++) {
			Usuario u1 = s1.getUsuariosList().get(i);
			s1.saludar(u1);
			List<Producto> p1 = new ArrayList<Producto>();
			p1 = s1.filtrarProdPosibles(u1);
			Collections.sort(p1, Collections.reverseOrder(new OrdenaPorCosto()));
	//		Collections.sort(p1, new OrdenaPorTiempo());
//			while(p1.size() > 0) {
				if (s1.preguntar(p1.get(0))) {
					System.out.println("Compraste: "+ p1.get(0).nombre);
					u1.comprar();
				}
//			}
		}		
	}
}
