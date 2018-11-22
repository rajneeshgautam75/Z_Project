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

public class TestExecution_878793 extends LaunchBrowser {
LoginPage lp;
ProjectPage pp;
ReleasePage rp;
BasePage bp;
TestRepositoryPage tr;
CreateTestCasePage ctc;
TestPlanningPage tp;
ExecutionPage ep;
ExportPage epp;
LaunchBrowser lb=new LaunchBrowser();
String filename="TestExecution_878793";
boolean []actual=new boolean[63];
SoftAssert soft=new SoftAssert();
	
   @Given("^User is in Test repository page of new release$")
	public void user_is_in_Test_repository_page_of_new_release() throws Throwable {
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

	@When("^create new phase and add testcases with test steps to phase$")
	public void create_new_phase_and_add_testcases_with_test_steps_to_phase() throws Throwable {
		try
		{
			epp= new ExportPage(driver);
			ctc=new CreateTestCasePage(driver);
		    String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 0);
		    String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 7, 1);
		    actual[3]=tr.doubleClickOnRelease(releaseName);
		    bp.waitForElement();
		    actual[4]= tr.addNode(p_Name1,p_Desc1);
		    actual[5]=bp.waitForElement();
		    bp.waitForElement();
			String [] Phase =new String[1];
			Phase[0]=p_Name1;
			actual[6]=tr.navigateToNode(releaseName, Phase);
			bp.waitForElement();
		    for(int i=0;i<=3;i++)
		    {
		    actual[7]=tr.addTestCase();
		    }
		    actual[8]=bp.waitForElement();
	        String [] tcNo1 =new String[1];
		    tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0));
		    actual[9]=epp.selectMultipleTestCaseFromGrid(tcNo1);
		    actual[10]=bp.waitForElement();
		    actual[11]=tr.clickOnDetails();
	        bp.waitForElement();
			String[] stepDetails0=new String[3];
			stepDetails0[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
			stepDetails0[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
			stepDetails0[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
		    actual[12]=ctc.enterTestCaseStepDetail(stepDetails0);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0));
			actual[13]=epp.selectMultipleTestCaseFromGrid(tcNo1);
			bp.waitForElement();
			String [] tcNo2 =new String[1];
		    tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
			actual[14]=epp.selectMultipleTestCaseFromGrid(tcNo2);
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			String[] stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
			actual[15]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[16]=tr.clickOnList();
			bp.waitForElement();
		    tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
			actual[17]=epp.selectMultipleTestCaseFromGrid(tcNo2);
			bp.waitForElement();
			String [] tcNo3 =new String[1];
			tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
			actual[18]=epp.selectMultipleTestCaseFromGrid(tcNo3);
			bp.waitForElement();
			actual[19]=tr.clickOnDetails();
			bp.waitForElement();
			String[] stepDetails2=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
			actual[20]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[21]=tr.clickOnList();
			bp.waitForElement();
			tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
			actual[22]=epp.selectMultipleTestCaseFromGrid(tcNo3);
			bp.waitForElement();
			String [] tcNo4 =new String[1];
			tcNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
			actual[23]=epp.selectMultipleTestCaseFromGrid(tcNo4);
			bp.waitForElement();
			actual[24]=tr.clickOnDetails();
		    bp.waitForElement();
			String[] stepDetails3=new String[3];
			stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
			stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
			stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
			actual[25]=	ctc.enterTestCaseStepDetail(stepDetails3);
			bp.waitForElement();
			actual[26]=tr.clickOnList();
			actual[27]=bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
		               }
		
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 }
	   
	}

	@When("^User launch test Planning page, create new cycle$")
	public void user_launch_test_Planning_page_create_new_cycle() throws Throwable {
		try
		{   
		tp =new TestPlanningPage(driver);
		actual[28]=rp.clickOnTestPlanning();
		actual[29]=bp.waitForElement();	
		String cyclename0=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 3, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 11);
		actual[30]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[31]=tp.CreateCycle(cyclename0, Build, Environment,hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[32]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[33]=tp.saveTestCycle();
		bp.waitForElement();
		}
		catch(Exception e)
		{  lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 }
	    
	}

	@When("^Add existing phase to cycle, assign testcases under phase to lead$")
	public void add_existing_phase_to_cycle_assign_testcases_under_phase_to_lead() throws Throwable {
		try {
			
			String cyclename[]=new String[1];
		    cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 3, 0);
		    actual[34]=tp.navigateToCycle(cyclename);
	        String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 7, 0);
		    bp.waitForElement();
		    actual[35]=tp.addPhaseToCycle(nodeName);
	        String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	        actual[36]=tp.bulkAssignment(Bulk_type);
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

	@When("^Launch Test Execution page after assigning to lead$")
	public void launch_Test_Execution_page_after_assigning_to_lead() throws Throwable {
		try{
			 /*String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp= new ReleasePage(driver);
			   tr=new TestRepositoryPage(driver);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   tp=new TestPlanningPage(driver);
			   tr=new TestRepositoryPage(driver);*/
			   
			ep=new ExecutionPage(driver);
			actual[37]=rp.clickOnTestExecution(); 
			bp.waitForElement();
			String[] cycleName=new String[3];
			cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1,0 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",3,0 );
		    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",7,0 );
		    bp.waitForElement();
			actual[38]=tp.navigateToCycle(cycleName);
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

	@When("^User select first testcase and change the status of first testcase step to Pass$")
	public void user_select_first_testcase_and_change_the_status_of_first_testcase_step_to_Pass() throws Throwable {
		try {
			 tr.clickOnDetails();
			 bp.waitForElement();
			String testcase1[]=new String [1];
			testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		    actual[39]=ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
		   
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
			status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
			actual[40]=ep.changeStepDetailStatus(testcase,status1);
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

	@Then("^First testcase step status changed to Pass$")
	public void first_testcase_step_status_changed_to_Pass() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
			status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
		    actual[41]=ep.validateStepDetailStatus(testcase,status1);
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
	@When("^User execute same first testcase step status to Blocked$")
	public void user_execute_same_first_testcase_step_status_to_Blocked() throws Throwable {
		try {
			String testcase1[]=new String [1];
			testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		    actual[42]=ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			//ep.stepDetailButton.click();
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
			status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[43]=ep.changeStepDetailStatus(testcase,status1);
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

	@Then("^First testcase step status should change to Blocked$")
	public void first_testcase_step_status_should_change_to_Blocked() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
			status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4,2 );
		    actual[44]=ep.validateStepDetailStatus(testcase,status1);
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
@When("^User select second testcase and change the status of second testcase step to Fail$")
	public void user_select_second_testcase_and_change_the_status_of_second_testcase_step_to_Fail() throws Throwable {
	try {
		 
		String testcase2[]=new String [1];
		testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3));
	    actual[45]=ep.selectMultipleTestCaseFromExecutionGrid(testcase2);
		bp.waitForElement();
		int testcase[]=new int[1];
	    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
	    String status2[]=new String[1];
		status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
		actual[46]=ep.changeStepDetailStatus(testcase,status2);
		bp.waitForElement();
		bp.waitForElement();
		}
	catch(Exception e)
	{
		e.printStackTrace();
		driver.close();
   	Relogin_TPE rl=new Relogin_TPE();
   	rl.reLogin();
   	throw e;
	 }}

	@Then("^Second testcase step status changed to Fail$")
	public void second_testcase_step_status_changed_to_Fail() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status2[]=new String[1];
			status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[47]=ep.validateStepDetailStatus(testcase,status2);
			bp.waitForElement();
			}
		catch(Exception e)
		{
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }}

	@When("^User execute same second testcase step status to Blocked$")
	public void user_execute_same_second_testcase_step_status_to_Blocked() throws Throwable {
		
		try {
			
			String testcase2[]=new String [1];
			testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3));
		    actual[48]=ep.selectMultipleTestCaseFromExecutionGrid(testcase2);
			bp.waitForElement();
			//ep.stepDetailButton.click();
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status2[]=new String[1];
			status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[49]=ep.changeStepDetailStatus(testcase,status2);
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

	@Then("^Second testcase step status should change to Blocked$")
	public void second_testcase_step_status_should_change_to_Blocked() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status2[]=new String[1];
			status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4,2 );
		    actual[50]=ep.validateStepDetailStatus(testcase,status2);
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
	@When("^User select third testcase and change the status of third testcase step to WIP$")
	public void user_select_third_testcase_and_change_the_status_of_third_testcase_step_to_WIP() throws Throwable {
		try {
			
			String testcase3[]=new String [1];
			testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3));
		    actual[51]=ep.selectMultipleTestCaseFromExecutionGrid(testcase3);
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status3[]=new String[1];
			status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",3 ,2 );
			actual[52]=ep.changeStepDetailStatus(testcase,status3);
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

   @Then("^Third testcase step status changed to WIP$")
	public void third_testcase_step_status_changed_to_WIP() throws Throwable {
	   try{
		   int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status3[]=new String[1];
			status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",3 ,2 );
			actual[53]=ep.validateStepDetailStatus(testcase,status3);
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

	@When("^User execute same testcase step status to Blocked$")
	public void user_execute_same_testcase_step_status_to_Blocked() throws Throwable {
		try {

			String testcase3[]=new String [1];
			 testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3));
		    actual[54]=ep.selectMultipleTestCaseFromExecutionGrid(testcase3);
			bp.waitForElement();
			//ep.stepDetailButton.click();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status3[]=new String[1];
			status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[55]=ep.changeStepDetailStatus(testcase,status3);
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
	@Then("^Third testcase step status should change to Blocked$")
	public void third_testcase_step_status_should_change_to_Blocked() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status3[]=new String[1];
			status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4,2 );
		    actual[56]=ep.validateStepDetailStatus(testcase,status3);
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

	@When("^User select fourth testcase and change the status of second testcase step to Blocked$")
	public void user_select_fourth_testcase_and_change_the_status_of_second_testcase_step_to_Blocked() throws Throwable {
		try {
	
			String testcase4[]=new String [1];
			testcase4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3));
		    actual[57]=ep.selectMultipleTestCaseFromExecutionGrid(testcase4);
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[58]=ep.changeStepDetailStatus(testcase,status4);
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
	@Then("^Fourth testcase step status changed to Blocked$")
	public void fourth_testcase_step_status_changed_to_Blocked() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[59]=ep.validateStepDetailStatus(testcase,status4);
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
	@When("^User execute same fourth testcase step status to Pass$")
	public void user_execute_same_fourth_testcase_step_status_to_Pass() throws Throwable {
		try {
	
			String testcase4[]=new String [1];
			testcase4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3));
		    actual[60]=ep.selectMultipleTestCaseFromExecutionGrid(testcase4);
			bp.waitForElement();
			//ep.stepDetailButton.click();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[61]=ep.changeStepDetailStatus(testcase,status4);
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

	@Then("^Fourth testcase step status should change to Pass$")
	public void fourth_testcase_step_status_should_change_to_Pass() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2,2 );
		    actual[62]=ep.validateStepDetailStatus(testcase,status4);
		    bp.waitForElement();
		    tr.clickOnList();
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
	}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	   	    rl.reLogin();
	   	    throw e;
		 }}
		

	
	
	
	
	

}
