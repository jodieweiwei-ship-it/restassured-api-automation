package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTest {
   // protected String baseURI = "https://reqres.in/api";
    protected RequestSpecification requestSpec;  

    @BeforeClass
    public void setup() {
        //RestAssured.baseURI = baseURI;
        requestSpec = new RequestSpecBuilder()
        		.setBaseUri("https://reqres.in/api")
                .addHeader("x-api-key", "reqres-free-v1")  
                .addHeader("Content-Type", "application/json")  
                .build();
    }

    protected void printResponse(Response response) {
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Response Body: " + response.getBody().asString());
    }
}