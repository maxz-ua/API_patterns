package org.example.api.facade;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiFacade {

    // Method to get the user profile by userId
    public Response getUserProfile(int userId) {
        // Set the base URL for the API
        RestAssured.baseURI = "http://api.example.com";

        // Perform the login request and retrieve the token
        Response loginResponse = RestAssured.given()
                .formParam("username", "your_username")
                .formParam("password", "your_password")
                .post("/login");

        // Extract the token from the login response
        String token = loginResponse.jsonPath().getString("token");

        // Use the token to send an authenticated request for the user profile
        return RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get("/users/" + userId);
    }
}

