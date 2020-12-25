package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Encapsulation of bottom disclaimer logic which notifies the user about cookies usage
 */
public class CookiesDisclaimer extends Page{

    public CookiesDisclaimer(WebDriver driver) {
        super(driver);
    }

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
        WebElement acceptCookiesButton = driver.findElement(By.className("cookie-disclaimer__button"));
        acceptCookiesButton.click();
    }
}
