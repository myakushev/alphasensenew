package com.alphasense.petshop.testcontext;

import io.cucumber.core.api.Scenario;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext testContextEntity = null;

    private TestContext() {
    }

    public static TestContext getTestContext()
    {
        if (testContextEntity == null)
            testContextEntity = new TestContext();
        return testContextEntity;
    }


    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Response response;

    // Map for storing parameters used in tests.
    // This map can be updated during test execution.
    private Map<String, String> params = new HashMap<String, String>();

    private Scenario scenario;

    public void clear() {
        params.clear();
        response = null;
        scenario = null;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getParam(String paramName) {
        if (params.get(paramName) != null) {
            return params.get(paramName).toString();
        }
        return null;
    }

    public void addParam(String name, String value) {
        logger.info("Adding parameter '{}' with value: '{}' to context \n", name, value);
        params.put(name, value);
    }

    public boolean containsParam(String name) {
        return params.containsKey(name);
    }

       public String getResponseBody() {
           return response.body().asString();
       }

       public Response getResponse() {
           return response;
       }
    //
    //    public void setResponse(HttpResponseDecorator response) {
    //        this.response = response;
    //    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
