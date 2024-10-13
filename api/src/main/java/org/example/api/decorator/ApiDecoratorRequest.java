package org.example.api.decorator;

import io.restassured.response.Response;

// Interface for API Request
public interface ApiDecoratorRequest {
    Response send();
}


