package eradeimperios;

public class Soldado extends Unidad {

	public Soldado(Posicion pos) {
		super(pos);
		this.setDistMinimaAtaque(0);
		this.setDistMaximaAtaque(1.5);
		this.setDanioInfringido(20);
	}
	
}
