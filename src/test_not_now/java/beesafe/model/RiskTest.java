package beesafe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
