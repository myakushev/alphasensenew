package com.alphasense.petshop.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.core.api.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

import static com.alphasense.petshop.tests.testcontext.TestContext.getTestContext;

public class CucumberHooks {

    private static final String SPLITTER = "======================";
    private final Logger logger = LogManager.getLogger(CucumberHooks.class);

    public CucumberHooks() {
    }

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        logger.info("{} SCENARIO '{}' {}", SPLITTER, scenario.getName(), SPLITTER);
        Collection<String> tags = scenario.getSourceTagNames();
        getTestContext().setScenario(scenario);
    }

    @After(order = 1)
    public void tearDown() {
        getTestContext().clear();
    }

}