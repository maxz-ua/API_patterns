package org.example.api.strategy;

import io.restassured.response.Response;

public interface ValidationStrategy {
    void validate(Response response);
}
