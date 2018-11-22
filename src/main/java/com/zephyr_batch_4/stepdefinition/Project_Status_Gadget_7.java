package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_7 extends LaunchBrowser{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[27];
	SoftAssert soft=new SoftAssert();
    String fileName="Project_Status_Gadget_7";
	@Given("^Tester/lead is in a DashBoard$")
	public void tester_lead_is_in_a_DashBoard() throws Throwable {
		
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

	@When("^tester/lead creates a dashboard and selects$")
	public void tester_lead_creates_a_dashboard_and_selects() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 35, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[2]=dp.clickOnAddDashBoardSymbol();
		   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   actual[4]=dp.selectDashboard(name);
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

	@When("^tester/lead adds project status gadget$")
	public void tester_lead_adds_project_status_gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[6]=dp.addGadget(gadget);
			
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

	@Then("^project status gadget should be validated$")
	public void project_status_gadget_should_be_validated() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[7]=dp.validateGadget(gadget);
			
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

	@When("^tester/lead Minimizes the saved Project Status Gadget$")
	public void tester_lead_Minimizes_the_saved_Project_Status_Gadget() throws Throwable {
		try
		{
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String value=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 8);
			bp.waitForElement();
			actual[8]=dp.configureProjectStatusGadget(normalproject);
			dp.saveGadget();
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=dp.gadgetOperation(value);
			
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

	@Then("^Should be able to minimize saved Project Status Gadget$")
	public void should_be_able_to_minimize_saved_Project_Status_Gadget() throws Throwable {
		try
		{
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[10]=dp.validateSavedGadget(normalproject);
			
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

	@When("^tester maximizes the minimized saved Project Status Gadget$")
	public void tester_maximizes_the_minimized_saved_Project_Status_Gadget() throws Throwable {
		try
		{
			String value=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 8);
			bp.waitForElement();
			actual[11]=dp.gadgetOperation(value);
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

	@Then("^Should be able to maximize the minimized saved Project Status Gadget$")
	public void should_be_able_to_maximize_the_minimized_saved_Project_Status_Gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[12]=dp.validateGadget(gadget);
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

	@When("^tester Minimizes the unsaved Project Status Gadget$")
	public void tester_Minimizes_the_unsaved_Project_Status_Gadget() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			bp.waitForElement();
			actual[13]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[14]=dp.addGadget(gadget);
			String value=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 8);
			bp.waitForElement();
			actual[15]=dp.gadgetOperation(value);
			
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

	@Then("^tester should be able to minimize the unsaved Project Status Gadget$")
	public void tester_should_be_able_to_minimize_the_unsaved_Project_Status_Gadget() throws Throwable {
		try
		{
			
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[16]=dp.validateSavedGadget(normalproject);
			
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

	@When("^tester Maximizes the minimized unsaved Project Status Gadget$")
	public void tester_Maximizes_the_minimized_unsaved_Project_Status_Gadget() throws Throwable {
		try
		{
			String value=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 8);
			bp.waitForElement();
			actual[17]=dp.gadgetOperation(value);
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

	@Then("^tester Should be able to maximize the minimized unsaved Project Status Gadget$")
	public void tester_Should_be_able_to_maximize_the_minimized_unsaved_Project_Status_Gadget() throws Throwable {
		try
		{
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[18]=dp.validateSavedGadget(normalproject);
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

	@When("^tester Minimizes and attempt to configure/edit saved Project Status Gadget$")
	public void tester_Minimizes_and_attempt_to_configure_edit_saved_Project_Status_Gadget() throws Throwable {
		try
		{
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Isolated_Project_2");
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			String value_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 8, 8);
			String value_2=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 9, 8);
			String configure=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 8);
			bp.waitForElement();
			actual[19]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[20]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[21]=dp.configureProjectStatusGadget(project);
			dp.saveGadget();
			bp.waitForElement();
			bp.waitForElement();
			actual[22]=dp.gadgetOperation(value_1);
			bp.waitForElement();
			actual[23]=dp.gadgetOperation(value_2);
			bp.waitForElement();
			actual[24]=dp.gadgetOperation(configure);
			bp.waitForElement();
			actual[25]=dp.configureProjectStatusGadget(normalproject);
			dp.saveGadget();
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

	@Then("^Should be able to minimize and configure/edit saved project status Gadget$")
	public void should_be_able_to_minimize_and_configure_edit_saved_project_status_Gadget() throws Throwable {
		try
		{
			String normalproject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[26]=dp.validateSavedGadget(normalproject);
			bp.waitForElement();
			pp.navigateToProjectPage();
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
