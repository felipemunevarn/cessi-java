package turismoModel;

import java.util.Comparator;

public class Ordenador implements Comparator<Ofertable> {

	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		if (o1.getCosto().compareTo(o2.getCosto()) == 0) {
			return -o1.getTiempo().compareTo(o2.getTiempo());
		} else {
			return -o1.getCosto().compareTo(o2.getCosto());
		}
	}

}
