package sberleasing.api.steps;

import com.fasterxml.jackson.databind.JsonNode;
import io.qameta.allure.Step;
import sberleasing.api.dto.UserDto;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiSteps {
    private final String userName = "User78263156";

    @Step("Создаем нового юзера")
    public void createNewUser() {
        var user = List.of(new UserDto(0L, userName, "Dima", "HI", "QA@mail.com", "new", "891764343", 0));
        given()
                .body(user)
                .when()
                .post("/user/createWithList")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().as(JsonNode.class);
    }

    @Step ("Изменяем данные юзера по username")
    public UserDto updateUserDataByUsername () {
        var updatedUserData = List.of(new UserDto(0L, userName, "Amid", "HI", "QA@mail.com", "new", "891764343", 0));
        return given().
                body(updatedUserData)
                .when()
                .put("/user/%s".formatted(userName))
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(UserDto.class);

    }



    @Step("Получаем юзера по username")
    public UserDto getCreatingNewUserByUsername() {
        return given().
                when()
                .get("/user/%s".formatted(userName))
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .as(UserDto.class);
    }

    @Step("Проверяем, что юзер создан")
    public void checkCreatingNewUser(UserDto user) {
        assertThat(user.getUsername())
                .as("Юзер по userName не найден!")
                .isNotEmpty();
    }

    @Step("Удаляем юзера")
    public void deletingUser() {
        given().
                when()
                .delete("/user/%s".formatted(userName))
                .then()
                .log()
                .all().statusCode(200);
    }

    @Step("Проверяем, что юзер удален")
    public void checkDeleteNewUser() {
        given().
                when()
                .get("/user/%s".formatted(userName))
                .then()
                .log()
                .all()
                .statusCode(404);
    }
}


