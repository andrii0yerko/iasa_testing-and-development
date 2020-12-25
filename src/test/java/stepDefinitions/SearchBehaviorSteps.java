package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Header;
import pageObjects.MainPage;
import pageObjects.SearchPanel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchBehaviorSteps {
    TestContext context;
    WebDriver driver;
    SearchPanel searchPanel;

    public SearchBehaviorSteps(TestContext testContext) {
        context = testContext;
        driver = context.getDriver();
    }

    // Background
    @Given("search drop-down panel is open")
    public void searchDropDownPanelIsOpen() {
        driver.get(MainPage.URL);
        Header header = new Header(driver);
        header.openSearchPanel();
        searchPanel = new SearchPanel(driver);
    }

    @Given("input is empty")
    public void inputIsEmpty() {
        searchPanel.clearSearchField();
    }

    @When("cursor is placed in input field")
    public void cursorIsPlacedInInputField() {
        searchPanel.placeCursorInTextField();
    }

    @Then("frequent searches menu should be displayed")
    public void frequentSearchesMenuShouldBeDisplayed() {
        assertTrue(searchPanel.isFrequentSearchesDropDownVisible());
    }

    @When("I write something")
    public void iWriteSomething() {
        searchPanel.writeASearchQuery("Hey there!");
    }

    @Then("frequent searches menu should disappear")
    public void frequentSearchesMenuShouldDisappear() {
        assertFalse(searchPanel.isFrequentSearchesDropDownVisible());
    }

    @Given("frequent searches menu is shown")
    public void frequentSearchesMenuIsShown() {
        searchPanel.clearSearchField();
        searchPanel.placeCursorInTextField();
    }

    @When("I remove the cursor from the input field")
    public void iRemoveTheCursorFromTheInputField() {
        searchPanel.clickOnSearchPanel();
    }
}
