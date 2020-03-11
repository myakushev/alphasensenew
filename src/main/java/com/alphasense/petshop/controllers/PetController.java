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
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(15000L))
                .log(LogDetail.ALL)
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

    public Pet getPet(Pet pet) {
        return given()
                .when()
                .get()
                .as(Pet.class);
    }





}
