/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.beesafe;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import main.beesafe.handlers.ApplicationHouseholdRemedyIntentHandler;
import main.beesafe.handlers.CancelandStopIntentHandler;
import main.beesafe.handlers.FallbackIntentHandler;
import main.beesafe.handlers.GoodByeIntentHandler;
import main.beesafe.handlers.HelpIntentHandler;
import main.beesafe.handlers.LaunchRequestHandler;
import main.beesafe.handlers.MyInjuryIsIntentHandler;
import main.beesafe.handlers.RiskIntentHandler;
import main.beesafe.handlers.SessionEndedRequestHandler;
import main.beesafe.handlers.TreatmentIntentHandler;


public class BeeSafeStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                		new TreatmentIntentHandler(),
                		new MyInjuryIsIntentHandler(),
                        new LaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),
                        new FallbackIntentHandler(),
                		new GoodByeIntentHandler(),
                		new RiskIntentHandler(),
                		new ApplicationHouseholdRemedyIntentHandler())
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public BeeSafeStreamHandler() {
        super(getSkill());
    }

}
