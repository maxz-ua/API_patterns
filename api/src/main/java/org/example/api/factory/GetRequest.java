package org.example.api.factory;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest implements ApiFactoryRequest {
    private String url;

    public GetRequest(String url) {
        this.url = url;
    }

    @Override
    public Response sendRequest() {
        return RestAssured.get(url);
    }
}
