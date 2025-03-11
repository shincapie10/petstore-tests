package com.petstore.tests;


import com.petstore.model.UserDTO;
import com.petstore.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

/**
 * Test para login de usuario, creando antes un usuario.
 */
public class LoginUserTest {

    @Test(testName = "Login with a newly created User")
    public void loginUser() {
        // 1. Crear usuario para garantizar que exista
        UserDTO user = UserDTO.builder()
                .id(1002)
                .username("loginUser")
                .firstName("Login")
                .lastName("User")
                .email("loginuser@example.com")
                .password("loginpass")
                .phone("123456789")
                .userStatus(1)
                .build();

        RequestBuilder.getRequestSpec()
                .body(user)
                .post("/user")
                .then()
                .statusCode(200)
                .body("message", equalTo("1002"));

        Response loginResponse = RequestBuilder.getRequestSpec()
                .queryParam("username", "loginUser")
                .queryParam("password", "loginPass")
                .get("/user/login");

        loginResponse.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", containsString("logged in user session"));
    }
}
