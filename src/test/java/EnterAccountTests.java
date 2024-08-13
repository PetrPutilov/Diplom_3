import api.model.RegisterUserResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import pages.RestorePasswordPage;

public class EnterAccountTests extends BaseUITest {

    public EnterAccountTests(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("enter account using 'Войти в аккаунт' button on main page")
    public void enterAccountFromMainPage() {
        Response registerUserResponse = registerUser(registerUserRequest);
        setAccessToken(registerUserResponse.getBody().as(RegisterUserResponse.class).getAccessToken());

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();

        loginPage.login(registerUserRequest.getEmail(), registerUserRequest.getPassword());

        //проверяем, что осуществился переход на главную и появилась кнопка "Оформить заказ"
        mainPage.waitForLoadMakeOrderButton();
    }

    @Test
    @DisplayName("enter account using 'Личный кабинет' button on main page")
    public void enterAccountFromUserProfile() {
        Response registerUserResponse = registerUser(registerUserRequest);
        setAccessToken(registerUserResponse.getBody().as(RegisterUserResponse.class).getAccessToken());

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickEnterUserProfileButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();

        loginPage.login(registerUserRequest.getEmail(), registerUserRequest.getPassword());

        //проверяем, что осуществился переход на главную и появилась кнопка "Оформить заказ"
        mainPage.waitForLoadMakeOrderButton();
    }

    @Test
    @DisplayName("enter account using register page")
    public void enterAccountFromRegisterPage() {
        Response registerUserResponse = registerUser(registerUserRequest);
        setAccessToken(registerUserResponse.getBody().as(RegisterUserResponse.class).getAccessToken());

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getPage();
        registerPage.waitForLoadRegisterPage();
        registerPage.clickEnterAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();

        loginPage.login(registerUserRequest.getEmail(), registerUserRequest.getPassword());

        //проверяем, что осуществился переход на главную и появилась кнопка "Оформить заказ"
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMakeOrderButton();
    }

    @Test
    @DisplayName("enter account using restore password page")
    public void enterAccountFromRestorePasswordPage() {
        Response registerUserResponse = registerUser(registerUserRequest);
        setAccessToken(registerUserResponse.getBody().as(RegisterUserResponse.class).getAccessToken());

        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.getPage();
        restorePasswordPage.waitForLoadRestorePasswordPage();
        restorePasswordPage.clickEnterAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();

        loginPage.login(registerUserRequest.getEmail(), registerUserRequest.getPassword());

        //проверяем, что осуществился переход на главную и появилась кнопка "Оформить заказ"
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMakeOrderButton();
    }
}
