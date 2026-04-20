package com.sashathe.api.tests;

import com.sashathe.api.base.BaseApiTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TodoApiTest extends BaseApiTest {

    @Test
    public void shouldGetTodoById() {
        Response response = given()
                .when()
                .get("/todos/1");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body:");
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("delectus aut autem"))
                .body("completed", equalTo(false));
    }

    @Test
    public void shouldCreateNewTodo() {
        String requestBody = """
                {
                  "title": "Learn API testing",
                  "completed": false,
                  "userId": 99
                }
                """;

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/todos")
                .then()
                .statusCode(201)
                .body("title", equalTo("Learn API testing"))
                .body("completed", equalTo(false))
                .body("userId", equalTo(99));
    }

    @Test
    public void shouldReturn404ForUnknownEndpoint() {
        given()
                .when()
                .get("/unknown-endpoint")
                .then()
                .statusCode(404);
    }

    @Test
    public void shouldUpdateTodo() {
        String requestBody = """
            {
              "id": 1,
              "title": "Updated title",
              "completed": true,
              "userId": 1
            }
            """;

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/todos/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated title"))
                .body("completed", equalTo(true));
    }

    @Test
    public void shouldDeleteTodo() {
        given()
                .when()
                .delete("/todos/1")
                .then()
                .statusCode(200);
    }

}
