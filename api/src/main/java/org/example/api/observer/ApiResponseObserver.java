package org.example.api.observer;

import io.restassured.response.Response;

// Observer interface for API response updates
public interface ApiResponseObserver {
    void update(Response response);
}
