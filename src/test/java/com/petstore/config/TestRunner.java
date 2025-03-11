package com.petstore.config;

import org.testng.TestNG;

import java.util.Collections;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Collections.singletonList("src/test/resources/testing.xml"));
        testNG.run();
    }
}
