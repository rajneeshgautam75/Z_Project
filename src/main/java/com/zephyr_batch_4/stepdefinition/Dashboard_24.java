package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_24 extends LaunchBrowser  
{
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_24";
	
	boolean[] actual=new boolean[34];
	 SoftAssert soft=new SoftAssert();
	 
	@Given("^User is in normal project page$")
	public void user_is_in_normal_project_page() throws Throwable {
		try
		{
			bp=new BasePage();
			pp=new ProjectPage(driver);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		actual[0]=pp.selectProject(projectName);
		
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

	@When("^user navigate to test repository page$")
	public void user_navigate_to_test_repository_page() throws Throwable {
		try
		{
		rp=new ReleasePage(driver);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	    
	    
	    actual[1]=pp.selectRelease(releaseName);
	    actual[2]=rp.clickOnTestRep();
	    
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

	@When("^create a phase with name and description$")
	public void create_a_phase_with_name_and_description() throws Throwable {
	
		try
		{
			tr=new TestRepositoryPage(driver);
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 8);
	 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 9);
	 
	 actual[3]=tr.clickOnRelease(releaseName);
	 actual[4]=tr.addNode(phaseName, phaseDesc);
		
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

	@Then("^phase should be created successfully$")
	public void phase_should_be_created_successfully() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 8);
	   
		 actual[5]=tr.navigateToNode(releaseName, phase);
		 
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

	@When("^user selects restricted project$")
	public void user_selects_restricted_project() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
		actual[6]=pp.selectProject(projectName);
		
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

	@When("^navigate to test repository page$")
	public void navigate_to_test_repository_page() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	    
	    
	    actual[7]=pp.selectRelease(releaseName);
	    actual[8]= rp.clickOnTestRep();
	    
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

	@When("^create a Phase with name and description$")
	public void create_a_Phase_with_name_and_description() throws Throwable {
		try
		{
			 tr=new TestRepositoryPage(driver);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 8);
		 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 9);
		
		 actual[9]=tr.clickOnRelease(releaseName);
		 actual[10]=tr.addNode(phaseName, phaseDesc);
			
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

	@Then("^phase should be created successfully in restricted project$")
	public void phase_should_be_created_successfully_in_restricted_project() throws Throwable {
		 
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 8);
		 actual[11]= tr.navigateToNode(releaseName, phase);
	   
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

	@When("^user selects isolated project$")
	public void user_selects_isolated_project() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_1");
		actual[12]=pp.selectProject(projectName);
		
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

	@When("^create a phase with Name and Description$")
	public void create_a_phase_with_Name_and_Description() throws Throwable {
		try
		{
			 //tr=new TestRepositoryPage(driver);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 8);
		 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 9);
		
		 actual[13]=tr.clickOnRelease(releaseName);
		 actual[14]=tr.addNode(phaseName, phaseDesc);
			
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

	@Then("^phase should be created successfully in isolated project$")
	public void phase_should_be_created_successfully_in_isolated_project() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 8);
		 actual[15]=tr.navigateToNode(releaseName, phase);
	     bp.waitForElement();
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

	@When("^user navigate to dashboard page$")
	public void user_navigate_to_dashboard_page() throws Throwable {
		try
		{
		db=new DashBoardPage(driver);
		actual[16]=db.clickOnManageDashboards();
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

	@Then("^user successfully navigated to dashboard page$")
	public void user_successfully_navigated_to_dashboard_page() throws Throwable {
	  try
	  {
		  actual[17]=db.validateDashboards();
	   
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

	@When("^user create a new dashboard$")
	public void user_create_a_new_dashboard() throws Throwable {
		 try
		  {
			  
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 1);
		    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 2);
		    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 3);
		    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 4);
		    actual[18]=db.clickOnAddDashBoardSymbol();
		    actual[19]=db.enterDashBoardDetails(name, desc, layout, shareType);
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

	@Then("^dashboard should be created successfully$")
	public void dashboard_should_be_created_successfully() throws Throwable {
		 try
		   {
			   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 1);
			   actual[20]= db.validateDashBoard(dashBoard);
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

	@When("^user add Test Automation Distribution Gadget by Phase for normal project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_Phase_for_normal_project() throws Throwable {
		try
		{
	    String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 5);
	 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 7);
	  String[] value=new String[1];
	  value[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 8);
	  
	    actual[21]=db.selectDashboard(dashBoard);
	    actual[22]= db.clickOnAddGadgetSymbol();
	    actual[23]=db.addGadget(gadgetName);
	    
	    actual[24]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
	    
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

	@Then("^Test Automation Distribution Gadget for normal project added successfully$")
	public void test_Automation_Distribution_Gadget_for_normal_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 3, 5);
		actual[25]=db.validateGadget(gadgetName);
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

	@When("^user add Test Automation Distribution Gadget by Phase for restricted project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_Phase_for_restricted_project() throws Throwable {
	 
		  try
		  {
		  //gadget fields
		    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 5);
		 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 6);
		  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 7);
		  String[] value=new String[1];
		  value[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 8);
		  
		   
		    actual[26]= db.clickOnAddGadgetSymbol();
		    actual[27]=db.addGadget(gadgetName);
		    bp.waitForElement();
		    
		    
		    actual[28]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
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

	@Then("^Test Automation Distribution Gadget for restricted project added successfully$")
	public void test_Automation_Distribution_Gadget_for_restricted_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 4, 5);
		actual[29]=db.validateGadget(gadgetName);
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

	@When("^user add Test Automation Distribution Gadget by Phase for isolated project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_Phase_for_isolated_project() throws Throwable {
  
		try
		{
		  //gadget fields
		    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 5);
		 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Isolated_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 6);
		  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 7);
		  String[] value=new String[1];
		  value[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 8);
		  
		 
		    actual[30]= db.clickOnAddGadgetSymbol();
		    actual[31]=db.addGadget(gadgetName);
		    
		    actual[32]=db.configureTestAutomationDistributionGadget(project, release, refreshRate, typeName, value);
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

	@Then("^Test Automation Distribution Gadget for isolated project added successfully$")
	public void test_Automation_Distribution_Gadget_for_isolated_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 5, 5);
		actual[33]=db.validateGadget(gadgetName);
		
		pp.backToProjectPage();
		
		
		 for(int k=0;k<=actual.length-1;k++)
			{
				//System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
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
