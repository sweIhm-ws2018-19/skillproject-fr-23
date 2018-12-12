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

import main.java.beesafe.model.HospitalFinder;

public class NearestHospitalIntent implements RequestHandler{
	public static final String ADDRESS_SLOT = "address";
	public static final String ADDRESS_KEY = "ADDRESS";

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("NearestHospitalIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String location = slots.get(ADDRESS_SLOT).getValue();
        String answer = "";
        if(!location.isEmpty()) {
        	location = location.replaceAll(" ", "+");
        	HospitalFinder hospital = new HospitalFinder();
        	String[] address = hospital.getNextHospitalAddress(location);
        	if(address != null) {
        		answer = "Das naechste Krankenhaus ist " + address[0] + " in der " + address[1] + " " + address[2];
        	} else {
        		answer = "Leider konnte ich fuer deine Adresse kein Krankenhaus finden. Ruf doch bitte den Notruf unter 112 an.";
        	}
        } else {
        	answer = "Leider habe ich dich nicht verstanden, bitte ruf doch einfach den Notruf 112 an.";
        }   		
		return input.getResponseBuilder()
	        	.withSpeech(answer)
	        	.withShouldEndSession(false)
	        	.build();
	}

}
