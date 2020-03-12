package com.alphasense.petshop.controllers;

import com.alphasense.petshop.datamodels.petmodel.Pet;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class PetController extends AbstractController {

    public PetController() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBasePath("/v2/pet")
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
    }

    public Pet addPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post()
                .as(Pet.class);
    }

    public Pet addPet(String pet) {
        return given()
                .body(pet)
                .when()
                .post()
                .as(Pet.class);
    }

    public Response getPet(String petId) {
        return given()
                .get(petId);
    }


}
