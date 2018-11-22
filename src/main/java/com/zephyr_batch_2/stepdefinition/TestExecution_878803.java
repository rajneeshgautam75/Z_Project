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

public class TestExecution_878803 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878803";
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	CreateTestCasePage ctc;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	ExportPage epp;
	boolean actual[]=new boolean[78];
	SoftAssert soft=new SoftAssert();
	
	 @Given("^User is in TestRepository page of Normal Project$")
	public void user_is_in_TestRepository_page_of_Normal_Project() throws Throwable {
		try {
			 String ProjectName=Property_Lib.getPropertyValue(CONFIG_PATH+ CONFIG_FILE_TPE,"Normal_Project_1");
			 String Release =Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 pp=new ProjectPage(driver);
		     pp.clickOnLogout();
		     bp.waitForElement();
		     lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     bp.waitForElement();
			 actual[0]=pp.selectProject(ProjectName);
			 actual[1]=pp.selectRelease(Release);
			 rp=new ReleasePage(driver);
			 actual[2]=rp.clickOnTestRep();
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

	@When("^Creates new phase and add testcases with teststeps to phase$")
	public void creates_new_phase_and_add_testcases_with_teststeps_to_phase() throws Throwable {
try {
	    tr=new TestRepositoryPage(driver);
	    ctc=new CreateTestCasePage(driver);
	    epp=new ExportPage(driver);
	    bp=new BasePage();
	    String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1,0);
	    actual[3]=tr.doubleClickOnRelease(Release);
	    bp.waitForElement();
	    String Phase_N=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 0);
	    String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 11, 1);
	    actual[4]=tr.addNode(Phase_N, Desc);
	    actual[5]=bp.waitForElement();
		String Phase[]=new String[1];
		Phase[0]=Phase_N;
		tr.navigateToNode(Release, Phase);
		bp.waitForElement();
		actual[6]=tr.addTestCase();
		actual[7]=bp.waitForElement();
		actual[8]=tr.clickOnDetails();
		bp.waitForElement();
		String[] stepDetails1=new String[3];
		stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 0);
		stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 1);
		stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 1, 2);
		actual[9]=ctc.enterTestCaseStepDetail(stepDetails1);
		bp.waitForElement();
		actual[10]=tr.clickOnList();
		bp.waitForElement();
		actual[11]=tr.addTestCase();
		bp.waitForElement();
		String []Testcase2=new String[1];
		Testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5,"TestPlanning", 1, 0));
		actual[12]=epp.selectMultipleTestCaseFromGrid(Testcase2);
		bp.waitForElement();
		actual[13]=tr.clickOnDetails();	
		bp.waitForElement();
		String[] stepDetails2=new String[3];
		stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 0);
		stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 1);
		stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 2, 2);
		actual[14]=ctc.enterTestCaseStepDetail(stepDetails2);
		bp.waitForElement();
		actual[15]=tr.clickOnList();
		bp.waitForElement();
		actual[16]=epp.selectMultipleTestCaseFromGrid(Testcase2);
		bp.waitForElement();
		actual[17]=tr.addTestCase();
		bp.waitForElement();
		String []Testcase3=new String[1];
		Testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 2, 0));
		actual[18]=epp.selectMultipleTestCaseFromGrid(Testcase3);
		bp.waitForElement();
		actual[19]=tr.clickOnDetails();
		bp.waitForElement();
		String[] stepDetails3=new String[3];
		stepDetails3[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 0);
		stepDetails3[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 1);
		stepDetails3[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 3, 2);
		actual[20]=ctc.enterTestCaseStepDetail(stepDetails3);
		bp.waitForElement();
		actual[21]=tr.clickOnList();
		bp.waitForElement();
		actual[22]=epp.selectMultipleTestCaseFromGrid(Testcase3);
		bp.waitForElement();
		actual[23]=tr.addTestCase();
		bp.waitForElement();
		String []Testcase4=new String[1];
		Testcase4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestPlanning", 3, 0));
		actual[24]=epp.selectMultipleTestCaseFromGrid(Testcase4);
		bp.waitForElement();
		actual[25]=tr.clickOnDetails();
		bp.waitForElement();
		String[] stepDetails4=new String[3];
		stepDetails4[0]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 0);
		stepDetails4[1]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 1);
		stepDetails4[2]=Excel_Lib.getData(INPUT_PATH_5, "stepDetails", 4, 2);
		actual[26]=ctc.enterTestCaseStepDetail(stepDetails4);
		bp.waitForElement();
		actual[27]=tr.clickOnList();
		actual[28]=bp.waitForElement();
		 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
		 }
		catch (Exception e)
         {lb.getScreenShot(filename);
		   e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		  }
	      }

	@When("^Launch TestPlanning page and create new cycle$")
	public void launch_TestPlanning_page_and_create_new_cycle() throws Throwable {
    try 
       {
	    tp=new TestPlanningPage(driver);
	    actual[29]=rp.clickOnTestPlanning();
	    actual[1]=tp.clickOnAddTestCycleSymbol();
	    String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 7, 0);
	    String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
	    String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
	    String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100,100);
	    actual[30]=tp.CreateCycle(cycle, Build, Environment, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
		actual[31]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[32]=tp.saveTestCycle();
		bp.waitForElement();
		  }
		catch (Exception e)
         {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@When("^add phase to cycle and assign testcases to Anyone$")
	public void add_phase_to_cycle_and_assign_testcases_to_Anyone() throws Throwable {
try 
     { 
	   String cycleName[]=new String[1];
	   cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 7, 0);
	   actual[33]=tp.navigateToCycle(cycleName);
	   String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 11,0);
	   actual[34]=tp.addPhaseToCycle(Phase);
	   String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 2, 0);
	   actual[35]=tp.bulkAssignment(Bulk_type);
	   bp.waitForElement();
       tp.goBackToCycle();
		  bp.waitForElement();
	   actual[36]=pp.clickOnLogout();
	   }
		catch (Exception e)
        {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@When("^Login as a Tester and Launch Test Execuion Page and view testcases assigned to Anyone$")
	public void login_as_a_Tester_and_Launch_Test_Execuion_Page_and_view_testcases_assigned_to_Anyone() throws Throwable {
try 
     { 
	     lp=new LoginPage(driver);
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
         String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
         actual[37]=lp.enterUname(Uname);
         actual[38]=lp.enterPass(Pass);
         actual[39]=lp.clickOnLogin();
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH +CONFIG_FILE_TPE ,"Normal_Project_1");
	     String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
	     pp=new ProjectPage(driver);
	     bp=new BasePage();
	     tp=new TestPlanningPage(driver);
	     rp=new ReleasePage(driver);
	     actual[40]=pp.selectProject(projectName);
	     bp.waitForElement();
	     actual[41]=pp.selectRelease(Release);
	     ep=new ExecutionPage(driver);
	     actual[42]=rp.clickOnTestExecution();
	     bp.waitForElement();
	     String[] cycleName=new String[3];
		 cycleName[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases",1 ,0 );
	     cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",7,0 );
	     cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",11,0 );
		 actual[43]=tp.navigateToCycle(cycleName);
		 bp.waitForElement();
         }
		catch (Exception e)
           {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		   }
	       }

	@When("^As a Tester change the Execution Status of First testcase to Pass$")
	public void as_a_Tester_change_the_Execution_Status_of_First_testcase_to_Pass() throws Throwable {
try
      {
	    String testCaseNo1[]=new String[1];
	    testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,3));
        actual[44]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo1);
        bp.waitForElement();
        int testcase1 []=new int[1];
        testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3);
        String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
        actual[45]=ep.changeStatusOfTestCases(testcase1, status1);
        bp.waitForElement();
       }
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }
  @Then("^Execution Status of first testcase should be changed to Pass$")
	public void execution_Status_of_first_testcase_should_be_changed_to_Pass() throws Throwable {
try {
	String testCaseNo1[]=new String[1];
	   testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,3));
    actual[46]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo1);
    bp.waitForElement();
    int testcase1 []=new int[1];
    testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3);
    String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
    actual[47]=ep.ValidateStatusOfTestCases(testcase1, status1);
    bp.waitForElement();
	 }
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@When("^Change the Execution Status of same testcase to Fail$")
	public void change_the_Execution_Status_of_same_testcase_to_Fail() throws Throwable {
try 
   {
	  String testCaseNo1[]=new String[1];
	  testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,3));
      actual[48]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo1);
      bp.waitForElement();
      int testcase1 []=new int[1];
      testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3);
      String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
      actual[49]=ep.changeStatusOfTestCases(testcase1, status1);
      bp.waitForElement();
		}
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@Then("^Execution Status of testcase should be changed to Fail$")
	public void execution_Status_of_testcase_should_be_changed_to_Fail() throws Throwable {
try {
	   String testCaseNo1[]=new String[1];
	   testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1,3));
       actual[50]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo1);
       bp.waitForElement();
       int testcase1 []=new int[1];
       testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 3);
       String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
       actual[51]=ep.ValidateStatusOfTestCases(testcase1, status1);
       actual[52]=bp.waitForElement();
			}
		catch (Exception e)
          {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@When("^As a Tester change the Execution Status of Second testcase to Fail$")
	public void as_a_Tester_change_the_Execution_Status_of_Second_testcase_to_Fail() throws Throwable {
try
    {
	   String testCaseNo2[]=new String[1];
	   testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,3));
       actual[53]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo2);
       bp.waitForElement();
       int testcase2 []=new int[1];
       testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3);
       String status2=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
       actual[54]=ep.changeStatusOfTestCases(testcase2, status2);
       bp.waitForElement();
		}
		catch (Exception e)
       {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@Then("^Execution Status of Second testcase should be changed to Fail$")
	public void execution_Status_of_Second_testcase_should_be_changed_to_Fail() throws Throwable {
try {
	   String testCaseNo[]=new String[1];
	   testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,3));
       actual[55]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
       bp.waitForElement();
       int testcase1 []=new int[1];
       testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3);
       String status1=Excel_Lib.getData(INPUT_PATH_5, "Execution", 2, 2);
       actual[56]=ep.ValidateStatusOfTestCases(testcase1, status1);
       bp.waitForElement();
			}
		catch (Exception e)
          {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }
 @When("^Change the Execution Status of same testcase to Pass$")
	public void change_the_Execution_Status_of_same_testcase_to_Pass() throws Throwable {
try 
    {
	  String testCaseNo[]=new String[1];
  	  testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,3));
      actual[57]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
      bp.waitForElement();
      int testcase2 []=new int[1];
      testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3);
      String status2=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
      actual[58]=ep.changeStatusOfTestCases(testcase2, status2);
      bp.waitForElement();
	}
		catch (Exception e)
     {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@Then("^Execution Status of testcase should be changed to Pass$")
	public void execution_Status_of_testcase_should_be_changed_to_Pass() throws Throwable {
try 
   {
	    String testCaseNo[]=new String[1];
	    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2,3));
        actual[59]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
        bp.waitForElement();
        int testcase2 []=new int[1];
        testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 3);
        String status2=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
        actual[60]=ep.ValidateStatusOfTestCases(testcase2, status2);
        bp.waitForElement();
		}
		catch (Exception e)
            {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@When("^As a Tester change the Execution Status of Third testcase to WIP$")
	public void as_a_Tester_change_the_Execution_Status_of_Third_testcase_to_WIP() throws Throwable {
try {
	   String testCaseNo3[]=new String[1];
	   testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3,3));
       actual[61]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo3);
       bp.waitForElement();
       int testcase3 []=new int[1];
       testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3);
       String status3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
       actual[62]=ep.changeStatusOfTestCases(testcase3, status3);
       bp.waitForElement();
		}
		catch (Exception e)
         {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@Then("^Execution Status of Third testcase should be changed to WIP$")
	public void execution_Status_of_Third_testcase_should_be_changed_to_WIP() throws Throwable {
try {
	   String testCaseNo3[]=new String[1];
	   testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3,3));
       actual[63]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo3);
       bp.waitForElement();
       int testcase3 []=new int[1];
       testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3);
       String status3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
       actual[64]=ep.ValidateStatusOfTestCases(testcase3, status3);
       bp.waitForElement();
		}
		catch (Exception e)
        {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@When("^Change the Execution Status of same testcase to Blocked$")
	public void change_the_Execution_Status_of_same_testcase_to_Blocked() throws Throwable {
try {
	  String testCaseNo3[]=new String[1];
	  testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3,3));
      actual[65]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo3);
      bp.waitForElement();
      int testcase3 []=new int[1];
      testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3);
      String status3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
      actual[66]=ep.changeStatusOfTestCases(testcase3, status3);
      bp.waitForElement();
		}
		catch (Exception e)
        {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    }

	@Then("^Execution Status of testcase should be changed to Blocked$")
	public void execution_Status_of_testcase_should_be_changed_to_Blocked() throws Throwable {
try {
	   String testCaseNo3[]=new String[1];
	   testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,3));
       actual[67]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo3);
       bp.waitForElement();
       int testcase3 []=new int[1];
       testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 3, 3);
       String status3=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
       actual[68]=ep.ValidateStatusOfTestCases(testcase3, status3);
      bp.waitForElement();
		}
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   }

	@When("^As a Tester change the Execution Status of Fourth testcase to Blocked$")
	public void as_a_Tester_change_the_Execution_Status_of_Fourth_testcase_to_Blocked() throws Throwable {
try    
       {
	    String testCaseNo4[]=new String[1];
	    testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,3));
        actual[69]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo4);
        bp.waitForElement();
        int testcase4 []=new int[1];
        testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3);
        String status4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
        actual[70]=ep.changeStatusOfTestCases(testcase4, status4);
         }
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   
	}

	@Then("^Execution Status of first testcase should be changed to Blocked$")
	public void execution_Status_of_first_testcase_should_be_changed_to_Blocked() throws Throwable {
try {
	   String testCaseNo4[]=new String[1];
	   testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,3));
       actual[71]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo4);
       bp.waitForElement();
       int testcase4 []=new int[1];
       testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3);
      String status4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 4, 2);
      actual[72]=ep.ValidateStatusOfTestCases(testcase4, status4);
      bp.waitForElement();
			}
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   
	}

	@When("^Change the Execution Status of same testcase to WIP$")
	public void change_the_Execution_Status_of_same_testcase_to_WIP() throws Throwable {
try {
	   String testCaseNo4[]=new String[1];
	   testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,3));
       actual[73]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo4);
       bp.waitForElement();
      int testcase4 []=new int[1];
      testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3);
      String status4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
      actual[74]=ep.changeStatusOfTestCases(testcase4, status4);
      bp.waitForElement();
			
		}
		catch (Exception e){lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	    
	}

	@Then("^Execution Status of testcase should be changed to WIP$")
	public void execution_Status_of_testcase_should_be_changed_to_WIP() throws Throwable {
try {
	
	 String testCaseNo4[]=new String[1];
	  testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4,3));
      actual[75]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo4);
      bp.waitForElement();
      int testcase4 []=new int[1];
      testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 4, 3);
      String status4=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3, 2);
      actual[76]=ep.ValidateStatusOfTestCases(testcase4, status4);
      actual[77]=bp.waitForElement();
      //actual[77]=pp.clickOnLogout();
      //pp.closeBrowser();
      for (int k=0;k<=actual.length-1;k++)
       {
         soft.assertEquals(actual[k], true);	
         }
      soft.assertAll();
	  log.info("User successfully  the testcase");	
		}
		catch (Exception e)
           {lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			}
	        }
	        }
