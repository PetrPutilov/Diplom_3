import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class BaseUITest extends BaseApiTest {
    private Browser browser;
    protected WebDriver driver;

    public BaseUITest(Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Object[][] addParametersList() {
        return new Object[][]{
                {Browser.YANDEX},
                {Browser.CHROME},
        };
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
