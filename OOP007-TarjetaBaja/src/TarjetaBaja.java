
public class TarjetaBaja {
	private double saldo;
	private int cantViajesColec = 0, cantViajesSubte = 0;
	private final double PRECIO_COLECTIVO = 21.5;
	private final double PRECIO_SUBTE = 19.5;
	
	/**
	 * post: saldo de la Tarjeta en saldoInicial.
	 */
	public TarjetaBaja(double saldoInicial) {
		saldo = saldoInicial;
	}

	/**
	 * post: devuelve el saldo actual de la Tarjeta
	 */
	public double obtenerSaldo() {
		return saldo;
	}

	/**
	 * post: agrega el monto al saldo de la Tarjeta.
	 */
	public void cargar(double monto) {
		if (monto > 0) {
			saldo += monto;
		} else {
			System.out.println("Monto incorrecto. Debe ser mayor a 0");
		}		
	}

	/**
	 * pre : saldo suficiente. post: utiliza 21.50 del saldo para un viaje en
	 * colectivo.
	 */
	public void pagarViajeEnColectivo() {
		if (saldo >= PRECIO_COLECTIVO) {
			saldo -= PRECIO_COLECTIVO;
			cantViajesColec++;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	/**
	 * pre : saldo suficiente. post: utiliza 19.50 del saldo para un viaje en subte.
	 */
	public void pagarViajeEnSubte() {
		if (saldo >= PRECIO_SUBTE) {
			saldo -= PRECIO_SUBTE;
			cantViajesSubte++;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	/**
	 * post: devuelve la cantidad de viajes realizados.
	 */
	public int contarViajes() {
		return (cantViajesColec + cantViajesSubte);
	}

	/**
	 * post: devuelve la cantidad de viajes en colectivo.
	 */
	public int contarViajesEnColectivo() {
		return cantViajesColec;
	}

	/**
	 * post: devuelve la cantidad de viajes en subte.
	 */
	public int contarViajesEnSubte() {
		return cantViajesSubte;
	}

}
