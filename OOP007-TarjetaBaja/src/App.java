
public class App {

	public static void main(String[] args) {
		TarjetaBaja miBaja = new TarjetaBaja(500);
		miBaja.pagarViajeEnColectivo();
		System.out.println(miBaja.contarViajes());
		System.out.println(miBaja.obtenerSaldo());
		miBaja.pagarViajeEnSubte();
		System.out.println(miBaja.contarViajesEnSubte());
		System.out.println(miBaja.obtenerSaldo());
		miBaja.cargar(40);
		System.out.println(miBaja.obtenerSaldo());
	}

}
