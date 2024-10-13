package org.example.api.builder;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class ApiRequestBuilder {
    private String url;
    private HttpMethod method;

    // Set the URL for the request
    public ApiRequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    // Set the HTTP method for the request
    public ApiRequestBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    // Send the request and return the response
    public Response sendRequest() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(url);
        return request.request(method.name());
    }
}

