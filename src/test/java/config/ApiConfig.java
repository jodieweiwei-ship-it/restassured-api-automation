package config;

/**
 * API Configuration class
 * Centralizes all API endpoint URLs and environment settings
 */
public class ApiConfig {

    // Base URI
    public static final String BASE_URI = "https://reqres.in/api";

    // Endpoint paths
    public static final String USERS_ENDPOINT = "/users";
    public static final String REGISTER_ENDPOINT = "/register";
    public static final String LOGIN_ENDPOINT = "/login";

    // Environment settings
    public enum Environment {
        DEV("https://dev.reqres.in/api"),
        QA("https://qa.reqres.in/api"),
        PROD("https://reqres.in/api");

        private final String baseUri;

        Environment(String baseUri) {
            this.baseUri = baseUri;
        }

        public String getBaseUri() {
            return baseUri;
        }
    }

    /**
     * Get base URI based on environment
     * Default is PROD
     */
    public static String getBaseUri() {
        String env = System.getProperty("env", "PROD");
        try {
            return Environment.valueOf(env.toUpperCase()).getBaseUri();
        } catch (IllegalArgumentException e) {
            return Environment.PROD.getBaseUri();
        }
    }

    /**
     * Get full URL for an endpoint
     */
    public static String getEndpointUrl(String endpoint) {
        return BASE_URI + endpoint;
    }
}
