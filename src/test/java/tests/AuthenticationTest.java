package tests;

import base.BaseTest;
import io.restassured.response.Response;

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
            .body("token", notNullValue())
            .body("id", equalTo(4))
            .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test(priority = 2, description = "Registration without password - Verify 400")
    public void testRegistrationMissingPassword() {
        String requestBody = "{\r\n"
        		+ "    \"email\": \"sydney@fife\"\r\n"
        		+ "}";

        given()
        .spec(requestSpec)  // 👈 添加

            //.contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/register")
        .then()
            .statusCode(400)
            //.body("error", containsString("password"));
            .body("error", equalTo("Missing password"));
    }
    @Test(priority = 3, description = "Registration without email - Verify 400")
    public void testRegistrationMissingEmail() {
        String requestBody = "{\r\n"
        		+ "    \"password\": \"pistol\"\r\n"
        		+ "}";

        given()
        .spec(requestSpec)  // 👈 添加

            //.contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/register")
        .then()
            .statusCode(400)
            //.body("error", containsString("password"));
            .body("error", equalTo("Missing email or username"));
    }

    @Test(priority = 4, description = "Successful login")
    public void testSuccessfulLogin() {
        String requestBody = "{\r\n"
        		+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
        		+ "    \"password\": \"cityslicka\"\r\n"
        		+ "}";

        given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue())
            .body("token",equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test(priority = 5, description = "Login with invalid credentials: wrong password")
    public void testLoginInvalidCredentials() {
        String requestBody = "{\n" +
                "    \"email\": \"invalid@test.com\",\n" +
                "    \"password\": \"wrongpassword\"\n" +
                "}";

        Response response = given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", notNullValue())
            .body("error",equalTo("user not found"))

            .extract().response();
        printResponse(response);

    }
    @Test(priority = 6, description = "Login with invalid credentials: Missing password")
    public void testLoginMissingPassword() {
        String requestBody = "{\r\n"
        		+ "    \"email\": \"peter@klaven\"\r\n"
        		+ "}";

        Response response = given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", notNullValue())
            .body("error",equalTo("Missing password"))
            .extract().response();
        printResponse(response);

    }
    @Test(priority = 7, description = "Login with invalid credentials: Missing username")
    public void testLoginMissingUsername() {
        String requestBody = "{\r\n"
        		+ "    \"password\": \"cityslicka\"\r\n"
        		+ "}";

        Response response = given()
        .spec(requestSpec)  // 👈 添加

        //            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", notNullValue())
            .body("error",equalTo("Missing email or username"))
            .extract().response();
        printResponse(response);

    }
}