package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878799 extends LaunchBrowser
{

	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878799";
	boolean[] actual = new boolean[23];
	SoftAssert soft = new SoftAssert();
	
	String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@Given("^User is in the test repository module$")
	public void user_is_in_the_test_repository_module() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);  
		
		pp=new ProjectPage(driver);
		 bp=new BasePage();  
		   
		actual[0]=pp.selectProject(projectName);
		actual[1]=pp.selectRelease(releaseName);
	    rp=new ReleasePage(driver);
	    actual[2]=rp.clickOnTestRep();
		
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

	@When("^User creates a phase and add testcase$")
	public void user_creates_a_phase_and_add_testcase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,2);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,2);
		actual[4]=tr.addNode(name, desc);
		
		bp.waitForElement();
		String Phase[]=new String[1];
		Phase[0]=name;
		actual[5]=tr.navigateToNode(releaseName, Phase);
		bp.waitForElement();
		
		actual[6]=tr.addTestCase();
		
		   
		
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

	@When("^enters the testcase step details in testcase$")
	public void enters_the_testcase_step_details_in_testcase() throws Throwable {
	   
		try
		{
		actual[7]=tr.clickDetailButton();
		ctc=new CreateTestCasePage(driver);
		String[] stepDetail=new String[3];
		int k=0;
		for(int i=19;i<=21;i++)
		{
			stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
			k++;
		}
		
		actual[8]=ctc.enterTestCaseStepDetail(stepDetail);
		bp.waitForElement();
		
		
		tr.clickOnList();
		bp.waitForElement();
		tr.doubleClickOnRelease(Release);
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

	@When("^create a new cycle and add created phase to the cycle and assign to lead$")
	public void create_a_new_cycle_and_add_created_phase_to_the_cycle_and_assign_to_lead() throws Throwable {
		
		try
		{
		  String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 7, 5);
		  String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 7, 6);
		   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 7, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		    String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 7, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 7, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 7, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",7, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 7, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 7, 13));		
		    tp=new TestPlanningPage(driver);
		    actual[9]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[10]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[11]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[12]=tp.saveTestCycle();
		    bp.waitForElement();
		    
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,5);
		    actual[13]=tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,2);
	       actual[14]=tp.addPhaseToCycle(phase);
	       bp.waitForElement();
	       actual[15]=tp.cancelBulkAssign();
	       bp.waitForElement();
	       
	       String[] phase1=new String[1];
	       phase1[0]=phase;
	       actual[16]=tp.navigateToCycle(phase1);
		    
	       int[] testcase=new int[1];
		   testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
			actual[17]=tp.individualAssinTo(testcase, assignee);
			
		    bp.waitForElement();
		    tp.goBackToCycle();
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

	@When("^navigate to the phase$")
	public void navigate_to_the_phase() throws Throwable {
	  
		try
		{
		String[] nodes=new String[2];
		String release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,5);
		nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,2);

		actual[18]=tr.navigateToNode(release,nodes);
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

	@When("^Add Attachment to a test case that contains special characters in the file name$")
	public void add_Attachment_to_a_test_case_that_contains_special_characters_in_the_file_name() throws Throwable {
	   try
	   {
		exp=new ExecutionPage(driver);
		String[] testCase=new String[1];
		testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
		exp.selectMultipleTestCaseFromExecutionGrid(testCase);
		bp.waitForElement();
		tr.clickDetailButton();
		String[] filepath=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",5,1);
		actual[19]=exp.uploadAttachement(filepath);
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

	@When("^Add Attachment to a test case that contains international characters in the file name$")
	public void add_Attachment_to_a_test_case_that_contains_international_characters_in_the_file_name() throws Throwable {
		try
		{
		String[] filepath=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",6,1);
		actual[20]=exp.uploadAttachement(filepath);
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

	@Then("^Attachements should be attached to the testcase$")
	public void attachements_should_be_attached_to_the_testcase() throws Throwable {
		try
		{
		String filepath1=Excel_Lib.getData(INPUT_PATH_2,"Files",5,0);
		String filepath2=Excel_Lib.getData(INPUT_PATH_2,"Files",6,0);
		actual[21]=exp.validateAttachement(filepath1);
		actual[22]=exp.validateAttachement(filepath2);
		bp.waitForElement();
		tr.clickOnList();
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
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
		
	}
}
