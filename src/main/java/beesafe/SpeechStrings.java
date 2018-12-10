package main.java.beesafe;

import main.java.beesafe.model.Conversation;

public class SpeechStrings {
	public static final String welcomeMessage = "Willkommen bei Ask Grandma! " 
												+ "Hallo! Wie kann ich dir helfen?";
	public static final String welcomeMessage_Reprompt = "Hey ist da jemand <break time =\"1s\"/>? Deine Grossmutter hat gerade Zeit fuer dich.";
	
	public static final String welcomeWithLastInjury = "Hallo! Geht es deinem " + Conversation.getLastInjury() + " wieder besser?";
	public static final String welcomeWithLastInjury_Reprompt = "Bitte sage mir, ob es dir nach deinem " + Conversation.getLastInjury() + "wieder gut geht?";
	
	public static final String stopMessage = "Ich hoffe ich konnte dir helfen. Bis zum naechsten mal!";
	
	public static final String BeeSafeName = "bee safe";
	
	public static final String helpMessage = "Sag mir, welche Verletzung du hast."; 
	public static final String helpMessage_Reprompt = "Du kannst mir sagen, welche Verletzung du hast."; 
}
