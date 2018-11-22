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

public class TestExecution_878792 extends LaunchBrowser{
	BasePage bp;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
	LaunchBrowser lb=new LaunchBrowser();
	boolean actual[]=new boolean[40];
	SoftAssert soft=new SoftAssert();
	String filename="TestExecution_878792";
	
@Given("^User is in Test Repository Page of Normal Project$")
	public void user_is_in_Test_Repository_Page_of_Normal_Project() throws Throwable {
	 try
	   {   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   rp= new ReleasePage(driver);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
	       bp.waitForElement();
		   actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
	   }
	   catch (Exception e) 
		{
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User creates new Phase and add's testcases with teststeps to Phase$")
	public void user_creates_new_Phase_and_add_s_testcases_with_teststeps_to_Phase() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			epp= new ExportPage(driver);
			ctc=new CreateTestCasePage(driver);
		    String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 0);
		    String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 6, 1);
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
		    actual[8]=tr.clickOnDetails();
		    bp.waitForElement();
	    	String tcName=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 2);
			String tcDesc=Excel_Lib.getData(INPUT_PATH_5,"Phase" , 1, 3);
		    actual[9]=ctc.enterTestCaseNameAndDesc(tcName, tcDesc);
			String[] stepDetails0=new String[3];
			stepDetails0[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
			stepDetails0[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
			stepDetails0[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
			actual[10]=ctc.enterTestCaseStepDetail(stepDetails0);
			bp.waitForElement();
		    tr.clickOnList();
			bp.waitForElement();
			actual[11]=tr.addTestCase();
			bp.waitForElement();
			String [] tcNo1 =new String[1];
		    tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
		    epp.selectMultipleTestCaseFromGrid(tcNo1);
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			String tcName1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 2, 2);
			String tcDesc1=Excel_Lib.getData(INPUT_PATH_5,"Phase" , 2, 3);
			actual[12]=ctc.enterTestCaseNameAndDesc(tcName1, tcDesc1);
	        String[] stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
			ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			tr.clickOnList();
			tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
			epp.selectMultipleTestCaseFromGrid(tcNo1);
			bp.waitForElement();
			actual[13]=tr.addTestCase();
			bp.waitForElement();
			String [] tcNo2 =new String[1];
			tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
			epp.selectMultipleTestCaseFromGrid(tcNo2);
		    bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			String tcName2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 3, 2);
			String tcDesc2=Excel_Lib.getData(INPUT_PATH_5,"Phase" , 3, 3);
			actual[14]=ctc.enterTestCaseNameAndDesc(tcName2, tcDesc2);
			String[] stepDetails2=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
			ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			tr.clickOnList();
		    tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
			epp.selectMultipleTestCaseFromGrid(tcNo2);
			bp.waitForElement();
			actual[15]=tr.addTestCase();
			String [] tcNo3 =new String[1];
			tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
			epp.selectMultipleTestCaseFromGrid(tcNo3);
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			String tcName3=Excel_Lib.getData(INPUT_PATH_5, "Phase", 4, 2);
			String tcDesc3=Excel_Lib.getData(INPUT_PATH_5,"Phase" , 4, 3);
			actual[16]=ctc.enterTestCaseNameAndDesc(tcName3, tcDesc3);
			String[] stepDetails3=new String[3];
			stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
			stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
			stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
			actual[17]=	ctc.enterTestCaseStepDetail(stepDetails3);
			bp.waitForElement();
			tr.clickOnList();
		    bp.waitForElement();
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
	   	 }}

	@When("^User is in test planning page, creates new cycle\\.$")
	public void user_is_in_test_planning_page_creates_new_cycle() throws Throwable {
		try
	{   
		tp =new TestPlanningPage(driver);
		rp=new ReleasePage(driver);
		actual[18]=rp.clickOnTestPlanning();
		bp.waitForElement();	
		String cyclename0=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 2, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 11);
		actual[19]=tp.clickOnAddTestCycleSymbol();
		actual[20]=tp.CreateCycle(cyclename0, Build, Environment,hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[21]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[22]=tp.saveTestCycle();
		bp.waitForElement();
		}
		catch(Exception e)
		{   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	   	 }
		}
	
@When("^User adds existing phase to cycle and assign's to lead$")
	public void user_adds_existing_phase_to_cycle_and_assign_s_to_lead() throws Throwable {
		try {
			String cyclename[]=new String[1];
		   cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 2, 0);
		   actual[23]=tp.navigateToCycle(cyclename);
	       String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 6, 0);
		   bp.waitForElement();
		   actual[24]=tp.addPhaseToCycle(nodeName);
		   bp.waitForElement();
	       String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	       actual[25]=tp.bulkAssignment(Bulk_type);
	       bp.waitForElement();
	       tp.goBackToCycle();
			  bp.waitForElement();
	 }
	catch(Exception e)
	{
		 lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}}

@When("^User is in  Test Execution Page of project$")
	public void user_is_in_Test_Execution_Page_of_project() throws Throwable {
	
	try{
		 
		
		
		
		ep=new ExecutionPage(driver);
		actual[26]=rp.clickOnTestExecution(); 
		bp.waitForElement();
		String[] cycleName=new String[3];
		cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",2,0 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",6,0 );
	    tp=new TestPlanningPage(driver);
	    actual[27]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		}
	catch(Exception e)
	{   lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
   	Relogin_TPE rl=new Relogin_TPE();
   	rl.reLogin();
   	throw e;
	 }}

	@When("^User changes the status of first testcase step to Pass$")
	public void user_changes_the_status_of_first_testcase_step_to_Pass() throws Throwable {
		try {
			String testcase1[]=new String [1];
			testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3));
		    actual[28]=ep.selectMultipleTestCaseFromExecutionGrid(testcase1);
			bp.waitForElement();
			tr.clickOnDetails();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status1[]=new String[1];
			status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
			actual[29]=ep.changeStepDetailStatus(testcase,status1);
			bp.waitForElement();
			
			
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	   
	}

	@Then("^Status of first testcase step changed to Pass$")
	public void status_of_first_testcase_step_changed_to_Pass() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
			String status1[]=new String[1];
		    status1[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
		    actual[30]=ep.validateStepDetailStatus(testcase,status1);
			bp.waitForElement();
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	    	Relogin_TPE rl=new Relogin_TPE();
	   	    rl.reLogin();
	   	    throw e;
		 }   
	}

	@When("^User changes the status of second testcase step to Fail$")
	public void user_changes_the_status_of_second_testcase_step_to_Fail() throws Throwable {
		try {
			String testcase2[]=new String [1];
			testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3));
		    actual[31]=ep.selectMultipleTestCaseFromExecutionGrid(testcase2);
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status2[]=new String[1];
			status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[32]=ep.changeStepDetailStatus(testcase,status2);
			bp.waitForElement();
			}
		catch(Exception e)
		{   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	     	Relogin_TPE rl=new Relogin_TPE();
	    	rl.reLogin();
	    	throw e;
		 }
	   
	}

	@Then("^Status of Second testcase step changed to Fail$")
	public void status_of_Second_testcase_step_changed_to_Fail() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status2[]=new String[1];
			status2[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
			actual[33]=ep.validateStepDetailStatus(testcase,status2);
			bp.waitForElement();
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	   
	}

	@When("^User changes the status of third testcase step to WIP$")
	public void user_changes_the_status_of_third_testcase_step_to_WIP() throws Throwable {
		try {
			String testcase3[]=new String [1];
			 testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3));
		     actual[34]=ep.selectMultipleTestCaseFromExecutionGrid(testcase3);
			 bp.waitForElement();
			 int testcase[]=new int[1];
		     testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		     String status3[]=new String[1];
			 status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",3 ,2 );
			 actual[35]=ep.changeStepDetailStatus(testcase,status3);
			 bp.waitForElement();
			}
		catch(Exception e)
		{   lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	    
	}

	@Then("^Status of third testcase step changed to WIP$")
	public void status_of_third_testcase_step_changed_to_WIP() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status3[]=new String[1];
			status3[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",3 ,2 );
			actual[36]=ep.validateStepDetailStatus(testcase,status3);
			bp.waitForElement();
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	   }

	@When("^User changes the status of fourth testcase step to Blocked$")
	public void user_changes_the_status_of_fourth_testcase_step_to_Blocked() throws Throwable {
		try {
			String testcase4[]=new String [1];
			 testcase4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3));
		actual[37]=	ep.selectMultipleTestCaseFromExecutionGrid(testcase4);
			bp.waitForElement();
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[38]=ep.changeStepDetailStatus(testcase,status4);
			bp.waitForElement();
			
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }
	   
	}

	@Then("^Status of fourth testcase step changed to Blocked$")
	public void status_of_fourth_testcase_step_changed_to_Blocked() throws Throwable {
		try{
			int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String status4[]=new String[1];
			status4[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
			actual[39]=ep.validateStepDetailStatus(testcase,status4);
			bp.waitForElement();
			tr.clickOnList();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			
			for(int k=0;k<=actual.length-1;k++)
		     {
			  System.out.println("Actual["+k+"]="+actual[k]);	
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully  the testcase");
			
			}
		catch(Exception e)
		{    lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	   	Relogin_TPE rl=new Relogin_TPE();
	   	rl.reLogin();
	   	throw e;
		 }}
	}
