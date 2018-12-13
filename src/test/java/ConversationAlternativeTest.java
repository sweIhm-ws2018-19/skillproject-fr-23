package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.beesafe.model.Conversation;

public class ConversationAlternativeTest {
		
	@Test
	public void testStichYes() {
		Conversation.reset();
		String injuryString = "stich"; 
		Conversation.setInjury(injuryString); 
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Oh nein! Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! Hast du schonmal allergisch auf Stiche reagiert?", Conversation.getAnswerToInjury());
		assertEquals("Hast du den Stachel schon rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert?", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Wenn du mir deine Adresse gibst kann ich dir das nächstgelegen Krankenhaus sagen: ", Conversation.getNextAnswer(true));
		assertEquals("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Wenn du mir deine Adresse gibst kann ich dir das nächstgelegen Krankenhaus sagen: ", Conversation.getNextAnswer(true));
		assertEquals("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Wenn du mir deine Adresse gibst kann ich dir das nächstgelegen Krankenhaus sagen: ", Conversation.getNextAnswer(true));
		assertEquals("Sehr gut! Trage etwas von der Salbe auf. Sie wirkt entzündungshemmend und kühlt die Stelle. Versuche trotzdem die Stelle weiterhin zu kühlen. Vermeide es die Stelle zu kratzen.", Conversation.getNextAnswer(true));
		assertEquals("Sehr gut! Halbiere die Zitrone oder Zwiebel und lege die Schnittstelle auf den Stich. Das Gift wird dadurch dem Stich entzogen. Kühle die Stelle trotzdem weiterhin und kratze die Stelle nicht.", Conversation.getNextAnswer(true));
		assertEquals("Super! Backpulver hilft auch gut - vermische es mit ein bisschen Wasser zu einer Paste und trage es auf den Stich auf. Sollte es dir gut tun kannst du es auch nochmal später wiederholen. Vergiss nicht weiterhin die Wunde zu kühlen und kratze nicht an der Einstichstelle.", Conversation.getNextAnswer(true));
		assertEquals("Und du weißt, Oma ist immer für dich da. Es kann passieren, dass sich der Stich infiziert dann solltest du nochmal zum Onkel Doktor schauen. Aber das passiert meistens nicht - du weißt doch, Oma ist immer übervorsichtig.", Conversation.getGoodByeMessage());
	}
	
	@Test
	public void testStichNo() {
		Conversation.reset();
		String injuryString = "stich"; 
		Conversation.setInjury(injuryString); 
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Oh nein! Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! Hast du schonmal allergisch auf Stiche reagiert?", Conversation.getAnswerToInjury());
		assertEquals("Hast du den Stachel schon rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert?", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Wo wurdest du gestochen?", Conversation.getNextAnswer(false));
		assertEquals("OK das hört sich nicht so schlimm an! Ist es denn stark geschwollen oder hast du Atemnot?", Conversation.getNextAnswer(false));
		assertEquals("Perfekt! Dann ist es nicht schlimm bleib ruhig und befolge Omas Rat. Hast du Venestil zu Hause?", Conversation.getNextAnswer(false));
		assertEquals("Nicht schlimm, lass mich mal in der Küche schauen, was passen könnte. <audio src='soundbank://soundlibrary/foley/amzn_sfx_kitchen_ambience_01'/> Ah! Ich habe was gefunden! Hast du vielleicht eine Zitrone oder eine Zwiebel zu Hause?", Conversation.getNextAnswer(false));
		assertEquals("Ok nicht schlimm! Oma weiß doch immer einen Ausweg. Hast du Backpulver da?", Conversation.getNextAnswer(false));
		assertEquals("Auch nicht so schlimm. Kühle den Stich einfach mit ein paar umwickelten Eiswürfeln oder einem kalten Handtuch. Pass aber auf, dass du nicht zu sehr kühlst, sonst kommt es zu Irritationen an der Haut. Lager die Stelle etwas hoch und versuche dich zu schonen. Wichtig ist auch, dass du nicht an der Stelle kratzt!", Conversation.getNextAnswer(false));
		assertEquals("Und du weißt, Oma ist immer für dich da. Es kann passieren, dass sich der Stich infiziert dann solltest du nochmal zum Onkel Doktor schauen. Aber das passiert meistens nicht - du weißt doch, Oma ist immer übervorsichtig.", Conversation.getGoodByeMessage());
	}
	
	@Test
	public void testSonnenbrandYes() {
		Conversation.reset();
		String injuryString = "sonnenbrand"; 
		Conversation.setInjury(injuryString); 
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Oh je, <break time=\"0.1s\"/> bei starkem Sonnenbrand können Blasen entstehen. Siehst du welche?", Conversation.getAnswerToInjury());
		assertEquals("Siehst du Blasen an deinem Sonnenbrand?", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Dann solltest du auf jeden Fall zu einem Arzt gehen. Hier sind die Notaufnahmen: ", Conversation.getNextAnswer(true));
		assertEquals("Oh je, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Hier sind die nächsten Notaufnahmen:", Conversation.getNextAnswer(true));
		assertEquals("Sehr gut! Trage es einfach großzügig auf den Sonnenbrand auf.", Conversation.getNextAnswer(true));
		assertEquals("Super, streich das Produkt einfach auf ein Baumwolltuch und lege auf die verbrannte Stelle. Bevor es wieder warm wird, solltest du es aber wegnehmen.", Conversation.getNextAnswer(true));
		assertEquals("Sehr gut, bereite den Tee zu und lege die gebrauchten Teebeutel in den Kühlschrank. Sobald sie kalt sind, kannst du sie auf deine verbrannte Haut legen.", Conversation.getNextAnswer(true));
		assertEquals("Super, schneide die Gurke in Scheiben und lege diese dann auf den Sonnenbrand.", Conversation.getNextAnswer(true));
		assertEquals("Vergiss nicht viel zu trinken! Und du weißt, Oma ist immer für dich da. Falls doch noch Blasen entstehen, solltest du auf jeden Fall zu einem Arzt gehen. Das passiert aber selten - du weißt doch, Oma ist immer übervorsichtig.", Conversation.getGoodByeMessage());
	}
	
	@Test
	public void testSonnenbrandNo() {
		Conversation.reset();
		String injuryString = "sonnenbrand"; 
		Conversation.setInjury(injuryString); 
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Oh je, <break time=\"0.1s\"/> bei starkem Sonnenbrand können Blasen entstehen. Siehst du welche?", Conversation.getAnswerToInjury());
		assertEquals("Siehst du Blasen an deinem Sonnenbrand?", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Gut, hast du Kreislaufprobleme oder Fieber?", Conversation.getNextAnswer(false));
		assertEquals("Sehr schön, dann lass mich mal in meinem schlauen Büchlein nachsehen. <audio src='soundbank://soundlibrary/human/amzn_sfx_walking_on_grass_02'/> Hast du Aloe Vera oder Feuchtigkeitscreme zur Hand?", Conversation.getNextAnswer(false));
		assertEquals("Nicht schlimm, hast du Quark oder Joghurt daheim?", Conversation.getNextAnswer(false));
		assertEquals("Okay, kein Problem! Hast du Kamillentee oder Schwarzen Tee zur Hand?", Conversation.getNextAnswer(false));
		assertEquals("Das ist nicht schlimm, hast du eine Gurke daheim?", Conversation.getNextAnswer(false));
		assertEquals("Schade, aber eine kalte Dusche wird deiner Haut auch guttun.", Conversation.getNextAnswer(false));
		assertEquals("Vergiss nicht viel zu trinken! Und du weißt, Oma ist immer für dich da. Falls doch noch Blasen entstehen, solltest du auf jeden Fall zu einem Arzt gehen. Das passiert aber selten - du weißt doch, Oma ist immer übervorsichtig.", Conversation.getGoodByeMessage());
	}
	
	@Test
	public void testNoInjury() {
		Conversation.reset();
		assertEquals("Ich habe dich leider nicht verstanden. Kannst du mir deine Verletzung nochmal sagen?", Conversation.getAnswerToInjury());
		assertEquals("Bitte sag mir zuerst, was deine Verletzung ist.", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen", Conversation.getNextAnswer(true));
		assertEquals("Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen", Conversation.getNextAnswer(false));
		assertEquals("Ich hoffe, ich konnte dir weiterhelfen.", Conversation.getGoodByeMessage());
	}
	
	@Test
	public void testUnknownInjury() {
		Conversation.reset(); 
		String injuryString = "kopfschmerzen"; 
		Conversation.setInjury(injuryString); 
		assertEquals("Oh! Da kenne ich mich leider nicht aus. Hier sind drei Notaufnahmen in deiner Naehe: ", Conversation.getAnswerToInjury());
		assertEquals("Da kann ich dir leider nicht helfen. Geh doch zur naechsten Notaufnahme. ", Conversation.getAnswerToInjuryReprompt());
		assertEquals("Super, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(true));
		assertEquals("Oh! da kenne ich mich leider nicht aus.", Conversation.getNextAnswer(true));
		assertEquals("Oh! da kenne ich mich leider nicht aus.", Conversation.getNextAnswer(false));
		assertEquals("Ich hoffe, ich konnte dir weiterhelfen.", Conversation.getGoodByeMessage());
	}

	@Test
	public void testEmergencyLastInjury() {
		Conversation.reset(); 
		assertEquals("Ohje, dann solltest du vielleicht zu einem Arzt gehen. Möchtest du wissen, wo die nächste Notaufnahme ist?", Conversation.getNextAnswer(false));
		assertEquals("Hier sind die Notaufnahmen:", Conversation.getNextAnswer(true));
	}	
	
	@Test
	public void testNoEmergencyLastInjury() {
		Conversation.reset(); 
		assertEquals("Ohje, dann solltest du vielleicht zu einem Arzt gehen. Möchtest du wissen, wo die nächste Notaufnahme ist?", Conversation.getNextAnswer(false));
		assertEquals("Alles klar, wie kann ich dir sonst helfen?", Conversation.getNextAnswer(false));
	}
}