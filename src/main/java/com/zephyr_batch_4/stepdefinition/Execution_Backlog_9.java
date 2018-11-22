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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_9 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_9";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	DashBoardPage dp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[19];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 25, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	@Given("^Lead is Test Repository Page, navigate to node and delete the testcase$")
	public void lead_is_Test_Repository_Page_navigate_to_node_and_delete_the_testcase() throws Throwable {
		 try
		 {
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 bp=new BasePage();
		 pp.selectProject(project2);
		 actual[0]=pp.selectProject(project);
		 actual[1]=pp.selectRelease(release);
		 bp.waitForElement();
		 actual[2]=rp.clickOnTestRep();
		 bp.waitForElement();
		 actual[3]=tr.clickOnRelease(release);
		 actual[4]=bp.waitForElement();
		 String navigation[]=new String [1];
		 navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 62, 0);
		 actual[5]=tr.navigateToNode(release, navigation);
		 actual[6]=tr.deleteNode();
		 bp.waitForElement();
		 }
		 catch(Exception e)
		 {
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		 }
	   
	}

	@Given("^Launch DashBoards Page and create a new Dashbaord$")
	public void launch_DashBoards_Page_and_create_a_new_Dashbaord() throws Throwable {
		try
		 {
		  dp=new DashBoardPage(driver);
		  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		  actual[7]=dp.clickOnManageDashboards();
		  dp.validateDashboards();
		  actual[8]=dp.clickOnAddDashBoardSymbol();
		  actual[9]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		  bp.waitForElement();
		  actual[10]=dp.validateDashBoard(dashBoardName); 
		 }
		 catch(Exception e)
		 {
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		 }   
	   
	}

	@When("^Add new Execution Backlog Gadget and select By User checkbox if testcases are deleted$")
	public void add_new_Execution_Backlog_Gadget_and_select_By_User_checkbox_if_testcases_are_deleted() throws Throwable {
		try
		 {
		  actual[11]=dp.selectDashboard(dashBoardName);
		  bp.waitForElement();
		  actual[12]=dp.clickOnAddGadgetSymbol();
		  actual[13]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[14]=dp.validateGadget(gadget);
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[15]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
		  String [] userName=new String [1];
		  userName[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_2");
		  actual[16]=dp.filterBy(filterBy, userName);
		  actual[17]=dp.saveGadget();
		  bp.waitForElement();
		 }
		 catch(Exception e)
		 {
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		 }    
	   
	}

	@Then("^Execution Backlog should be added successfully$")
	public void execution_Backlog_should_be_added_successfully() throws Throwable {
		 try
		 {
		  actual[18]=dp.validateSavedGadget(project);
		  pp.backToProjectPage();
		  for(int k=0;k<=actual.length-1;k++)
		   {
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		   }
		 }
		 catch(Exception e)
		 {
		   e.printStackTrace();
		   lb.getScreenShot(fileName);
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
		 }     
	   
	}

}
