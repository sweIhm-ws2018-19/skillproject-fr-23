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
	
	public static final String hausmittelStich = "Als Hausmittel fuer einen Bienenstich kannst du eine Zitrone, Zwiebel, Backpulver oder Venestil benutzen. Sage mir einfach welches du davon zur Hand hast und ich kann dir sagen wie du es anwendest.";
	public static final String hausmittelSonnenbrand = "Als Hausmittel fur einen Sonnenbrand kannst du Quark, schwarzen Tee, Aloe Vera oder eine Gurke benutzen. Sage mir einfach welches du davon zur Hand hast und ich kann dir sagen wie du es anwendest.";
	public static final String hausmittelKeineVerletzung = "Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das bitte zuerst, dann kann ich dir mit Hausmitteln weiterhelfen.";
	
	public static final String anwendungBackpulver = "muss noch eingefuegt werden.";
	public static final String anwendungVenestil = "Einfach ein bisschen venestil auf den Stich auftragen.";
	public static final String anwendungZwiebel = "Schneide die Zwiebel in zwei Haelften und lege sie auf den Stich.";
	public static final String anwendungZitrone = "Schneide die Zitrone in zwei Haelften und lege sie auf den Stich.";
	public static final String anwendungAlternativeStich = "Das macht nichts. Lass etwas kaltes Wasser darueber laufen, dass hilft auch schon.";

	public static final String anwendungQuark = "Streiche einfach ein bisschen Quark auf die verbrannten Stellen.";
	public static final String anwendungSchwarzerTee = "muss noch eingefuegt werden.";
	public static final String anwendungAloevera = "muss noch eingefuegt werden.";
	public static final String anwendungGurke = "muss noch eingefuegt werden.";	
	public static final String anwendungAlternativeSonnenbrand = "Das macht nichts. Eine kalte Dusche hilft dir sicher weiter.";

	public static final String anwendungKeineVerletzung = "Leider hast du die Art deiner Verletzung noch nicht angegeben. Mach das Bitte zuerst, dann kann ich dir mit der Anwendung von Hausmitteln weiterhelfen";
	public static final String anwendungFalscheAngabe = "Damit solltest du deine Verletzung nicht behandeln. Frag bitte nochmal nach den Hausmitteln fuer deine Verletzung an.";
	
	public static final String goodByeMessage = "Ich hoffe dir geht es bald besser! " + ""
			+ "Lass es heute noch ein bisschen ruhiger angehen. Schoenen Tag dir noch.";
}
