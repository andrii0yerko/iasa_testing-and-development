package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Encapsulation of header logic, which is common
 * for most of the pages on the site.
 * Notice that this class implements ONLY fullsize header
 * Excluding its changes referring to Adaptive UI
 */
public class Header extends Page{

    @FindBy(className = "header-search__button")
    WebElement searchButton;
    @FindBy(className = "location-selector__button")
    WebElement regionButton;
    @FindBy(className = "cta-button-ui")
    WebElement contactUsButton;
    @FindBy(className = "header__logo")
    WebElement logo;

    boolean regionPanelIsOpen = false;
    boolean searchPanelIsOpen = false;

    public Header(WebDriver driver) {
        super(driver);
    }


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

    public void clickOnLogo() {
        logo.click();
    }

    public void clickOnContactUs() {
        contactUsButton.click();
    }

    public void openRegionPanel() {
        if (!regionPanelIsOpen) {
            regionButton.click();
            regionPanelIsOpen = true;
        }
    }

    public void closeRegionPanel() {
        if (regionPanelIsOpen) {
            regionButton.click();
            regionPanelIsOpen = false;
        }
    }
}
