import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetController {
    //метод для создания нового питомца
    public Response addNewPet(Pet pet) {

        Specification.installSpecification(
                Specification.requestSpec(Constanta.BASE_URL),
                Specification.responseSpec(200));

        return given()
                .body(pet)
                .post("/pet")
                .then()
                .log().all()
                .extract().response();
    }
}
