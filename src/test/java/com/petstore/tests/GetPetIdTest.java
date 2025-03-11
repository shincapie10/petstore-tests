package com.petstore.tests;


import com.petstore.model.PetDTO;
import com.petstore.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetPetIdTest {

    @Test(testName = "Get data for a specific Pet")
    public void getSpecificPet() {
        PetDTO pet = PetDTO.builder()
                .id(5001)
                .name("testPet")
                .status("available")
                .build();

        RequestBuilder.getRequestSpec()
                .body(pet)
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(5001));

        Response getPetResponse = RequestBuilder.getRequestSpec()
                .get("/pet/5001");

        getPetResponse.then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("id", equalTo(5001))
                .body("name", equalTo("testPet"));
    }
}
