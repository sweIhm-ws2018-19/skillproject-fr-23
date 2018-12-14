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
import java.util.Collections;
import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

import main.java.beesafe.model.Conversation; 

public class MyInjuryIsIntentHandler implements RequestHandler {
	public static final String INJURY_SLOT = "Injury";
	public static final String INJURY_KEY = "INJURY"; 
	
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
        Slot injurySlot = slots.get(INJURY_SLOT);   
        String injury = injurySlot.getResolutions().getResolutionsPerAuthority().get(0).getValues().get(0).getValue().getName();
        Conversation.setInjury(injury);
        
        input.getAttributesManager().setSessionAttributes(Collections.singletonMap("LAST_INJURY", injury));

        //store persistent
        AttributesManager attributesManager = input.getAttributesManager();
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.put("LAST_INJURY", injurySlot.getValue());
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();
        
        String speechText = Conversation.getAnswerToInjury();

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSimpleCard("ColorSession", speechText)
                .withSpeech(speechText)
                .withShouldEndSession(false);


        return responseBuilder.build();
    }

}
