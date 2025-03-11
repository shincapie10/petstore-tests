package com.petstore.tests;

import com.petstore.request.RequestBuilder;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class ListAvailablePetsTest {

    @Test(testName = "List all pets with status 'available'")
    public void listAvailablePets() {
        RequestBuilder.getRequestSpec()
                .get("/pet/findByStatus?status=available")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }
}
