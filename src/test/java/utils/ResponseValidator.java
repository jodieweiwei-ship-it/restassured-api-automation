package utils;

import io.restassured.response.Response;
import org.testng.Assert;

/**
 * Response Validator
 * Provides common validation and utility methods for API responses
 */
public class ResponseValidator {

    /**
     * Print detailed response information
     */
    public static void printResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
    }

    /**
     * Validate that response time is within acceptable limit
     */
    public static void validateResponseTime(Response response, long maxTimeMs) {
        long actualTime = response.getTime();
        Assert.assertTrue(actualTime < maxTimeMs,
                "Response time (" + actualTime + "ms) should be less than " + maxTimeMs + "ms");
    }

    /**
     * Extract value from JSON path
     */
    public static String extractJsonPath(Response response, String path) {
        return response.jsonPath().getString(path);
    }

    /**
     * Extract integer value from JSON path
     */
    public static Integer extractJsonPathInt(Response response, String path) {
        return response.jsonPath().getInt(path);
    }

    /**
     * Validate that email contains @ symbol
     */
    public static void validateEmail(String email) {
        Assert.assertNotNull(email, "Email should not be null");
        Assert.assertTrue(email.contains("@"), "Email should contain @ symbol");
    }

    /**
     * Validate that a field is not null
     */
    public static void validateNotNull(Object value, String fieldName) {
        Assert.assertNotNull(value, fieldName + " should not be null");
    }
}
