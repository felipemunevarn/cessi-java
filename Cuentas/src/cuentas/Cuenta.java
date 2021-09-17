package cuentas;

public class Cuenta {
	private double saldo;

	public Cuenta(double saldo) {
		if (saldo <= 0) {
			throw new Error("No se puede generar una cuenta con saldo 0 ó menos");
		}
		this.saldo = saldo;
	}

	public double obtenerSaldo() {
		return this.saldo;
	}

	public void extraer(double aExtraer) {
		if (aExtraer < 0) {
			throw new Error("No se puede extraer un monto negativo");
		}
		if (this.saldo - aExtraer < 0) {
			throw new Error("No tiene saldo suficiente");
		}
		this.saldo -= aExtraer;
	}

	public double extraerOtra(double aExtraer) {

	}
}
