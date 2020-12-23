import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://www.epam.com/";

    // search
    @FindBy(className = "header-search__button")
    WebElement searchButton;

    boolean searchPanelIsOpen = false;

    public void openSearchPanel() {
        if (!searchPanelIsOpen) {
            searchButton.click();
            searchPanelIsOpen = true;
        }
    }

    public void closeSearchPanel() {
        if (searchPanelIsOpen) {
            searchButton.click();
            searchPanelIsOpen = false;
        }
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

    // cookies bottom panel
    @FindBy(className = "cookie-disclaimer__button")
    WebElement acceptCookiesButton;

    public boolean isCookiesDisclaimerVisible() {
        try {
            driver.findElement(By.className("cookie-disclaimer__content"));
        }
        catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    // header
    public void clickOnLogo() {
        WebElement logo = driver.findElement(By.className("header__logo"));
        logo.click();
    }

    public void clickOnContactUs() {
        WebElement contactUsButton = driver.findElement(By.className("cta-button-ui"));
        contactUsButton.click();
    }
}