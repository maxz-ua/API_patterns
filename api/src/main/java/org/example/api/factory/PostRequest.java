package org.example.api.factory;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest implements ApiFactoryRequest {
    private String url;
    private Object body;

    public PostRequest(String url, Object body) {
        this.url = url;
        this.body = body;
    }

    @Override
    public Response sendRequest() {
        return RestAssured.given()
                .body(body)
                .post(url);
    }
}
