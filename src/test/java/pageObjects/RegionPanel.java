package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegionPanel extends Page {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/nav/ul/li[8]/a")
    WebElement Ukraine_en;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/nav/ul/li[2]/a")
    WebElement India_en;
    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/ul/li[2]/div/nav/ul/li[1]/a")
    WebElement Global_en;

    public RegionPanel(WebDriver driver) {
        super(driver);
    }

    public void chooseLocation(String region) {
        switch (region) {
            case "Ukraine":
                Ukraine_en.click();
                break;
            case "India":
                India_en.click();
                break;
            case "Global":
                Global_en.click();
                break;
            default:
                throw (new NoSuchElementException("There is no location called " + region));
        }
    }
}
