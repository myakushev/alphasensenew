package com.alphasense.petshop.tests.steps;

import com.alphasense.petshop.tests.controllers.ApiUrls;
import com.alphasense.petshop.tests.controllers.HttpController;
import com.alphasense.petshop.tests.datamodels.ordermodel.Order;
import com.alphasense.petshop.tests.datamodels.petmodel.Pet;
import com.alphasense.petshop.tests.datamodels.notfoundmodel.ObjectNotFound;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.alphasense.petshop.tests.testcontext.TestContext.getTestContext;

public class StepsDefinitions {

    @Given("get unique pet id")
    public void getUniquePetId() {
        int id = getUniqueId(ApiUrls.PET_BASE_PATH, "Pet");
        getTestContext().addParam("petId", String.valueOf(id));
        getTestContext().getResponse().prettyPrint();
    }

    @Given("create pet with params")
    public void createPetParams(List<Map<String, String>> parametersList) {
        StepUtils.putParamsIntoContext(getTestContext(), parametersList);
        Pet petTest = new Pet(getTestContext().getParams());
        getTestContext().addParam("petToCreate", petTest);
        Response rs = HttpController.add(ApiUrls.PET_BASE_PATH, petTest);
        rs.then().statusCode(HttpStatus.SC_OK);
        getTestContext().setResponse(rs);
    }

    @Given("check creation of pet")
    public void checkPetCreation() {
        Response rs = HttpController.get(ApiUrls.PET_BASE_PATH, String.valueOf(getTestContext().getParam("petId")));
        rs.then().statusCode(HttpStatus.SC_OK);
        rs.prettyPrint();
        Assert.assertEquals("Created pet does not equal expected one.", getTestContext().getParam("petToCreate"), rs.as(Pet.class));
    }

    @Given("delete created pet")
    public void deletePet() {
        Response rs = HttpController.delete(ApiUrls.PET_BASE_PATH, String.valueOf(getTestContext().getParam("petId")));
        rs.then().statusCode(HttpStatus.SC_OK);
    }

    @Given("check deletion of pet")
    public void checkPetDeletion() {
        Response rs = HttpController.get(ApiUrls.PET_BASE_PATH, String.valueOf(getTestContext().getParam("petId")));
        rs.then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Given("get unique order id")
    public void getUniqueOrderId() {
        int id = getUniqueId(ApiUrls.ORDER_BASE_PATH, "Order");
        getTestContext().addParam("orderId", String.valueOf(id));
        getTestContext().getResponse().prettyPrint();
    }

    @Given("create order with params")
    public void createOrderParams(List<Map<String, String>> parametersList) {
        StepUtils.putParamsIntoContext(getTestContext(), parametersList);
        Order orderTest = new Order(getTestContext().getParams());
        getTestContext().addParam("orderToCreate", orderTest);
        Response rs = HttpController.add(ApiUrls.ORDER_BASE_PATH, orderTest);
        rs.then().statusCode(HttpStatus.SC_OK);
        getTestContext().setResponse(rs);
    }

    @Given("check creation of order")
    public void checkOrderCreation() {
        Response rs = HttpController.get(ApiUrls.ORDER_BASE_PATH, String.valueOf(getTestContext().getParam("orderId")));
        rs.then().statusCode(HttpStatus.SC_OK);
        rs.prettyPrint();
        Assert.assertEquals("Created order does not equal expected one.", getTestContext().getParam("orderToCreate"), rs.as(Order.class));
    }

    private int getUniqueId(String basePath, String objectName) {
        Random random = new Random();
        int id;
        while (true) {
            id = random.nextInt(Integer.MAX_VALUE);
            Response rs = HttpController.get(basePath, String.valueOf(id));
            getTestContext().setResponse(rs);
            int code = getTestContext().getResponse().getStatusCode();
            if (code == HttpStatus.SC_NOT_FOUND && rs.as(ObjectNotFound.class).getMessage().equals(String.format("%s not found", objectName))) {
                break;
            }
            Assert.assertNotEquals("500 error code in get response", HttpStatus.SC_INTERNAL_SERVER_ERROR, code);
        }
        return id;
    }
}
