package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By mailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");

    public LoginPage(WebDriver driver) {
        super(driver, "/login");
    }

    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    public void login(String email, String password) {
        fillMailInput(email);
        fillPasswordInput(password);
        clickEnterButton();
    }

    public void clickEnterButton() {
        clickElement(enterButton);
    }

    public void clickRegisterLink() {
        clickElement(registerLink);
    }

    public void fillMailInput(String txt) {
        fillInput(mailInput, txt);
    }

    public void fillPasswordInput(String txt) {
        fillInput(passwordInput, txt);
    }

}
