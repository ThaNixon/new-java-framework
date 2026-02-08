import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommandConstants.BASE_URI;
import static io.restassured.RestAssured.given;
import static testdata.TestData.DEFAULT_USER;


public class SmokeApiTest {
    @Test
    void testSmokeApi() {
        Response response = given()
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .baseUri(BASE_URI)
                .when()
                    .body(DEFAULT_USER)
                    .post("user")
                .andReturn();

        int actualCode = response.getStatusCode();

        System.out.println("Тело ответа: " + response.getBody().asString());
        Assertions.assertEquals(200, actualCode, "Ожидался код 200, но получен:" + actualCode);
        System.out.println("Статус код:" + actualCode);
    }
}
