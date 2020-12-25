package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ContactPage;
import pageObjects.Header;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderBehaviorSteps {
    TestContext context;
    WebDriver driver;
    Header header;

    public HeaderBehaviorSteps(TestContext testContext) {
        context = testContext;
        driver = context.getDriver();
    }

    @Given("I am on the Contact Us page")
    public void IAmOnTheContactUsPage() {
        driver.get(ContactPage.URL);
        header = new Header(driver);
    }

    @When("I click on logo")
    public void iClickOnLogo() {
        header.clickOnLogo();
    }

    @Then("I should be redirected to the {}")
    public void iShouldBeRedirectedToThePage(String page) {
        // I think we should choose one of creating Map<"Page Name", "Page URL"> (or better enum)
        // and specifying url directly in .feature
        String expectedUrl;
        if (page.equals("Main page")) {
            expectedUrl = MainPage.URL;
        }
        else if (page.equals("Contact Us page")) {
            expectedUrl = ContactPage.URL;
        }
        else expectedUrl = page;
        // waits until page is loaded, throws exception if more than 20 seconds
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        try {
            assertEquals(expectedUrl, driver.getCurrentUrl());
        } finally {
            driver.get(MainPage.URL);
        }
    }

    @Given("I am on the Main page")
    public void iAmOnTheMainPage() {
        driver.get(MainPage.URL);
        header = new Header(driver);
    }

    @When("I click on contact us button")
    public void iClickOnContactUsButton() {
        header.clickOnContactUs();
    }

    @Given("Region panel is open")
    public void regionPanelIsOpen() {
        iAmOnTheMainPage();
        header.openRegionPanel();
    }

    @When("I click on {} location")
    public void iClickOnTheLocation(String region) {
        header.chooseLocation(region);
    }


}
