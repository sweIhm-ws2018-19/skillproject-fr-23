package main.java.beesafe.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import main.java.beesafe.SpeechStrings;

public class ApplicationHouseholdRemedyIntentHandler implements RequestHandler{
	public static final String HOUSEHOLDREMEDY_SLOT = "HouseholdRemedy";
	public static final String HOUSEHOLDREMEDY_KEY = "HOUSEHOLDREMEDY";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("ApplicationHouseholdRemedyIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String householdRemedy = slots.get(HOUSEHOLDREMEDY_SLOT).getValue().toLowerCase(); 
        
		String injury = MyInjuryIsIntentHandler.injury.getInjury().toLowerCase();
		String response = SpeechStrings.anwendungKeineVerletzung;
		
		if(!injury.isEmpty()) {
			
			if(injury.equals("stich")) {
				switch (householdRemedy) {
				case "zitrone": response = SpeechStrings.anwendungZitrone;
					break;
				case "zwiebel": response = SpeechStrings.anwendungZwiebel;
					break;
				case "backpulver": response = SpeechStrings.anwendungBackpulver;
					break;
				case "venestil": response = SpeechStrings.anwendungVenestil;
					break;
				case "nein": response = SpeechStrings.anwendungAlternativeStich;
					break;
				default: response = SpeechStrings.anwendungFalscheAngabe;
				}				
			} else {
				switch (householdRemedy) {
				case "quark": response = SpeechStrings.anwendungQuark;
					break;
				case "schwarzer tee": response = SpeechStrings.anwendungSchwarzerTee;
					break;
				case "aloevera": response = SpeechStrings.anwendungAloevera;
					break;
				case "gurke": response = SpeechStrings.anwendungGurke;
					break;
				case "nein": response = SpeechStrings.anwendungAlternativeSonnenbrand;
					break;
				default: response = SpeechStrings.anwendungFalscheAngabe;
				}
			}
		} 
		
		return input.getResponseBuilder().
				withSimpleCard(SpeechStrings.BeeSafeName, response)
                .withSpeech(response)
                .withShouldEndSession(false)
                .build();
	}

}
