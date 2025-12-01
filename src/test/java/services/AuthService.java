package services;

import config.ApiConfig;
import io.restassured.response.Response;
import models.AuthRequest;
import specifications.RequestSpecs;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Authentication Service
 * Wraps all authentication-related API endpoints
 */
public class AuthService {

    /**
     * Register a user with email and password
     */
    public static Response register(AuthRequest authRequest) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(authRequest)
                .when()
                .post(ApiConfig.REGISTER_ENDPOINT);
    }

    /**
     * Register with missing email (password only)
     */
    public static Response registerWithMissingEmail(String password) {
        Map<String, String> body = new HashMap<>();
        body.put("password", password);

        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(body)
                .when()
                .post(ApiConfig.REGISTER_ENDPOINT);
    }

    /**
     * Register with missing password (email only)
     */
    public static Response registerWithMissingPassword(String email) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);

        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(body)
                .when()
                .post(ApiConfig.REGISTER_ENDPOINT);
    }

    /**
     * Login a user with email and password
     */
    public static Response login(AuthRequest authRequest) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(authRequest)
                .when()
                .post(ApiConfig.LOGIN_ENDPOINT);
    }

    /**
     * Login with missing password (email only)
     */
    public static Response loginWithMissingPassword(String email) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);

        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(body)
                .when()
                .post(ApiConfig.LOGIN_ENDPOINT);
    }

    /**
     * Login with missing email (password only)
     */
    public static Response loginWithMissingEmail(String password) {
        Map<String, String> body = new HashMap<>();
        body.put("password", password);

        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(body)
                .when()
                .post(ApiConfig.LOGIN_ENDPOINT);
    }
}
