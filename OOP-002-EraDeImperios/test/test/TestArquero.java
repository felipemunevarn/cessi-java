package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import eradeimperios.*;

public class TestArquero {

	@Test
	public void test() {
		Arquero u1 = new Arquero(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(0, 6));
		Unidad u3 = new Unidad(new Posicion(0, 4));
	
		Assert.assertEquals(100, u2.getSalud(), 0);
		u1.atacar(u2);
		Assert.assertEquals( 93, u2.getSalud(), 0);
	
		Assert.assertEquals(100, u3.getSalud(), 0);
		u1.atacar(u3);
		Assert.assertEquals(100, u3.getSalud(), 0);
	}

}
