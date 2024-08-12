package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clickTabByValue(String text){
        //в приложении есть косяк: при клике на пункт меню конструктора "Булки"
        // клик получает не отдельный таб, а весь таббар, поэтому код немного костыльный
        // на работоспособности не отражается, но тестировать менее удобно
        String xpath;
        if ("Булки".equals(text)){
            xpath = String.format(".//span[text()='%s']/parent::div/parent::div",text);
        } else {
            xpath = String.format(".//span[text()='%s']/parent::*", text);
        }
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void waitConstructorTopicVisibleByValue(String text){
        By elementLocator = By.xpath(String.format(".//h2[text()='%s']", text));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}
