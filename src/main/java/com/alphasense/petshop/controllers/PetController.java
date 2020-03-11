package com.alphasense.petshop.controllers;

import com.alphasense.petshop.dataModels.Pet;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
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

    public Pet getPet(String petId) {
        return given()
                .when()
                .get(petId)
                .as(Pet.class);
    }


}
