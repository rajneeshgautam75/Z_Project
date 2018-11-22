package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OverAllDefect_25 extends LaunchBrowser {

LaunchBrowser lb=new LaunchBrowser();
String fileName="OverAllDefect_25";

BasePage bp;
ProjectPage pp;
ReleasePage rp;
TestRepositoryPage tr;
TestPlanningPage tp;
DashBoardPage dp;
ExecutionPage ep;
LoginPage lp;

boolean actual[]=new boolean[16];
SoftAssert soft=new SoftAssert();

private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 4, 0);
	
	
@Given("^Test Manager is in DashBoards Page$")
public void test_Manager_is_in_DashBoards_Page() throws Throwable {
try
{
lp=new LoginPage(driver);
pp=new ProjectPage(driver);
bp=new BasePage();
dp=new DashBoardPage(driver);
pp.clickOnLogout();
bp.waitForElement();
String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
actual[0]=lp.enterUnameAndPassword(name, passWord);
bp.waitForElement();
actual[1]=dp.clickOnManageDashboards();
bp.waitForElement();
bp.waitForElement();
actual[2]=dp.validateDashboards();
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}
}

@When("^click on add button and create new dashboard$")
public void click_on_add_button_and_create_new_dashboard() throws Throwable {
try
{
actual[3]=dp.clickOnAddDashBoardSymbol();
bp.waitForElement();
String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
actual[4]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
bp.waitForElement();
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}

@Then("^Should be able to add new DashBoard$")
public void should_be_able_to_add_new_DashBoard() throws Throwable {
try
{
actual[5]=dp.validateDashBoard(dashBoardName);		
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	    
}

@When("^Click on newly created dashboard$")
public void click_on_newly_created_dashboard() throws Throwable {
try
{
actual[6]=dp.searchDashboard(dashBoardName);
bp.waitForElement();
actual[7]=dp.selectDashboard(dashBoardName);
bp.waitForElement();

}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	  
}

@When("^Add OverAll Defects Gadget by clicking on add button$")
public void add_OverAll_Defects_Gadget_by_clicking_on_add_button() throws Throwable {
try
{
actual[8]=dp.clickOnAddGadgetSymbol();
String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
actual[9]=dp.addGadget(gadgetName);
bp.waitForElement();
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}

@Then("^Should be able to add Overall Gadget to DashBoard$")
public void should_be_able_to_add_Overall_Gadget_to_DashBoard() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
	actual[10]=dp.validateGadget(gadgetName);		
	}	
	catch(Exception e)
	{
	e.printStackTrace();
	lb.getScreenShot(fileName);
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
	}	   
}



@When("^Configure gadget with project, Release, refresh rate details and save it$")
public void configure_gadget_with_project_Release_refresh_rate_details_and_save_it() throws Throwable {
try
{
String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
actual[10]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);	
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}




@Then("^Should be able to save Overall Gadget to DashBoard$")
public void should_be_able_to_save_Overall_Gadget_to_DashBoard() throws Throwable {
	try
	{
	int defectCount=dp.linkCountInGadgetPage();
	System.out.println(defectCount);
	bp.waitForElement();
	}	
	catch(Exception e)
	{
	e.printStackTrace();
	lb.getScreenShot(fileName);
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
	}	   
}



@When("^Click on minimize the gadget$")
public void click_on_minimize_the_gadget() throws Throwable {
try
{
String value=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 0, 6);
actual[11]=dp.gadgetOperation(value);
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}

@Then("^Gadget should be minimized$")
public void gadget_should_be_minimized() throws Throwable {
try
{
actual[12]=dp.validateMinimizeOrMaximizeGadget(project);
bp.waitForElement();
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}

@When("^Click on maximize the gadget$")
public void click_on_maximize_the_gadget() throws Throwable {
try
{
String value=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 6);
actual[13]=dp.gadgetOperation(value);
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}

@Then("^Gadget should be maximized$")
public void gadget_should_be_maximized() throws Throwable {
try
{
actual[14]=dp.validateMinimizeOrMaximizeGadget(project);
actual[15]=pp.backToProjectPage();
for(int k=0;k<=actual.length-1;k++)
{
System.out.println("Actual["+k+"]="+actual[k]);	
soft.assertEquals(actual[k], true);
}
}	
catch(Exception e)
{
e.printStackTrace();
lb.getScreenShot(fileName);
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}	   
}	
}
