package test.java;

import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import main.java.beesafe.handlers.YesIntentHandler;
import main.java.beesafe.model.Conversation;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class YesIntentHandlerTest {

    private YesIntentHandler handler;

    @Before
    public void setup() {
        handler = new YesIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    //TODO entfernen, oder lauffähig machen. der test schlägt aktuell fehl
    /*
    @Test
    public void testHandle() {
        main.java.beesafe.model.Conversation.setInjury("stich");

        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());


        for(int i = -1;i < 1; i++ ){
            Conversation.setIndex(i);
            Conversation.setNowConversation(false);
            Optional<Response> response = handler.handle(input);
            assertTrue(response.isPresent());
            Response res = response.get();

            Conversation.setIndex(i);
            Conversation.setNowConversation(false);
            String expectedString = Conversation.getNextAnswer(true);

            assertTrue(res.getOutputSpeech().toString().contains(expectedString));
        }

        
        for(int i = -1;i < 7; i++ ){
            Conversation.setIndex(i);
            Conversation.setNowConversation(true);
            Optional<Response> response = handler.handle(input);
            assertTrue(response.isPresent());
            Response res = response.get();

            Conversation.setIndex(i);
            Conversation.setNowConversation(true);
            String expectedString = Conversation.getNextAnswer(true);

            assertTrue(res.getOutputSpeech().toString().contains(expectedString));
        }



    }*/


}
