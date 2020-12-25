package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * An abstract class that implements a common logic (constructor so far)
 * for all the Page and Page Element classes
 */
public abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
