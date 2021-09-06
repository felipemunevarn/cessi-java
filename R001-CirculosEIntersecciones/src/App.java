
public class App {
	public static void main(String[] args) {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(0, 2), 1.5);
		System.out.println(c1.intersectaCon(c2));
	}
}
