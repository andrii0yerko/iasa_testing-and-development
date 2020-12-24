package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;

/**
 * Abstract class that implements common behavior for all tests -
 * WebDriver launching and closing, and contains basic Pages variables
 */
public abstract class AbstractTest {

    public static WebDriver driver;
    public static MainPage mainPage;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.epam.com/");
        mainPage = new MainPage(driver);
    }

    @AfterAll
    public static void closeBrowser() {
//        driver.quit();
    }
}