package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

/**
 * Encapsulation of Search panel logic which is available from the common header
 */
public class SearchPanel extends Page{

    @FindBy(className = "frequent-searches__input")
    WebElement searchTextField;
    @FindBy(className = "frequent-searches-ui")
    WebElement frequentSearchesDropDown;
    @FindBy(className = "header-search__panel")
    WebElement searchPanel;

    public SearchPanel(WebDriver driver) {
        super(driver);
    }

    public boolean isFrequentSearchesDropDownVisible() {
        return ! frequentSearchesDropDown.getAttribute("class").contains("frequent-searches--hidden");
    }

    public void clickOnSearchPanel() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        // to avoid clicking on overlapping element
        jse.executeScript("arguments[0].click();", searchPanel);
    }

    public void placeCursorInTextField() {
        searchTextField.click();
        searchTextField.sendKeys(Keys.ARROW_LEFT);
    }

    public void writeASearchQuery(String queryText) {
        searchTextField.sendKeys(queryText);
    }

    public void clearSearchField() {
        searchTextField.clear();
    }
}
