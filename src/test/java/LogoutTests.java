import api.model.RegisterUserResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

public class LogoutTests extends BaseUITest{

    public LogoutTests(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("logout test")
    public void logOutTest(){
        Response registerUserResponse = registerUser(registerUserRequest);
        setAccessToken(registerUserResponse.getBody().as(RegisterUserResponse.class).getAccessToken());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        loginPage.waitForLoadLoginPage();
        loginPage.login(registerUserRequest.getEmail(), registerUserRequest.getPassword());

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMakeOrderButton();
        mainPage.clickEnterUserProfileButton();

        UserProfilePage userProfilePage = new UserProfilePage(driver);
        userProfilePage.waitForLoadUserProfilePage();
        userProfilePage.clickLogout();

        //проверяем, что перешли на страницу логина
        loginPage.waitForLoadLoginPage();
    }

}
