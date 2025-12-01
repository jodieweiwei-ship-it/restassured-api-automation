package base;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import specifications.RequestSpecs;

/**
 * Base Test Class
 * Provides common setup and utilities for all test classes
 */
public class BaseTest {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        // Use centralized request specification from RequestSpecs
        requestSpec = RequestSpecs.getBaseSpec();
    }
}