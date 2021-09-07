package prueba;

public class Punto {

	private double ejeX;
	private double ejeY;

	/**
	 * pre: Un punto debe tener dos coordenadas (una en X y otra en Y). post: Se
	 * crea el punto con los datos establecidos.
	 * 
	 * @param ejeX
	 * @param ejeY
	 */
	public Punto(double ejeX, double ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}

	/**
	 * @return la coordenada en X del punto.
	 */
	public double getEjeX() {
		return ejeX;
	}

	/**
	 * @return la coordenada en Y del punto.
	 */
	public double getEjeY() {
		return ejeY;
	}

	/**
	 * post: Devuelve la distancia entre dos puntos
	 * 
	 * @param otroPunto
	 * @return
	 */
	public double distanciaAlPunto(Punto otroPunto) {
		return Math.sqrt((Math.pow(otroPunto.getEjeX() - getEjeX(), 2)) + Math.pow(otroPunto.getEjeY() - getEjeY(), 2));
	}
}
