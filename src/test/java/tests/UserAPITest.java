package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAPITest extends BaseTest {

    @Test(priority = 1, description = "Get list of users - Verify status code 200")
    public void testGetUsers() {
        Response response = given()
                .spec(requestSpec)  // 👈 添加

            .queryParam("page", 1)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("page", equalTo(1))
            .body("data", not(empty()))
            .body("data[0].id", notNullValue())
            .body("data[0].email", containsString("@"))
        .extract().response();

        printResponse(response);
        
        Assert.assertTrue(response.getTime() < 3000, 
            "Response time should be less than 3 seconds");
    }

    @Test(priority = 2, description = "Get single user - Verify user details")
    public void testGetSingleUser() {
        int userId = 2;
        
        Response response = given()
                .spec(requestSpec)  // 👈 添加

        .when()
            .get("/users/" + userId)
        .then()
            .statusCode(200)
            .body("data.id", equalTo(userId))
            .body("data.email", notNullValue())
            .body("data.first_name", notNullValue())
            .body("data.last_name", notNullValue())
        .extract().response();

        printResponse(response);
        
        String email = response.jsonPath().getString("data.email");
        Assert.assertNotNull(email, "Email should not be null");
        Assert.assertTrue(email.contains("@"), "Email should contain @");
    }

    @Test(priority = 3, description = "Get non-existent user - Verify 404")
    public void testGetUserNotFound() {
        given()
        .spec(requestSpec)  // 👈 添加

        .when()
            .get("/users/999")
        .then()
            .statusCode(404)
            .body(equalTo("{}"));
    }

    @Test(priority = 4, description = "Create new user - Verify 201 status")
    public void testCreateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Jodie Wei\",\n" +
                "    \"job\": \"SDET Engineer\"\n" +
                "}";

        Response response = given()
                .spec(requestSpec)  // 👈 添加

            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Jodie Wei"))
            .body("job", equalTo("SDET Engineer"))
            .body("id", notNullValue())
            .body("createdAt", notNullValue())
        .extract().response();

        printResponse(response);
        
        String createdId = response.jsonPath().getString("id");
        Assert.assertNotNull(createdId, "Created user should have an ID");
    }

    @Test(priority = 5, description = "Update user - Verify PUT request")
    public void testUpdateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Jodie Wei Updated\",\n" +
                "    \"job\": \"Senior SDET Engineer\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

           // .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/users/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Jodie Wei Updated"))
            .body("job", equalTo("Senior SDET Engineer"))
            .body("updatedAt", notNullValue());
    }

    @Test(priority = 6, description = "Partial update user - Verify PATCH request")
    public void testPatchUser() {
        String requestBody = "{\n" +
                "    \"job\": \"Lead SDET Engineer\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

           // .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .patch("/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Lead SDET Engineer"));
    }

    @Test(priority = 7, description = "Delete user - Verify 204 status")
    public void testDeleteUser() {
        given()
        .spec(requestSpec)  // 👈 添加

        .when()
            .delete("/users/2")
        .then()
            .statusCode(204);
    }

    @Test(priority = 8, description = "Verify response time is acceptable")
    public void testResponseTime() {
        Response response = given()
                .spec(requestSpec)  // 👈 添加

        .when()
            .get("/users?page=1");

        long responseTime = response.getTime();
        System.out.println("Response time: " + responseTime + "ms");
        
        Assert.assertTrue(responseTime < 2000, 
            "API response time should be under 2 seconds");
    }
}