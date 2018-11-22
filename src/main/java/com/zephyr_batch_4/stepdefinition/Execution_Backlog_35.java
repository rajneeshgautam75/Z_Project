package com.zephyr_batch_4.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_35 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	DashBoardPage dp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_35";
	@Given("^CustomRoler is in DashBoard Window$")
	public void customroler_is_in_DashBoard_Window() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[0]=bp.waitForElement();
		actual[1]=dp.clickOnManageDashboards();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
		    e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
			
		}      
	    
	}

	@When("^CustomRoler adds a dashboard by clicking on plus icon and selects added dashboard$")
	public void customroler_adds_a_dashboard_by_clicking_on_plus_icon_and_selects_added_dashboard() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   actual[2]=bp.waitForElement();
			   actual[3]=dp.clickOnAddDashBoardSymbol();
			   actual[4]=dp.enterDashBoardDetails(name, description, layout, shareType);
			   actual[5]=dp.selectDashboard(name);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
		    e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
			
		}    
	    
	}

	@Then("^DashBOard should be validated successfully$")
	public void dashboard_should_be_validated_successfully() throws Throwable {
		try
		{
			 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
			 bp.waitForElement();
			 actual[6]=dp.validateDashBoard(name);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
		    e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
			
		}    
	   
	}
	@When("^CustomRoler Adds ten Executions Backlog Gadget with different projects in same dashboard$")
	public void customroler_Adds_ten_Executions_Backlog_Gadget_with_different_projects_in_same_dashboard() throws Throwable {
		try
	    {
			 String project[]=new String[10];
			 project[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			 project[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
			 project[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			 project[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			 project[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
			 project[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6");
			 project[6]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_7");
			 project[7]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8");
			 project[8]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_9");
			 project[9]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
			 String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 2);
			 String values[]=new String[1];
	    	 values[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	    	String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
	    	for(int i=0;i<=9;i++)
	    	{
			bp.waitForElement();
			actual[7]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[8]=dp.addGadget(gadget);
			bp.waitForElement();
			dp.validateGadget(gadget);
			bp.waitForElement();
			actual[9]=dp.configureTraceabilityGadget(project[i], release, refreshrate);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=dp.filterBy(filterByName, values);
			bp.waitForElement();
			dp.saveTraceabilityGadget();
	    	}
	    }
	    catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
		    e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
			
		}   
	
	
	
	
	
	
	}

	@Then("^Should be able to Add multiple ten Executions Backlog Gadget with different projects in same dashabord$")
	public void should_be_able_to_Add_multiple_ten_Executions_Backlog_Gadget_with_different_projects_in_same_dashabord() throws Throwable {
	    
         try
         {
		 String project[]=new String[10];
		 project[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		 project[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_2");
		 project[2]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		 project[3]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		 project[4]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
		 project[5]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_6");
		 project[6]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_7");
		 project[7]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_8");
		 project[8]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_9");
		 project[9]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
		 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		 for(int i=0;i<=9;i++)
		 {
		 bp.waitForElement();
		 actual[11]=dp.validateSavedGadget(project[i], release);
		 }
		 bp.waitForElement();
		 pp.backToProjectPage();
		    for(int k=0;k<=actual.length-1;k++)
	        {
	        soft.assertEquals(actual[k], true);
	        }
	        soft.assertAll();
         }
		catch(Exception e)
		{
			lb=new LaunchBrowser();
            lb.getScreenShot(fileName);
		    e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
			
		}   
		
	}

}
