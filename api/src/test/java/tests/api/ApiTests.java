package tests.api;

import io.restassured.response.Response;
import org.example.api.builder.ApiRequestBuilder;
import org.example.api.builder.HttpMethod;
import org.example.api.decorator.request.ApiDecoratorRequest;
import org.example.api.decorator.request.AuthorizedRequestDecorator;
import org.example.api.decorator.request.BasicRequest;
import org.example.api.facade.ApiFacade;
import org.example.api.factory.ApiFactoryRequest;
import org.example.api.factory.RequestFactory;
import org.example.api.observer.ApiResponseSubject;
import org.example.api.observer.ResponseChecker;
import org.example.api.observer.ResponseLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiTests {
    @Test
    public void testGetRequestFactory() {
        ApiFactoryRequest request = RequestFactory.createRequest("GET", "/data");
        Response response = request.sendRequest();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testPostRequestFactory() {
        ApiFactoryRequest request = RequestFactory.createRequest("POST", "/submit");
        Response response = request.sendRequest();
        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void testDecoratorPattern() {
        // Create a basic request
        ApiDecoratorRequest request = new BasicRequest("http://example.com/secure/data");

        // Decorate the basic request with authorization
        ApiDecoratorRequest authorizedRequest = new AuthorizedRequestDecorator(request, "your_token_here");

        // Send the authorized request and get the response
        Response response = authorizedRequest.send();

        // Validate the response status code
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testFacadePattern() {
        // Create an instance of ApiFacade
        ApiFacade api = new ApiFacade();
        // Call the getUserProfile method with userId 1
        Response response = api.getUserProfile(1);
        // Assert that the response status code is 200
        assertEquals(200, response.getStatusCode());
        // Assert that the "profile" field is present in the response
        assertNotNull(response.jsonPath().get("profile"));
    }

    @Test
    public void testBuilderPattern() {
        // Create an instance of the ApiRequestBuilder
        ApiRequestBuilder builder = new ApiRequestBuilder();

        // Build the request and send it
        Response response = builder
                .setUrl("http://example.com/data")
                .setMethod(HttpMethod.GET)
                .sendRequest(); //.build

        // Assert that the response status code is 200
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testObserverPattern() {
        // Create an instance of the ApiResponseSubject
        ApiResponseSubject subject = new ApiResponseSubject();
        // Add observers to the subject
        subject.addObserver(new ResponseLogger());
        subject.addObserver(new ResponseChecker());
        // Fetch the response from the API
        subject.fetchResponse("http://example.com/data");
    }
}

