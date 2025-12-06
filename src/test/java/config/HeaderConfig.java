package config;

import java.util.HashMap;
import java.util.Map;

/**
 * Header Configuration class
 * Manages all common HTTP headers used across API requests
 */
public class HeaderConfig {

    // Header constants
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final String X_API_KEY = "x-api-key";

    // Header values
    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String API_KEY = "YOUR_API_KEY";


    /**
     * Get default headers for API requests (x-api-key: YOUR_API_KEY)
     */
    public static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, JSON_CONTENT_TYPE);
        headers.put(X_API_KEY, API_KEY);
        return headers;
    }

    /**
     * Get headers with custom content type
     */
    public static Map<String, String> getHeadersWithContentType(String contentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, contentType);
        headers.put(X_API_KEY, API_KEY);
        return headers;
    }
}
