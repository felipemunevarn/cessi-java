package Inversion;

public class Inversion {
	// Atributos
	private double montoInvertir;
	private double interesAnual;

	// Constructor
	public Inversion(double montoInvertir, double interesAnual) {
		this.montoInvertir = montoInvertir;
		this.interesAnual = interesAnual;
	}

	// Metodos
	public double calculaInversion(int cantAniosMax) {
		double saldo = 0;
		for (int i = 0; i < cantAniosMax; i++) {
			saldo = this.montoInvertir * Math.pow((1 + this.interesAnual / 12), ((i + 1) * 12));
			System.out.printf("%.4f\n", saldo);
		}
		return saldo;
	}

	public int calculaTiempoPara(double saldoFinalDeseado) {
		int meses = 0;
		meses = (int) (Math.log(saldoFinalDeseado / this.montoInvertir) / Math.log(1 + this.interesAnual / 12));
		return meses + 1;
	}
}