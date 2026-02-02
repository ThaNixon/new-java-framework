package controllers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static constants.CommandConstants.BASE_URI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PetController {
    RequestSpecification requestSpecification;
    private static final String PET_ENDPOINT = "pet";

    public PetController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

    //implement
}