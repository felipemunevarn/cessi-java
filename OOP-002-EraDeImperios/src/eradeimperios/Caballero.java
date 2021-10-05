package eradeimperios;

public class Caballero extends Unidad {

	public Caballero(Posicion pos) {
		super(pos);
		this.setDistMinimaAtaque(1);
		this.setDistMaximaAtaque(3);
		this.setDanioInfringido(30);
	}
	
}
