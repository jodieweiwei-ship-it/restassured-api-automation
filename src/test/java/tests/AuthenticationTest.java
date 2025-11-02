package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthenticationTest extends BaseTest {

    @Test(priority = 1, description = "Successful registration")
    public void testSuccessfulRegistration() {
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

          //  .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/register")
        .then()
            .statusCode(200)
            .body("id", notNullValue())
            .body("token", notNullValue());
    }

    @Test(priority = 2, description = "Registration without password - Verify 400")
    public void testRegistrationMissingPassword() {
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

            //.contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/register")
        .then()
            .statusCode(400)
            .body("error", containsString("password"));
    }

    @Test(priority = 3, description = "Successful login")
    public void testSuccessfulLogin() {
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue());
    }

    @Test(priority = 4, description = "Login with invalid credentials")
    public void testLoginInvalidCredentials() {
        String requestBody = "{\n" +
                "    \"email\": \"invalid@test.com\",\n" +
                "    \"password\": \"wrongpassword\"\n" +
                "}";

        given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", notNullValue());
    }
}