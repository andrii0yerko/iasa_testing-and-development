import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * implements Rule: Header behavior
 */
public class HeaderBehaviorTest extends AbstractTest{

    ContactPage contactPage;

    @Test
    public void userClicksOnLogo() {
        driver.get(ContactPage.URL);
        contactPage = new ContactPage(driver);
        contactPage.clickOnLogo();
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertEquals(MainPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void userSearchesForContact() {
        mainPage.clickOnContactUs();
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertEquals(ContactPage.URL, driver.getCurrentUrl());
        driver.get(mainPage.URL);
    }
}