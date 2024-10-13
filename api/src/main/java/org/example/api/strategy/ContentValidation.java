package org.example.api.strategy;

import io.restassured.response.Response;

// Content validation implementation
public class ContentValidation implements ValidationStrategy {
    @Override
    public void validate(Response response) {
        // Validate that the "content" field is not null
        assertNotNull(response.jsonPath().get("content"));
    }
}
