package org.example.api.observer;

import io.restassured.response.Response;

// Logger implementation of ApiResponseObserver
public class ResponseLogger implements ApiResponseObserver {
    @Override
    public void update(Response response) {
        // Log the status line of the response
        System.out.println("Response received: " + response.getStatusLine());
    }
}
