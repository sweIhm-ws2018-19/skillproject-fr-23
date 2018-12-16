package test.java;

import main.java.beesafe.handlers.LaunchRequestHandler;
import main.java.beesafe.SpeechStrings;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import com.amazon.ask.attributes.AttributesManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class LaunchRequestHandlerTest {

    private LaunchRequestHandler handler;

    @Before
    public void setup() {
        handler = new LaunchRequestHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void testHandleNoPreviousInjury() {

        final AttributesManager attributesManagerMock = Mockito.mock(AttributesManager.class);

        Map<String, Object> persistentAttributes = Collections.emptyMap();
        when(attributesManagerMock.getPersistentAttributes()).thenReturn(persistentAttributes);

        //Building the correct input object
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getAttributesManager()).thenReturn(attributesManagerMock);

        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();

        assertTrue(res.getOutputSpeech().toString().contains(SpeechStrings.WELCOME_MESSAGE));
    }

    @Test
    public void testHandleWithPreviousInjury() {

        final AttributesManager attributesManagerMock = Mockito.mock(AttributesManager.class);

        Map<String, Object> persistentAttributes = Mockito.mock(Map.class);
        when(attributesManagerMock.getPersistentAttributes()).thenReturn(persistentAttributes);

        //Building the correct input object
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getAttributesManager()).thenReturn(attributesManagerMock);
        when(persistentAttributes.get("LAST_INJURY")).thenReturn("Stich");

        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();

        assertTrue(res.getOutputSpeech().toString().contains(SpeechStrings.WELCOME_WITH_LAST_INJURY));
    }


}

