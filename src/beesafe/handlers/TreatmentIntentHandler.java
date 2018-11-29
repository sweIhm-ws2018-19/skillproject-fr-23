package beesafe.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import beesafe.SpeechStrings;
import beesafe.model.InjuryStatus;

public class TreatmentIntentHandler implements RequestHandler{
	
	public static final String injury_SLOT = "injury";
	public static final String injury_KEY = "injury";

	@Override
	public boolean canHandle(HandlerInput input) {			
		return input.matches(intentName("injuryIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String injury = InjuryStatus.injury.getInjury();
		String response;
        
        if(!injury.isEmpty()) {
        	if(injury.contains("stich")){
        		response = SpeechStrings.hausmittelStich;	
        	} else {
        		response = SpeechStrings.hausmittelSonnenbrand;
        	}
        } else {        	
        	response = SpeechStrings.hausmittelKeineVerletzung;
        }
					
		return input.getResponseBuilder()
				.withSimpleCard(SpeechStrings.BeeSafeName, response)
				.withSpeech(response)
				.withShouldEndSession(false)
                .build();
	}

}
