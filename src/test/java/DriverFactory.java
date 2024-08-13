import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    public static WebDriver WebDriver(Browser type)
    {
        WebDriver driver = null;
        switch (type)
        {
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;

        }
        return driver;
    }
}
