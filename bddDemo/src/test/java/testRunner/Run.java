package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/akshiy/IdeaProjects/bddDemo/Features/Assignment.feature",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target/Destination1"}
        //tags = "@tag1, @tag2"
)

public class Run {
}