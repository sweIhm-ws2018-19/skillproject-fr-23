package main.beesafe.handlers;

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

import main.beesafe.SpeechStrings;

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
        String householdRemedy = slots.get(HOUSEHOLDREMEDY_SLOT).getValue(); 
        
		String injury = MyInjuryIsIntentHandler.injury.getInjury();
		String response;
		//TODO unterscheidung der Hausmittel einbauen!
		
		if(householdRemedy != null && !injury.isEmpty()) {
			if(injury.equals("stich")) {
				response = SpeechStrings.anwendungZitrone;
			} else {
				response = SpeechStrings.anwendungDusche;
			}
		} else {
			response = SpeechStrings.anwendungKeineVerletzung;
		}
		
		return input.getResponseBuilder().
				withSimpleCard(SpeechStrings.BeeSafeName, response)
                .withSpeech(response)
                .withShouldEndSession(false)
                .build();
	}

}
