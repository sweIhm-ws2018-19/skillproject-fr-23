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

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import main.java.beesafe.model.Conversation;

public class YesIntentHandler implements RequestHandler {
	private static boolean endSession = false;
	
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("YesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
    	String answer = Conversation.getNextAnswer(true); 
    	String speechText = answer;     	
    	ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSpeech(speechText)
                .withShouldEndSession(endSession);

        return responseBuilder.build();
    }
    
    public static void setEndSession(boolean session) {
    	endSession = session;
    }
}