package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected String baseURI = "https://reqres.in/api";
    protected RequestSpecification requestSpec;  // 👈 添加这个

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
        requestSpec = new RequestSpecBuilder()
                .addHeader("x-api-key", "reqres-free-v1")  // 👈 添加header
                .addHeader("Content-Type", "application/json")  // 👈 也可以加其他通用header
                .build();
    }

    protected void printResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
    }
}