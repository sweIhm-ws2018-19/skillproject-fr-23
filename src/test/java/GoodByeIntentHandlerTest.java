package test.java;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import main.java.beesafe.handlers.GoodByeIntentHandler;
import main.java.beesafe.model.Conversation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

public class GoodByeIntentHandlerTest {

    private GoodByeIntentHandler handler;

    @Before
    public void setup() {
        handler = new GoodByeIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    //TODO Weiß er die Injury während des Testen?
    @Test
    public void testHandle() {
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();

        assertTrue(res.getOutputSpeech().toString().contains(Conversation.getGoodByeMessage()));
    }

}
