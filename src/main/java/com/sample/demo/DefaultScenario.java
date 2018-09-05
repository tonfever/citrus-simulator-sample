package com.sample.demo;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioRunner;
import org.springframework.http.HttpStatus;

@Scenario("DEFAULT_SCENARIO")
public class DefaultScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioRunner scenario) {
        scenario
            .http()
            .receive(httpServerReceiveActionBuilder -> httpServerReceiveActionBuilder
                .get()
            );

        scenario
            .http()
            .send((builder -> builder
                .response(HttpStatus.OK)
                .payload("This is a default response!"))
            );
    }
}
