package com.runner;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.reports.Reporting;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags=(""),plugin ={ "pretty","json:target\\Output.json" },publish=true,
     monochrome=true,dryRun = false,features="src\\test\\resources",glue="com.stepdefinition",snippets=SnippetType.CAMELCASE)

public class TestRunnerClass extends BaseClass {
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectLocator()+getPropertyFileValue("jsonPath"));
	}

}
