package com.petstore.request;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class RequestBuilder {

    private static String baseUrl;

    static {
        try (InputStream input = RequestBuilder.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            baseUrl = prop.getProperty("base.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json");
    }
}
