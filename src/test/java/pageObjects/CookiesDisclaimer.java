package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Encapsulation of bottom disclaimer logic which notifies the user about cookies usage
 */
public class CookiesDisclaimer extends Page{

    @FindBy(className = "cookie-disclaimer__button")
    WebElement acceptCookiesButton;
    @FindBy(className = "cookie-disclaimer__content")
    WebElement disclaimer;

    public CookiesDisclaimer(WebDriver driver) {
        super(driver);
    }

    public boolean isCookiesDisclaimerVisible() {
        try {
            return disclaimer.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }
}
