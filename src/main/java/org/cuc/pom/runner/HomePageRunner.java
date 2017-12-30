package org.cuc.pom.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	features="src\\main\\java\\org\\cuc\\pom\\feature\\FreeCRM.feature",
					glue={"org\\cuc\\pom\\stepdefinition"},
					format={"pretty", "html:test-output"},
					dryRun=false,
					strict=false,
					monochrome=true,
					tags={"@SystemTesting","@RegressionTesting"} //system testing and regression testing
					//tags={"@SystemTesting,@RegressionTesting"} //system testing or regression testing
					//tags={"~@SystemTesting,@RegressionTesting"} //execute everything except scenarios with only system testing
					//tags={"@SystemTesting","~@RegressionTesting"} //execute only system testing
 		
		)
public class HomePageRunner {

}
