package eradeimperios;

public class Arquero extends Unidad {

	public Arquero(Posicion pos) {
		super(pos);
		this.setDistMinimaAtaque(5);
		this.setDistMaximaAtaque(25);
		this.setDanioInfringido(7);
	}
	
}