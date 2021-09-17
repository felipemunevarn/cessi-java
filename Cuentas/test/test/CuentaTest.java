package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cuentas.Cuenta;

public class CuentaTest {

	@Test(expected = Error.class)	
	public void crearCuentaCon0() {
		Cuenta cuenta = new Cuenta(0);
		
	}

}
