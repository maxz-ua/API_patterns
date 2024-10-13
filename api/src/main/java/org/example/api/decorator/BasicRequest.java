package org.example.api.decorator;


import io.restassured.RestAssured;
import io.restassured.response.Response;

// Implementation of a basic GET request
public class BasicRequest implements ApiDecoratorRequest {
    private String url;
    // Constructor to initialize the URL
    public BasicRequest(String url) {
        this.url = url;
    }
    // Override the send method to send a GET request
    @Override
    public Response send() {
        return RestAssured.get(url);
    }
}
