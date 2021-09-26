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
}
