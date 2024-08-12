package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterAccountLink = By.xpath(".//a[text()='Войти']");
    private final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    private final By mailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By incorrectPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver, "/register");
    }

    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }

    public void waitForIncorrectPasswordMessageAppear() {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordMessage));
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
    }

    public void clickEnterAccount() {
        clickElement(enterAccountLink);
    }

    public void fillNameInput(String txt) {
        fillInput(nameInput, txt);
    }

    public void fillMailInput(String txt) {
        fillInput(mailInput, txt);
    }

    public void fillPasswordInput(String txt) {
        fillInput(passwordInput, txt);
    }
}
