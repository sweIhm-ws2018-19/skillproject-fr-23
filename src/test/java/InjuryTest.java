package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import beesafe.model.HouseholdRemedy;
import beesafe.model.Injury;
import beesafe.model.Risk;

public class InjuryTest {

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

}
