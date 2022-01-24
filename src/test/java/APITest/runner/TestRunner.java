package APITest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/APITest/resources/*.feature",
        glue = "src/test/java/APITest/step_definition/**"
)
public class TestRunner {
}

