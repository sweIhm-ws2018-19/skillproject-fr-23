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

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Optional;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import main.java.beesafe.SpeechStrings;
import main.java.beesafe.model.Conversation;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) { 
    	Conversation.reset();
    	
    	AttributesManager attributesManager = input.getAttributesManager();
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        String lastInjury = (String) persistentAttributes.get("LAST_INJURY");
        Conversation.setLastInjury(lastInjury);
    	
    	if(lastInjury == null) {
	        return input.getResponseBuilder()
	                .withSimpleCard(SpeechStrings.BEE_SAFE_NAME, SpeechStrings.WELCOME_MESSAGE)
	                .withSpeech(SpeechStrings.WELCOME_MESSAGE)
	                .withReprompt(SpeechStrings.WELCOME_MESSAGE_REPROMT)
	                .build();
    	} else {
    		return input.getResponseBuilder()
	                .withSimpleCard(SpeechStrings.BEE_SAFE_NAME, SpeechStrings.WELCOME_WITH_LAST_INJURY)
	                .withSpeech(SpeechStrings.WELCOME_WITH_LAST_INJURY)
	                .withReprompt(SpeechStrings.WELCOME_WITH_LAST_INJURY_REPROMT)
	                .build();
    	}
    }
}
