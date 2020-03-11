package com.alphasense.petshop;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.Random;

public class StepsDefinitions {

//    @Given("set unique pet id in context")
//    public void setPetId() {
//        Random random = new Random();
//        int petId;
//        while (true) {
//            petId = random.nextInt(Integer.MAX_VALUE);
//            testContext.setResponse(restGatewayClient.petApi().getPet(Integer.toString(petId)));
//            int code = testContext.getResponse().getStatusCode();
//            if (code == 404 &&
//                    testContext.getResponse().getJsonParam("$.message").toString().equals("Pet not found")) {
//                testContext.addParam("petId", petId);
//                break;
//            }
//            Assert.assertNotEquals("500 error code in getPet response", 500, code);
//        }
//    }
}
