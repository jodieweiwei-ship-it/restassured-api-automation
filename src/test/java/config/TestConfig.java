package config;

/**
 * Test Configuration class
 * Stores test data, credentials, and test-related configuration
 */
public class TestConfig {

    // Valid test credentials
    public static final String VALID_EMAIL = "eve.holt@reqres.in";
    public static final String VALID_PASSWORD = "pistol";
    public static final String VALID_LOGIN_PASSWORD = "cityslicka";

    // Invalid test data
    public static final String INVALID_EMAIL = "invalid@test.com";
    public static final String INVALID_PASSWORD = "wrongpassword";
    public static final String SYDNEY_EMAIL = "sydney@fife";
    public static final String PETER_EMAIL = "peter@klaven";

    // Expected tokens
    public static final String EXPECTED_TOKEN = "reqres_d12155d34a0a4bc897208cb2893e9c0c";
    public static final int EXPECTED_USER_ID = 4;

    // Timeout configurations (in milliseconds)
    public static final long DEFAULT_TIMEOUT = 3000;
    public static final long MAX_RESPONSE_TIME = 2000;

    // Test user data
    public static final String TEST_USER_NAME = "Jodie Wei";
    public static final String TEST_USER_JOB = "SDET Engineer";
    public static final String UPDATED_USER_NAME = "Jodie Wei Updated";
    public static final String UPDATED_USER_JOB = "Senior SDET Engineer";
    public static final String PATCHED_USER_JOB = "Lead SDET Engineer";

    // Test user IDs
    public static final int EXISTING_USER_ID = 2;
    public static final int NON_EXISTENT_USER_ID = 999;

    // Pagination
    public static final int DEFAULT_PAGE = 1;
}
