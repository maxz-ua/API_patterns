package org.example.api.decorator.request;

import io.restassured.response.Response;

// Interface for API Request
public interface ApiDecoratorRequest {
    Response send();
}


