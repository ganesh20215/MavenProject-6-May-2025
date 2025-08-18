package apiautomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAPI {

    //Response : Interface which validates status code, body, header, token.
    //RequestSpecification : Represents the request configuration [headers, param, body, cookies]
    //RestAssured : This is a class which contain static method(given(), when(), then())
    
    @Test(description = "Verify Get Http request")
    public void verifyGetAPI() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .log()
                .all()
                .get("/2")
                .then()
                .log()
                .all()
                .extract()
                .response();
        response.then().statusCode(HttpStatus.SC_OK)
                .body("data.id", Matchers.equalTo(2),
                        "data.first_name", Matchers.equalTo("Janet"),
                        "data.last_name", Matchers.equalTo("Weaver"));

    }


    @Test(description = "Verify Post Http request with valid data")
    public void verifyPostAPIWithValidData() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        JSONObject jsonData = new JSONObject();
        jsonData.put("firstName", "Vaishanavi");
        jsonData.put("lastName", "Fatate");
        jsonData.put("job", "Automation Engineer");
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(jsonData.toJSONString())
                .when()
                .log()
                .all()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();
        response.then().statusCode(HttpStatus.SC_CREATED)
                .body("firstName", Matchers.equalTo("Vaishanavi"),
                        "lastName", Matchers.equalTo("Fatate"),
                        "job", Matchers.equalTo("Automation Engineer"));
    }

    @Test(description = "Verify Put Http request with valid data")
    public void verifyPutAPIWithValidData() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        JSONObject jsonData = new JSONObject();
        jsonData.put("firstName", "Vaishanavi");
        jsonData.put("lastName", "Fatate");
        jsonData.put("job", "Automation Engineer");
        jsonData.put("mobile", "8857953527");
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .body(jsonData.toJSONString())
                .when()
                .log()
                .all()
                .put()
                .then()
                .log()
                .all()
                .extract()
                .response();
        response.then().statusCode(HttpStatus.SC_OK)
                .body("firstName", Matchers.equalTo("Vaishanavi"),
                        "lastName", Matchers.equalTo("Fatate"),
                        "job", Matchers.equalTo("Automation Engineer"),
                        "mobile", Matchers.equalTo("8857953527"));
    }

    @Test(description = "Verify delete Http request with valid data")
    public void verifyDeleteAPIWithValidData() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1")
                .when()
                .log()
                .all()
                .delete()
                .then()
                .log()
                .all()
                .extract()
                .response();
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
