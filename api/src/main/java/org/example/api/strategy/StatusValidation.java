package org.example.api.strategy;

import io.restassured.response.Response;

// Status code validation implementation
public class StatusValidation implements ValidationStrategy {
    @Override
    public void validate(Response response) {
        // Validate that the status code is 200
        assertEquals(200, response.getStatusCode());
    }
}