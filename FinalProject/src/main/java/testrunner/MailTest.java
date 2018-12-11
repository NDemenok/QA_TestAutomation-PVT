package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
tags = { "@searchTest, @mailTest, @vktest" }, 
glue = "steps")
public class MailTest {

}