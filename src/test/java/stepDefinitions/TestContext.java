package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ContactPage;
import pageObjects.MainPage;

public class TestContext {
    private WebDriver driver;
    private MainPage mainPage;
    private ContactPage contactPage;

    public TestContext() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public MainPage getMainPage(){
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public ContactPage getContactPage(){
        return (contactPage == null) ? contactPage = new ContactPage(driver) : contactPage;
    }

}
