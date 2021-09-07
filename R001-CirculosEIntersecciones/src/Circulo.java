
public class Circulo {
	private Punto center;
	private double radio;
	public Circulo(Punto center, double radio) {
		this.center = center;
		this.radio = radio;
	}
	public boolean intersectaCon(Circulo circ2) {
		return this.center.distanceCon(circ2.center) < this.radio + circ2.radio;
	}
}
