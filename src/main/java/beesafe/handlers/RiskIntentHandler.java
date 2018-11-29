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

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class RiskIntentHandler implements RequestHandler {
	public static final String RISK_SLOT = "Risk";
	public static final String RISK_KEY = "RISK";
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.RiskIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String risk = slots.get(RISK_SLOT).getValue();
    	
    	Injury injury = MyInjuryIsIntentHandler.injury; 
    	String speechText, repromptText;
    	boolean isAskResponse = false;
    	
    	if (injury.equals("stich")) { 
    		speechText = SpeechStrings.risikoBeiStich_Message;
    		repromptText = SpeechStrings.risikoBeiStich_Message_Reprompt;
    	}
    	else if (injury.equals("sonnenbrand")) { 
    		if(risk.equals("fieber") || risk.equals("kreislaufprobleme")) { 
    			speechText = SpeechStrings.risikoEinesSonnenstichs_Message;
        		repromptText = SpeechStrings.risikoEinesSonnenstichs_Message_Reprompt;
    		}
    		else { 
    			speechText = SpeechStrings.risikoBeiSonnenbrand_Message;
        		repromptText = SpeechStrings.risikoBeiSonnenbrand_Message_Reprompt;
    		}
    	}
    	else { 
    		speechText = "Bitte sag mir zuerst, was deine Verletzung ist"; 
    		repromptText = "Ich wei� leider nicht, was deine Verletzung ist.";
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