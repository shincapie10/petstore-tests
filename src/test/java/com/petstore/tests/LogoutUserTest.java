package com.petstore.tests;

import org.testng.annotations.Test;
import com.petstore.request.RequestBuilder;

import static org.hamcrest.Matchers.equalTo;

public class LogoutUserTest {

    @Test(testName = "Logout from the application")
    public void logoutUser() {
        RequestBuilder.getRequestSpec()
                .get("/user/logout")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("message", equalTo("ok"));
    }
}
