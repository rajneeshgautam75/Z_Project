package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_10 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	String fileName="Dashboard_10";
	
	boolean[] actual=new boolean[26];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a dashbOard page$")
	public void user_is_in_a_dashbOard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[0]=dbp.clickOnManageDashboards();
			actual[1]=dbp.validateDashboards();
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

	@When("^User create a dashbOard with the Available fields$")
	public void user_create_a_dashbOard_with_the_Available_fields() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[4]=dbp.validateDashBoard(dashboardName);
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

	@When("^User add a Test Automation Status gadget with the project/release with interval as One Hour$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_as_One_Hour() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,2);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			 actual[5]=dbp.selectDashboard(dashboardName);
		     actual[6]=dbp.clickOnAddGadgetSymbol();
		     actual[7]=dbp.addGadget(gadgetName);
			 actual[8]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^User is able to validate the added Test Automation Status gadget$")
	public void user_is_able_to_validate_the_added_Test_Automation_Status_gadget() throws Throwable {
	    try
	    {
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[9]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
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

	@When("^User add a Test Automation Status gadget with the project/release with interval as Four Hour$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_as_Four_Hour() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,8);
			 actual[10]=dbp.clickOnAddGadgetSymbol();
			 actual[11]=dbp.addGadget(gadgetName);
			 actual[12]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^User should be able to validate test automation status gadget$")
	public void user_should_be_able_to_validate_test_automation_status_gadget() throws Throwable {
		try
	    {
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[13]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
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

	@When("^User add a Test Automation Status gadget with the project/release with interval as Eight Hour$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_as_Eight_Hour() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8);
			 actual[14]=dbp.clickOnAddGadgetSymbol();
			 actual[15]=dbp.addGadget(gadgetName);
			 actual[16]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^should be able to validate the test automation status gadget$")
	public void should_be_able_to_validate_the_test_automation_status_gadget() throws Throwable {
		try
	    {
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[17]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
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

	@When("^User add a Test Automation Status gadget with the project/release with interval as One Day$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_as_One_Day() throws Throwable {
		try
	    {
	    	
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,8);
			 actual[18]=dbp.clickOnAddGadgetSymbol();
			 actual[19]=dbp.addGadget(gadgetName);
			 actual[20]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^User should be Able to validate test automation status gadget$")
	public void user_should_be_Able_to_validate_test_automation_status_gadget() throws Throwable {
		try
	    {
	    	 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 actual[21]=dbp.validateGadget(gadgetName);
			 bp.waitForElement();
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

	@When("^User add a Test Automation Status gadget with the project/release with interval as One Week$")
	public void user_add_a_Test_Automation_Status_gadget_with_the_project_release_with_interval_as_One_Week() throws Throwable {
		try
	    {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,8); 
			 actual[22]=dbp.clickOnAddGadgetSymbol();
			 actual[23]=dbp.addGadget(gadgetName);
			 actual[24]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
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

	@Then("^Should be able to validate the Test automation status gadget$")
	public void should_be_able_to_validate_the_Test_automation_status_gadget() throws Throwable {
		 try
		   {
			    String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
//			    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
//				String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
				actual[25]=dbp.validateGadget(gadgetName);
				bp.waitForElement();
				for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
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
