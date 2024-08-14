import api.model.RegisterUserResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

public class FollowToConstructorTests extends BaseUITest{

    @Test
    @DisplayName("follow to constructor page from user profile page using 'Конструктор' button")
    public void goToConstructorFromUserProfilePageUsingConstructorButton(){
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
        userProfilePage.clickConstructorButton();

        //
        mainPage.waitForLoadMakeOrderButton();
    }

    @Test
    @DisplayName("follow to constructor page from user profile page using logo click")
    public void goToConstructorFromUserProfilePageUsingLogo(){
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
        userProfilePage.clickLogo();

        //
        mainPage.waitForLoadMakeOrderButton();
    }
}
