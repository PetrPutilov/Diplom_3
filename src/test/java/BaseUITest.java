import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseUITest extends BaseApiTest {
    private final Browser browser;
    protected WebDriver driver;

    public BaseUITest() {
        this.browser = Browser.valueOf(System.getProperty("browser", "chrome").toUpperCase());
    }

    @Before
    public void setUp() {
        driver = DriverFactory.WebDriver(browser);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
