package sberleasing.api.spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.SneakyThrows;

public class Specifications {
    private final static String URL = "https://petstore.swagger.io/v2";

    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static ResponseSpecification checkResponseCode(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .build();
    }


    @SneakyThrows
    public static void installSpecification(int expectedStatusCode) {
        RestAssured.requestSpecification = requestSpecification(URL);
        RestAssured.responseSpecification = checkResponseCode(expectedStatusCode);
    }
}
