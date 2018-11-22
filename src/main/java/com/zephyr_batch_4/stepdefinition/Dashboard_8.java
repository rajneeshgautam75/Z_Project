package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_8 extends LaunchBrowser {

	ProjectPage pp;
	DashBoardPage db;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_8";
	
	boolean[] actual=new boolean[24];
	 SoftAssert soft=new SoftAssert();
	
	
	@Given("^User is in manage dashboard page$")
	public void user_is_in_manage_dashboard_page() throws Throwable {
	   
		try
		{
			pp=new ProjectPage(driver);
		db=new DashBoardPage(driver);
		actual[0]=db.clickOnManageDashboards();
		}
		 catch(Exception e)
		{
	    
	       lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		}  
		
		
	}
	

@When("^user click on add dashboard symbol and create a dashboard$")
public void user_click_on_add_dashboard_symbol_and_create_a_dashboard() throws Throwable {
  try
  {
	  
    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 2);
    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 3);
    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 4);
    actual[1]=db.clickOnAddDashBoardSymbol();
    actual[2]=db.enterDashBoardDetails(name, desc, layout, shareType);
}
  catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
}

@Then("^dashboard created successfully$")
public void dashboard_created_successfully() throws Throwable {
   try
   {
	   String dashBoard=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
	   actual[3]= db.validateDashBoard(dashBoard);
   }
   catch(Exception e)
	{
 
    lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
 	Relogin_TPE rl=new Relogin_TPE();
 	rl.reLogin();
 	throw e;
	}  
}

@When("^user add first Test Automation status gadget by clicking \\+ symbol$")
public void user_add_first_Test_Automation_status_gadget_by_clicking_symbol() throws Throwable {
 
	try
	{
  String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
  
  //gadget fields
    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
//  String project=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
//  String release=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
//  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 1);
  
    actual[4]=db.selectDashboard(dashBoard);
    actual[5]= db.clickOnAddGadgetSymbol();
    actual[6]=db.addGadget(gadgetName);
	
	
	//db.configureTestAutomationStatusGadget(project, release, refreshRate);
}
catch(Exception e)
{

lb.getScreenShot(fileName);
   e.printStackTrace();
   driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
}
}

@Then("^first Test Automation status gadget added successfully$")
public void first_Test_Automation_status_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	actual[7]=db.validateGadget(gadgetName);
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
	
}

@When("^user add second Test Automation status gadget by clicking add gadget button$")
public void user_add_second_Test_Automation_status_gadget_by_clicking_add_gadget_button() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);

	db.layoutSelection(layout);
	//db.selectDashboard(dashBoard);
	actual[8]= db.clickOnAddGadgetSymbol();
	actual[9]=db.addGadget(gadgetName);
	}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
}

@Then("^second Test Automation status gadget added successfully$")
public void second_Test_Automation_status_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	actual[10]=db.validateGadget(gadgetName);
	}
		
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
}

@When("^user add third Test Automation status gadget and select normal project in configure gadget detail and save$")
public void user_add_third_Test_Automation_status_gadget_and_select_normal_project_in_configure_gadget_detail_and_save() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 6);
	  
	  String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);

		db.layoutSelection(layout);
	 // db.selectDashboard(dashBoard);
	  actual[11]=db.clickOnAddGadgetSymbol();
	  actual[12]=db.addGadget(gadgetName);
	  actual[13]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
	}
		catch(Exception e)
		{

		lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
}

@Then("^third Test Automation status gadget added successfully$")
public void third_Test_Automation_status_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	actual[14]=db.validateGadget(gadgetName);
		
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
}

@When("^user add fourth Test Automation status gadget and select restricted project in configure gadget detail and save$")
public void user_add_fourth_Test_Automation_status_gadget_and_select_restricted_project_in_configure_gadget_detail_and_save() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 6);
	  
	 	 // db.selectDashboard(dashBoard);
	  actual[15]=db.clickOnAddGadgetSymbol();
	  actual[16]=db.addGadget(gadgetName);
	  actual[17]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
	 
		
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
}

@Then("^fourth Test Automation status gadget added successfully$")
public void fourth_Test_Automation_status_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	actual[18]=db.validateGadget(gadgetName);
	 String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);

		db.layoutSelection(layout);

		
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
}

@When("^user add fifth Test Automation status gadget and select isolated project in configure gadget detail and save$")
public void user_add_fifth_Test_Automation_status_gadget_and_select_isolated_project_in_configure_gadget_detail_and_save() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 6);
	  
	  
	 // db.selectDashboard(dashBoard);
	  actual[19]= db.clickOnAddGadgetSymbol();
	  actual[20]=db.addGadget(gadgetName);
	  actual[21]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
}

@Then("^fifth Test Automation status gadget added successfully$")
public void fifth_Test_Automation_status_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 1, 5);
	actual[22]=db.validateGadget(gadgetName);
	String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 22, 3);

      actual[23]=db.layoutSelection(layout);
	
      
      pp.backToProjectPage();
      
	 for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			//soft.assertEquals(actual[k], true);
		}
		soft.assertAll();	
	
	}
	catch(Exception e)
	{

	lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}  
}
}
