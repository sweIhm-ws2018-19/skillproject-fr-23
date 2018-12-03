package main.java.beesafe.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import main.java.beesafe.SpeechStrings;
import main.java.beesafe.model.Injury;

public class GoodByeIntentHandler implements RequestHandler{
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("GoodByeIntent"));
    }

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText; 
		if (MyInjuryIsIntentHandler.injury.getInjury().equals("stich")) { 
			speechText = SpeechStrings.goodByeMessage_Stich; 
		}
		else if(MyInjuryIsIntentHandler.injury.getInjury().equals("sonnenbrand")) { 
			speechText = SpeechStrings.goodByeMessage_Sonnenbrand; 
		}
		else { 
			speechText = SpeechStrings.goodByeMessage_Alternative; 
		}
		
		return input.getResponseBuilder()
				.withSimpleCard(SpeechStrings.BeeSafeName, speechText)
				.withSpeech(speechText)
				.withShouldEndSession(true)
				.build();
	}	
}
