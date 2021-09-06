
public class Circulo {
	private Punto center;
	private double radio;
	public Circulo() {
		super();
	}
	public Circulo(Punto center, double radio) {
		super();
		this.center = center;
		this.radio = radio;
	}
	public Punto getCenter() {
		return center;
	}
	public void setCenter(Punto center) {
		this.center = center;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double distance(Punto p1, Punto p2) {
		double distx, disty;
		distx = (p1.getX() - p2.getX());
		disty = (p1.getY() - p2.getY()); 
		return Math.pow((distx * distx + disty * disty), 0.5);
	}
	public boolean intersectaCon(Circulo circ2) {
		return distance(this.getCenter(),circ2.getCenter()) < (this.getRadio() + circ2.getRadio());
	}
}
