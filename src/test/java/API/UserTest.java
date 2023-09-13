package API;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import sberleasing.api.extension.ApiExtension;
import sberleasing.api.steps.ApiSteps;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ApiExtension.class)
public class UserTest {
    private final ApiSteps apiSteps = new ApiSteps();


    @Test
    @Order(1)
    public void createUser() {
        apiSteps.createNewUser();
    }

    @Test
    @Order(2)
    public void updateUser() {
        apiSteps.updateUserDataByUsername();
    }


    @Test
    @Order(3)
    public void getUserByUserName() {
        var user = apiSteps.getCreatingNewUserByUsername();
        apiSteps.checkCreatingNewUser(user);
    }

    @Test
    @Order(4)
    public void deleteUser() {
        apiSteps.deletingUser();
        apiSteps.checkDeleteNewUser();
    }
}
