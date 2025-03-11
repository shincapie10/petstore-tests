package com.petstore.tests;

import com.petstore.model.UserDTO;
import com.petstore.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class CreateUserTest {

    @Test(testName = "Create a new User")
    public void createUser() {
        UserDTO user = UserDTO.builder()
                .id(1001)
                .username("myUser")
                .firstName("My")
                .lastName("User")
                .email("myuser@example.com")
                .password("pass123")
                .phone("123456789")
                .userStatus(1)
                .build();

        Response response = RequestBuilder.getRequestSpec()
                .body(user)
                .post("/user");
        response.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("1001")); // Normalmente la API retorna el ID como mensaje
    }
}