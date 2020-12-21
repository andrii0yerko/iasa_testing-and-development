import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBehaviorTest {

    @Given("search drop-down panel is open")
    public void OpenSearchPanel() {
//        mainPage.openSearchPanel();
    }

    @Given ("input is empty")
    public void emptyInput() {

    }

    @When("cursor is placed in input field")
    public void placeCursorInInputField() {

    }

    @And("frequent searches menu should be displayed")
    public void checkFrequentSearches() {
    }

    @When("I write something")
    public void iWriteSomething() {
    }

    @Then("frequent searches menu should disappear")
    public void frequentSearchesMenuShouldDisappear() {
    }

    @Given("frequent searches menu is shown")
    public void frequentSearchesMenuIsShown() {
    }

    @When("I remove the cursor from the input field")
    public void iRemoveTheCursorFromTheInputField() {
    }


}
