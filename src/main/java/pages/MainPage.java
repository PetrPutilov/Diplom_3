package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By userProfileButton = By.xpath(".//a/p[text()='Личный Кабинет']");

    public MainPage(WebDriver driver) {
        super(driver, "");
    }

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }

    public void waitForLoadMakeOrderButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
    }

    public void clickEnterAccountButton() {
        clickElement(enterAccountButton);
    }

    public void clickEnterUserProfileButton() {
        clickElement(userProfileButton);
    }

}
