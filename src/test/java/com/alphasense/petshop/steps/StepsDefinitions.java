package com.alphasense.petshop.steps;

import com.alphasense.petshop.controllers.PetController;
import com.alphasense.petshop.datamodels.petmodel.Pet;
import com.alphasense.petshop.datamodels.petnotfoundmodel.PetNotFound;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.alphasense.petshop.testcontext.TestContext.getTestContext;


public class StepsDefinitions {

    @Given("get unique pet id")
    public void setPetId() {
        Random random = new Random();
        int petId;
        while (true) {
            petId = random.nextInt(Integer.MAX_VALUE);
            Response rs = new PetController().getPet(String.valueOf(petId));
            getTestContext().setResponse(rs);
            int code = getTestContext().getResponse().getStatusCode();
            if (code == 404 && rs.as(PetNotFound.class).getMessage().equals("Pet not found")) {
                getTestContext().addParam("petId", String.valueOf(petId));
                break;
            }
            Assert.assertNotEquals("500 error code in getPet response", 500, code);
        }
        System.out.println(getTestContext().getResponseBody());
    }

    @Given("create pet with params")
    public void sendCreatePetParams(List<Map<String, String>> parametersList) {
        StepUtils.putParamsIntoContext(getTestContext(), parametersList);

        Pet petTest = new Pet(getTestContext().getParams());

        Pet pet = new PetController().addPet(petTest);


        System.out.println("aefarfgvdsgadfsrge");


        // Response rs = new PetController().getPet(String.valueOf(petId));

        // String body = createPetFromMap(DataReader.substituteParamsInMap(parametersList.get(0), testContext.getParams()))
        //         .petToJson(JsonInclude.Include.NON_NULL);
        // testContext.setResponse(restGatewayClient.petApi().createPet(body));
    }


    @And("check creation of pet")
    public void checkPetCreation() {
        String substitutedPetId = DataReader.substituteParamsInString(petId, testContext.getParams());
        testContext.setResponse(restGatewayClient.petApi().getPet(substitutedPetId));
        Assert.assertTrue(String.format("Creation of pet with id %s was not successful. Pet was not appeared in Database.", substitutedPetId),
                testContext.getResponse().isSuccess());
        logger.info(String.format("Pet with id %s was successfully created", substitutedPetId));
    }

}
