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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Project_Status_Gadget_20 extends LaunchBrowser  {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
    String fileName="Project_Status_Gadget_20";
	@Given("^Custom role user is in a DashBoard Page$")
	public void custom_role_user_is_in_a_DashBoard_Page() throws Throwable {
		try
		{
		pp=new ProjectPage(driver);
		dp=new DashBoardPage(driver);
		bp=new BasePage();
//		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
//		pp.selectProject(projectName);
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

	@When("^custom role user adds a new dashboard and selects$")
	public void custom_role_user_adds_a_new_dashboard_and_selects() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 37, 1);
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

	@When("^adds Project status gadget for added DashBoard$")
	public void adds_Project_status_gadget_for_added_DashBoard() throws Throwable {
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

	@Then("^Project status gadget to be added$")
	public void project_status_gadget_to_be_added() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 6, 6);
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

	@When("^Delete Project Status Gadget when user has delete permission and is assigned to any project$")
	public void delete_Project_Status_Gadget_when_user_has_delete_permission_and_is_assigned_to_any_project() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			bp.waitForElement();
			actual[8]=dp.configureProjectStatusGadget(projectName);
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

	@Then("^To be able to Delete Project status Gadget$")
	public void to_be_able_to_Delete_Project_status_Gadget() throws Throwable {
		try
		{
			String delete=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 10, 8);
			bp.waitForElement();
			actual[9]=dp.gadgetOperation(delete);
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

	@When("^user Attempts to delete Project Status Gadget when user has delete permission and is not assigned to any project$")
	public void user_Attempts_to_delete_Project_Status_Gadget_when_user_has_delete_permission_and_is_not_assigned_to_any_project() throws Throwable {
	    
		try
		{
			lp=new LoginPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			pp.clickOnLogout();
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_3");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_3");
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 37, 1);
			actual[10]=lp.enterUname(Uname);
			System.out.println(" User name is " + Uname +"name");
			actual[11]=lp.enterPass(pass);
			System.out.println("Password is " + pass + "passsowrd");
			actual[12]=lp.clickOnLogin();
			System.out.println(Uname);
			actual[13]=dp.clickOnManageDashboards();
			actual[14]=dp.searchDashboard(name);
			
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

	@Then("^Should Not Be Able to Delete Project Status Gadget$")
	public void should_Not_Be_Able_to_Delete_Project_Status_Gadget() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 37, 1);
			bp.waitForElement();
			actual[15]=dp.validateDashBoard(name);
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
