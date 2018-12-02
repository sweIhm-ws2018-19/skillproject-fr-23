/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.java.beesafe.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

import main.java.beesafe.SpeechStrings;
import main.java.beesafe.model.Injury;
import main.java.beesafe.model.Risk; 

public class RiskIntentHandler implements RequestHandler {
	public static final String RISK_SLOT = "Risk";
	public static final String RISK_KEY = "RISK";
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RiskIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        Slot riskSlot = slots.get(RISK_SLOT);
        Risk risk = new Risk(riskSlot.getResolutions().getResolutionsPerAuthority().get(0).getValues().get(0).getValue().getName());
    	
    	Injury injury = MyInjuryIsIntentHandler.injury; 
    	String speechText, repromptText;
    	boolean isAskResponse = false;
    	
    	if (injury != null) {
	    	if (injury.getInjury().equals("stich")) { 
	    		speechText = SpeechStrings.risikoBeiStich_Message;
	    		repromptText = SpeechStrings.risikoBeiStich_Message_Reprompt;
	    	}
	    	else if (injury.getInjury().equals("sonnenbrand")) { 
	    		if(risk.getName().equals("fieber") || risk.getName().equals("kreislaufprobleme")) { 
	    			speechText = SpeechStrings.risikoEinesSonnenstichs_Message;
	        		repromptText = SpeechStrings.risikoEinesSonnenstichs_Message_Reprompt;
	    		}
	    		else { 
	    			speechText = SpeechStrings.risikoBeiSonnenbrand_Message;
	        		repromptText = SpeechStrings.risikoBeiSonnenbrand_Message_Reprompt;
	    		}
	    	} else {
	    		speechText = "Bitte sag mir zuerst, was deine Verletzung ist"; 
	    		repromptText = "Ich wei� leider nicht, was deine Verletzung ist.";
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