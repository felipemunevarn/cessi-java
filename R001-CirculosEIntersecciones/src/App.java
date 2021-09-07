
public class App {
	public static void main(String[] args) {
//		throw new Error("Test");
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		System.out.println(c1.intersectaCon(c2));
	}
}
