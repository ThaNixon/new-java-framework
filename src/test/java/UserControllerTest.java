import controllers.UserController;
import models.AddUserResponse;
import models.User;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserControllerTest {
    UserController userController = new UserController();

    @Test
    void createUserControllerTest() {
        User user = User.builder()
                .username("shinu_user")
                .firstName("Ray")
                .lastName("Shinu")
                .email("test@mail.com")
                .password("12345")
                .phone("123456789")
                .userStatus(0)
                .build();


        Response response = userController.createUser(user);

        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown",  createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());
    }
}