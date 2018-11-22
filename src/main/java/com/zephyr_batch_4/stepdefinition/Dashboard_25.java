package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_25 extends LaunchBrowser {
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	CreateTestCasePage ctc;
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Dashboard_25";
	
	boolean[] actual=new boolean[34];
	 SoftAssert soft=new SoftAssert();
	
	@When("^create a Phase with Name and Description$")
	public void create_a_Phase_with_Name_and_Description() throws Throwable {
		try
		{
	
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 9);
	 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 10);
	 
	 actual[0]=tr.clickOnRelease(releaseName);
	 actual[1]=tr.addNode(phaseName, phaseDesc);
		
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

	@Then("^Phase should be created successfully$")
	public void phase_should_be_created_successfully() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 9);
	   
		 actual[2]=tr.navigateToNode(releaseName, phase);
		 
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

	@When("^user add a testcase with tags$")
	public void user_add_a_testcase_with_tags() throws Throwable {
		try
		{
		ctc=new CreateTestCasePage(driver);
		String[] tags=new String[2];
	 tags[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 11);
	 tags[1]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 11);
	  
	   actual[3]=tr.addTestCase();
	   
	   tr.clickDetailButton();
	   actual[4]=ctc.enterMultipletags(tags);
	   
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

	@Then("^testcase should be added with tags$")
	public void testcase_should_be_added_with_tags() throws Throwable {
		try
		{
		actual[5]=tr.verifyPresentTestCase();
		tr.clickOnList();
		
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

	@When("^creates a phase with name and description$")
	public void creates_a_phase_with_name_and_description() throws Throwable 
	{
		try
		{
		 tr=new TestRepositoryPage(driver);
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 9);
		 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 10);
		
		 actual[6]=tr.clickOnRelease(releaseName);
		 actual[7]=tr.addNode(phaseName, phaseDesc);
		 
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

	@Then("^Phase should be created successfully in restricted project$")
	public void phase_should_be_created_successfully_in_restricted_project() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 9);
	   
		 actual[8]=tr.navigateToNode(releaseName, phase);
		 
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

	@When("^user add a testcase with mutiple tags$")
	public void user_add_a_testcase_with_mutiple_tags() throws Throwable {
		try
		{
		String[] tags=new String[2];
		 tags[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 11);
		 tags[1]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 11);
		   
		   actual[9]=tr.addTestCase();
		   
		   tr.clickDetailButton();
		   actual[10]=ctc.enterMultipletags(tags);
		   
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

	@Then("^testcase should be added with multiple tags$")
	public void testcase_should_be_added_with_multiple_tags2() throws Throwable {
		try
		{
		actual[11]=tr.verifyPresentTestCase();
		tr.clickOnList();
		
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

	@When("^creates a phase with Name and Description$")
	public void creates_a_phase_with_Name_and_Description() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 8, 9);
		 String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 8, 10);
		
		 actual[12]=tr.clickOnRelease(releaseName);
		 actual[13]=tr.addNode(phaseName, phaseDesc);
		 
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

	@Then("^Phase should be created successfully in isolated project$")
	public void phase_should_be_created_successfully_in_isolated_project() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 8, 9);
	   
		 actual[14]=tr.navigateToNode(releaseName, phase);
		 
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

	@When("^user add a testCase with mutiple tags$")
	public void user_add_a_testCase_with_mutiple_tags() throws Throwable {
		try
		{
		String[] tags=new String[2];
		 tags[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 11);
		 tags[1]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 11);
		  
		   actual[15]=tr.addTestCase();
		   tr.clickDetailButton();
		   actual[16]=ctc.enterMultipletags(tags);
		   
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

	@Then("^testCase should be added with multiple tags$")
	public void testcase_should_be_added_with_multiple_tags() throws Throwable {
		try
		{
		actual[17]=tr.verifyPresentTestCase();
		tr.clickOnList();
		
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

	@When("^user creates a new Dashboard$")
	public void user_creates_a_new_Dashboard() throws Throwable {
		try
		  {
			db=new DashBoardPage(driver);
			 
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 1);
		    String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 2);
		    String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 3);
		    String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 4);
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

	@Then("^Dashboard should be created successfully$")
	public void dashboard_should_be_created_successfully() throws Throwable {
		 try
		   {
			   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 1);
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

	@When("^user add Test Automation Distribution Gadget by tag for normal project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_tag_for_normal_project() throws Throwable {
		try
		{
	    String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
	   String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 7);
	  String[] value=new String[1];
	  value[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 8);
	  
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

	@Then("^Test Automation Distribution Gadget by tag for normal project added successfully$")
	public void test_Automation_Distribution_Gadget_by_tag_for_normal_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
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

	@When("^user add Test Automation Distribution Gadget by tag for restricted project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_tag_for_restricted_project() throws Throwable {
		try
		{
	   // String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
	 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Restricted_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 7);
	  String[] value=new String[1];
	  value[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 7, 8);
	  
	    //actual[26]=db.selectDashboard(dashBoard);
	    actual[26]= db.clickOnAddGadgetSymbol();
	    actual[27]=db.addGadget(gadgetName);
	    
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

	@Then("^Test Automation Distribution Gadget by tag for restricted project added successfully$")
	public void test_Automation_Distribution_Gadget_by_tag_for_restricted_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
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

	@When("^user add Test Automation Distribution Gadget by tag for isolated project$")
	public void user_add_Test_Automation_Distribution_Gadget_by_tag_for_isolated_project() throws Throwable {
		try
		{
	 //   String dashBoard=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 1);
	  
	  //gadget fields
	    String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
	 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 6);
	  String typeName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 7);
	  String[] value=new String[1];
	  value[0]=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 8, 8);
	  
	    //actual[31]=db.selectDashboard(dashBoard);
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

	@Then("^Test Automation Distribution Gadget by tag for isolated project added successfully$")
	public void test_Automation_Distribution_Gadget_by_tag_for_isolated_project_added_successfully() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 6, 5);
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
