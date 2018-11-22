package com.zephyr.testrunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features={"Batch2_Features"},

//tags={"@Test_Execution44"},
//tags={"@Test_Execution44,@ExecuteStatus4"},
//tags={"@search_Master1,@Retrieve1,@Delete1"},
tags={"@Login"},
///tags={"@Create_Cycle,@Retrieve,@search_Master,@Sync_Master"},
//tags={"@Assign,@Retrieve,@search_Master,@Sync_Master,@Free_Form_Master,@Set_Reset_Master,@Delete,@ExecuteStatus"},
glue={"com.zephyr_batch_2.stepdefinition"},
plugin = {"html:target/cucumber-html-report","junit:target/cucumber_batch2.xml",
		"pretty:target/cucumber-pretty.txt","rerun:target/rerun.txt",
		"usage:target/cucumber-usage.json","json:target/cucumber009.json"},
		monochrome = false)

public class Batch2_TestRunnerNew_TPE 
{
	
}
