package beesafe.handlers;

import java.util.Optional;
import main.java.beesafe.handlers.HelpIntentHandler;
import main.java.beesafe.SpeechStrings;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class HelpIntentHandlerTest {

    private HelpIntentHandler handler;

    @Before
    public void setup() {
        handler = new HelpIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    //TODO speechText ist lokal in FallbackIntentHandler gespeichert, nicht in Speechstrings
    @Test
    public void testHandle() {
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();

        assertTrue(res.getOutputSpeech().toString().contains(SpeechStrings.HELP_MESSAGE));
    }

}
