package main.java.beesafe.model;

import java.util.List; 
import java.util.ArrayList;

public class SeriesOfAnswers {
	private int index; 
	List<String> answersToNo; 
	List<String> answersToYes; 
	Injury injury; 
	
	public SeriesOfAnswers(Injury injury) { 
		index = -1; 
		this.injury = injury; 
		answersToYes = new ArrayList<>();
		answersToNo = new ArrayList<>(); 
		
		if (injury.getInjury().equals("stich")) { 
			answersToYes.add("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Soll ich dir einen Krankenwagen rufen?"); 
			answersToYes.add("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Soll ich dir einen Krankenwagen rufen?"); 
			answersToYes.add("Das hört sich nicht gut an! Es wäre besser wenn du in die nächste Notaufnahme gehst! Soll ich dir einen Krankenwagen rufen?"); 
			answersToYes.add("Sehr gut! Trage etwas von der Salbe auf. Sie wirkt entzündungshemmend und kühlt die Stelle. Versuche trotzdem die Stelle weiterhin zu kühlen. Vermeide es die Stelle zu kratzen."); 
			answersToYes.add("Sehr gut! Halbiere die Zitrone oder Zwiebel und lege die Schnittstelle auf den Stich. Das Gift wird dadurch dem Stich entzogen. Kühle die Stelle trotzdem weiterhin und kratze die Stelle nicht."); 
			answersToYes.add("Super! Backpulver hilft auch gut - vermische es mit ein bisschen Wasser zu einer Paste und trage es auf den Stich auf. Sollte es dir gut tun kannst du es auch nochmal später wiederholen. Vergiss nicht weiterhin die Wunde zu kühlen und kratze nicht an der Einstichstelle.");
			
			answersToNo.add("Wurdest du an einer gefährlichen Stelle gestochen?"); 
			answersToNo.add("OK das hört sich nicht so schlimm an! Ist es denn stark geschwollen oder hast du Atemnot?"); 
			answersToNo.add("Perfekt! Dann ist es nicht schlimm bleib ruhig und befolge Omas Rat. Hast du Venestil zu Hause?"); 
			answersToNo.add("Nicht schlimm, lass mich mal in der Küche schauen, was passen könnte. <break time =\"1s\"/> Ah! Ich habe was gefunden! Hast du vielleicht eine Zitrone oder eine Zwiebel zu Hause?"); 
			answersToNo.add("Ok nicht schlimm! Oma weiß doch immer einen Ausweg. Hast du Backpulver da?"); 
			answersToNo.add("Auch nicht so schlimm. Kühle den Stich einfach mit ein paar umwickelten Eiswürfeln oder einem kalten Handtuch. Pass aber auf, dass du nicht zu sehr kühlst, sonst kommt es zu Irritationen an der Haut. Lager die Stelle etwas hoch und versuche dich zu schonen. Wichtig ist auch, dass du nicht an der Stelle kratzt!");
		}
		else if (injury.getInjury().equals("sonnenbrand")) { 
			answersToYes.add("Dann solltest du auf jeden Fall zu einem Arzt gehen. Hier sind die Notaufnahmen: "); 
			answersToYes.add("Oh je, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Hier sind die nächsten Notaufnahmen:"); 
			answersToYes.add("Sehr gut! Trage es einfach großzügig auf den Sonnenbrand auf."); 
			answersToYes.add("Super, streich das Produkt einfach auf ein Baumwolltuch und lege auf die verbrannte Stelle. Bevor es wieder warm wird, solltest du es aber wegnehmen."); 
			answersToYes.add("Sehr gut, bereite den Tee zu und lege die gebrauchten Teebeutel in den Kühlschrank. Sobald sie kalt sind, kannst du sie auf deine verbrannte Haut legen."); 
			answersToYes.add("Super, schneide die Gurke in Scheiben und lege diese dann auf den Sonnenbrand.");
			
			answersToNo.add("Gut, hast du Kreislaufprobleme oder Fieber?"); 
			answersToNo.add("Sehr schön, dann lass mich mal in meinem schlauen Büchlein nachsehen. <audio src='soundbank://soundlibrary/human/amzn_sfx_walking_on_grass_02'/> Hast du Aloe Vera oder Feuchtigkeitscreme zur Hand?"); 
			answersToNo.add("Nicht schlimm, hast du Quark oder Joghurt daheim?"); 
			answersToNo.add("Okay, kein Problem! Hast du Camillentee oder Schwarzen Tee zur Hand?"); 
			answersToNo.add("Das ist nicht schlimm, hast du eine Gurke daheim?"); 
			answersToNo.add("Schade, aber eine kalte Dusche wird deiner Haut auch guttun.");
		}
	}
	
	public String getNextAnswer(boolean answerIsYes) { 
		index += 1;
		if (index < answersToYes.size()) { 
			if (answerIsYes) { 
				return answersToYes.get(index);
			}
			else { 
				return answersToNo.get(index);
			}
		}
		else { 
			return "Wie kann ich dir helfen?"; 
		}
	}
}
