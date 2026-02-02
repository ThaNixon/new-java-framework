package controllers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static constants.CommandConstants.BASE_URI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class StoreController {
    RequestSpecification requestSpecification;
    private static final String STORE_ENDPOINT = "Store";

    public StoreController() {
        this.requestSpecification = given()
                .accept(JSON)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

    //implement
}