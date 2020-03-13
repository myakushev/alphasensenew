package com.alphasense.petshop.tests.controllers;

import com.alphasense.petshop.tests.datamodels.petmodel.Pet;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetController extends AbstractController {

    public PetController() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBasePath("/v2/pet")
                .build();
    }

    public Response addPet(Pet pet) {
        return given()
                .body(pet)
                .post();
    }

    public Response getPet(String petId) {
        return given()
                .get(petId);
    }

    public Response deletePet(String petId) {
        return given()
                .delete(petId);
    }
}
