package org.example.api.factory;

public class RequestFactory {
    public static ApiFactoryRequest createRequest(String method, String url, Object... params) {
        return switch (method.toUpperCase()) {
            case "GET" -> new GetRequest(url);
            case "POST" -> new PostRequest(url, params[0]); //first param - body
            // add more
            default -> throw new IllegalArgumentException("Invalid method type: " + method);
        };
    }
}
