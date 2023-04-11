package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C://Users//abhis//All projects//All Projects done for practice//CucumberMavenNewProject//Feature//",glue = "StepDefination",
tags = "@Smoke5",
plugin = {"json:target/cucumber.json"})
public class Testrun extends AbstractTestNGCucumberTests{
	
	

}
