import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver WebDriver(Browser type)
    {
        WebDriver driver = null;
        switch (type)
        {
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
                driver = new ChromeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;

        }
        return driver;
    }
}
