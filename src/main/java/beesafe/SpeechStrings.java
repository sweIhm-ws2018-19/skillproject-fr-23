package main.java.beesafe;

public class SpeechStrings {
	public static final String welcomeMessage = "Willkommen bei Ask Grandma! " 
												+ "Hallo! Wie kann ich dir helfen?";
	public static final String welcomeMessage_Reprompt = "Hey ist da jemand <break time =\"1s\"/>? Deine Grossmutter hat gerade Zeit fuer dich.";
	
	public static final String stopMessage = "Ich hoffe ich konnte dir helfen. Bis zum naechsten mal!";
	
	public static final String BeeSafeName = "bee safe";
	
	public static final String helpMessage = "Sag mir, welche Verletzung du hast."; 
	public static final String helpMessage_Reprompt = "Du kannst mir sagen, welche Verletzung du hast."; 
	
	public static final String injuryIsStich_Message = "Oh nein! <break time=\"0.1s\"/> Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! <break time=\"0.4s\"/> Hast du schonmal allergisch auf Stiche reagiert oder wurdest du an einer gefährlichen Stelle gestochen? Ist der Stich angeschwollen oder hast du Atemnot? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Hausmitteln fragen.";
	public static final String injuryIsStich_Message_Reprompt = "Hast du den Stachel rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert oder wurdest du an einer gefährlichen Stelle gestochen? Ist der Stich angeschwollen oder hast du Atemnot? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Hausmitteln fragen.";
	public static final String injuryIsSonnenbrand_Message = "Oh, <break time=\"0.1s\"/> Siehst du Blasen an deinem Sonnenbrand oder hast du Kreislaufprobleme oder Fieber? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Hausmitteln fragen.";
	public static final String injuryIsSonnenbrand_Message_Reprompt = "Siehst du Blasen oder hast du Kreislaufprobleme oder Fieber? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Hausmitteln fragen.";
	
	public static final String risikoBeiStich_Message = "Das hört sich nicht gut an! <break time =\"0.2s\"/>Es wäre besser wenn du in die nächste Notaufnahme gehst! Soll ich dir einen Krankenwagen rufen?";
	public static final String risikoBeiStich_Message_Reprompt = "Geh lieber in die nächste Notaufnahme.";
	public static final String risikoEinesSonnenstichs_Message = "Oh nein, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Hier sind die nächsten Notaufnahmen:";
	public static final String risikoEinesSonnenstichs_Message_Reprompt = "Bei einem Sonnenstich solltest du lieber zur nächsten Notaufnahme gehen.";
	public static final String risikoBeiSonnenbrand_Message = "Dann solltest du auf jeden Fall zu einem Arzt gehen. <break time =\"0.2s\"/> Hier sind die Notaufnahmen:"; 
	public static final String risikoBeiSonnenbrand_Message_Reprompt = "Geh lieber zu einem Arzt oder in die nächste Notaufnahme.";
	
	public static final String hausmittelStich = "Schoen, dann lass mich mal in meinem schlauen Buechlein nachschlagen." +
			" Als Hausmittel fuer einen Bienenstich kannst du eine Zitrone, Zwiebel, Backpulver oder Venestil benutzen." +
			" Sage mir einfach welches du davon zur Hand hast und ich kann dir sagen wie du es anwendest.";
	public static final String hausmittelSonnenbrand = "Schoen, dann lass mich mal in meinem schlauen Buechlein nachschlagen." +
			" Als Hausmittel fuer einen Sonnenbrand kannst du Quark, schwarzen Tee, Aloe Vera oder eine Gurke benutzen." +
			" Sage mir einfach welches du davon zur Hand hast und ich kann dir sagen wie du es anwendest.";
	public static final String hausmittelKeineVerletzung = "Leider hast du mir noch nicht gesagt, was dir fehlt." +
			" Mach das bitte zuerst, dann kann ich dir mit Hausmitteln weiterhelfen.";
	
	public static final String anwendungBackpulver = "Super! Backpulver hilft auch gut. Vermische es mit ein bisschen Wasser zu einer Paste und trage es auf den Stich auf." +
			" Sollte es dir gut tun kannst du es auch nochmal spaeter wiederholen. Vergiss nicht weiterhin die Wunde zu kuehlen und kratze nicht an der Einstichstelle.";
	public static final String anwendungVenestil = "Sehr gut! Trage etwas von der Salbe auf. Sie wirkt entzuendungshemmen und kuehlt die Stelle." +
			"Versuche trotzdem die Stelle weiterhin zu kuehlen. Vermeide es die Stelle zu kratzen";
	public static final String anwendungZwiebel = "Sehr gut! Halbiere die Zwiebel und lege die Schnittstelle auf den Stich." +
			" Das Gift wird dadurch dem Stich entzogen. Kuehle die Stelle trotzdem weiterhin und kratze die Stelle nicht.";
	public static final String anwendungZitrone = "Sehr gut! Halbiere die Zwiebel und lege die Schnittstelle auf den Stich." +
			" Das Gift wird dadurch dem Stich entzogen. Kuehle die Stelle trotzdem weiterhin und kratze die Stelle nicht.";
	public static final String anwendungAlternativeStich = "Das ist auch nicht so schlimm. Kuehle den Stich einfach mit ein paar umwickelten Eiswuerfeln oder einem kalten Handtuch." +
			" Pass aber auf, dass du nicht zu sehr kuehlst, sonst kommt es zu Irritationen an der Haut. Lager die Stelle etwas hoch und versuche dich zu schonen." +
			" Wichtig ist auch, dass du nicht an der Stelle kratzt!";

	public static final String anwendungQuark = "Super, streich das Produkt einfach auf ein Baumwolltuch und lege es auf die verbrannte Stelle. Bevor es wieder warm wird, solltest du es aber wegnehmen.";
	public static final String anwendungSchwarzerTee = "Sehr gut, bereite den Tee zu und lege die gebrauchten Teebeutel in den Kuehlschrank. Sobald sie kalt sind, kannst du sie auf deine verbrannte Haut legen.";
	public static final String anwendungAloevera = "Sehr gut! Trage es einfach grosszuegig auf den Sonnenbrand auf.";
	public static final String anwendungGurke = "Super, schneide die Gurke in Scheiben und lege diese dann auf den Sonnenbrand.";	
	public static final String anwendungAlternativeSonnenbrand = "Schade, aber eine kalte Dusche wird deiner Haut auch guttun.";

	public static final String anwendungKeineVerletzung = "Leider hast du mir noch nicht gesagt, was fuer eine Verletzung du hast." +
	" Mach das bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen";
	public static final String anwendungFalscheAngabe = "Damit solltest du deine Verletzung nicht behandeln. Frag bitte nochmal nach den Hausmitteln fuer deine Verletzung an.";
	
	public static final String goodByeMessage = "Ich hoffe dir geht es bald besser und du weist Oma ist immer fuer dich da. " + ""
			+ "Lass es heute noch ein bisschen ruhiger angehen. Schoenen Tag dir noch.";
}
