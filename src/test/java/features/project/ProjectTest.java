package features.project;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/project/project.feature")
//@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/project/sprint.feature")
@CucumberOptions(plugin = {"pretty"})
public class ProjectTest {
}