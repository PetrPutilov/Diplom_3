import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

@RunWith(Parameterized.class)
public class ConstructorTopicsTests extends BaseUITest {
    private final String value;

    public ConstructorTopicsTests(String value, Browser browser) {
        super(browser);
        this.value = value;
    }

    @Parameterized.Parameters
    public static Object[][] addParametersList() {
        return new Object[][]{
                {"Начинки", Browser.CHROME},
                {"Соусы", Browser.CHROME},
                {"Булки", Browser.CHROME},
                {"Начинки", Browser.YANDEX},
                {"Соусы", Browser.YANDEX},
                {"Булки", Browser.YANDEX}
        };
    }

    @Test
    @DisplayName("follow constructor topics")
    public void followConstructorTopics() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickTabByValue(value);
        mainPage.waitConstructorTopicVisibleByValue(value);
    }
}
