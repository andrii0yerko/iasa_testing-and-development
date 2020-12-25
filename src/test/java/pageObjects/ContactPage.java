package pageObjects;

import org.openqa.selenium.WebDriver;

public class ContactPage extends MainPage{
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://www.epam.com/about/who-we-are/contact";

    /*
    An encapsulation of page content logic would be there
    if I got a task to test it
     */
}
