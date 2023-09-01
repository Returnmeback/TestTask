package API;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStoreTest {
    private final static String URL = "https://petstore.swagger.io/v2";
    @Test
    public void createUser () {
        Specifications.installSpecification(Specifications.requestSpecification(URL),Specifications.responseSpecOK200());
        Integer code = 200;
        String type = "unknown";
        String message = "ok";
        UserData user = new UserData(1, "Dimonchik", "Dima", "Pidr", "idiot@mail.com","idiot","891764343",2);
        UserIsCreated userIsCreated = given()
                .body(user)
                .when()
                .post("/user/createWithList")
                .then().log().all()
                .extract().as(UserIsCreated.class);
    }
    @Test
    public void getUserByUserName () {
        Specifications.installSpecification(Specifications.requestSpecification(URL),Specifications.responseSpecOK200());
        List<UserData> users = given().
                when()
                .get("/user/Dimonchik")
                .then().log().all()
                .extract().body().jsonPath().getList("User", UserData.class);
    }
    @Test
    public void deleteUser () {
        Specifications.installSpecification(Specifications.requestSpecification(URL),Specifications.responseSpecError404());
        List<UserData> users = given().
                when()
                .delete("/user/Dimonchik")
                .then().log().all()
                .extract().body().jsonPath().get();
    }
}
