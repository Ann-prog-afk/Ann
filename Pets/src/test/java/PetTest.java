import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PetTest {
    @Test
    public void findByStatus() {
        given().param("status", "available").when().get("https://petstore.swagger.io/v2/pet/findByStatus").then().statusCode(200);
    }

    @Test
    public void petId() {
        given().param("petId", 2).when().get("https://petstore.swagger.io/v2/pet/2").then().statusCode(200);
    }

    @Test
    public void orderId() {
        given().param("orderId", 3).when().get("https://petstore.swagger.io/v2/store/order/3").then().statusCode(200);
    }

    @Test
    public void inventory() {
        given().when().get("https://petstore.swagger.io/v2/store/inventory").then().statusCode(200);
    }

    @Test
    public void username() {
        given().param("username", "Murzik").when().get("https://petstore.swagger.io/v2/user/Murzik").then().statusCode(404);
    }

    @Test
    public void login() {
        given().param("username", "password").when().get("https://petstore.swagger.io/v2/user/login?username=A&password=123").then().statusCode(200);
    }

    @Test
    public void logout() {
        given().when().get("https://petstore.swagger.io/v2/user/logout").then().statusCode(200);
    }

    @Test
    public void pet() {
        String body = "{\"name\": \"doggie\", \"photoUrls\": [ \"string\" ]}";
        given().header("Content-Type", "application/json").body(body).when().post("https://petstore.swagger.io/v2/pet").then().statusCode(200);
    }

    @Test
    public void order() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2023-12-12T08:31:21.618Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().post("https://petstore.swagger.io/v2/store/order").then().statusCode(200);
    }

    @Test
    public void createWithArray() {
        String body = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"string\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        given().header("Content-Type", "application/json").body(body).when().post("https://petstore.swagger.io/v2/user/createWithArray").then().statusCode(200);
    }

    @Test
    public void createWithList() {
        String body = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"string\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user/createWithList").then().statusCode(200);
    }

    @Test
    public void user() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user").then().statusCode(200);
    }

    @Test
    public void updatePet() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/pet").then().statusCode(200);
    }

    @Test
    public void updateUser() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user/666").then().statusCode(200);
    }

    @Test
    public void deletePet() {
        given().header("accept", "application/json").when().body("https://petstore.swagger.io/v2/pet/666").then().statusCode(404);
    }

    @Test
    public void deletePurchase() {
        given().header("accept", "application/json").when().body("https://petstore.swagger.io/v2/store/order/666").then().statusCode(404);
    }

    @Test
    public void uploadImage() {
        String body = "{\n" +
                "  \"code\": 0,\n" +
                "  \"type\": \"string\",\n" +
                "  \"message\": \"string\"\n" +
                "}";
        given().header("Content-Type", "multipart/form-data").param("petId", 555).when().body("https://petstore.swagger.io/v2/pet/555/uploadImage").then().statusCode(415);
    }

    @Test
    public void updatePetStore() {
        String body = "{\n" +
                "  \"code\": 0,\n" +
                "  \"type\": \"string\",\n" +
                "  \"message\": \"string\"\n" +
                "}";
        given().header("accept", "application/json").param("petId", 666).when().body("https://petstore.swagger.io/v2/pet/666").then().statusCode(404);
    }

    @Test
    public void uploadImageImage() {
        String body = "{\n" +
                "  \"code\": 0,\n" +
                "  \"type\": \"string\",\n" +
                "  \"message\": \"\"\n" +
                "}";
        given().header("Content-Type", "multipart/form-data").param("petId", 555).when().body("https://petstore.swagger.io/v2/pet/555/uploadImage").then().statusCode(404);
    }
    @Test
    public void orderOrder() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2023-12-12T08:31:21.618Z\",\n" +
                "  \"status\": \"\",\n" +
                "  \"complete\": true\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().post("https://petstore.swagger.io/v2/store/order").then().statusCode(200);
    }
    @Test
    public void createWithArrayArray() {
        String body = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        given().header("Content-Type", "application/json").body(body).when().post("https://petstore.swagger.io/v2/user/createWithArray").then().statusCode(200);
    }
    @Test
    public void createWithListList() {
        String body = "[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"\",\n" +
                "    \"firstName\": \"string\",\n" +
                "    \"lastName\": \"string\",\n" +
                "    \"email\": \"string\",\n" +
                "    \"password\": \"string\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user/createWithList").then().statusCode(200);
    }
    @Test
    public void userUser() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user").then().statusCode(200);
    }
    @Test
    public void updatePetPet() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/pet").then().statusCode(200);
    }
    @Test
    public void updateUserUser() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        given().header("Content-Type", "application/json").body(body).when().body("https://petstore.swagger.io/v2/user/666").then().statusCode(200);
    }

}
