package test.java;

import com.amazon.ask.model.*;
import com.amazon.ask.model.slu.entityresolution.Resolutions;
import main.java.beesafe.handlers.MyInjuryIsIntentHandler;
import main.java.beesafe.SpeechStrings;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import com.amazon.ask.attributes.AttributesManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.*;

public class MyInjuryIsIntentHandlerTest {

    private MyInjuryIsIntentHandler handler;

    @Before
    public void setup() {
        handler = new MyInjuryIsIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    //Keine Moeglichkeit gefunden um den Namen der Verletzung in den Intent zu builden.
    /*
    @Test
    public void testHandle() {

        final Intent.Builder intentBuilder = Intent.builder();
        List<Resolutions> resPerAuthList = Mockito.mock(List.class);

        //TODO withResolutionsPerAuthority akzeptiert die gemockte Liste resPerAuthList nicht
        final Slot slotMock = Slot.builder().withName("INJURY_SLOT").withValue("stich")
                .withResolutions(Resolutions.builder()
                        .withResolutionsPerAuthority(resPerAuthList).build())
                        .build()
                .build();

        Map<String, Slot> mapMock = new HashMap<>();
        mapMock.put("INJURY_SLOT",slotMock);

        //Build intent
        intentBuilder.withSlots(mapMock);

        //wrap intent in RequestEnvelope
        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withIntent(intentBuilder.build())
                        .build())
                .build();

        HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.getRequestEnvelope()).thenReturn(requestEnvelopeMock);



        final Optional<Response> response = handler.handle(inputMock);
        assertTrue(response.isPresent());
        final Response res = response.get();

        assertTrue(res.getOutputSpeech().toString().contains("Oh nein! Falls der Stachel noch in der Haut steckt, zieh ihn sofort raus! Hast du schonmal allergisch auf Stiche reagiert?"));
    }

*/

}

