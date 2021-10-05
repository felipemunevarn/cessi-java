package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import eradeimperios.*;

public class TestSoldado {

	@Test
	public void test() {
		Soldado u1 = new Soldado(new Posicion(0, 0));
		Unidad u2 = new Unidad(new Posicion(-1, 0));
		Unidad u3 = new Unidad(new Posicion(-1.8, 0));
	
		Assert.assertEquals(100, u2.getSalud(), 0);
		u1.atacar(u2);
		Assert.assertEquals( 80, u2.getSalud(), 0);
	
		Assert.assertEquals(100, u3.getSalud(), 0);
		u1.atacar(u3);
		Assert.assertEquals(100, u3.getSalud(), 0);
	}

}
