package io.quarkus.ts.openshift.deployment.strategies.quarkus.serverless;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class HelloTest {
    @Test
    public void hello() {
        when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body("content", is("Hello, World!"));
    }

    @Test
    public void parameterizedHello() {
        given()
                .when()
                .queryParam("name", "Isaac")
                .get("/hello")
                .then()
                .statusCode(200)
                .body("content", is("Hello, Isaac!"));
    }
}
