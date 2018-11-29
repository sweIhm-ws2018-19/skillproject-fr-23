package beesafe.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import beesafe.SpeechStrings;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class GoodByeIntentHandler implements RequestHandler{
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("GoodByeIntent"));
    }

	@Override
	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder()
				.withSimpleCard(SpeechStrings.BeeSafeName, SpeechStrings.goodByeMessage)
				.withSpeech(SpeechStrings.goodByeMessage)
				.withShouldEndSession(true)
				.build();
	}	
}
