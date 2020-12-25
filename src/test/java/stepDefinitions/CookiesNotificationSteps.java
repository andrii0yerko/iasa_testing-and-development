package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.CookiesDisclaimer;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * implements Rule: Cookies Notification
 */
public class CookiesNotificationSteps{

    TestContext context;
    WebDriver driver;
    MainPage mainPage;
    CookiesDisclaimer cookies;


    public CookiesNotificationSteps(TestContext testContext) {
        context = testContext;
        driver = context.getDriver();
    }

    // Scenario: Notify the user about cookies
    @Given("user opens site for the first time")
    public void userOpensSiteForTheFirstTime() {
        // I think I should reload driver here
        driver.get(MainPage.URL);
    }

    @When("page is loaded")
    public void pageIsLoaded() {
        mainPage = new MainPage(driver);
        cookies = new CookiesDisclaimer(driver);
    }

    @Then("notification about cookies should be displayed")
    public void notificationAboutCookiesShouldBeDisplayed() {
        assertTrue(cookies.isCookiesDisclaimerVisible());
    }

    // Scenario: User accepts cookies
    @Given("notification about cookies is visible")
    public void notificationAboutCookiesIsVisible() {
        driver.get(MainPage.URL);
        mainPage = new MainPage(driver);
        cookies = new CookiesDisclaimer(driver);
        assertTrue(cookies.isCookiesDisclaimerVisible());
    }

    @When("I click Accept")
    public void iClickAccept() {
        cookies.acceptCookies();
    }

    @Then("notification should disappear")
    public void notificationShouldDisappear() {
        assertFalse(cookies.isCookiesDisclaimerVisible());
    }
}