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

public class Project_Status_Gadget_3 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert();
    String fileName="Project_Status_Gadget_3";
	@Given("^User is in a DashBoardWindow$")
	public void user_is_in_a_DashBoardWindow() throws Throwable {
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

	@When("^user creates a new DashBoard and selects it$")
	public void user_creates_a_new_DashBoard_and_selects_it() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 27, 1);
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

	@When("^user adds Project status Gadget for selected dashboard$")
	public void user_adds_Project_status_Gadget_for_selected_dashboard() throws Throwable {
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

	@When("^user attempts to save Project Status Gadget wihtout selecting any  Project$")
	public void user_attempts_to_save_Project_Status_Gadget_wihtout_selecting_any_Project() throws Throwable {
		try
		{
			String project=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			actual[7]=dp.checkProject(project);
			
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

	@Then("^user Should not be able to save the gadget without selecting project$")
	public void user_Should_not_be_able_to_save_the_gadget_without_selecting_project() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[8]=dp.saveGadget();
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

	@When("^user attempts to save Project Status Gadget by de-selecting already selected project$")
	public void user_attempts_to_save_Project_Status_Gadget_by_de_selecting_already_selected_project() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[9]=dp.checkProject(projectName);
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			String projectName_1=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 100, 100);
			actual[10]=dp.checkProject(projectName_1);
		
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

	@Then("^user should not be able to save the gadget for already selected project$")
	public void user_should_not_be_able_to_save_the_gadget_for_already_selected_project() throws Throwable {
		try
		{
		
			bp.waitForElement();
			actual[11]=dp.saveGadget();
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

	@When("^user attempts to save the changes by editing Project Status Gadget and click on Cancel$")
	public void user_attempts_to_save_the_changes_by_editing_Project_Status_Gadget_and_click_on_Cancel() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			String configure=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 8);
			actual[12]=dp.configureProjectStatusGadget(projectName);
			dp.saveGadget();
			bp.waitForElement();
			actual[13]=dp.gadgetOperation(configure);	
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

	@Then("^user should not be able to Save the changes if user click on cancel$")
	public void user_should_not_be_able_to_Save_the_changes_if_user_click_on_cancel() throws Throwable {
		try
		{
			bp.waitForElement();
			dp.gadgetCancel.click();
		
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
