package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.java.beesafe.model.HospitalFinder;

public class HospitalFinderTest {
	private static final String validAddress = "münchen+marienplatz+3";
	private static final String invalidAddress = "würstelbude";

	@Test
	public void testValidAddress() {
		HospitalFinder finder = new HospitalFinder();
		String[] answer = finder.getNextHospitalAddress(validAddress);
		assertEquals("Klinikum der Ludwig-Maximilians-Uni", answer[0]);
		assertEquals("Lindwurmstraße 2 2", answer[1]);
		assertEquals("80337 München", answer[2]);
	}
	
	@Test
	public void testInvalidAddress() {
		HospitalFinder finder = new HospitalFinder();
		String[] answer = finder.getNextHospitalAddress(invalidAddress);
		assertNull(answer);
	}
}
