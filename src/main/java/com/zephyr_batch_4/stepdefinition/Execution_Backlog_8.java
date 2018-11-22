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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_8 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_8";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	
	boolean actual[]=new boolean[32];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 24, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	@Given("^As a lead, launch Test Repository, add testcases and assign testcases to another User$")
	public void as_a_lead_launch_Test_Repository_add_testcases_and_assign_testcases_to_another_User() throws Throwable {
		 try
		 {
			 
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 bp=new BasePage();
		 pp.selectProject(project2);
		 actual[0]=pp.selectProject(project);
		 actual[1]=pp.selectRelease(release);
		 bp.waitForElement();
		 actual[2]=rp.clickOnTestRep();
		 bp.waitForElement();
		 actual[3]=tr.clickOnRelease(release);
		 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 62, 0);
		 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
		 actual[4]=tr.addNode(phase, Desc);
		 bp.waitForElement();
		 String navigation[]=new String [1];
		 navigation[0]=phase;
		 actual[5]=tr.navigateToNode(release, navigation);
		 actual[6]=tr.addTestCase();
		 bp.waitForElement();
		 actual[7]=rp.clickOnTestPlanning();
		 actual[8]=tp.clickOnAddTestCycleSymbol();
		 bp.waitForElement();
		 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 35, 0);
		 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		 actual[9]=tp.CreateCycle(cycle, Build, Environment, hide);
		 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		 actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		 actual[11]=tp.saveTestCycle(); 
		 bp.waitForElement(); 
		 String [] cycle1 =new String[1];
		 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 35, 0);
		 actual[12]=tp.navigateToCycle(cycle1);
		 actual[13]=tp.addPhaseToCycle(phase);
		 actual[14]=bp.waitForElement();
		 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 3, 0);
		 actual[15]=tp.bulkAssignment(Bulk_type);
		 bp.waitForElement();
		 actual[16]=tr.clickOnRelease(phase);
		 bp.waitForElement();
		 int [] testCaseNo=new int [1];
		 testCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		 actual[17]=tp.selectSingleMultipleTestcase(testCaseNo);
		 bp.waitForElement();
		 String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_2");
		 actual[18]=tp.assignAllSelected(assignee);
		 bp.waitForElement();
		 actual[19]=tp.goBackToCycle();
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

	@Given("^launch Manage DashBoard page and create new DashBoard$")
	public void launch_Manage_DashBoard_page_and_create_new_DashBoard() throws Throwable {
		 try
		 {
		  dp=new DashBoardPage(driver);
		  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
		  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
		  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
		  actual[20]=dp.clickOnManageDashboards();
		  dp.validateDashboards();
		  actual[21]=dp.clickOnAddDashBoardSymbol();
		  actual[22]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
		  bp.waitForElement();
		  actual[23]=dp.validateDashBoard(dashBoardName); 
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

	@When("^Add Executions Backlog Gadget and select filterBy User checkbox if testcases are assigned from one user to other$")
	public void add_Executions_Backlog_Gadget_and_select_filterBy_User_checkbox_if_testcases_are_assigned_from_one_user_to_other() throws Throwable {
		 try
		 {
		  actual[24]=dp.selectDashboard(dashBoardName);
		  bp.waitForElement();
		  actual[25]=dp.clickOnAddGadgetSymbol();
		  actual[26]=dp.addGadget(gadget);
		  bp.waitForElement();
		  actual[27]=dp.validateGadget(gadget);
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[28]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
		  String [] userName=new String [1];
		  userName[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_2");
		  actual[29]=dp.filterBy(filterBy, userName);
		  actual[30]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added successfully$")
	public void execution_Backlog_Gadget_should_be_added_successfully() throws Throwable {
		 try
		 {
		  actual[31]=dp.validateSavedGadget(project);	
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
