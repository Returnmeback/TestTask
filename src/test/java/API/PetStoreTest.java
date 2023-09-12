package API;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import sberleasing.api.dto.UserDto;

import java.util.List;

import static io.restassured.RestAssured.given;
import static sberleasing.api.spec.Specifications.installSpecification;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetStoreTest {


    private final String userName = "Dimonchik777";

    @Test
    @Order(1)
    public void createUser() {
        installSpecification(200);
        List<UserDto> user = List.of(new UserDto(0L, userName, "Dima", "HI", "QA@mail.com", "new", "891764343", 0));
        var t = given()
                .body(user)
                .when()
                .post("/user/createWithList")
                .then().log().all()
                .extract().as(JsonNode.class);
        System.out.println(user.get(0).getUsername());
    }

    @Test
    @Order(2)
    public void getUserByUserName() {
        installSpecification(200);
        var users = given().
                when()
                .get("/user/%s".formatted(userName))
                .then().log().all()
                .extract().body().as(UserDto.class);
    }

    @Test
    @Order(3)
    public void deleteUser() {
        installSpecification(200);
        var users = given().
                when()
                .delete("/user/%s".formatted(userName))
                .then().log().all();
    }
}
