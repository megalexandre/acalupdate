package br.org.acal.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber-report.json"},
    features = "src/test/resources/features",
    glue = "br.org.acal.cucumber.step"
)
public class RunCucumberTest {

}