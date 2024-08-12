package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePasswordPage extends BasePage {

    private final By restoreButton = By.xpath(".//button[text()='Восстановить']");
    private final By enterAccountLink = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        super(driver, "/forgot-password");
    }

    public void waitForLoadRestorePasswordPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(restoreButton));
    }

    public void clickEnterAccount() {
        clickElement(enterAccountLink);
    }

}
