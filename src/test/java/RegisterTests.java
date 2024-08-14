import api.model.LoginUserRequest;
import api.model.LoginUserResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.hamcrest.Matchers.equalTo;

public class RegisterTests extends BaseUITest {

    @Test
    @DisplayName("successful registration test")
    public void registerUserTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForLoadRegisterPage();
        registerPage.fillNameInput(registerUserRequest.getName());
        registerPage.fillMailInput(registerUserRequest.getEmail());
        registerPage.fillPasswordInput(registerUserRequest.getPassword());

        registerPage.clickRegisterButton();

        //рповеряем, что загрузилась страница входа в аккаунт
        loginPage.waitForLoadLoginPage();

        //проверяем, что регистрация прошла успешно
        Response loginUserResponse = loginUser(new LoginUserRequest(registerUserRequest.getEmail(), registerUserRequest.getPassword()));
        loginUserResponse.then().statusCode(200)
                .and().assertThat().body("success", equalTo(true));

        //сетим accesToken, чтобы зарегистрированный пользователь удалился по окончанию теста
        setAccessToken(loginUserResponse.getBody().as(LoginUserResponse.class).getAccessToken());

    }

    @Test
    @DisplayName("incorrect password during registration test")
    public void incorrectPasswordTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForLoadRegisterPage();
        registerPage.fillNameInput(registerUserRequest.getName());
        registerPage.fillMailInput(registerUserRequest.getEmail());
        registerPage.fillPasswordInput("12345");

        registerPage.clickRegisterButton();

        //проверяем появилось ли сообщение о некорректном пароле
        registerPage.waitForIncorrectPasswordMessageAppear();
    }
}
