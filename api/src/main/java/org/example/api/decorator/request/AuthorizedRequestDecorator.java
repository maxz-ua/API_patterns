package org.example.api.decorator.request;

import io.restassured.RestAssured;
import io.restassured.response.Response;

// Decorator class for adding authorization to the API request
public class AuthorizedRequestDecorator implements ApiDecoratorRequest {
    private ApiDecoratorRequest wrappedRequest;
    private String token;

    // Constructor to wrap an existing ApiRequest and add a token
    public AuthorizedRequestDecorator(ApiDecoratorRequest request, String token) {
        this.wrappedRequest = request;
        this.token = token;
    }

    // Override the send method to add authorization header and send the request
    @Override
    public Response send() {
        // Use RestAssured to add the authorization header
        RestAssured.given().header("Authorization", "Bearer " + token);
        // Delegate the request sending to the wrapped request
        return wrappedRequest.send();
    }
}

