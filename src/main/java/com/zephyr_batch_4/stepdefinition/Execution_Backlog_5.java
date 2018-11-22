package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class Execution_Backlog_5 extends LaunchBrowser{
LaunchBrowser lb=new LaunchBrowser();
String fileName="Execution_Backlog_5";

BasePage bp;
LoginPage lp;
ReleasePage rp;
ProjectPage pp;
ExecutionPage ep;
DashBoardPage dp;
TestPlanningPage tp;
TestRepositoryPage tr;
CreateTestCasePage ctc;

boolean actual[]=new boolean[63];
SoftAssert soft=new SoftAssert();

private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
private String project2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_2");
private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
private String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 29, 0);
private String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 6, 4);
	
	
	
	@Given("^Lead is in Test Repository page, creates new phase and add testcases with priority, tag and custom field$")
	public void lead_is_in_Test_Repository_page_creates_new_phase_and_add_testcases_with_priority_tag_and_custom_field() throws Throwable {
		try
		 {
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 bp=new BasePage();
			 ctc=new CreateTestCasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 pp.selectProject(project2);
			 actual[0]=pp.selectProject(project);
			 actual[1]=pp.selectRelease(release);
			 bp.waitForElement(); 
			 actual[2]=rp.clickOnTestRep();
			 bp.waitForElement();
			 actual[3]=tr.clickOnRelease(release);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 66, 0);
			 String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			 actual[4]=tr.addNode(phase, Desc);
			 bp.waitForElement();
			 String navigation[]=new String [1];
			 navigation[0]=phase;
			 actual[5]=tr.navigateToNode(release, navigation);
			 actual[6]=tr.addTestCase();
			 bp.waitForElement();
			 tr.clickOnDetails();
			 bp.waitForElement();
			 String tag[]=new String [1];
			 tag[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 10);
			 actual[7]=ctc.enterMultipleTags(tag);
			 bp.waitForElement();	
			 String priority[]=new String [1];
			 priority[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 9);
			 actual[8]=ctc.enterPriority(priority);
			 bp.waitForElement();
			 String pickupList=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 11);
			 String text=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String longText=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String number=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String checkBox=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 String date=Excel_Lib.getData(INPUT_PATH_5, "Phase", 100, 100);
			 actual[9]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
			 bp.waitForElement();
			 tr.clickOnList();
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

	@Given("^Launch Test planning, add phase to cycle and execute those testcases in Test Execution page$")
	public void launch_Test_planning_add_phase_to_cycle_and_execute_those_testcases_in_Test_Execution_page() throws Throwable {
		try
		 {
			 tp=new TestPlanningPage(driver);
			 ep=new ExecutionPage(driver);
			 actual[10]=rp.clickOnTestPlanning();
			 actual[11]=tp.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
			 String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 40, 0);
			 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			 String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			 actual[12]=tp.CreateCycle(cycle, Build, Environment, hide);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			 actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 actual[14]=tp.saveTestCycle(); 
			 bp.waitForElement(); 
			 String [] cycle1 =new String[1];
			 cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 40, 0);
			 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 66, 0);
			 actual[15]=tp.navigateToCycle(cycle1);
			 actual[16]=tp.addPhaseToCycle(phase);
			 actual[17]=bp.waitForElement();
			 String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			 actual[18]=tp.bulkAssignment(Bulk_type);
			 actual[19]=bp.waitForElement();
			 actual[20]=tp.goBackToCycle();
			 bp.waitForElement();  
			 actual[21]=rp.clickOnTestExecution();
			 actual[22]=bp.waitForElement();
			 String[] cycleName=new String[2];           
			 cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",40,0 );
			 cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",66,0 );
			 actual[23]=tr.navigateToNode(release, cycleName);
			 bp.waitForElement();
			 actual[24]=ep.selectAndDeselectAllTestCase();
			 bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			 actual[25]=ep.changeMultiSelectedStatus(status);
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

	@Given("^Launch dashBoards page and create new dashboard$")
	public void launch_dashBoards_page_and_create_new_dashboard() throws Throwable {
		try
		 {
			  dp=new DashBoardPage(driver);
			  String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			  String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			  String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			  actual[26]=dp.clickOnManageDashboards();
			  dp.validateDashboards();
			  bp.waitForElement();
			  actual[27]=dp.clickOnAddDashBoardSymbol();
			  actual[28]=dp.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
			  bp.waitForElement(); 
			  actual[29]=dp.validateDashBoard(dashBoardName);
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

	@When("^Add Executions Backlog Gadget by selecting filterBy User checkbox$")
	public void add_Executions_Backlog_Gadget_by_selecting_filterBy_User_checkbox() throws Throwable {
		try
		 {
			  actual[30]=dp.selectDashboard(dashBoardName);
			  bp.waitForElement();
			  actual[31]=dp.clickOnAddGadgetSymbol();
			  actual[32]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[33]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[34]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			  String [] user=new String [1];
			  user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
			  actual[35]=dp.filterBy(filterBy, user);
			  actual[36]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully with filterBy user checkbox$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully_with_filterBy_user_checkbox() throws Throwable {
		try
		 {
			actual[37]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 1, 7);
			actual[38]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget by selecting filterBy priority checkbox$")
	public void add_Executions_Backlog_Gadget_by_selecting_filterBy_priority_checkbox() throws Throwable {
		try
		 {
			  actual[39]=dp.clickOnAddGadgetSymbol();
			  actual[40]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[41]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[42]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			  String [] p=new String [1];
			  p[0]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 9);
			  actual[43]=dp.filterBy(filterBy, p);
			  actual[44]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully with filterBy priority checkbox$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully_with_filterBy_priority_checkbox() throws Throwable {
		try
		 {
			actual[45]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 2, 7);
			actual[46]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget by selecting filterBy Tag checkbox$")
	public void add_Executions_Backlog_Gadget_by_selecting_filterBy_Tag_checkbox() throws Throwable {
		try
		 {
			  actual[47]=dp.clickOnAddGadgetSymbol();
			  actual[48]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[49]=dp.validateGadget(gadget); 
			  bp.waitForElement();
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[50]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			  String [] phase=new String [1];
			  phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 10);
			  actual[51]=dp.filterBy(filterBy, phase);
			  actual[52]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully with filterBy Tag checkbox$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully_with_filterBy_Tag_checkbox() throws Throwable {
		try
		 {
			actual[53]=dp.validateSavedGadget(project);
			 String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 3, 7);
			actual[54]=dp.viewMsg(filterBy);
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

	@When("^Add Executions Backlog Gadget by selecting filterBy custom field checkbox$")
	public void add_Executions_Backlog_Gadget_by_selecting_filterBy_custom_field_checkbox() throws Throwable {
		try
		 {
			  actual[55]=dp.clickOnAddGadgetSymbol();
			  actual[56]=dp.addGadget(gadget);
			  bp.waitForElement();
			  actual[57]=dp.validateGadget(gadget); 
			  String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
			  actual[58]=dp.configureTraceabilityGadget(project, release, refreshRate); 
			  String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			  String [] customField=new String [1];
			  customField[0]=Excel_Lib.getData(INPUT_PATH_5, "DashBoards",1 , 9);
			  actual[59]=dp.filterBy(filterBy, customField);
			  actual[60]=dp.saveGadget();
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

	@Then("^Execution Backlog Gadget should be added sucessfully with filterBy custom field checkbox$")
	public void execution_Backlog_Gadget_should_be_added_sucessfully_with_filterBy_custom_field_checkbox() throws Throwable {
		try
		 {
			actual[61]=dp.validateSavedGadget(project);
			String filterBy=Excel_Lib.getData(INPUT_PATH_5,"DashBoards", 5, 7);
			actual[62]=dp.viewMsg(filterBy);
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
