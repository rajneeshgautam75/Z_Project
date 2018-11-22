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

public class TestExecution_878794  extends LaunchBrowser{
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
	boolean []actual=new boolean[35];
	SoftAssert soft=new SoftAssert();
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878794";	
	@Given("^User is in Test Repository page of Normal Project$")
	public void user_is_in_Test_Repository_page_of_Normal_Project() throws Throwable {
		 try
		   {  
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp= new ReleasePage(driver);
			   tr=new TestRepositoryPage(driver);
			  actual[0]=pp.selectProject(projectName);
			  actual[1]=pp.selectRelease(releaseName);
			  bp.waitForElement();
			  actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
		}
 @When("^User Creates New phase and adds testcases with test steps$")
	public void user_Creates_New_phase_and_adds_testcases_with_test_steps() throws Throwable {
		try
		{
		     epp= new ExportPage(driver);
			 ctc=new CreateTestCasePage(driver);
		     String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		     String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 0);
		     String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 8, 1);
		     actual[3]=tr.doubleClickOnRelease(releaseName);
		     bp.waitForElement();
		     actual[4]= tr.addNode(p_Name1,p_Desc1);
		     actual[5]=bp.waitForElement();
			 String [] Phase =new String[1];
			 Phase[0]=p_Name1;
			 actual[6]=tr.navigateToNode(releaseName, Phase);
			 bp.waitForElement();
	    	 actual[7]=tr.addTestCase();
	      	 bp.waitForElement();
		     actual[8]=tr.clickDetailButton();
		     bp.waitForElement();
			 String[] stepDetails0=new String[3];
			stepDetails0[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
			stepDetails0[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
			stepDetails0[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
			bp.waitForElement();
			actual[9]=ctc.enterTestCaseStepDetail(stepDetails0);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
               }
catch(Exception e)
{lb.getScreenShot(filename);
e.printStackTrace();
driver.close();
Relogin_TPE rl=new Relogin_TPE();
rl.reLogin();
throw e;
}
}

	@When("^Launch test planning and creates a new cycle in testplanning$")
	public void launch_test_planning_and_creates_a_new_cycle_in_testplanning() throws Throwable {
		try
		{   
			tp =new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			actual[10]=rp.clickOnTestPlanning();
			actual[11]=bp.waitForElement();	
		String cyclename0=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 4, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 11);
		actual[12]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[13]=tp.CreateCycle(cyclename0, Build, Environment,hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[14]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[15]=tp.saveTestCycle();
		bp.waitForElement();
		}
		catch(Exception e)
	{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 }
		}

	@When("^Add existing phase to cycle and assign to lead$")
	public void add_existing_phase_to_cycle_and_assign_to_lead() throws Throwable {
		try {
			String cyclename[]=new String[1];
		cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 4, 0);
		actual[16]=tp.navigateToCycle(cyclename);
	String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 8, 0);
		bp.waitForElement();
		actual[17]=tp.addPhaseToCycle(nodeName);
		bp.waitForElement();
	  String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	   actual[18]=tp.bulkAssignment(Bulk_type);
	   bp.waitForElement();
	   tp.goBackToCycle();
		  bp.waitForElement();
	 }
	catch(Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}
	}

	@When("^Launch Test Execution page$")
	public void launch_Test_Execution_page() throws Throwable {
	try{
			ep=new ExecutionPage(driver);
			actual[19]=rp.clickOnTestExecution(); 
			 bp.waitForElement();
			String[] cycleName=new String[3];
			cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1,0 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",4,0 );
		    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",8,0 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
			actual[20]=tp.navigateToCycle(cycleName);
			bp.waitForElement();
			
			tr.clickDetailButton();
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	     }

	@When("^Select a testcase and change the testcase step execution to Pass$")
	public void select_a_testcase_and_change_the_testcase_step_execution_to_Pass() throws Throwable {
		try {
			String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[21]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			 int testcase[]=new int[1];
			    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
			    String status1[]=new String[1];
				status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
			actual[22]=ep.changeStepDetailStatus(testcase,status1);
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	     }

	@Then("^Selected testcase step execution status should change to Pass$")
	public void selected_testcase_step_execution_status_should_change_to_Pass() throws Throwable {
		try{
			String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[23]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
		        bp.waitForElement();
		        int testcase[]=new int[1];
			    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
			    String status1[]=new String[1];
				status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
		actual[24]=	ep.validateStepDetailStatus(testcase,status1);
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	     }

	@When("^User selects a testcase and change the testcase step status execution to Fail$")
	public void user_selects_a_testcase_and_change_the_testcase_step_status_execution_to_Fail() throws Throwable {
		try {
			String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[25]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			//ep.stepDetailButton.click();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
		    status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[26]=ep.changeStepDetailStatus(testcase,status1);
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	     }

	@Then("^Selected testcase step execution status should change to Fail$")
	public void selected_testcase_step_execution_status_should_change_to_Fail() throws Throwable {
		try{
			String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[27]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			 int testcase[]=new int[1];
			    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
			    String status1[]=new String[1];
				status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2,2 );
		actual[28]=	ep.validateStepDetailStatus(testcase,status1);
			bp.waitForElement();
			
			tr.clickOnList();
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	     }

	@When("^User selects a testcase and change the Execution status of testcase to Fail$")
	public void user_selects_a_testcase_and_change_the_Execution_status_of_testcase_to_Fail() throws Throwable {
		try {
			String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[29]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			int [] tcno=new int [1];
			tcno[0]= Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3);
			String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[30]=ep.changeStatusOfTestCases(tcno, status1);
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	    }

	@Then("^Selected testcase status execution status should change to Fail$")
	public void selected_testcase_status_execution_status_should_change_to_Fail() throws Throwable {
		try
		{
			int [] testcase1 =new int[1];
			testcase1[0]= Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1 ,3 );
		    String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
		  actual[31]=ep.ValidateStatusOfTestCases(testcase1, status1);
	    }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
		}

	@When("^User selects the same testcase and change the status from Fail Status to Not Executed status$")
	public void user_selects_the_same_testcase_and_change_the_status_from_Fail_Status_to_Not_Executed_status() throws Throwable {
		try {
			 String testcase1[]=new String [1];
			 testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		actual[32]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
			  int statusDropDownType1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1,3 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_5, "Execution",5,2 );
			   actual[33]=ep.executeStatus(statusDropDownType1, statusType1);
				bp.waitForElement();
			}
			catch(Exception e)
			{lb.getScreenShot(filename);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
		   	 }}

	@Then("^Selcted testcase with teststeps status Execution should change to Not Executed status$")
	public void selcted_testcase_with_teststeps_status_Execution_should_change_to_Not_Executed_status() throws Throwable {
		try
		{
			int [] testcase1 =new int[1];
			testcase1[0]= Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1 ,3 );
		    String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution",5 ,2 );
		  actual[34]=ep.ValidateStatusOfTestCases(testcase1, status1);
		  bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
		for(int k=0;k<=actual.length-1;k++)
	     {
			
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	log.info("User successfully  the testcase");
	    
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
		 }
}

