
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookiesNotificationTest extends AbstractTest{

    /**
     * Testing if new users get a cookies disclaimer
     */
    @BeforeAll
    public static void given() {
        assertTrue(mainPage.isCookiesDisclaimerVisible());
    }

    @Test
    public void userAcceptsCookies() {
        mainPage.acceptCookies();
        assertFalse(mainPage.isCookiesDisclaimerVisible());
    }

}
