package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.beesafe.model.Risk;

public class RiskTest {

	@Test
	public void test() {
		Risk schwellung = new Risk("Schwellung");
		assertEquals(false, schwellung.getIsOccured());
		assertEquals("Schwellung", schwellung.getName());
		schwellung.setIsOccured(true);
		assertEquals(true, schwellung.getIsOccured());
	}

}
