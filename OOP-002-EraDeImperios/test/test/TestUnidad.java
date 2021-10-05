package test;

import org.junit.Assert;
import org.junit.Test;

import eradeimperios.*;

public class TestUnidad {

	@Test
	public void test() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		Assert.assertEquals(Math.sqrt(2), u1.distanciaCon(u2), 0.01);	
	}
	
	@Test
	public void testAtacar() {
		Unidad u1 = new Unidad(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(1, 1));
		Unidad u3 = new Unidad(new Posicion(2, 2));
	
		Assert.assertEquals(100, u2.getSalud(), 0);
		u1.atacar(u2);
		Assert.assertEquals( 90, u2.getSalud(), 0);
	
		Assert.assertEquals(100, u3.getSalud(), 0);
		u1.atacar(u3);
		Assert.assertEquals(100, u3.getSalud(), 0);
	}
}
