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

public class TestExecution_878824 extends LaunchBrowser {
	LaunchBrowser lb=new LaunchBrowser();         
	BasePage bp;
	CreateTestCasePage ctc;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
      boolean actual[]=new boolean[87];
      SoftAssert soft=new SoftAssert();
	String filname="TestExecution_878824";
@Given("^Lead is in Test repository Page of normal project$")
		public void lead_is_in_Test_repository_Page_of_normal_project() throws Throwable 
      {
	try
	    {
		pp=new ProjectPage(driver);
		rp=new ReleasePage(driver);
		bp=new BasePage();
		String ProjectName =Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
		String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		actual[0]=pp.selectProject(ProjectName);
		bp.waitForElement();
		actual[1]=pp.selectRelease(Release);
		bp.waitForElement();
		actual[2]=rp.clickOnTestRep();
		actual[3]=bp.waitForElement();
	    }
	catch (Exception e)
	    {
		lb.getScreenShot(filname);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	    }
		 }

@When("^Creates new phase and add two systems to phase$")
		public void creates_new_phase_and_add_two_systems_to_phase() throws Throwable   {
	try
    {
		tr=new TestRepositoryPage(driver);
		epp=new ExportPage(driver);
		ctc=new CreateTestCasePage(driver);
		String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
		actual[4]=tr.doubleClickOnRelease(Release);
		bp.waitForElement();
		String Phase_N=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 0);
		String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12,1);
		actual[5]=tr.addNode(Phase_N, Desc);
		 bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=Phase_N;
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
	    actual[6]=tr.selectPhase(Phase_N);
	    bp.waitForElement();
	    String System1_N=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 4);
	    String System1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 5);
	    actual[7]=tr.addNode(System1_N, System1_Desc);
	    bp.waitForElement();
	    tr.clickOnRelease(Release);
	    bp.waitForElement();
	    actual[8]=tr.selectPhase(Phase_N);
	    bp.waitForElement();
	    String System2_N=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 4);
	    String System2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 5);
	    actual[9]=tr.addNode(System2_N, System2_Desc);
	    bp.waitForElement();
	     }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Add ten testcases with teststeps to phase and each system$")
		public void add_ten_testcases_with_teststeps_to_phase_and_each_system() throws Throwable   {
	try
    {       
		    String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
		    String Phase_N=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 0);
		    actual[10]=tr.selectPhase(Phase_N);
		    actual[11]=tr.addTestCase();
		    bp.waitForElement();
		    actual[12]=tr.clickOnDetails();
		    bp.waitForElement();
		    String StepDetails1[]=new String[3];
		    StepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
		    StepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
		    StepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
		    actual[13]=ctc.enterTestCaseStepDetail(StepDetails1);
		    bp.waitForElement();
		    actual[14]=tr.clickOnList();
		    bp.waitForElement();
		    actual[15]=tr.addTestCase();
		    bp.waitForElement();
		    String tcNo2[]=new String[1];
		    tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,0));
		    actual[16]=epp.selectMultipleTestCaseFromGrid(tcNo2);
		    bp.waitForElement();
		    actual[17]=tr.clickOnDetails();
		    bp.waitForElement();
		    String StepDetails2[]=new String[3];
		    StepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
		    StepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
		    StepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
		    actual[18]=ctc.enterTestCaseStepDetail(StepDetails2);
		    bp.waitForElement();
		    actual[19]=tr.clickOnList();
		    bp.waitForElement();
		    actual[20]=tr.selectallTestCase();
		    actual[21]=tr.cloneTestCase();
		    bp.waitForElement();
		    actual[22]=tr.selectallTestCase();
		    actual[23]=tr.cloneTestCase();
		    bp.waitForElement();
		    String testCaseNo[]=new String[1];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
		    actual[24]=epp.selectMultipleTestCaseFromGrid(testCaseNo);
		    String testCaseNo1[]=new String[1];
		    testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
		    actual[25]=epp.selectMultipleTestCaseFromGrid(testCaseNo1);
		    bp.waitForElement();
		    actual[26]=tr.cloneTestCase();
		    bp.waitForElement();
		    String[] phase=new String[2];
			phase[0]=Phase_N;
			phase[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 4);
			bp.waitForElement();
		    tr.navigateToNode(Release, phase);
			bp.waitForElement();
		    String System1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 4);
	        actual[27]=tr.selectPhase(System1);
	        bp.waitForElement();
			    actual[28]=tr.addTestCase();
			    bp.waitForElement();
			    actual[29]=tr.clickOnDetails();
			    bp.waitForElement();
			    String StepDetails11[]=new String[3];
			    StepDetails11[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 0);
			    StepDetails11[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 1);
			    StepDetails11[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 3, 2);
			    actual[30]=ctc.enterTestCaseStepDetail(StepDetails11);
			    bp.waitForElement();
			    actual[31]=tr.clickOnList();
			    bp.waitForElement();
			    actual[32]=tr.addTestCase();
			    bp.waitForElement();
			    String tcNo21[]=new String[1];
			    tcNo21[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,0));
			    actual[33]=epp.selectMultipleTestCaseFromGrid(tcNo21);
			    bp.waitForElement();
			    actual[34]=tr.clickOnDetails();
			    bp.waitForElement();
			    String StepDetails12[]=new String[3];
			    StepDetails12[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 0);
			    StepDetails12[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 1);
			    StepDetails12[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 4, 2);
			    actual[35]=ctc.enterTestCaseStepDetail(StepDetails12);
			    bp.waitForElement();
			    actual[36]=tr.clickOnList();
			    bp.waitForElement();
			    actual[37]=tr.selectallTestCase();
			    actual[38]=tr.cloneTestCase();
			    bp.waitForElement();
			    actual[39]=tr.selectallTestCase();
			    actual[40]=tr.cloneTestCase();
			    bp.waitForElement();
			    String testCaseNo11[]=new String[1];
			    testCaseNo11[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
			    actual[41]=epp.selectMultipleTestCaseFromGrid(testCaseNo11);
			    String testCaseNo111[]=new String[1];
			    testCaseNo111[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
			    actual[42]=epp.selectMultipleTestCaseFromGrid(testCaseNo111);
			    bp.waitForElement();
			    actual[43]=tr.cloneTestCase();
			    bp.waitForElement();
			    String[] phase1=new String[2];
				phase1[0]=Phase_N;
				phase1[1]=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 4);
				bp.waitForElement();
			    tr.navigateToNode(Release, phase1);
				bp.waitForElement();
		        String System2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 13, 4);
			    actual[44]=tr.selectPhase(System2);
			    bp.waitForElement();
			    actual[45]=tr.addTestCase();
			    bp.waitForElement();
			    actual[46]=tr.clickOnDetails();
			    bp.waitForElement();
			    String StepDetails21[]=new String[3];
			    StepDetails21[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
			    StepDetails21[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
			    StepDetails21[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
			    actual[47]=ctc.enterTestCaseStepDetail(StepDetails21);
			    bp.waitForElement();
			    actual[48]=tr.clickOnList();
			    bp.waitForElement();
			    actual[49]=tr.addTestCase();
			    bp.waitForElement();
			    String tcNo22[]=new String[1];
			    tcNo22[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,0));
			    actual[50]=epp.selectMultipleTestCaseFromGrid(tcNo22);
			    bp.waitForElement();
			    actual[51]=tr.clickOnDetails();
			    bp.waitForElement();
			    String StepDetails22[]=new String[3];
			    StepDetails22[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
			    StepDetails22[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
			    StepDetails22[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
			    actual[52]=ctc.enterTestCaseStepDetail(StepDetails22);
			    bp.waitForElement();
			    actual[53]=tr.clickOnList();
			    bp.waitForElement();
			    actual[54]=tr.selectallTestCase();
			    actual[55]=tr.cloneTestCase();
			    bp.waitForElement();
			    actual[56]=tr.selectallTestCase();
			    actual[57]=tr.cloneTestCase();
			    bp.waitForElement();
			    String testCaseNo21[]=new String[1];
			    testCaseNo21[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
			    actual[58]=epp.selectMultipleTestCaseFromGrid(testCaseNo21);
			    String testCaseNo211[]=new String[1];
			    testCaseNo211[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
			    actual[59]=epp.selectMultipleTestCaseFromGrid(testCaseNo211);
			    bp.waitForElement();
			    actual[60]=tr.cloneTestCase();
			    bp.waitForElement();
			    String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
	
               }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Launch TestPlanning and create a new cycle$")
		public void launch_TestPlanning_and_create_a_new_cycle() throws Throwable   {
	try
    {
		tp=new TestPlanningPage(driver);
		actual[61]=rp.clickOnTestPlanning();
		actual[62]=tp.clickOnAddTestCycleSymbol();
		String Cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 8, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		String Hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		actual[63]=tp.CreateCycle(Cycle, Build, Environment, Hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1,1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,5));
		actual[64]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[65]=tp.saveTestCycle();
	    bp.waitForElement();
    }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Add phase to created cycle and cancel the BulkAssignment$")
		public void add_phase_to_created_cycle_and_cancel_the_BulkAssignment() throws Throwable   {
	try
	{    
		String cycle1[]=new String [1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 8,0);
		actual[66]=tp.navigateToCycle(cycle1);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 0);
		actual[67]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		actual[68]=tp.cancelBulkAssign();
		bp.waitForElement();
		//rp.clickOnTestPlanning();
		tp.goBackToCycle();
		bp.waitForElement();
		 }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Launch TestPlanning create new cycle$")
		public void launch_TestPlanning_create_new_cycle() throws Throwable   {
	try
    {
	actual[69]=rp.clickOnTestPlanning();
	actual[70]=tp.clickOnAddTestCycleSymbol();
	String Cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 9, 0);
	String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
	String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
	String Hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
	actual[71]=tp.CreateCycle(Cycle, Build, Environment, Hide);
	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
	String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1,1);
	String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,2));
	String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
	String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
	String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,5));
	actual[72]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
	actual[73]=tp.saveTestCycle();
    bp.waitForElement();
	
	
    }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Add phase to new cycle and cancel the BulkAssignment$")
		public void add_phase_to_new_cycle_and_cancel_the_BulkAssignment() throws Throwable  {
	try
    {
		
		String cycle1[]=new String [1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 9,0);
		actual[74]=tp.navigateToCycle(cycle1);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 0);
		actual[75]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		actual[76]=tp.cancelBulkAssign();
	
      }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Assign testcases to Lead using BulkAssignment window$")
		public void assign_testcases_to_Lead_using_BulkAssignment_window() throws Throwable   {
	try
        { 
		 String Phase[]=new String[1];
         Phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12,0);
		 actual[77]=tp.navigateToCycle(Phase);
		 actual[78]=tp.bulkAssignTestcasesSelectedFolder();
		 bp.waitForElement();
		 String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		 String Check=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 0, 1);
		 actual[79]=tp.assignAllUnassigned(Assignee, Check);
		 bp.waitForElement();
		 //rp.clickOnTestPlanning();
		 tp.goBackToCycle();
		 bp.waitForElement();
	     }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@When("^Launch TestExecution and navigate to phase/Systems$")
		public void launch_TestExecution_and_navigate_to_phase_Systems() throws Throwable   {
	try
    {   
		
		ep=new ExecutionPage(driver);
		actual[80]=rp.clickOnTestExecution();
		bp.waitForElement();
		String cycle[]=new String[3];
		cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 9, 0);
		cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 12, 0);
		actual[81]=tp.navigateToCycle(cycle);
	   }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }
	 }

@Then("^Testcases count Assigned to Lead should be visible$")
		public void testcases_count_Assigned_to_Lead_should_be_visible() throws Throwable   {
	try
    {
	  actual[82]=tr.verifyPresentTestCase();
	  bp.waitForElement();
	  String System1=Excel_Lib.getData(INPUT_PATH_5, "Phase",12, 4);
	  actual[83]=tr.selectPhase(System1);
	 actual[84]=tr.verifyPresentTestCase();
	 String System2=Excel_Lib.getData(INPUT_PATH_5, "Phase",13, 4);
	  actual[85]=tr.selectPhase(System2);
	 actual[86]=tr.verifyPresentTestCase();
	 bp.waitForElement();
		tp=new TestPlanningPage(driver);
		String [] Release=new String[1];
		Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		tp.navigateToCycle(Release);
		bp.waitForElement();
		
	  for(int k=0;k<=actual.length-1;k++){
		  
		  System.out.println("Actual["+k+"]="+ actual[k] );
		  soft.assertEquals(actual[k], true);
	  }
	  soft.assertAll();
	  log.info("User successfully  the testcase");	
    }
catch (Exception e)
    {lb.getScreenShot(filname);
	e.printStackTrace();
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
    }
	  }
         }

