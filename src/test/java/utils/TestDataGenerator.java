package utils;

import config.TestConfig;
import models.AuthRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Test Data Generator
 * Provides methods to generate test data for various scenarios
 */
public class TestDataGenerator {

    private static final Random random = new Random();

    /**
     * Generate a valid authentication request
     */
    public static AuthRequest generateValidAuthRequest() {
        return new AuthRequest(TestConfig.VALID_EMAIL, TestConfig.VALID_PASSWORD);
    }

    /**
     * Generate a valid login request
     */
    public static AuthRequest generateValidLoginRequest() {
        return new AuthRequest(TestConfig.VALID_EMAIL, TestConfig.VALID_LOGIN_PASSWORD);
    }

    /**
     * Generate an invalid authentication request
     */
    public static AuthRequest generateInvalidAuthRequest() {
        return new AuthRequest(TestConfig.INVALID_EMAIL, TestConfig.INVALID_PASSWORD);
    }

    /**
     * Generate a random email address
     */
    public static String generateRandomEmail() {
        return "test" + random.nextInt(10000) + "@example.com";
    }

    /**
     * Generate a random name
     */
    public static String generateRandomName() {
        String[] firstNames = { "John", "Jane", "Michael", "Sarah", "David", "Emma" };
        String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };
        return firstNames[random.nextInt(firstNames.length)] + " " +
                lastNames[random.nextInt(lastNames.length)];//random.nextInt(array.length): This method from the Random class generates a random integer between 0 (inclusive) and the number passed as the argument (exclusive).
    }

    /**
     * Generate user data map for create/update operations
     */
    public static Map<String, String> generateUserData(String name, String job) {
        Map<String, String> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("job", job);
        return userData;
    }

    /**
     * Generate a partial update map (job only)
     */
    public static Map<String, String> generatePartialUpdate(String job) {
        Map<String, String> update = new HashMap<>();
        update.put("job", job);
        return update;
    }
}
