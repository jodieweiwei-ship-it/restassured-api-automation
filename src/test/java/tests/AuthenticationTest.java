package tests;

import base.BaseTest;
import config.TestConfig;
import io.restassured.response.Response;
import models.AuthRequest;
import org.testng.annotations.Test;
import services.AuthService;
import utils.ResponseValidator;

import static org.hamcrest.Matchers.*;

/**
 * Authentication Test Class
 * Tests for user registration and login endpoints
 */
public class AuthenticationTest extends BaseTest {

    @Test(priority = 1, description = "Successful registration")
    public void testSuccessfulRegistration() {
        AuthRequest authRequest = new AuthRequest(TestConfig.VALID_EMAIL, TestConfig.VALID_PASSWORD);

        AuthService.register(authRequest)
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue())
                .body("id", equalTo(TestConfig.EXPECTED_USER_ID))
                .body("token", equalTo(TestConfig.EXPECTED_TOKEN));
    }

    @Test(priority = 2, description = "Registration wrong password - Verify 400")
    public void testRegistrationWrongPassword() {
        AuthRequest authRequest = new AuthRequest(TestConfig.SYDNEY_EMAIL, "wrong password");

        AuthService.register(authRequest)
                .then()
                .statusCode(400)
                .body("error", equalTo("Bad Request"));
    }

    @Test(priority = 3, description = "Registration without password - Verify 400")
    public void testRegistrationMissingPassword() {
        AuthService.registerWithMissingPassword(TestConfig.SYDNEY_EMAIL)
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test(priority = 4, description = "Registration without email - Verify 400")
    public void testRegistrationMissingEmail() {
        AuthService.registerWithMissingEmail(TestConfig.VALID_PASSWORD)
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing email or username"));
    }

    @Test(priority = 5, description = "Successful login")
    public void testSuccessfulLogin() {
        AuthRequest authRequest = new AuthRequest(TestConfig.VALID_EMAIL, TestConfig.VALID_LOGIN_PASSWORD);

        AuthService.login(authRequest)
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("token", equalTo(TestConfig.EXPECTED_TOKEN));
    }

    @Test(priority = 6, description = "Login with invalid credentials: wrong password")
    public void testLoginInvalidCredentials() {
        AuthRequest authRequest = new AuthRequest(TestConfig.INVALID_EMAIL, TestConfig.INVALID_PASSWORD);

        Response response = AuthService.login(authRequest)
                .then()
                .statusCode(400)
                .body("error", notNullValue())
                .body("error", equalTo("user not found"))
                .extract().response();

        ResponseValidator.printResponse(response);
    }

    @Test(priority = 7, description = "Login with invalid credentials: Missing password")
    public void testLoginMissingPassword() {
        Response response = AuthService.loginWithMissingPassword(TestConfig.PETER_EMAIL)
                .then()
                .statusCode(400)
                .body("error", notNullValue())
                .body("error", equalTo("Missing password"))
                .extract().response();

        ResponseValidator.printResponse(response);
    }

    @Test(priority = 8, description = "Login with invalid credentials: Missing username")
    public void testLoginMissingUsername() {
        Response response = AuthService.loginWithMissingEmail(TestConfig.VALID_LOGIN_PASSWORD)
                .then()
                .statusCode(400)
                .body("error", notNullValue())
                .body("error", equalTo("Missing email or username"))
                .extract().response();

        ResponseValidator.printResponse(response);
    }
}