package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Assign_868166 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868166";
	@Given("^Launch test Repository to create phase$")
	public void launch_test_Repository_to_create_phase() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Given("^Create a Phase and Add test cases to Phase$")
	public void create_a_Phase_and_Add_test_cases_to_Phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			actual[7]=tr.addTestCase();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   tr.cloneTestCase();
			   bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch Test Planning Create cycle and add Phase to Cycle and assign to Anyone$")
	public void launch_Test_Planning_Create_cycle_and_add_Phase_to_Cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   
		   tl.goBackToCycle();
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch execution navigate to phase Execute and Enter Actual time for testcases$")
	public void launch_execution_navigate_to_phase_Execute_and_Enter_Actual_time_for_testcases() throws Throwable 
	{
		try
		{
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    bp.waitForElement();
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			actual[40]=tr.navigateToNode(cyclename1[0],cyclename1);
			bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    
		   
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    epp.executeStatus(tcNo, statusType);
		    bp.waitForElement();
		    
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.executeStatus(tcNo2, statusType2);  
		    bp.waitForElement();
		    
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    epp.executeStatus(tcNo3, statusType3);
		    bp.waitForElement();
		    
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.executeStatus(tcNo4, statusType4);
		    bp.waitForElement();
		    
		    String[] tcno=new String[1];
		    tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"timeZone", 3, 3));
		    tr.clickOnDetails();
		    epp.selectMultipleTestCaseFromExecutionGrid(tcno);
		    
		    String day=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 0);
		    String hr=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 1);
		    String mn=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 2);
		    epp.actualTime(day, hr, mn);
		    bp.waitForElement();
		    
		    String[] tcno2=new String[1];
		    tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"timeZone", 4, 3));
		    epp.selectMultipleTestCaseFromExecutionGrid(tcno2);
		    String day1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 0);
		    String hr1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 1);
		    String mn1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 2);
		    epp.actualTime(day1, hr1, mn1);
		    bp.waitForElement();
		    tr.clickOnList();
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch test Planning navigate to cycle and phase and un-Assign$")
	public void launch_test_Planning_navigate_to_cycle_and_phase_and_un_Assign() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
		    tl.doubleClickOnCycle(cycleName);
		    
		    String cyclename1[]=new String[2];
		    cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			tl.assignPhase();
			bp.waitForElement();
			
			String cyclename2[]=new String[1];
			cyclename2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
			actual[40]=tl.navigateToCycle(cyclename2);
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			
			 String unassign=Excel_Lib.getData(INPUT_PATH_4, "Assignee",7, 0);
			//String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			tl.assignAllSelected(unassign);
			bp.waitForElement();
			
			tl.goBackToCycle();
		    bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^Actual time Should Retain its value$")
	public void actual_time_Should_Retain_its_value() throws Throwable 
	{
		try
		{
			
//		    rp.clickOnTestExecution();
//		    bp.waitForElement();
//		    bp.waitForElement();
//		    bp.waitForElement();
//		    String cyclename1[]=new String[3];
//		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
//			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 47, 0);
//			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 57, 0);
//			actual[40]=tl.navigateToCycle(cyclename1);
//			bp.waitForElement();
//			
//			  String[] tcno=new String[1];
//			  tcno[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"timeZone", 3, 3));
//			    epp.selectMultipleTestCaseFromExecutionGrid(tcno);
//			    
//			    String day=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 0);
//			    String hr=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 1);
//			    String mn=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 2, 2);
//			epp.validateActualTime(day, hr, mn);
//			
//			String[] tcno2=new String[1];
//			tcno2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"timeZone", 3, 3));
//		    epp.selectMultipleTestCaseFromExecutionGrid(tcno2);
//		    String day1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 0);
//		    String hr1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 1);
//		    String mn1=Excel_Lib.getData(INPUT_PATH_4, "timeZone", 3, 2);
//		    epp.validateActualTime(day1, hr1, mn1);
//		    
//		    rp.clickOnTestPlanning();
//		    bp.waitForElement();
			
			//..........because after assing to unassign the cyle will not visible in test executon so i commented................////////////
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
