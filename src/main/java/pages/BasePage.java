package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    private final String baseUrl = "https://stellarburgers.nomoreparties.site";
    protected String currentPageUrl;
    protected final WebDriver driver;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        currentPageUrl = baseUrl + url;
    }

    public void getPage(){
        driver.get(currentPageUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    protected void clickElement(By locator){
        driver.findElement(locator).click();
    }

    protected void fillInput(By locator, String txt) {
        WebElement passwordInputElement = driver.findElement(locator);
        passwordInputElement.clear();
        passwordInputElement.sendKeys(txt);
    }

}
