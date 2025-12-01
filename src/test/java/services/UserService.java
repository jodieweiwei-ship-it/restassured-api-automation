package services;

import config.ApiConfig;
import io.restassured.response.Response;
import models.User;
import specifications.RequestSpecs;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * User Service
 * Wraps all user-related API endpoints
 */
public class UserService {

    /**
     * Get users with pagination
     */
    public static Response getUsers(int page) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .queryParam("page", page)
                .when()
                .get(ApiConfig.USERS_ENDPOINT);
    }

    /**
     * Get a single user by ID
     */
    public static Response getUserById(int userId) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .when()
                .get(ApiConfig.USERS_ENDPOINT + "/" + userId);
    }

    /**
     * Create a new user
     */
    public static Response createUser(User user) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(user)
                .when()
                .post(ApiConfig.USERS_ENDPOINT);
    }

    /**
     * Create a user with name and job
     */
    public static Response createUser(String name, String job) {
        User user = new User(name, job);
        return createUser(user);
    }

    /**
     * Update a user (PUT - full update)
     */
    public static Response updateUser(int userId, String name, String job) {
        User user = new User(name, job);
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(user)
                .when()
                .put(ApiConfig.USERS_ENDPOINT + "/" + userId);
    }

    /**
     * Partially update a user (PATCH - partial update)
     */
    public static Response patchUser(int userId, Map<String, String> updates) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .body(updates)
                .when()
                .patch(ApiConfig.USERS_ENDPOINT + "/" + userId);
    }

    /**
     * Delete a user
     */
    public static Response deleteUser(int userId) {
        return given()
                .spec(RequestSpecs.getBaseSpec())
                .when()
                .delete(ApiConfig.USERS_ENDPOINT + "/" + userId);
    }
}
