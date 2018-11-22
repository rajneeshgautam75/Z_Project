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

public class Project_Status_Gadget_4 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
    String fileName="Project_Status_Gadget_4";
	@Given("^user is in DashBoard$")
	public void user_is_in_DashBoard() throws Throwable {
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

	@When("^user adds new dashboard and selects added new DashBoard$")
	public void user_adds_new_dashboard_and_selects_added_new_DashBoard() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 30, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[2]=dp.clickOnAddDashBoardSymbol();
		   actual[3]=dp.enterDashBoardDetails(name, description, layout, shareType);
		   bp.waitForElement();
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

	@When("^user adds project status gadget for Normal Project and Saves It$")
	public void user_adds_project_status_gadget_for_Normal_Project_and_Saves_It() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[5]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[6]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[7]=dp.configureProjectStatusGadget(project);
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

	@Then("^user should be able to add and save Project Status Gadget for Normal Project$")
	public void user_should_be_able_to_add_and_save_Project_Status_Gadget_for_Normal_Project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[8]=dp.validateSavedGadget(project);
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

	@When("^user adds and save Project Status Gadget for Isolated project$")
	public void user_adds_and_save_Project_Status_Gadget_for_Isolated_project() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Isolated_Project_1");
			bp.waitForElement();
			actual[9]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[10]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[11]=dp.configureProjectStatusGadget(project);
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

	@Then("^user should able to save for Isolated project$")
	public void user_should_able_to_save_for_Isolated_project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Isolated_Project_1");
			bp.waitForElement();
			actual[12]=dp.validateSavedGadget(project);
		
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

	@When("^user adds project status gadget for Restricted project$")
	public void user_adds_project_status_gadget_for_Restricted_project() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
			bp.waitForElement();
			actual[13]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[14]=dp.addGadget(gadget);
			bp.waitForElement();
			actual[15]=dp.configureProjectStatusGadget(project);
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

	@Then("^user shold able to add and save for Restricted project$")
	public void user_shold_able_to_add_and_save_for_Restricted_project() throws Throwable {
		try
		{
			String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Restricted_Project_1");
			bp.waitForElement();
			actual[16]=dp.validateSavedGadget(project);
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
