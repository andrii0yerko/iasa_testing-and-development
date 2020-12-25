import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import stepDefinitions.TestContext;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue="stepDefinitions"
)
public class TestRunner {
    @AfterClass
    public static void closeBrowser() {
        TestContext.getDriver().close();
    }
}