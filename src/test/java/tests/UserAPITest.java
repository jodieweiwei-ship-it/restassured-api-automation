package tests;

import base.BaseTest;
import config.TestConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;
import utils.ResponseValidator;
import utils.TestDataGenerator;

import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * User API Test Class
 * Tests for user CRUD operations
 */
public class UserAPITest extends BaseTest {

        @Test(priority = 1, description = "Get users list - Verify status code 200")
        public void testGetUsers() {
                Response response = UserService.getUsers(TestConfig.DEFAULT_PAGE)
                                .then()
                                .statusCode(200)
                                .body("page", equalTo(TestConfig.DEFAULT_PAGE))
                                .body("data", not(empty()))
                                .extract().response();

                ResponseValidator.printResponse(response);
                ResponseValidator.validateResponseTime(response, TestConfig.MAX_RESPONSE_TIME);
        }

        @Test(priority = 2, description = "Get single user - Verify user details")
        public void testGetSingleUser() {
                Response response = UserService.getUserById(TestConfig.EXISTING_USER_ID)
                                .then()
                                .statusCode(200)
                                .body("data.id", equalTo(TestConfig.EXISTING_USER_ID))
                                .body("data.email", notNullValue())
                                .body("data.first_name", notNullValue())
                                .body("data.last_name", notNullValue())
                                .extract().response();

                ResponseValidator.printResponse(response);

                String email = ResponseValidator.extractJsonPath(response, "data.email");
                ResponseValidator.validateEmail(email);
        }

        @Test(priority = 3, description = "Get non-existent user - Verify 404")
        public void testGetUserNotFound() {
                UserService.getUserById(TestConfig.NON_EXISTENT_USER_ID)
                                .then()
                                .statusCode(404);
        }

        @Test(priority = 4, description = "Create new user - Verify 201 status")
        public void testCreateUser() {
                Response response = UserService.createUser(TestConfig.TEST_USER_NAME, TestConfig.TEST_USER_JOB)
                                .then()
                                .statusCode(201)
                                .body("name", equalTo(TestConfig.TEST_USER_NAME))
                                .body("job", equalTo(TestConfig.TEST_USER_JOB))
                                .body("id", notNullValue())
                                .body("createdAt", notNullValue())
                                .extract().response();

                ResponseValidator.printResponse(response);

                String createdId = ResponseValidator.extractJsonPath(response, "id");
                ResponseValidator.validateNotNull(createdId, "Created user ID");
        }

        @Test(priority = 5, description = "Update user - Verify PUT request")
        public void testUpdateUser() {
                Response response = UserService.updateUser(
                                TestConfig.EXISTING_USER_ID,
                                TestConfig.UPDATED_USER_NAME,
                                TestConfig.UPDATED_USER_JOB)
                                .then()
                                .statusCode(200)
                                .body("name", equalTo(TestConfig.UPDATED_USER_NAME))
                                .body("job", equalTo(TestConfig.UPDATED_USER_JOB))
                                .body("updatedAt", notNullValue())
                                .extract().response();

                ResponseValidator.printResponse(response);

                Assert.assertEquals(
                                ResponseValidator.extractJsonPath(response, "name"),
                                TestConfig.UPDATED_USER_NAME);
        }

        @Test(priority = 6, description = "Partial update user - Verify PATCH request")
        public void testPatchUser() {
                Map<String, String> updates = TestDataGenerator.generatePartialUpdate(TestConfig.PATCHED_USER_JOB);

                Response response = UserService.patchUser(TestConfig.EXISTING_USER_ID, updates)
                                .then()
                                .statusCode(200)
                                .body("job", equalTo(TestConfig.PATCHED_USER_JOB))
                                .body("updatedAt", notNullValue())
                                .extract().response();

                ResponseValidator.printResponse(response);
        }

        @Test(priority = 7, description = "Delete user - Verify 204 status")
        public void testDeleteUser() {
                UserService.deleteUser(TestConfig.EXISTING_USER_ID)
                                .then()
                                .statusCode(204);
        }
}