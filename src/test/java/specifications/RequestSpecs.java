package specifications;

import config.ApiConfig;
import config.HeaderConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Request Specifications
 * Provides reusable request specifications for API tests
 */
public class RequestSpecs {

    /**
     * Get base request specification with default headers
     */
    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.BASE_URI)
                .addHeaders(HeaderConfig.getDefaultHeaders())
                .build();
    }

    /**
     * Get request specification with custom content type
     */
    public static RequestSpecification getSpecWithContentType(String contentType) {
        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.BASE_URI)
                .addHeaders(HeaderConfig.getHeadersWithContentType(contentType))
                .build();
    }
}
