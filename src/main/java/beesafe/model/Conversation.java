package main.java.beesafe.model;

import java.util.List; 
import java.util.ArrayList;

public class Conversation {
	private static int index = -1; 
	private static Injury injury = null; 
	
	private static final String[] answersToYes_stich = new String[] {
			"Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Hier sind die nächsten Notaufnahmen: ", 
			"Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Hier sind die nächsten Notaufnahmen: ", 
			"Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Hier sind die nächsten Notaufnahmen: ", 
			"Sehr gut! Trage etwas von der Salbe auf. Sie wirkt entzündungshemmend und kühlt die Stelle. Versuche trotzdem die Stelle weiterhin zu kühlen. Vermeide es die Stelle zu kratzen.", 
			"Sehr gut! Halbiere die Zitrone oder Zwiebel und lege die Schnittstelle auf den Stich. Das Gift wird dadurch dem Stich entzogen. Kühle die Stelle trotzdem weiterhin und kratze die Stelle nicht.", 
			"Super! Backpulver hilft auch gut - vermische es mit ein bisschen Wasser zu einer Paste und trage es auf den Stich auf. Sollte es dir gut tun kannst du es auch nochmal später wiederholen. Vergiss nicht weiterhin die Wunde zu kühlen und kratze nicht an der Einstichstelle."
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
			"Dann solltest du auf jeden Fall zu einem Arzt gehen. Hier sind die Notaufnahmen: ", 
			"Oh je, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Hier sind die nächsten Notaufnahmen:", 
			"Sehr gut! Trage es einfach großzügig auf den Sonnenbrand auf.", 
			"Super, streich das Produkt einfach auf ein Baumwolltuch und lege auf die verbrannte Stelle. Bevor es wieder warm wird, solltest du es aber wegnehmen.", 
			"Sehr gut, bereite den Tee zu und lege die gebrauchten Teebeutel in den Kühlschrank. Sobald sie kalt sind, kannst du sie auf deine verbrannte Haut legen.", 
			"Super, schneide die Gurke in Scheiben und lege diese dann auf den Sonnenbrand."
	}; 
	private static final String[] answersToNo_sonnenbrand = new String[]{
			"Gut, hast du Kreislaufprobleme oder Fieber?", 
			"Sehr schön, dann lass mich mal in meinem schlauen Büchlein nachsehen. <audio src='soundbank://soundlibrary/human/amzn_sfx_walking_on_grass_02'/> Hast du Aloe Vera oder Feuchtigkeitscreme zur Hand?", 
			"Nicht schlimm, hast du Quark oder Joghurt daheim?", 
			"Okay, kein Problem! Hast du Kamillentee oder Schwarzen Tee zur Hand?", 
			"Das ist nicht schlimm, hast du eine Gurke daheim?", 
			"Schade, aber eine kalte Dusche wird deiner Haut auch guttun."
    };
	
	
	
	public static void setInjury(String injuryString) { 
		injury = new Injury(injuryString); 
	}
	
	public static String getAnswerToInjury() { 
		if (injury != null) { 
			if (injury.getInjury().equals("stich")) {
        		return "Oh nein! Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! Hast du schonmal allergisch auf Stiche reagiert?";
            }
        	else if (injury.getInjury().equals("sonnenbrand")) { 
        		return "Oh je, <break time=\"0.1s\"/> bei starkem Sonnenbrand können Blasen entstehen. Siehst du welche?";
        	}
        	else {
        		return "Oh! Da kenne ich mich leider nicht aus. Hier sind drei Notaufnahmen in deiner Naehe: ";
        	}
		}
		else {
			return "Ich habe dich leider nicht verstanden. Kannst du mir deine Verletzung nochmal sagen?"; 
		}
	}
	
	public static String getAnswerToInjury_Reprompt() { 
		if (injury != null) { 
			if (injury.getInjury().equals("stich")) {
        		return "Hast du den Stachel schon rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert?";
            }
        	else if (injury.getInjury().equals("sonnenbrand")) { 
        		return "Siehst du Blasen an deinem Sonnenbrand?";
        	}
        	else {
        		return "Da kann ich dir leider nicht helfen. Geh doch zur naechsten Notaufnahme. ";
        	}
		}
		else {
			return "Bitte sag mir zuerst, was deine Verletzung ist."; 
		}
	}
	
	public static String getNextAnswer(boolean answerIsYes) { 
		index += 1;
		if (index < 6) { 
			if (injury != null) { 
				if (injury.getInjury().equals("stich")) { 
					if (answerIsYes) { 
						return answersToYes_stich[index];
					}
					else { 
						return answersToNo_stich[index];
					}
				}
				else if (injury.getInjury().equals("stich")) { 
					if (answerIsYes) { 
						return answersToYes_sonnenbrand[index];
					}
					else { 
						return answersToNo_sonnenbrand[index];
					}
				} 
				else { 
					return "Oh! da kenne ich mich leider nicht aus."; 
				}
			} 
			else { 
				return "Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen"; 
			}
		}
		else { 
			return getGoodByeMessage(); 
		}
	}
	
	public static String getGoodByeMessage() { 
		if (injury != null) { 
			if (injury.getInjury().equals("stich")) { 
				return "Und du weißt, Oma ist immer für dich da. Es kann passieren, dass sich der Stich infiziert dann solltest du nochmal zum Onkel Doktor schauen. Aber das passiert meistens nicht - du weißt doch, Oma ist immer übervorsichtig.";  
			}
			else if (injury.getInjury().equals("sonnenbrand")) { 
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
}