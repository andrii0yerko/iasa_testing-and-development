import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderBehaviorTest {
    @Given("I am on the main page")
    public void iAmOnThePage() {
    }

    @When("I click on logo")
    public void iClickOnLogo() {

    }

    @Then("I should be redirected to the main page")
    public void iShouldBeRedirectedToTheMainPage() {
    }

    @Given("header is displayed")
    public void headerIsDisplayed() {

    }

    @When("I point cursor on the {} section and drop-down menu is available for it")
    public void iPointCursorOnTheSectionAndDropDownMenuIsAvailableForIt(String section) {

    }

    @Then("drop-down menu should appear")
    public void dropDownMenuShouldAppear() {
    }

    @Given("Region panel is open")
    public void regionPanelIsOpen() {
    }

    @When("I click on {} region")
    public void iClickOnRegion(String region) {

    }

    @Then("I should be redirected to the {} region page")
    public void iShouldBeRedirectedToTheRegion_page(String region_page) {
    }

    @After()
    public void closeBrowser() {
//        driver.quit();
    }
}
