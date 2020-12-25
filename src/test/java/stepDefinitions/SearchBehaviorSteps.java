package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchBehaviorSteps {
    TestContext context;
    WebDriver driver;
    MainPage mainPage;

    public SearchBehaviorSteps(TestContext testContext) {
        context = testContext;
        driver = context.getDriver();
        driver.get(MainPage.URL);
        mainPage = new MainPage(driver);
    }

    // Background
    @Given("search drop-down panel is open")
    public void searchDropDownPanelIsOpen() {
        mainPage.openSearchPanel();
    }

    @Given("input is empty")
    public void inputIsEmpty() {
        mainPage.clearSearchField();
    }

    @When("cursor is placed in input field")
    public void cursorIsPlacedInInputField() {
        mainPage.placeCursorInTextField();
    }

    @Then("frequent searches menu should be displayed")
    public void frequentSearchesMenuShouldBeDisplayed() {
        assertTrue(mainPage.isFrequentSearchesDropDownVisible());
    }

    @When("I write something")
    public void iWriteSomething() {
        mainPage.writeASearchQuery("Hey there!");
    }

    @Then("frequent searches menu should disappear")
    public void frequentSearchesMenuShouldDisappear() {
        assertFalse(mainPage.isFrequentSearchesDropDownVisible());
    }

    @Given("frequent searches menu is shown")
    public void frequentSearchesMenuIsShown() {
        mainPage.clearSearchField();
        mainPage.placeCursorInTextField();
    }

    @When("I remove the cursor from the input field")
    public void iRemoveTheCursorFromTheInputField() {
        mainPage.clickOnSearchPanel();
    }
}
