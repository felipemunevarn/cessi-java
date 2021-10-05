package pony;

public class App {

	public static void main(String[] args) {

	}
	
	public static int caballos(int[] distancias) { 
		int contCaballos = 0;
		int distRecorrida = 0;
		for (int i = 0; i < distancias.length; i++) {
			distRecorrida += distancias[i];
			if(i == (distancias.length - 1)) { 
				if (distRecorrida >= distancias[i]) {
					contCaballos++;
				}
			} else {
				if ((distRecorrida + distancias[i + 1]) > 100) {
					distRecorrida = 0;
					contCaballos++;
				}
			}
		}
		return contCaballos;
	}
	
	public static int caballos2(int[] distancias) {
		final int DISTANCIA_MAXIMA = 100;
//		verificarDistacias(distancias);
		int distancia = 0;
		int cantCaballos = 0;
		for (int i = 0; i < distancias.length; i++) {
			if (distancias[i] > 0) {
				if (distancia + distancias[i] > DISTANCIA_MAXIMA) {
					distancia = 0;
				}
				if (distancia == 0) {
					cantCaballos++;
				}
				distancia = distancia + distancias[i];
			}
		}
		return cantCaballos;
	}
	
	public static int caballos3(int[] distancias) {
		int cantidadDeCaballos = 1;
		int millasAcumuladas = 0;
		
		for (int millas : distancias) {
			
			if (millasAcumuladas+millas > 100) {
				cantidadDeCaballos++;
				millasAcumuladas = 0;
			}
			
			millasAcumuladas += millas;
		}
		return cantidadDeCaballos;
	}
}
