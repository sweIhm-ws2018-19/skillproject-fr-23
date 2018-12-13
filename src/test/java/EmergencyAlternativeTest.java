package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.beesafe.model.Emergency;

public class EmergencyAlternativeTest {

	@Test
	public void testGetAddress() {
		Emergency notaufnahme1 = new Emergency("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Strasse 22 <break time=\\\"0.4s\\\"/>, 81675 München");
		Emergency notaufnahme2 = new Emergency("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "Kölner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 München");
		assertEquals("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Strasse 22 <break time=\\\"0.4s\\\"/>, 81675 München", notaufnahme1.getAddress());		
		assertEquals("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "Kölner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 München", notaufnahme2.getAddress());
	}
	
	@Test
	public void testGetEmergencyCall() {
		assertEquals(112, new Emergency("").getEmergencyCall());
	}

	@Test
	public void testToString() {
		Emergency notaufnahme1 = new Emergency("Krankenhaus Buxdehude");
		assertEquals("Notrufnummer: 112\nAdresse: Krankenhaus Buxdehude", notaufnahme1.toString());
	}
}
