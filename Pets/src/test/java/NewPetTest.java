import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NewPetTest {
    @Test
    public void pet() {
        String body = "{\"name\": \"doggie\", \"photoUrls\": [ \"string\" ]}";
        given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);
    }

    @Test
    public void newPetTest(){
        Pet pet = new Pet("Bob");
        PetController petController = new PetController();
        petController.addNewPet(pet);
    }

    @Test
    public void newPetTest2(){
        Assertions.assertFalse(
                (new PetController()
                        .addNewPet(
                                new Pet("Рыжий")))
                        .jsonPath()
                        .get("id")
                        .toString()
                        .isEmpty());
    }
}
