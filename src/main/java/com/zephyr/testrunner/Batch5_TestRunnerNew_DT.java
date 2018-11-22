package com.zephyr.testrunner;



import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features={"Batch5_Features"},

//tags={"@JiraPermission"},
//tags={"@Login"},
//tags={"@DT_Admin,@Defect_Tracking,@DT_View,@Search_Defect"},
//tags={"@JiraPermission,@Search_Defect"},
tags={"@Defect_Tracking"},

glue={"com.zephyr_batch_5.stepdefinition"},
plugin = {"html:target/cucumber-html-report","junit:target/cucumber_batch5.xml",
		"pretty:target/cucumber-pretty.txt","rerun:target/rerun.txt",
		"usage:target/cucumber-usage.json","json:target/cucumber71.json"},
		monochrome = false)

public class Batch5_TestRunnerNew_DT 
{
	
	
	
	

}
