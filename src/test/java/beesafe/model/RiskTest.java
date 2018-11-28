package test.java.beesafe.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.beesafe.model.Risk;

class RiskTest {

	@Test
	void test() {
		Risk schwellung = new Risk("Schwellung");
		assertEquals(false, schwellung.getIsOccured());
		assertEquals("Schwellung", schwellung.getName());
		schwellung.setIsOccured(true);
		assertEquals(true, schwellung.getIsOccured());
	}

}
