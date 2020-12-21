import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    // search
    @FindBy(className = "header-search__button")
    WebElement searchButton;

    @FindBy(className = "header-search__panel")
    WebElement searchPanel;

    @FindBy(id = "new_form_search")
    WebElement searchTextField;

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

    // cookies bottom panel
    @FindBy(className = "cookie-disclaimer__button")
    WebElement acceptCookiesButton;

    @FindBy(className = "cookie-disclaimer__content")
    WebElement cookiesDisclaimer;

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

}
