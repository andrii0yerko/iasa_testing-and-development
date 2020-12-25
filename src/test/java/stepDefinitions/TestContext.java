package stepDefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
