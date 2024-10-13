package org.example.api.strategy;

import io.restassured.response.Response;

public class ApіResponseValidator {
    private ValidationStrategy strategy;

    // Constructor to inject the strategy
    public ApіResponseValidator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ValidationStrategy strategy){
        this.strategy = strategy;
    }

    public void validateResponse(Response response) {
        // Validate the response using the injected strategy
        strategy.validate(response);
    }
}
