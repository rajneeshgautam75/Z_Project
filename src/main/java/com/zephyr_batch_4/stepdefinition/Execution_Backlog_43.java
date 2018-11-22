package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_43 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="Execution_Backlog_43";
	
	BasePage bp;
	LoginPage lp;
	ReleasePage rp;
	ProjectPage pp;
	ExecutionPage ep;
	DashBoardPage dp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	CreateCustomFieldsPage ccf;
	
	
	boolean actual[]=new boolean[40];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 43, 0);
	private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	@Given("^Login as Manager and launch Administration$")
	public void login_as_Manager_and_launch_Administration() throws Throwable {
		 try
		  {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
			 lp=new LoginPage(driver);
			 actual[0]=pp.clickOnLogout();
			 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Username_1");
		     String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Manager_Password_1");
			 actual[1]=lp.enterUnameAndPassword(name, passWord);
			 bp.waitForElement();
			 actual[2]=pp.launchAdministration();
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

	@When("^Create different custom execution status$")
	public void create_different_custom_execution_status() throws Throwable {
		 try
		  { 
			 ep=new ExecutionPage(driver);
			 ccf=new CreateCustomFieldsPage(driver);
			 actual[3]=ccf.navigatingToCustomizationStatusTab();
			 actual[4]=ccf.clickOnExecutionStatusTab();
			 String value1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 6, 2);
			 boolean status1=ccf.checkAvailableCustomFields(value1);
			 if(status1==false)
			 {
			  String colour=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 2);
			  ccf.createCustomStaus(value1, colour);
			 }
			 String value2=Excel_Lib.getData(INPUT_PATH_5, "Execution", 7, 2);
			 boolean status2=ccf.checkAvailableCustomFields(value2);
			 if(status2==false)
			 {
			  String colour=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 2);
			  ccf.createCustomStaus(value2, colour);
			 }
			 String value3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 8, 2);
			 boolean status3=ccf.checkAvailableCustomFields(value3);
			 if(status3==false)
			 {
			  String colour=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 2);
			  ccf.createCustomStaus(value3, colour);
			 }
			 String value4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 9, 2);
			 boolean status4=ccf.checkAvailableCustomFields(value4);
			 if(status4==false)
			 {
			  String colour=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 2);
			  ccf.createCustomStaus(value4, colour);
			 }
			 String value5=Excel_Lib.getData(INPUT_PATH_5, "Execution", 10, 2);
			 boolean status5=ccf.checkAvailableCustomFields(value5);
			 if(status5==false)
			 {
			  String colour=Excel_Lib.getData(INPUT_PATH_5, "Execution", 11, 2);
			  ccf.createCustomStaus(value5, colour);
			 }
			 ccf.closeExecutionStatusPage.click();
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

	@When("^Launch EAS and create cycle and assign more than ten testcases$")
	public void launch_EAS_and_create_cycle_and_assign_more_than_ten_testcases() throws Throwable {
		try
		 {
			 ctc=new CreateTestCasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 tp=new TestPlanningPage(driver);
			 pp.backToProjectPage();
			 bp.waitForElement();
			 pp.selectProject(project2);
			 actual[5]=pp.selectProject(project);
			 actual[6]=pp.selectRelease(release);
			 bp.waitForElement(); 
			 actual[7]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[8]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 72, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[9]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[10]=tr.navigateToNode(release, navigation);
			 for(int i=0;i<=9;i++)
			 {
			 actual[11]=tr.addTestCase();
		     }
			 bp.waitForElement();
			 ep=new ExecutionPage(driver);
			 actual[12]=rp.clickOnTestPlanning();
			 actual[13]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 49, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[14]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[16]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 49, 0);
			 actual[17]=tp.navigateToCycle(cycle1);
			 actual[18]=tp.addPhaseToCycle(phase);
			 actual[19]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[20]=tp.bulkAssignment(Bulk_type);
             bp.waitForElement();
			 actual[21]=tp.goBackToCycle();   
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

	@When("^Launch TCE and execute ten or more testcases with all ten available execution status$")
	public void launch_TCE_and_execute_ten_or_more_testcases_with_all_ten_available_execution_status() throws Throwable {
	    try
	     {
	    	 actual[22]=rp.clickOnTestExecution();
			 actual[23]=bp.waitForElement();
			 String[] cycleName=new String[2]; 
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",49,0 );
		     cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",72,0 );
			 actual[24]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement(); 
			 String testCaseNo []=new String[1];
			 for(int i=0;i<=9;i++)
			 {
			 testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"Execution", 1+i, 0));
			 actual[25]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1+i, 2);
			 actual[26]=ep.changeMultiSelectedStatus(status);
			 bp.waitForElement();
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

	@When("^Create a dashboard and add Execution Backlog Gadget$")
	public void create_a_dashboard_and_add_Execution_Backlog_Gadget() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[27]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  actual[28]=dp.clickOnAddDashBoardSymbol();
			  actual[29]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[30]=dp.validateDashBoard(dashBoardName);
			  actual[31]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[32]=dp.clickOnAddGadgetSymbol();
			  actual[33]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[34]=dp.validateGadget(gadget); 
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

	@When("^Select Project/Release/Phase/RefreshInterval and save the gadget$")
	public void select_Project_Release_Phase_RefreshInterval_and_save_the_gadget() throws Throwable {
		try
		 { 
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		  actual[35]=dp.configureTraceabilityGadget(project, release, refreshRate); 
		  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
		  String [] phase =new String [1];
		  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 72, 0);
		  actual[36]=dp.filterBy(filterBy, phase);
		  actual[37]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be saved successfully$")
	public void execution_Backlog_Gadget_should_be_saved_successfully() throws Throwable {
		try
		 {
			actual[38]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 4, 7);
			actual[39]=dp.viewMsg(filterBy);
			bp.waitForElement();
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
