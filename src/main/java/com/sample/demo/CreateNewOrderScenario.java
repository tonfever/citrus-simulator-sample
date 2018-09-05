package com.sample.demo;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("CreateNewOrder")
@RequestMapping(value = "/services/rest/order", method = RequestMethod.POST)
public class CreateNewOrderScenario extends AbstractSimulatorScenario {
    @Override
    public void run(ScenarioRunner scenario) {
        scenario
            .http()
            .receive(httpServerReceiveActionBuilder -> {
                httpServerReceiveActionBuilder.post();
            });

        scenario
            .http()
            .send((builder -> builder
                .response(HttpStatus.OK)
                .payload("New Order has been created..."))
            );
    }
}