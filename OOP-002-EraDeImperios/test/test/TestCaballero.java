package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import eradeimperios.*;

public class TestCaballero {

	@Test
	public void test() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(0, -2.3));
		Unidad u3 = new Unidad(new Posicion(0, -0.5));
	
		Assert.assertEquals(100, u2.getSalud(), 0);
		u1.atacar(u2);
		Assert.assertEquals( 70, u2.getSalud(), 0);
	
		Assert.assertEquals(100, u3.getSalud(), 0);
		u1.atacar(u3);
		Assert.assertEquals(100, u3.getSalud(), 0);
	}

}
