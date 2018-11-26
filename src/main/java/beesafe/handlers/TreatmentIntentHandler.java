package main.java.beesafe.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

public class TreatmentIntentHandler implements RequestHandler{
	
	public static final String TREATMENT_SLOT = "Treatment";
	public static final String TREATMENT_KEY = "TREATMENT";

	@Override
	public boolean canHandle(HandlerInput input) {			
		return input.matches(intentName("TreatmentIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot treatmentSlot = slots.get(TREATMENT_SLOT);
		String response;

		boolean isAskResponse = false;
        
        if(treatmentSlot != null) {
        	String treatment = treatmentSlot.getValue();
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(TREATMENT_KEY, treatment));
        	if(treatment.contains("zwiebel") | treatment.contains("zitrone") | treatment.contains("venestil") | treatment.contains("backpulver")) {
        		response = String.format("Du hast %s als Hausmittel ausgewaehlt. Jetzt kannst du mich fragen, wie du das Hausmittel anwenden kannst.", treatment);	
        	} else {
        		response = "Auch nicht so schlimm. Kuehle den Stich einfach mit ein paar umwickelten Eiswuerfeln oder einem kalten Handtuch." +
        				"Pass aber auf, dass du nicht zu sehr kuehlst, sonst kommt es zu Irritationen an der Haut." +
        				"Lager die Stelle etwas hoch und versuche dich zu schonen. Wichtig ist auch, dass du nicht an der Stelle kratzt!";
        	}
        } else {
        	isAskResponse = true;
        	response = "Leider konnte ich dich nicht verstehen auf meine alten Tage. Kannst du bitte noch einmal sagen, welches Heilmittel du zu Hause hast?";
        }
        ResponseBuilder responseBuilder = input.getResponseBuilder();
        responseBuilder
			.withSpeech(response)
			.withShouldEndSession(false);
        
        if (isAskResponse) {
        	responseBuilder.withReprompt(response)
        		.withShouldEndSession(false);
        }
					
		return input.getResponseBuilder()
				.withSpeech(response)
				.withShouldEndSession(false)
                .build();
	}

}
