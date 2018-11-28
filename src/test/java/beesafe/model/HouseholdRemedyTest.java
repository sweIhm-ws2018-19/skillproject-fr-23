package test.java.beesafe.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.beesafe.model.HouseholdRemedy;

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
