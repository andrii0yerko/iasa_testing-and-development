package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * implements Rule: Search behavior
 */
public class SearchBehaviorTest extends AbstractTest{

    @BeforeAll
    public static void given() {
        mainPage.openSearchPanel();
    }

    @Test
    public void suggestFrequentSearches() {
        mainPage.placeCursorInTextField();
        Assertions.assertTrue(mainPage.isFrequentSearchesDropDownVisible());
    }

    @Test
    public void userWritesSearchQuery() {
        mainPage.writeASearchQuery("Hey there!");
        Assertions.assertFalse(mainPage.isFrequentSearchesDropDownVisible());
        mainPage.clearSearchField();
    }

    @Test
    public void userRemovesCursor() {
        mainPage.clickOnSearchPanel();
        Assertions.assertFalse(mainPage.isFrequentSearchesDropDownVisible());
    }
}