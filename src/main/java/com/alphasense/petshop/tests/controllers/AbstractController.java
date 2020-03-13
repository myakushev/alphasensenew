package com.alphasense.petshop.tests.controllers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public abstract class AbstractController {
    static {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "qweqweqwe123qwe")
                .setBaseUri("http://petstore.swagger.io")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }
}
