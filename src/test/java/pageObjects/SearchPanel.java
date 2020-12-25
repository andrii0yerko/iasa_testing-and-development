package pageObjects;

import org.openqa.selenium.*;

/**
 * Encapsulation of Search panel logic which is available from the common header
 */
public class SearchPanel extends Page{

    public SearchPanel(WebDriver driver) {
        super(driver);
    }

    public boolean isFrequentSearchesDropDownVisible() {
        WebElement panel = driver.findElement(By.className("frequent-searches-ui"));
        return ! panel.getAttribute("class").contains("frequent-searches--hidden");
    }

    public void clickOnSearchPanel() {
        WebElement searchPanel = driver.findElement(By.className("header-search__panel"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        // to avoid clicking on overlapping element
        jse.executeScript("arguments[0].click();", searchPanel);
    }

    public void placeCursorInTextField() {
        // id =  new_form_search
        WebElement searchTextField = driver.findElement(By.className("frequent-searches__input"));
        searchTextField.click();
        searchTextField.sendKeys(Keys.ARROW_LEFT);
    }

    public void writeASearchQuery(String queryText) {
        WebElement searchTextField = driver.findElement(By.className("frequent-searches__input"));
        searchTextField.sendKeys(queryText);
    }

    public void clearSearchField() {
        WebElement searchTextField = driver.findElement(By.className("frequent-searches__input"));
        searchTextField.clear();
    }
}
