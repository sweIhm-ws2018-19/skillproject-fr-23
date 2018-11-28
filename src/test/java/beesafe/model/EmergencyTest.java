package test.java.beesafe.model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.beesafe.model.Emergency;

class EmergencyTest {

	@Test
	void test() {
		Emergency notaufnahme1 = new Emergency("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Stra�e 22 <break time=\\\"0.4s\\\"/>, 81675 M�nchen"); 
		Emergency notaufnahme2 = new Emergency("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "K�lner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 M�nchen");
		assertEquals("Klinikum rechts der Isar <<break time=\\\"0.4s\\\"/>, "
				+ "Ismaninger Stra�e 22 <break time=\\\"0.4s\\\"/>, 81675 M�nchen", notaufnahme1.getAddress());
		assertEquals(112, notaufnahme1.getEmergencyCall());
		assertEquals("Notfallzentrum - Klinikum Schwabing <break time=\\\"0.4s\\\"/>,"
				+ "K�lner Platz 1 <break time=\\\"0.4s\\\"/>, 80804 M�nchen", notaufnahme2.getAddress());
	}

}
