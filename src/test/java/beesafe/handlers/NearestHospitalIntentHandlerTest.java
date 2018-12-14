package beesafe.handlers;

import com.amazon.ask.model.*;
import main.java.beesafe.handlers.NearestHospitalIntentHandler;
import main.java.beesafe.model.HospitalFinder;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class NearestHospitalIntentHandlerTest {

    private NearestHospitalIntentHandler handler;

    @Before
    public void setup() {
        handler = new NearestHospitalIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    /*
    //TODO Problem mit dem wrappen der Argumente im Handler input. Permanent NullPointerExceptions
    @Test
    public void testHandleWithLocation() {

        String testLocation = "Muenchen";

        final Intent.Builder intentBuilder = Intent.builder();
        final Slot slotMock = Slot.builder().withName("ADDRESS_SLOT").withValue(testLocation).build();

        intentBuilder.putSlotsItem("ADDRESS_SLOT", slotMock);

        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                .withIntent(intentBuilder.build())
                .build())
                .build();


        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getRequestEnvelope()).thenReturn(requestEnvelopeMock);
        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();
        HospitalFinder hospital = new HospitalFinder();
        String[] address = hospital.getNextHospitalAddress(testLocation);

        if(address != null) {
            String toMatch = "Am nächstgelegene Krankenhaus ist das " + address[0] + " in der " + address[1] + ". In " + address[2];
        } else {
            String toMatch = "Leider konnte ich fuer deine Adresse kein Krankenhaus finden. Ruf doch bitte den Notruf unter 112 an.";
        }

        assertTrue(res.getOutputSpeech().toString().contains(main.java.beesafe.SpeechStrings.HELP_MESSAGE));
    }

    @Test
    public void testHandleWithoutLocation() {

        String testLocation = null;

        final Intent.Builder intentBuilder = Intent.builder();
        final Slot slotMock = Slot.builder().withName("ADDRESS_SLOT").withValue(testLocation).build();

        intentBuilder.putSlotsItem("ADDRESS_SLOT2", slotMock);

        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withIntent(intentBuilder.build())
                        .build())
                .build();


        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getRequestEnvelope()).thenReturn(requestEnvelopeMock);
        final Optional<Response> response = handler.handle(input);
        assertTrue(response.isPresent());
        final Response res = response.get();

        String toMatch = "Leider habe ich dich nicht verstanden, bitte ruf doch einfach den Notruf 112 an.";

        assertTrue(res.getOutputSpeech().toString().contains(toMatch));
    }
*/
}
