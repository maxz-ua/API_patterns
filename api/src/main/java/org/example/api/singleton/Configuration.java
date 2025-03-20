package org.example.api.singleton;

public class Configuration {
    private static Configuration instance;
    private final String baseUrl;

    // Private constructor to prevent instantiation
    private Configuration() {
        // Initializing the baseUrl
        this.baseUrl = "https://api.example.com";
    }

    // Method to get the singleton instance of Configuration
    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    // Getter for baseUrl
    public String getBaseUrl() {
        return baseUrl;
    }
}

