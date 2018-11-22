package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878785 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();
	ProjectPage pp;
	ReleasePage rp;
    BasePage bp;
	TestRepositoryPage tr;
	CreateTestCasePage cp;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
	boolean actual[]=new boolean[37];
	SoftAssert soft= new SoftAssert();
 
	String filename="TestExecution_878785";
	
	@Given("^User is in Test Repository page$")
	public void user_is_in_Test_Repository_page() throws Throwable {
		 try
		   {   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
			   pp=new ProjectPage(driver);
			   actual[0]=pp.selectProject(projectName);
			  bp=new BasePage();
			  bp.waitForElement();
			  actual[1]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   tr=new TestRepositoryPage(driver);
			  bp.waitForElement();
		   }
		   catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}}

	@Given("^User creates new phase and add testcases with teststeps to phase$")
	public void user_creates_new_phase_and_add_testcases_with_teststeps_to_phase() throws Throwable {
  
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 0);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
		tr=new TestRepositoryPage(driver);
		epp= new ExportPage(driver);
		cp=new CreateTestCasePage(driver);
		bp=new BasePage();
		actual[3]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]= tr.addNode(p_Name1,p_Desc1);
		actual[5]=bp.waitForElement();
		String Phase[]=new String[1];
		Phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 0);
		tr.navigateToNode(releaseName, Phase);
		bp.waitForElement();
		actual[6]=tr.selectPhase(p_Name1);
		bp.waitForElement();
		actual[7]=tr.addTestCase();
	    bp.waitForElement();
		actual[8]=tr.clickDetailButton();
		actual[9]=bp.waitForElement();
		String[] stepDetails0=new String[3];
		stepDetails0[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
		stepDetails0[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
		stepDetails0[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
		actual[10]=cp.enterTestCaseStepDetail(stepDetails0);
		bp.waitForElement();
		actual[11]=	tr.clickOnList();
		bp.waitForElement();
		tr.addTestCase();
		bp.waitForElement();
		String [] tcNo1 =new String[1];
		tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
		epp.selectMultipleTestCaseFromGrid(tcNo1);
		bp.waitForElement();
		tr.clickOnDetails();
		bp.waitForElement();
	    String[] stepDetails1=new String[3];
		stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
		stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
		stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
		actual[12]=cp.enterTestCaseStepDetail(stepDetails1);
		bp.waitForElement();
		tr.clickOnList();
		bp.waitForElement();
		tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0));
		epp.selectMultipleTestCaseFromGrid(tcNo1);
		bp.waitForElement();
		actual[13]=tr.addTestCase();
		bp.waitForElement();
		String [] tcNo2 =new String[1];
		tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
		actual[14]=epp.selectMultipleTestCaseFromGrid(tcNo2);
		bp.waitForElement();
		tr.clickOnDetails();
		bp.waitForElement();
		String[] stepDetails2=new String[3];
		stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
		stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
		stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
		cp.enterTestCaseStepDetail(stepDetails2);
		bp.waitForElement();
		tr.clickOnList();
		tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
		epp.selectMultipleTestCaseFromGrid(tcNo2);
		bp.waitForElement();
		actual[15]=tr.addTestCase();
		bp.waitForElement();
		String [] tcNo3 =new String[1];
		tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
		actual[16]=epp.selectMultipleTestCaseFromGrid(tcNo3);
		bp.waitForElement();
		tr.clickOnDetails();
		bp.waitForElement();
		String[] stepDetails3=new String[3];
		stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
		stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
		stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
		actual[17]=	cp.enterTestCaseStepDetail(stepDetails3);
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
	   	 } }

	@When("^User is in Test Planning page$")
	public void user_is_in_Test_Planning_page() throws Throwable {
	try{	rp=new ReleasePage(driver);
		    actual[18]=rp.clickOnTestPlanning();
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

	@When("^Creates new cycle, add phase and assign to lead$")
	public void creates_new_cycle_add_phase_and_assign_to_lead() throws Throwable {
	try{
		tp=new TestPlanningPage(driver);
		String cyclename0=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 0);
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
		actual[22]=tp.saveTestCycle();
		String cyclename[]=new String[1];
		cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 0);
		actual[23]=tp.navigateToCycle(cyclename);
	    String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 1, 0);
		bp.waitForElement();
		actual[24]=tp.addPhaseToCycle(nodeName);
	    String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
	    actual[25]=tp.bulkAssignment(Bulk_type);
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

	@Then("^User is in Test Execution page$")
	public void user_is_in_Test_Execution_page() throws Throwable {
	try{
		ep=new ExecutionPage(driver);
		actual[26]=rp.clickOnTestExecution(); 
		bp.waitForElement();
		String[] cycleName=new String[3];
		cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",1,0 );
	    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",1,0 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
		actual[27]=tp.navigateToCycle(cycleName);
		bp.waitForElement();}
	catch(Exception e)
	{lb.getScreenShot(filename);
		e.printStackTrace();
		driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
   	 }}
	
	@Then("^View the executions assigned by lead$")
	public void view_the_executions_assigned_by_lead() throws Throwable {
		
	try{
		  int testcase []=new int[4];
		  testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0);
		  testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0);
		  testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0);
		  testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0);
		  String Assign1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_1");
		  ep.validateAssignedTestCase(testcase, Assign1);
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

	@When("^User changes the Execution status from not executed to Pass/Fail/Wip/Block$")
	public void user_changes_the_Execution_status_from_not_executed_to_Pass_Fail_Wip_Block() throws Throwable {
		try
		{    
		    int  statusDropDownType1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1 ,3 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_5, "Execution",1 ,2 );
		    actual[28]=ep.executeStatus(statusDropDownType1, statusType1); 
		    int statusDropDownType2=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",2,3 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2);
		    actual[29]=ep.executeStatus(statusDropDownType2, statusType2);
		    int statusDropDownType3=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",3,3 );
		    String statusType3=Excel_Lib.getData(INPUT_PATH_5, "Execution",3,2 );
		    actual[30]=ep.executeStatus(statusDropDownType3, statusType3);
		    int statusDropDownType4=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",4,3 );
		    String statusType4=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
		    actual[31]=ep.executeStatus(statusDropDownType4, statusType4);
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

	@When("^Change the Execution status from Pass to Fail$")
	public void change_the_Execution_status_from_Pass_to_Fail() throws Throwable {
		
		try {
		    int statusDropDownType1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1,3 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
		    actual[32]=ep.executeStatus(statusDropDownType1, statusType1);
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

	@Then("^User successfully changed execution  Status Across Testcases$")
	public void user_successfully_changed_execution_Status_Across_Testcases() throws Throwable {
		try
		{
			int [] testcase1 =new int[1];
			testcase1[0]= Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",1 ,3 );
		    String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2 );
		    actual[33]=ep.ValidateStatusOfTestCases(testcase1, status1); 
		    int [] testcase2 =new int[1];
		    testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",2,3 );
		    String status2=Excel_Lib.getData(INPUT_PATH_5, "Execution",2 ,2);
		    actual[34]=ep.ValidateStatusOfTestCases(testcase2, status2);
		    int [] testcase3 =new int[1];
		    testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",3,3 );
		    String status3=Excel_Lib.getData(INPUT_PATH_5, "Execution",3,2 );
		    actual[35]=ep.ValidateStatusOfTestCases(testcase3, status3);
		    int [] testcase4 =new int[1];
		    testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",4,3 );
		    String status4=Excel_Lib.getData(INPUT_PATH_5, "Execution",4 ,2 );
		    actual[36]=ep.ValidateStatusOfTestCases(testcase4, status4);
			ep.ValidateStatusOfTestCases(testcase4, status4);
			bp.waitForElement();
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
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
	      }	
		}}
