package org.example.api.observer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

// Subject class that maintains a list of observers
public class ApiResponseSubject {
    private List<ApiResponseObserver> observers = new ArrayList<>();
    private Response response;
    // Method to add an observer
    public void addObserver(ApiResponseObserver observer) {
        observers.add(observer);
    }
    // Method to notify all observers with the latest response
    public void notifyObservers() {
        for (ApiResponseObserver observer : observers) {
            observer.update(response);
        }
    }
    // Method to fetch the response from the API and notify observers
    public void fetchResponse(String url) {
        response = RestAssured.get(url);
        notifyObservers();
    }
}

