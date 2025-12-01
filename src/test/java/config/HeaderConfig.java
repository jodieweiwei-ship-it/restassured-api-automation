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

    // Header values
    public static final String JSON_CONTENT_TYPE = "application/json";

    /**
     * Get default headers for API requests (NO API key - reqres.in doesn't require
     * it)
     */
    public static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, JSON_CONTENT_TYPE);
        return headers;
    }

    /**
     * Get headers with custom content type
     */
    public static Map<String, String> getHeadersWithContentType(String contentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, contentType);
        return headers;
    }
}
