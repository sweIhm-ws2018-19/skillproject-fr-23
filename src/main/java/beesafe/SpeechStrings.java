package main.java.beesafe;

import main.java.beesafe.model.Conversation;

public class SpeechStrings {
	private SpeechStrings() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static final String WELCOME_MESSAGE = "Willkommen bei Ask Grandma! " 
												+ "Hallo! Wie kann ich dir helfen?";
	public static final String WELCOME_MESSAGE_REPROMT = "Hey ist da jemand <break time =\"1s\"/>? Deine Grossmutter hat gerade Zeit fuer dich.";
		
	public static final String STOP_MESSAGE = "Ich hoffe ich konnte dir helfen. Bis zum naechsten mal!";
	
	public static final String BEE_SAFE_NAME = "bee safe";
	
	public static final String HELP_MESSAGE = "Sag mir, welche Verletzung du hast."; 
	public static final String HELP_MESSAGE_REPROMT= "Du kannst mir sagen, welche Verletzung du hast."; 
}
