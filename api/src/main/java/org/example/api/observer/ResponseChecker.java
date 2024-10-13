package org.example.api.observer;

import io.restassured.response.Response;

// Checker implementation of ApiResponseObserver
public class ResponseChecker implements ApiResponseObserver {
    @Override
    public void update(Response response) {
        // Check if the status code is 200
        if (response.getStatusCode() != 200) {
            throw new AssertionError("Failed with status code: " + response.getStatusCode());
        }
    }
}
