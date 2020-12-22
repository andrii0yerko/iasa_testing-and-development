import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        assertTrue(mainPage.isFrequentSearchesDropDownVisible());
    }

    @Test
    public void userWritesSearchQuery() {
        mainPage.writeASearchQuery("Hey there!");
        assertFalse(mainPage.isFrequentSearchesDropDownVisible());
        mainPage.clearSearchField();
    }

    @Test
    public void userRemovesCursor() {
        mainPage.clickOnSearchPanel();
        assertFalse(mainPage.isFrequentSearchesDropDownVisible());
    }
}