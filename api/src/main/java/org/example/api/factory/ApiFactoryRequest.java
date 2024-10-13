package org.example.api.factory;

import io.restassured.response.Response;

public interface ApiFactoryRequest {
    Response sendRequest();
}
