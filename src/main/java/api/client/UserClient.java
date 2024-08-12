package api.client;

import api.model.LoginUserRequest;
import api.model.RegisterUserRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response registerUser(RegisterUserRequest request) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(request)
                .when()
                .post("/api/auth/register");
    }

    public Response loginUser(LoginUserRequest request) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(request)
                .when()
                .post("/api/auth/login");
    }

    public Response deleteUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .auth().oauth2(accessToken)
                .when()
                .delete("/api/auth/user");
    }

}
