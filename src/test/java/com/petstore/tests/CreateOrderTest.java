package com.petstore.tests;

import com.petstore.model.OrderDTO;
import com.petstore.request.RequestBuilder;
import com.petstore.model.PetDTO;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateOrderTest {

    @Test(testName = "Create a purchase order for a Pet")
    public void createOrderForPet() {
        PetDTO pet = PetDTO.builder()
                .id(6001)
                .name("orderPet")
                .status("available")
                .build();
        RequestBuilder.getRequestSpec()
                .body(pet)
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo(6001));

        OrderDTO order = OrderDTO.builder()
                .id(9001)
                .petId(6001)
                .quantity(2)
                .shipDate("2025-03-10T12:00:00.000Z")
                .status("placed")
                .complete(true)
                .build();

        RequestBuilder.getRequestSpec()
                .body(order)
                .post("/store/order")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("id", equalTo(9001))
                .body("petId", equalTo(6001));
    }
}
