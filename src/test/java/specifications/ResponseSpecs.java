package specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

/**
 * Response Specifications
 * Provides reusable response specifications for common validation patterns
 */
public class ResponseSpecs {

    /**
     * Success response specification (200 OK)
     */
    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    /**
     * Created response specification (201 Created)
     */
    public static ResponseSpecification createdResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }

    /**
     * Bad request response specification (400 Bad Request)
     */
    public static ResponseSpecification badRequestResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectBody("error", notNullValue())
                .build();
    }

    /**
     * Not found response specification (404 Not Found)
     */
    public static ResponseSpecification notFoundResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    /**
     * No content response specification (204 No Content)
     */
    public static ResponseSpecification noContentResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
