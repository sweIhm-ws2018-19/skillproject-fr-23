package main.java.beesafe;

public class SpeechStrings {
	public static final String welcomeMessage = "Willkommen bei Ask Grandma! " 
												+ "Hallo! Wie kann ich dir helfen?";
	public static final String welcomeMessage_Reprompt = "Hey ist da jemand <break time =\\\"1s\\\"/>? Deine Grossmutter hat gerade Zeit fÃ¼r dich.";
	
	public static final String stopMessage = "Ich hoffe ich konnte dir helfen. Bis zum naechsten mal!";
	
	public static final String BeeSafeName = "bee safe";
	
	public static final String helpMessage = "Sag mir, welche Verletzung du hast."; 
	public static final String helpMessage_Reprompt = "Du kannst mir sagen, welche Verletzung du hast."; 
	
	public static final String injuryIsStich_Message = "Oh nein! <break time=\"0.1s\"/> Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! <break time=\"0.4s\"/> Hast du schonmal allergisch auf Stiche reagiert oder wurdest du an einer gefährlichen Stelle gestochen? Ist der Stich angeschwollen oder hast du Atemnot? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Heilmitteln fragen.";
	public static final String injuryIsStich_Message_Reprompt = "Hast du den Stachel rausgezogen? <break time=\"0.1s\"/> Hast du schon mal allergisch auf Stiche reagiert oder wurdest du an einer gefährlichen Stelle gestochen? Ist der Stich angeschwollen oder hast du Atemnot? <break time=\"0.3s\"/> Wenn nicht, kannst du mich nach Heilmitteln fragen.";
	public static final String injuryIsSonnenbrand_Message = "Oh, <break time=\"0.1s\"/> Siehst du Blasen an deinem Sonnenbrand oder hast du Kreislaufprobleme oder Fieber? <break time=\\\"0.3s\\\"/> Wenn nicht, kannst du mich nach Heilmitteln fragen.";
	public static final String injuryIsSonnenbrand_Message_Reprompt = "Siehst du Blasen oder hast du Kreislaufprobleme oder Fieber? <break time=\\\"0.3s\\\"/> Wenn nicht, kannst du mich nach Heilmitteln fragen.";
	
	public static final String risikoBeiStich_Message = "Das hört sich nicht gut an! <break time =\"0.2s\"/>Es wäre besser wenn du in die nächste Notaufnahme gehst! Soll ich dir einen Krankenwagen rufen?"; 
	public static final String risikoBeiStich_Message_Reprompt = "Geh lieber in die nächste Notaufnahme."; 
	public static final String risikoEinesSonnenstichs_Message = "Oh nein, dann hast du möglicherweise einen Sonnenstich und solltest zu einem Arzt gehen. Hier sind die nächsten Notaufnahmen:"; 
	public static final String risikoEinesSonnenstichs_Message_Reprompt = "Bei einem Sonnenstich solltest du lieber zur nächsten Notaufnahme gehen."; 
	public static final String risikoBeiSonnenbrand_Message = "Dann solltest du auf jeden Fall zu einem Arzt gehen. <break time =\"0.2s\"/> Hier sind die Notaufnahmen:"; 
	public static final String risikoBeiSonnenbrand_Message_Reprompt = "Geh lieber zu einem Arzt oder in die nächste Notaufnahme."; 
	
	public static final String goodByeMessage = "Ich hoffe dir geht es bald besser! " + ""
			+ "Lass es heute noch ein bisschen ruhiger angehen. Schoenen Tag dir noch.";
}
