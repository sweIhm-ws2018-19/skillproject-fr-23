package beesafe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class HouseholdRemedyTest {

	@Test
	void test() {
		HouseholdRemedy gurke = new HouseholdRemedy("Gurke", 
				"Super, schneide die Gurke in Scheiben und lege diese "
				+ "dann auf den Sonnenbrand.");
		assertEquals("Gurke", gurke.getName());
		assertEquals("Super, schneide die Gurke in Scheiben und "
				+ "lege diese dann auf den Sonnenbrand.", gurke.getAction());
		assertEquals(false, gurke.getInstock());
		gurke.setInstock(true);
		assertEquals(true, gurke.getInstock());
		
	}

}
