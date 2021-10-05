package eradeimperios;

public class Unidad {
	private Posicion pos;
	private int salud = 100;
	private double distMinimaAtaque;
	private double distMaximaAtaque;
	private int danioInfringido;

	public Unidad(Posicion pos) {
		this.pos = pos;
		this.distMinimaAtaque = 0;
		this.distMaximaAtaque = 2;
		this.danioInfringido = 10;
	}

	public double distanciaCon(Unidad otraUnidad) {
		return Math.sqrt(Math.pow(this.pos.getX() - otraUnidad.pos.getX(), 2) + Math.pow(this.pos.getY() - otraUnidad.pos.getY(), 2));
	}
	
	public void atacar(Unidad otraUnidad){
		if(this.distanciaCon(otraUnidad) > distMinimaAtaque && this.distanciaCon(otraUnidad) < distMaximaAtaque) {
			otraUnidad.salud -= danioInfringido;
		}
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public double getDistMinimaAtaque() {
		return distMinimaAtaque;
	}

	public void setDistMinimaAtaque(double distMinimaAtaque) {
		this.distMinimaAtaque = distMinimaAtaque;
	}

	public double getDistMaximaAtaque() {
		return distMaximaAtaque;
	}

	public void setDistMaximaAtaque(double distMaximaAtaque) {
		this.distMaximaAtaque = distMaximaAtaque;
	}

	public int getDanioInfringido() {
		return danioInfringido;
	}

	public void setDanioInfringido(int danioInfringido) {
		this.danioInfringido = danioInfringido;
	}
	
}
