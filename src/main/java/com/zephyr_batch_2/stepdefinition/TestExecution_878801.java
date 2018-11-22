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

public class TestExecution_878801 extends LaunchBrowser {
	    LaunchBrowser lb=new LaunchBrowser();
	    LoginPage lp;
	    BasePage bp;
	    CreateTestCasePage cp;
	    ExportPage epp;
	    ExecutionPage ep;

	    ProjectPage pp;
	    ReleasePage rp;
	    TestRepositoryPage tr;
	    TestPlanningPage tp;
	    String ad="TestExecution_878801";
	    boolean actual[]=new boolean[110];
	    SoftAssert soft=new SoftAssert();
	    
   @Given("^User is in Test Repository page of normal project$")
	public void user_is_in_Test_Repository_page_of_normal_project() throws Throwable {
	   try {
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH +CONFIG_FILE_TPE ,"Normal_Project_1");
		   String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(Release);
		   rp=new ReleasePage(driver);
		   actual[2]=rp.clickOnTestRep();
		    actual[3]=bp.waitForElement();
		   }
	   catch(Exception e)
	        {
		  
		   lb.getScreenShot(ad);
		   e.printStackTrace();
		   driver.close();
		   Relogin_TPE rl=new Relogin_TPE();
		   rl.reLogin();
		   throw e;
	        }
	       }

	@When("^creates new phase and adds testcases with teststeps$")
	public void creates_new_phase_and_adds_testcases_with_teststeps() throws Throwable {
		try{
			epp=new ExportPage(driver);
			cp=new CreateTestCasePage(driver);
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[4]=tr.doubleClickOnRelease(Release);
			String Phase_N=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 10,0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 10,1);
			bp.waitForElement();
			actual[5]=tr.addNode(Phase_N,Desc);
			actual[6]=bp.waitForElement();
			String Phase[]=new String[1];
			Phase[0]=Phase_N;
			tr.navigateToNode(Release, Phase);
			actual[7]=bp.waitForElement();
			actual[8]=tr.addTestCase();
			bp.waitForElement();
			actual[9]=tr.clickOnDetails();
			bp.waitForElement();
			String[] stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
			actual[10]=cp.enterTestCaseStepDetail(stepDetails1);
			actual[11]=bp.waitForElement();
			actual[12]=tr.clickOnList();
			bp.waitForElement();
			actual[13]=tr.addTestCase();
			bp.waitForElement();
			String []Testcase2=new String[1];
			Testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestPlanning", 1, 0));
			actual[14]=epp.selectMultipleTestCaseFromGrid(Testcase2);
			actual[15]=bp.waitForElement();
			actual[16]=tr.clickOnDetails();
			bp.waitForElement();
			String[] stepDetails2=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
			actual[17]=cp.enterTestCaseStepDetail(stepDetails2);
			actual[18]=bp.waitForElement();
			actual[19]=tr.clickOnList();
			bp.waitForElement();
			actual[20]=epp.selectMultipleTestCaseFromGrid(Testcase2);
			actual[21]=bp.waitForElement();
			actual[22]=tr.addTestCase();
			bp.waitForElement();
			String []Testcase3=new String[1];
			Testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
			actual[23]=epp.selectMultipleTestCaseFromGrid(Testcase3);
			actual[24]=bp.waitForElement();
			actual[25]=tr.clickOnDetails();
			actual[26]=bp.waitForElement();
			String[] stepDetails3=new String[3];
			stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
			stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
			stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
			actual[27]=cp.enterTestCaseStepDetail(stepDetails3);
			actual[28]=bp.waitForElement();
			actual[29]=tr.clickOnList();
			bp.waitForElement();
			actual[30]=epp.selectMultipleTestCaseFromGrid(Testcase3);
			actual[31]=bp.waitForElement();
			actual[32]=tr.addTestCase();
			String []Testcase4=new String[1];
			Testcase4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
			actual[33]=epp.selectMultipleTestCaseFromGrid(Testcase4);
			actual[34]=bp.waitForElement();
			actual[35]=tr.clickOnDetails();
			actual[36]=bp.waitForElement();
			String[] stepDetails4=new String[3];
			stepDetails4[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
			stepDetails4[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
			stepDetails4[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
			actual[37]=cp.enterTestCaseStepDetail(stepDetails4);
			actual[38]=bp.waitForElement();
			actual[39]=tr.clickOnList();
			actual[40]=bp.waitForElement();
			actual[41]=epp.selectMultipleTestCaseFromGrid(Testcase4);
			actual[42]=bp.waitForElement();
			actual[43]=tr.addTestCase();
			bp.waitForElement();
			String []Testcase5=new String[1];
			Testcase5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 4, 0));
			actual[44]=epp.selectMultipleTestCaseFromGrid(Testcase5);
			actual[45]=bp.waitForElement();
			actual[46]=tr.clickOnDetails();
			actual[47]=bp.waitForElement();
			String[] stepDetails5=new String[3];
			stepDetails5[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 5, 0);
			stepDetails5[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 5, 1);
			stepDetails5[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 5, 2);
			actual[48]=cp.enterTestCaseStepDetail(stepDetails5);
			actual[49]=bp.waitForElement();
			actual[50]=tr.clickOnList();
			actual[51]=bp.waitForElement();
			actual[52]=epp.selectMultipleTestCaseFromGrid(Testcase5);
			actual[53]=bp.waitForElement();
			String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tr.doubleClickOnRelease(releaseName);
		    bp.waitForElement();
			}
		catch(Exception e){
			
			 lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   	}

	@When("^Launch TestPlanning Page and create new cycle$")
	public void launch_TestPlanning_Page_and_create_new_cycle() throws Throwable {
		try {
			tp=new TestPlanningPage(driver);
			actual[54]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[55]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 6, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[56]=tp.CreateCycle(cycle, Build, Environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[57]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[58]=tp.saveTestCycle();
			actual[59]=bp.waitForElement();
		    }
		catch (Exception e)
		{
			 lb.getScreenShot(ad);
		e.printStackTrace();	
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}
	    }

	@When("^add phase to created cycle$")
	public void add_phase_to_created_cycle() throws Throwable {
		try {
			 tp=new TestPlanningPage(driver);
			actual[60]=rp.clickOnTestPlanning();
			 String [] cycle =new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 6, 0);
			actual[61]=tp.navigateToCycle(cycle);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 10,0);
			actual[62]=tp.addPhaseToCycle(Phase);
			actual[63]=bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			actual[64]=tp.bulkAssignment(Bulk_type);
			actual[65]=bp.waitForElement();
		   }
		catch(Exception e){
			 lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@When("^Assign few testcases to Tester and few testcases to Anyone$")
	public void assign_few_testcases_to_Tester_and_few_testcases_to_Anyone() throws Throwable {
		try {
			String Phase[]=new String [1];
			Phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 10,0);
			actual[66]=tp.navigateToCycle(Phase);
			int []tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0);
			actual[67]=tp.selectSingleMultipleTestcase(tcNo1);
			int []testcaseNo1=new int[1];
			testcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0,0);
		    String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    bp.waitForElement();
		    actual[68]=tp.individualAssinTo(testcaseNo1, Assignee1);
	         int []tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0);
			actual[69]=tp.selectSingleMultipleTestcase(tcNo2);
			int []testcaseNo2=new int[1];
			testcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1,0);
		   String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		   bp.waitForElement();
	    	actual[70]=tp.individualAssinTo(testcaseNo2, Assignee2);
	       int []tcNo3=new int[1];
		    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0);
		   actual[71]=tp.selectSingleMultipleTestcase(tcNo3);
		   int []testcaseNo3=new int[1];
		   testcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2,0);
	       String Assignee3=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 1, 1);
	       bp.waitForElement();
	       actual[72]=tp.individualAssinTo(testcaseNo3, Assignee3);
	       int []tcNo4=new int[1];
		   tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0);
		   actual[73]=tp.selectSingleMultipleTestcase(tcNo4);
		   int []testcaseNo4=new int[1];
		   testcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3,0);
	       String Assignee4=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 1, 1);
	       bp.waitForElement();
	       actual[74]=tp.individualAssinTo(testcaseNo4, Assignee4);
	       actual[75]=bp.waitForElement();
		    }
		catch(Exception e){
		
			 lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		}

	@Then("^Few testcases should be assigned to Tester and Anyone in TestPlanning page$")
	public void few_testcases_should_be_assigned_to_Tester_and_Anyone_in_TestPlanning_page() throws Throwable {
		try {
			String [] Phase=new String[1];
			 Phase[0] =UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 10, 0);
			actual[76]=tp.navigateToCycle(Phase);
			int []tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0, 0);
			actual[77]=tp.selectSingleMultipleTestcase(tcNo1);
			int []testcaseNo1=new int[1];
			testcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 0,0);
		    String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    actual[78]=tp.validateAllAssigned(testcaseNo1, Assignee1);
			int []tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1, 0);
			actual[79]=tp.selectSingleMultipleTestcase(tcNo2);
			int []testcaseNo2=new int[1];
			testcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 1,0);
		    String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    actual[80]=tp.validateAllAssigned(testcaseNo2, Assignee2);
		    int []tcNo3=new int[1];
		    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0);
		    actual[81]=tp.selectSingleMultipleTestcase(tcNo3);
		    int []testcaseNo3=new int[1];
		    testcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2,0);
	        String Assignee3=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 1, 1);
	        actual[82]=tp.validateAllAssigned(testcaseNo3, Assignee3);
	        int []tcNo4=new int[1];
		    tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0);
		    actual[83]=tp.selectSingleMultipleTestcase(tcNo4);
		    int []testcaseNo4=new int[1];
		    testcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3,0);
	        String Assignee4=Excel_Lib.getData(INPUT_PATH_5, "TestPlanning", 1, 1);
	        actual[84]=tp.validateAllAssigned(testcaseNo4, Assignee4);
	        actual[85]=bp.waitForElement();
	        int []tcNo5=new int[1];
	        tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 4, 0);
	        actual[86]=tp.selectSingleMultipleTestcase(tcNo5);
	        int []testcaseNo5=new int[1];
	        testcaseNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3,0);
            String Assignee5=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
            actual[87]=tp.validateAllAssigned(testcaseNo5, Assignee5);
            actual[88]=bp.waitForElement();
            tp.goBackToCycle();
            bp.waitForElement();
	        actual[89]=pp.clickOnLogout();
	        }
		
		catch (Exception e) {
			 lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@When("^Login as Tester and Launch Test Execution Page and view testcases$")
	public void login_as_Tester_and_Launch_Test_Execution_Page_and_view_testcases() throws Throwable {
	      try {
	    	 
	         lp=new LoginPage(driver);
	         String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
	         String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
	         actual[90]=lp.enterUname(Uname);
	         actual[91]=lp.enterPass(Pass);
	         actual[92]=lp.clickOnLogin();
	         bp.waitForElement();
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH +CONFIG_FILE_TPE ,"Normal_Project_1");
			   String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   tp=new TestPlanningPage(driver);
			   ep=new ExecutionPage(driver);
			   rp=new ReleasePage(driver);
			   actual[93]=pp.selectProject(projectName);
			   actual[94]= bp.waitForElement();
			   actual[95]=pp.selectRelease(Release);
			   bp.waitForElement();
			   actual[96]=rp.clickOnTestExecution();
			   actual[97]=bp.waitForElement();
			   String[] cycleName=new String[3];
			   cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1 ,0 );
			   cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",6,0 );
			   cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",10,0 );
			   actual[98]=tp.navigateToCycle(cycleName);
			   actual[99]=bp.waitForElement();
			     }
		   catch(Exception e)
		        {
			   e.printStackTrace();
			   lb.getScreenShot(ad);
			   driver.close();
			   Relogin_TPE rl=new Relogin_TPE();
			   rl.reLogin();
			   throw e;
		        }
	            }

	@Then("^testcases assigned to Tester and Anyone should be visible for Tester$")
	public void testcases_assigned_to_Tester_and_Anyone_should_be_visible_for_Tester() throws Throwable {
		try {
			 String [] tcNo1=new String[1];
			tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			actual[100]=ep.selectMultipleTestCaseFromExecutionGrid(tcNo1); 
			int []testcaseNo1=new int[1];
			testcaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,0);
		    String Assignee1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		    actual[101]=ep.validateAssignedTestCase(testcaseNo1, Assignee1); 
		    actual[102]=bp.waitForElement();
		    String [] tcNo2=new String[1];
		   tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
		   actual[103]=ep.selectMultipleTestCaseFromExecutionGrid(tcNo2); 
		   int []testcaseNo2=new int[1];
			testcaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,0);
		   String Assignee2=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		   actual[104]=ep.validateAssignedTestCase(testcaseNo2, Assignee2);
		   String [] tcNo3=new String[1];
		   tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 0));
		   actual[105]=ep.selectMultipleTestCaseFromExecutionGrid(tcNo3); 
		   int []testcaseNo3=new int[1];
		   testcaseNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3,0);
	       String Assignee3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 4);
	       actual[106]=ep.validateAssignedTestCase(testcaseNo3, Assignee3);
	 
	   String [] tcNo4=new String[1];
	   tcNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 0));
	   actual[107]=ep.selectMultipleTestCaseFromExecutionGrid(tcNo1); 
	   int []testcaseNo4=new int[1];
	   testcaseNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,0);
	   String Assignee4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 4);
	   actual[108]=ep.validateAssignedTestCase(testcaseNo4, Assignee4); 
	   actual[109]=bp.waitForElement();
	   bp.waitForElement();
	   for(int k=0;k<=actual.length-1;k++)
	     {
			
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();		
		}
		catch(Exception e){
			 lb.getScreenShot(ad);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			}
	    }
	    }
