package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import main.java.beesafe.model.HouseholdRemedy;
import main.java.beesafe.model.Injury;
import main.java.beesafe.model.Risk;

public class InjuryAlternativeTest {

	@Test
	public void test() {
		ArrayList<HouseholdRemedy> households = new ArrayList<>();
		households.add(new HouseholdRemedy("Zitrone/Zwiebel", "Sehr gut! Halbiere die Zitrone oder "
				+ "Zwiebel und lege die Schnittstelle auf den Stich. Das Gift wird dadurch dem Stich entzogen. "
				+ "Kühle die Stelle trotzdem weiterhin und kratze die Stelle nicht."));
		households.add(new HouseholdRemedy("Venestil", "Sehr gut! Trage etwas von der Salbe auf. "
					+ "Sie wirkt entzündungshemmend und kühlt die Stelle. "
					+ "Versuche trotzdem die Stelle weiterhin zu kühlen. "
					+ "Vermeide es die Stelle zu kratzen."));
		households.add(new HouseholdRemedy("Backpulver", "Super! Backpulver hilft auch gut - vermische es mit ein "
				+ "bisschen Wasser zu einer Paste und trage es auf den Stich auf. Sollte es dir gut tun kannst du es "
				+ "auch nochmal später wiederholen. Vergiss nicht weiterhin die Wunde zu kühlen und kratze nicht an der "
				+ "Einstichstelle."));
		ArrayList<Risk> risks = new ArrayList<>();	
		risks.add(new Risk("Schwellung"));
		risks.add(new Risk("Riskante Stelle"));
		Injury bienenstich = new Injury("Stich");
		bienenstich.setHouseholds(households);
		bienenstich.setRisks(risks);
		
		assertEquals("Stich", bienenstich.getInjury());
	}

	@Test
	public void testToString() {
		ArrayList<HouseholdRemedy> households = new ArrayList<>();
		households.add(new HouseholdRemedy("bla", "blub"));
		ArrayList<Risk> risks = new ArrayList<>();	
		risks.add(new Risk("risk"));
		Injury stich = new Injury("bienenstich");
		stich.setHouseholds(households);
		stich.setRisks(risks);
		assertEquals("Name: bienenstich\nRisikofaktoren: \nName: risk\nAufgetreten: false\n"+
				"Hausmittel: \nName: bla\nVorraetig: false\nAnwendung: blub\n",stich.toString());
	}
	
	@Test
	public void testIsValidTrue() {
		assertTrue(new Injury("a").isValid());
	}
	
	@Test
	public void testIsValidFalse() {
		assertFalse(new Injury("").isValid());
	}
}
