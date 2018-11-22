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

public class Dashboard_16 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	DashBoardPage dbp;
	ProjectPage pp;
	String fileName="Dashboard_16";
	
	boolean[] actual=new boolean[20];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in A DashBOard page$")
	public void user_is_in_A_DashBOard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
	    	pp=new ProjectPage(driver);
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

	@When("^User Create a dashBOard with the Available fields$")
	public void user_Create_a_dashBOard_with_the_Available_fields() throws Throwable {
		try
		{
		
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,2);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[2]=dbp.clickOnAddDashBoardSymbol();
		actual[3]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^DashBoard should be created successfully$")
	public void dashboard_should_be_created_successfully() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,2);
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

	@When("^User Add a Test Automation Status gadget with the project/release and save it$")
	public void user_Add_a_Test_Automation_Status_gadget_with_the_project_release_and_save_it() throws Throwable {
		try
	    {
	    	String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 7,2);
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

	@Then("^Gadget added reconfigured successfully$")
	public void gadget_added_reconfigured_successfully() throws Throwable {
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

	@When("^User edit a Test Automation Status gadget without release$")
	public void user_edit_a_Test_Automation_Status_gadget_without_release() throws Throwable {
		try
		   {
				String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
				String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
				 String release=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100); 
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
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


@Then("^gadget should not saved$")
public void gadget_should_not_saved() throws Throwable {
	try
	   {
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
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

	
//	@Then("^gadget should edited successfully$")
//	public void gadget_should_edited_successfully() throws Throwable {
//		try
//		{
//		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
//		     actual[13]=dbp.validateGadget(gadgetName);
//		     bp.waitForElement();
//		}
//		 catch(Exception e)
//			{
//			   lb=new LaunchBrowser();
//			   lb.getScreenShot(fileName);
//			   e.printStackTrace();
//			   driver.close();
//		      	Relogin_TPE rl=new Relogin_TPE();
//		      	rl.reLogin();
//		      	throw e;
//			}    
//	}
	
	@When("^User edit a TEst Automation status gadget with project/release$")
	public void user_edit_a_TEst_Automation_status_gadget_with_project_release() throws Throwable {
		try
		   {	    
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
				 actual[13]=dbp.clickOnAddGadgetSymbol();
			     actual[14]=dbp.addGadget(gadgetName);
	
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

	@Then("^gadget should be reconfigured and edited Successfully$")
	public void gadget_should_be_reconfigured_and_edited_Successfully() throws Throwable {
		try
		{
		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_10"); 
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[15]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
		     actual[16]=dbp.validateGadget(gadgetName);
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

	@When("^USer edit Test Automation Status gadget without project$")
	public void user_edit_Test_Automation_Status_gadget_without_project() throws Throwable {
		try
		   {
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
				 actual[17]=dbp.clickOnAddGadgetSymbol();
			     actual[18]=dbp.addGadget(gadgetName);
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

	@Then("^Gadget should not be saved$")
	public void gadget_should_not_be_saved() throws Throwable {
		try
		   {
			     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6);
				 String projectName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100); 
				 String release=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100); 
				 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
				 actual[19]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
				 dbp.validateGadget(gadgetName);
				 bp.waitForElement();
				 for(int k=0;k<=actual.length-1;k++)
					{
						//System.out.println("Actual["+k+"]="+actual[k]);
						soft.assertEquals(actual[k], true);
					}
					soft.assertAll();	
					pp.backToProjectPage();
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
	
//	@Then("^Gadget should be edited successfully$")
//	public void gadget_should_be_edited_successfully() throws Throwable {
//		try
//		{
//		     String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,6); 
//		     actual[21]=dbp.validateGadget(gadgetName);
//		     bp.waitForElement();
//		     for(int k=0;k<=actual.length-1;k++)
//				{
//					//System.out.println("Actual["+k+"]="+actual[k]);
//					soft.assertEquals(actual[k], true);
//				}
//				soft.assertAll();	
//		}
//		 catch(Exception e)
//			{
//			   lb=new LaunchBrowser();
//			   lb.getScreenShot(fileName);
//			   e.printStackTrace();
//			   driver.close();
//		      	Relogin_TPE rl=new Relogin_TPE();
//		      	rl.reLogin();
//		      	throw e;
//			}    
//	}
}
