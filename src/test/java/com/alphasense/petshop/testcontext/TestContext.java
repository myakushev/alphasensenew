package com.alphasense.petshop.testcontext;

import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    private HttpResponseDecorator response;

    // Map for storing parameters used in tests.
    // This map can be updated during test execution.
    private Map<String, Object> params = new HashMap<String, Object>();

    private Scenario scenario;

    public void clear() {
        params.clear();
//        response = null;
        scenario = null;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public String getParam(String paramName) {
        if (params.get(paramName) != null) {
            return params.get(paramName).toString();
        }
        return null;
    }

    public void addParam(String name, Object value) {
        logger.info("Adding parameter '{}' with value: '{}' to context \n", name, value);
        params.put(name, value);
    }

    public boolean containsParam(String name) {
        return params.containsKey(name);
    }

//    public String getResponseBody() {
//        return response.getBody();
//    }
//
//    public HttpResponseDecorator getResponse() {
//        return response;
//    }
//
//    public void setResponse(HttpResponseDecorator response) {
//        this.response = response;
//    }

}
