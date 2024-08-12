package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }

    public void clickEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }
}
