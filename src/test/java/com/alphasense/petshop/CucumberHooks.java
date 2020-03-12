
package com.alphasense.petshop;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.core.api.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alphasense.petshop.testcontext.TestContext;

import java.util.Collection;

public class CucumberHooks {

    private static final String SPLITTER = "======================";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final TestContext testContext;

    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        logger.info("{} SCENARIO '{}' {}", SPLITTER, scenario.getName(), SPLITTER);
        Collection<String> tags = scenario.getSourceTagNames();
//        setDefaultContextParams();
        testContext.setScenario(scenario);
    }

    @After(order = 1)
    public void tearDown() {
        testContext.clear();
    }


//    private void setDefaultContextParams() {
//        RegexpUtils.REGEXPS.forEach(
//                (k, v) -> testContext.addParam(k, RegexpUtils.REGEXP_PREFIX + v));
//    }
}