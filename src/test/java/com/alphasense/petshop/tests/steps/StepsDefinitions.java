package com.alphasense.petshop.tests.steps;

import com.alphasense.petshop.tests.controllers.PetController;
import com.alphasense.petshop.tests.datamodels.petmodel.Pet;
import com.alphasense.petshop.tests.datamodels.petnotfoundmodel.PetNotFound;
import com.alphasense.petshop.tests.testcontext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class StepsDefinitions {

    @Given("get unique pet id")
    public void setPetId() {
        Random random = new Random();
        int petId;
        while (true) {
            petId = random.nextInt(Integer.MAX_VALUE);
            Response rs = new PetController().getPet(String.valueOf(petId));
            TestContext.getTestContext().setResponse(rs);
            int code = TestContext.getTestContext().getResponse().getStatusCode();
            if (code == 404 && rs.as(PetNotFound.class).getMessage().equals("Pet not found")) {
                TestContext.getTestContext().addParam("petId", String.valueOf(petId));
                break;
            }
            Assert.assertNotEquals("500 error code in getPet response", 500, code);
        }
        System.out.println(TestContext.getTestContext().getResponseBody());
    }

    @Given("create pet with params")
    public void createPetParams(List<Map<String, String>> parametersList) {
        StepUtils.putParamsIntoContext(TestContext.getTestContext(), parametersList);
        Pet petTest = new Pet(TestContext.getTestContext().getParams());
        TestContext.getTestContext().addParam("petToCreate", petTest);
        Response rs = new PetController().addPet(petTest);
        rs.then().statusCode(200);
        TestContext.getTestContext().setResponse(rs);

        System.out.println("time stop");
    }

    @And("check creation of pet")
    public void checkPetCreation() {
        Response rs = new PetController().getPet(String.valueOf(TestContext.getTestContext().getParam("petId")));
        rs.then().statusCode(200);
        rs.prettyPrint();
        System.out.println("time stop");
        Assert.assertTrue("Created pet does not equal expected one.", TestContext.getTestContext().getParam("petToCreate").equals(rs.as(Pet.class)));
    }

    @And("delete created pet")
    public void deletePet() {
        Response rs = new PetController().deletePet(String.valueOf(TestContext.getTestContext().getParam("petId")));
        rs.then().statusCode(200);
    }

    @And("check deletion of pet")
    public void checkPetDeletion() {
        Response rs = new PetController().getPet(String.valueOf(TestContext.getTestContext().getParam("petId")));
        rs.then().statusCode(404);
    }
}
