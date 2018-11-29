/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package beesafe.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder; 
import beesafe.SpeechStrings;
import beesafe.model.Injury;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class MyInjuryIsIntentHandler implements RequestHandler {
	public static final String INJURY_SLOT = "Injury";
	public static final String INJURY_KEY = "INJURY";
	public static Injury injury; 
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MyInjuryIsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        // Get the injury slot from the list of slots.
        injury = new Injury(slots.get(INJURY_SLOT).getValue());
        
        System.out.println(injury.getInjury());

        String speechText, repromptText;
        boolean isAskResponse = false;

        // Check for injury and create output to user.
        if (injury != null) {
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(INJURY_KEY, injury));

            if (injury.getInjury().equals("stich")) {
        		speechText = SpeechStrings.injuryIsStich_Message;
        		repromptText = SpeechStrings.injuryIsStich_Message_Reprompt;
            }
        	else if (injury.getInjury().equals("sonnenbrand")) { 
        		speechText = SpeechStrings.injuryIsSonnenbrand_Message;
        		repromptText = SpeechStrings.injuryIsSonnenbrand_Message_Reprompt;
        	}
        	else {
        		speechText = "Oh! Da kenne ich mich leider nicht aus. Hier sind drei Notaufnahmen in deiner Naehe: ";
        		repromptText = String.format("Bei %s kann ich dir leider nicht helfen. Geh doch zur naechsten Notaufnahme. ", injury);
        	}

        } else {
            // Render an error since we don't know what the users injury is.
            speechText = "Ich habe dich leider nicht verstanden. Kannst du mir deine Verletzung nochmal sagen?";
            repromptText = "Ich weiss nicht was Deine Verletzung ist. Sag mir Deine Verletzung nochmal.";
            isAskResponse = true;
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);

        if (isAskResponse) {
            responseBuilder.withShouldEndSession(false)
                    .withReprompt(repromptText);
        }

        return responseBuilder.build();
    }

}
