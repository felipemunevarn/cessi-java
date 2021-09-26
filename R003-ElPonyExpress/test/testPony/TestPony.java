package testPony;

import pony.App;
import org.junit.Assert;
import org.junit.Test;

public class TestPony {

	@Test
	public void test() {
		Assert.assertEquals(1, App.caballos(new int[] { 18, 15 }));
		Assert.assertEquals(2, App.caballos(new int[] { 43, 23, 40, 13 }));
		Assert.assertEquals(3, App.caballos(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
		Assert.assertEquals(3, App.caballos(new int[] { 51, 51, 51 }));
		Assert.assertEquals(4, App.caballos(new int[] { 6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49 }));
	}

}
