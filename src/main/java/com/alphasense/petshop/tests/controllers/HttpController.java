package com.alphasense.petshop.tests.controllers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class HttpController {
    static {
        String baseUrl = Optional.ofNullable(System.getProperty("baseUrl")).orElse(ApiUrls.BASE_URL);
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static Response add(String basePath, Object obj) {
        return given()
                .basePath(basePath)
                .body(obj)
                .post();
    }

    public static Response get(String basePath, String objId) {
        return given()
                .basePath(basePath)
                .get(objId);
    }

    public static Response delete(String basePath, String objId) {
        return given()
                .basePath(basePath)
                .delete(objId);
    }
}
