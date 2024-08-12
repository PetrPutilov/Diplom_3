package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage extends BasePage {

    private final By nameInput = By.xpath(".//input[@name='Name']");
    private final By constructorButton = By.xpath(".//a/p[text()='Конструктор']");
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    public UserProfilePage(WebDriver driver) {
        super(driver, "/account/profile");
    }

    public void waitForLoadUserProfilePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
    }

    public void clickConstructorButton(){
        clickElement(constructorButton);
    }

    public void clickLogo(){
        clickElement(logo);
    }

}
