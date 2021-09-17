package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Inversion.Inversion;

public class InversionTest {
	private Inversion ejem1;
	private Inversion ejem2;
	private Inversion ejem3;
	private Inversion ejem4;
	
	@Before
	public void init() {
		ejem1 = new Inversion(1000, 0.24);
		ejem2 = new Inversion(1000, 0.71355714);
		ejem3 = new Inversion(1000, 0.07);
		ejem4 = new Inversion(1000, 0.24);
	}
	
	@Test
	public void calculaInversionTest() {
		System.out.println("Ejemplo1");
		assertEquals(ejem1.calculaInversion(4), 2587.07, 0.01);
		System.out.println("Ejemplo2");
		assertEquals(ejem2.calculaInversion(5), 32000.0012, 0.0001);
	}
	
	@Test
	public void calculaTiempoParaTest() {
		assertEquals(ejem3.calculaTiempoPara(2000), 120, 0);
		assertEquals(ejem4.calculaTiempoPara(2587), 48, 0);
	}
}
