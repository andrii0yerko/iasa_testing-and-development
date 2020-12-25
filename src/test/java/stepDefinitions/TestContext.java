package stepDefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Used to share "context" - web driver instance
 * between steps and __scenarios__, which is not best practice for Cucumber
 * but seems like a good idea for me.
 */
public class TestContext {
    private static boolean initialized = false;
    private static WebDriver driver;
    // https://stackoverflow.com/questions/33062485/picocontainer-for-singleton-di
    @Before
    public void initialize(){
        if (!initialized){
            initialized = true;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
