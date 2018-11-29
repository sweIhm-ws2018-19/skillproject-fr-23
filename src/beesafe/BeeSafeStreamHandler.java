/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package beesafe;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import beesafe.handlers.ApplicationHouseholdRemedyIntentHandler;
import beesafe.handlers.CancelandStopIntentHandler;
import beesafe.handlers.FallbackIntentHandler;
import beesafe.handlers.GoodByeIntentHandler;
import beesafe.handlers.HelpIntentHandler;
import beesafe.handlers.LaunchRequestHandler;
import beesafe.handlers.MyInjuryIsIntentHandler;
import beesafe.handlers.RiskIntentHandler;
import beesafe.handlers.SessionEndedRequestHandler;
import beesafe.handlers.TreatmentIntentHandler;


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
