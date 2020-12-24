package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ContactPage;
import pageObjects.MainPage;

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
        // waits until page is loaded, throws exception if more than 20 seconds
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Assertions.assertEquals(MainPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void userSearchesForContact() {
        mainPage.clickOnContactUs();
        // waits until page is loaded, throws exception if more than 20 seconds
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Assertions.assertEquals(ContactPage.URL, driver.getCurrentUrl());
        driver.get(mainPage.URL);
    }
}