import api.client.UserClient;
import api.model.LoginUserRequest;
import api.model.RegisterUserRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseApiTest {

    private final UserClient userClient = new UserClient();

    private String accessToken;

    protected RegisterUserRequest registerUserRequest;

    @BeforeClass
    public static void restAssuredSetUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @Before
    public void registerUserRequest() {
        registerUserRequest = new RegisterUserRequest("yippeekiyay@mthfckr.com", "12345678", "John McClane");
    }

    @After
    public void deleteUser() {
        deleteUser(accessToken);
    }

    @Step("register user using API")
    public Response registerUser(RegisterUserRequest request) {
        return userClient.registerUser(request);
    }

    @Step("login user using API")
    public Response loginUser(LoginUserRequest request) {
        return userClient.loginUser(request);
    }

    @Step("delete user using API")
    public Response deleteUser(String accessToken) {
        if (accessToken == null) return null;
        return userClient.deleteUser(accessToken);
    }

    protected void setAccessToken(String accessToken){
        if (accessToken == null) {
            this.accessToken = null;
            return;
        }
        if (accessToken.contains("Bearer ")){
            this.accessToken = accessToken.substring(7);
        } else {
            this.accessToken = accessToken;
        }
    }

    protected String getAccessToken() {
        return accessToken;
    }

}
