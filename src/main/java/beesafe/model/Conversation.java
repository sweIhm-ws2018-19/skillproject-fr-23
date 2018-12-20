package main.java.beesafe.model;

import main.java.beesafe.handlers.YesIntentHandler;

public class Conversation {
	private static boolean remedyFirstTime = true;
	private static boolean doNotRepeat = true;
	private static int index = -1; 
	private static Injury injury = null; 
	private static final String SONNENBRAND = "sonnenbrand";
	private static final String STICH = "stich";
	private static Injury lastInjury = null;
	private static boolean nowConversation = (lastInjury != null);
	private static final String HOSPITAL = "Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Oma kann nicht mehr so gut hören, daher sage mir bitte vor dem Straßennamen und der Stadt laut und deutlich <break time =\"1s\"/>Meine Adresse ist: ";
	private static final String UNDERSTOOD = "Hast du das Verstanden?";
	
	private Conversation() {
	    throw new IllegalStateException("Utility class");
	  }
	
	private static final String[] answersToYes_stich = new String[] {
			HOSPITAL,
			HOSPITAL,
			HOSPITAL,
			"Sehr gut! Trage etwas von der Salbe auf. Sie wirkt entzündungshemmend und kühlt die Stelle. Versuche trotzdem die Stelle weiterhin zu kühlen. Vermeide es die Stelle zu kratzen. " + UNDERSTOOD, 
			"Sehr gut! Halbiere die Zitrone oder Zwiebel und lege die Schnittstelle auf den Stich. Das Gift wird dadurch dem Stich entzogen. Kühle die Stelle trotzdem weiterhin und kratze die Stelle nicht. " + UNDERSTOOD, 
			"Super! Backpulver hilft auch gut - vermische es mit ein bisschen Wasser zu einer Paste und trage es auf den Stich auf. Sollte es dir gut tun kannst du es auch nochmal später wiederholen. Vergiss nicht weiterhin die Wunde zu kühlen und kratze nicht an der Einstichstelle. " + UNDERSTOOD
	}; 
	private static final String[] answersToNo_stich = new String[]{
			"Wo wurdest du gestochen?",
			"OK das hört sich nicht so schlimm an! Ist es denn stark geschwollen oder hast du Atemnot?", 
			"Perfekt! Dann ist es nicht schlimm bleib ruhig und befolge Omas Rat. Hast du Venestil zu Hause?", 
			"Nicht schlimm, lass mich mal in der Küche schauen, was passen könnte. <audio src='soundbank://soundlibrary/foley/amzn_sfx_kitchen_ambience_01'/> Ah! Ich habe was gefunden! Hast du vielleicht eine Zitrone oder eine Zwiebel zu Hause?", 
			"Ok nicht schlimm! Oma weiß doch immer einen Ausweg. Hast du Backpulver da?", 
			"Auch nicht so schlimm. Kühle den Stich einfach mit ein paar umwickelten Eiswürfeln oder einem kalten Handtuch. Pass aber auf, dass du nicht zu sehr kühlst, sonst kommt es zu Irritationen an der Haut. Lager die Stelle etwas hoch und versuche dich zu schonen. Wichtig ist auch, dass du nicht an der Stelle kratzt!"
    };
	private static final String[] answersToYes_sonnenbrand = new String[] {
			"Dann solltest du auf jeden Fall zu einem Arzt gehen. Oma kann dir sagen wo die nächste Notaufnahme ist, aber ich kann nicht mehr so gut hören, daher sage mir bitte vor dem Straßennamen und der Stadt laut und deutlich <break time =\"1s\"/>Meine Adresse ist: ", 
			"Oh je, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Oma kann dir sagen wo die nächste Notaufnahme ist, aber ich kann nicht mehr so gut hören, daher sage mir bitte vor dem Straßennamen und der Stadt laut und deutlich <break time =\"1s\"/>Meine Adresse ist:  ", 
			"Sehr gut! Trage es einfach großzügig auf den Sonnenbrand auf. " + UNDERSTOOD, 
			"Super, streich das Produkt einfach auf ein Baumwolltuch und lege auf die verbrannte Stelle. Bevor es wieder warm wird, solltest du es aber wegnehmen. " + UNDERSTOOD, 
			"Sehr gut, bereite den Tee zu und lege die gebrauchten Teebeutel in den Kühlschrank. Sobald sie kalt sind, kannst du sie auf deine verbrannte Haut legen." + UNDERSTOOD, 
			"Super, schneide die Gurke in Scheiben und lege diese dann auf den Sonnenbrand. " + UNDERSTOOD
	}; 
	private static final String[] answersToNo_sonnenbrand = new String[]{
			"Gut, hast du Kreislaufprobleme oder Fieber?", 
			"Sehr schön, dann lass mich mal in meinem schlauen Büchlein nachsehen. <audio src='soundbank://soundlibrary/human/amzn_sfx_walking_on_grass_02'/> Hast du Aloe Vera oder Feuchtigkeitscreme zur Hand?", 
			"Nicht schlimm, hast du Quark oder Joghurt daheim?", 
			"Okay, kein Problem! Hast du Kamillentee oder Schwarzen Tee zur Hand?", 
			"Das ist nicht schlimm, hast du eine Gurke daheim?", 
			"Schade, aber eine kalte Dusche wird deiner Haut auch guttun."
    };
		
	public static void reset() { 
		injury = null;
		index = -1;
		nowConversation = (lastInjury == null);
		doNotRepeat = true;
		remedyFirstTime = true;
	}
	
	public static void setInjury(String injuryString) { 
		injury = new Injury(injuryString); 
	}
	
	public static String getAnswerToInjury() {
		index = -1;  
		if (injury != null) { 
			if (injury.getInjury().equals(STICH)) {
        		return "Oh nein! Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! Hast du schonmal allergisch auf Stiche reagiert?";
            	}
        	else if (injury.getInjury().equals(SONNENBRAND)) { 
        		return "Oh je, <break time=\"0.1s\"/> bei starkem Sonnenbrand können Blasen entstehen. Siehst du welche?";
        	}
        	else {
        		return "Oh! Da kenne ich mich leider nicht aus. Oma kann dir sagen wo die nächste Notaufnahme ist, aber ich kann nicht mehr so gut hören, daher sage mir bitte vor dem Straßennamen und der Stadt laut und deutlich <break time =\"1s\"/>Meine Adresse ist: ";
        	}
		}
		else {
			return "Ich habe dich leider nicht verstanden. Kannst du mir deine Verletzung nochmal sagen?"; 
		}
	}
	
	public static String getAnswerToInjuryReprompt() { 
		if (injury != null) { 
			if (injury.getInjury().equals(STICH)) {
        		return "Hast du den Stachel schon rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert?";
            	}
        	else if (injury.getInjury().equals(SONNENBRAND)) { 
        		return "Siehst du Blasen an deinem Sonnenbrand?";
        	}
        	else {
        		return "Da kann ich dir leider nicht helfen. Oma kann dir sagen wo die nächste Notaufnahme ist, aber ich kann nicht mehr so gut hören, daher sage mir bitte vor dem Straßennamen und der Stadt laut und deutlich <break time =\"1s\"/>Meine Adresse ist: ";
        	}
		}
		else {
			return "Bitte sag mir zuerst, was deine Verletzung ist."; 
		}
	}
		
	public static String getNextAnswer(boolean answerIsYes) {
		if (index < 6) { 
			if (injury != null) {
				index += 1;
				return answer(answerIsYes);
			} 
			else { 
				return "Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen"; 
			}
		}
		else { 
			return getGoodByeMessage(); 
		}
	}
	
	private static String answer(boolean answerIsYes) {
		if (injury.getInjury().equals(STICH)) { 
			if (answerIsYes) {
				String answer = answersToYes_stich[index];
				if(!remedyFirstTime) {
					answer = getGoodByeMessage();
					YesIntentHandler.setEndSession(true);
					index = 6;
				}
				if(index > 2 && remedyFirstTime) {
					remedyFirstTime = false;
					doNotRepeat = false;
				}				
				return answer;
			}
			else {
				if(doNotRepeat) {
					return answersToNo_stich[index];
				} else {
					index -= 1;
					return answersToYes_stich[index];
				}			
			}
		}
		else if (injury.getInjury().equals(SONNENBRAND)) { 
			if (answerIsYes) {
				String answer = answersToYes_sonnenbrand[index];
				if(!remedyFirstTime) {
					answer = getGoodByeMessage();
					YesIntentHandler.setEndSession(true);
					index = 6;
				}
				if(index > 1 && remedyFirstTime) {
					remedyFirstTime = false;
					doNotRepeat = false;
				}				
				return answer;
			}
			else {
				if(doNotRepeat) {
					return answersToNo_sonnenbrand[index];
				} else {
					index -= 1;
					return answersToYes_sonnenbrand[index];
				}
				
			}
		} 
		else {
			return "Oh! da kenne ich mich leider nicht aus."; 
		}
	}
		
	public static String getGoodByeMessage() { 
		if (injury != null) { 
			if (injury.getInjury().equals(STICH)) { 
				return "Und du weißt, Oma ist immer für dich da. Es kann passieren, dass sich der Stich infiziert dann solltest du nochmal zum Onkel Doktor schauen. Aber das passiert meistens nicht - du weißt doch, Oma ist immer übervorsichtig.";  
			}
			else if (injury.getInjury().equals(SONNENBRAND)) { 
				return "Vergiss nicht viel zu trinken! Und du weißt, Oma ist immer für dich da. Falls doch noch Blasen entstehen, solltest du auf jeden Fall zu einem Arzt gehen. Das passiert aber selten - du weißt doch, Oma ist immer übervorsichtig."; 
			}
			else { 
				return "Ich hoffe, ich konnte dir weiterhelfen."; 
			}
		}
		else {
			return "Ich hoffe, ich konnte dir weiterhelfen.";
		}
	}
	
	public static void setLastInjury(String lastInjuryString) { 
		lastInjury = new Injury(lastInjuryString); 
	}
	
	public static String getLastInjury() {
		return lastInjury.getInjury();
	}

	//Beide werden fuers Testen gebraucht
	public static void setIndex(int i){
		index = i;
	}
	public static void setNowConversation (boolean bool){
		nowConversation = bool;
	}
}
