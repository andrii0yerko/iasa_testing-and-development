
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", dryRun=true)
public class TestRunner {
///////////// from Maven report
//    Classes annotated with @RunWith(Cucumber.class) must not define any
//    Step Definition or Hook methods. Their sole purpose is to serve as
//    an entry point for JUnit. Step Definitions and Hooks should be defined
//    in their own classes. This allows them to be reused across features.
//    Offending class: class SiteTests

    public static WebDriver driver;
    public static MainPage mainPage;

    static ChromeDriver createChromeDriver() {
        // https://stackoverflow.com/questions/35867102/how-to-work-with-selenium-chrome-driver-in-maven-without-chromedriver-exe
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    @BeforeClass
    public static void setup() {
        driver = createChromeDriver();
        driver.get("https://www.epam.com/");
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

}
