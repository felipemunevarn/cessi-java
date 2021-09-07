
public class Punto {
	private int x;
	private int y;
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double distanceCon(Punto p2) {
		double distx, disty;
		distx = (this.x - p2.x);
		disty = (this.y - p2.y); 
		return Math.pow((distx * distx + disty * disty), 0.5);
	}
}
