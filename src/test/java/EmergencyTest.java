package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import beesafe.model.Emergency;

public class EmergencyTest {

	@Test
	public void test() {
		Emergency notaufnahme1 = new Emergency("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Strasse 22 <break time=\\\"0.4s\\\"/>, 81675 München");
		Emergency notaufnahme2 = new Emergency("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "Kölner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 München");
		assertEquals("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Strasse 22 <break time=\\\"0.4s\\\"/>, 81675 München", notaufnahme1.getAddress());
		assertEquals(112, notaufnahme1.getEmergencyCall());
		assertEquals("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "Kölner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 München", notaufnahme2.getAddress());
	}

}
