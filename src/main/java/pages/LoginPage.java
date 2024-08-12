package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By mailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void fillMailInput(String txt) {
        fillInput(mailInput, txt);
    }

    public void fillPasswordInput(String txt) {
        fillInput(passwordInput, txt);
    }

    private void fillInput(By locator, String txt) {
        WebElement passwordInputElement = driver.findElement(locator);
        passwordInputElement.clear();
        passwordInputElement.sendKeys(txt);
    }
}
