package runnerFiles;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.vimalselvam.cucumber.listener.ExtentCucumberFormatter;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
//plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
glue = {"stepDefs","hooks"},
//tags ="@Web or @Desktop",
tags=("@Desktop or @Mobile"),
//tags=("@Mobile"),
plugin= {"pretty","html:target/Report/report.html","json:target/Report/report.json"},
monochrome=true,
dryRun = false
)
public class runnerTest {	
	
	//@AfterClass
   // public static void writeExtentReport() {
       // Reporter.loadXMLConfig(new File("config/report.xml"));

//}
}

