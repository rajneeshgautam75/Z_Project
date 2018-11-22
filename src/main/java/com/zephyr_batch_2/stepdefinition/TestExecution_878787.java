package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878787 extends LaunchBrowser 
{
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878787";
	
	boolean[] actual=new boolean[32];
	 SoftAssert soft=new SoftAssert();
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@Given("^User launch the test repository module$")
	public void user_launch_the_test_repository_module() throws Throwable {
	    
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
		{ lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User Creates a phase and add a test case$")
	public void user_Creates_a_phase_and_add_a_test_case() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,2);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,2);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.clickOnRelease(releaseName);
		actual[4]=tr.addNode(name, desc);
		bp.waitForElement();
		String Phase[]=new String[1];
		Phase[0]=name;
		tr.navigateToNode(releaseName, Phase);
		String phaseName=name;
		bp.waitForElement();
		actual[5]=tr.selectPhase(phaseName);
		bp.waitForElement();
		actual[6]=tr.addTestCase();
	
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

	@When("^enters the test step detail in test case$")
	public void enters_the_test_step_detail_in_test_case() throws Throwable {
	   try
	   {
		actual[7]=tr.clickDetailButton();
		String[] stepDetail = new String[3];
		int k=0;
		for(int i=19;i<=21;i++)
		{
			stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
			k++;
		}
		ctc=new CreateTestCasePage(driver);
		actual[8]=ctc.enterTestCaseStepDetail(stepDetail);
		bp.waitForElement();
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		tr.clickOnList();
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
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

	@When("^Launch test planning Module$")
	public void launch_test_planning_Module() throws Throwable {
		try
		{
		actual[9]=rp.clickOnTestPlanning();
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

	
	
	
	@When("^Creates a cycle and add created phase to the cycle and assign to lead$")
	public void creates_a_cycle_and_add_created_phase_to_the_cycle_and_assign_to_lead() throws Throwable {
	    try
	    {
		tp=new TestPlanningPage(driver);
		
		String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 5);
		String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 6);
		   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		   
		   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 6, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 6, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 6, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",6, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 6, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 6, 13));		
		
		    actual[10]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[11]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[12]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[13]=tp.saveTestCycle();
		    bp.waitForElement();
		    
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,5);
		    actual[14]=tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,2);
	       actual[11]=tp.addPhaseToCycle(phase);
	       bp.waitForElement();
	       actual[15]=tp.cancelBulkAssign();
	       
	       String[] cycle1=new String[1];
		    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,2);
		    actual[16]=tp.navigateToCycle(cycle1);
	       
		    int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		    actual[17]=bp.waitForElement();
		   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
		   actual[18]=tp.individualAssinTo(testcase, assignee);
		   
		   tp.goBackToCycle();
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

	@When("^Launch test Execution module$")
	public void launch_test_Execution_module() throws Throwable {
		try
		{
			
		
			
		rp=new ReleasePage(driver);
		bp=new BasePage();
		actual[19]=rp.clickOnTestExecution();
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

	@When("^naviagate to the phase under cycle$")
	public void naviagate_to_the_phase_under_cycle() throws Throwable {
		try
		{
		String[] nodes=new String[3];
		    nodes[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 6, 5);
		   
		    nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,2);		   
		    actual[20]=tp.navigateToCycle(nodes);
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

	@When("^view the executions assigned$")
	public void view_the_executions_assigned() throws Throwable {
	  try
	  {
		exp=new ExecutionPage(driver);
	   int[] testcase=new int[1];
	   testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
	   
	   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
	   actual[21]=exp.validateAssignedTestCase(testcase, assignee);
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

	@When("^change the execution status to pass$")
	public void change_the_execution_status_to_pass() throws Throwable {
		
		try
		{
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
		
		  int testcase=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		  actual[22]=exp.executeStatus(testcase, status);
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

	@Then("^execution status should be change to the pass$")
	public void execution_status_should_be_change_to_the_pass() throws Throwable {
		try
		{
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
		int[] testcase=new int[1];
		  testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		  actual[23]=exp.ValidateStatusOfTestCases(testcase, status);
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

	@When("^User Add attachment to testcase execution in text format$")
	public void user_Add_attachment_to_testcase_execution_in_text_format() throws Throwable {
	   try
	   {
		   String[] testCase=new String[1];
		   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
		   exp.selectMultipleTestCaseFromExecutionGrid(testCase);
		   bp.waitForElement();
		String filepath[]=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",1,1);
		
		tr.clickOnDetails();
		bp.waitForElement();
		
		actual[24]=exp.uploadAttachement(filepath);
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

	@When("^Add attachment to testcase execution in Excel format$")
	public void add_attachment_to_testcase_execution_in_Excel_format() throws Throwable {
		try
		{
		String filepath[]=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",2,1);
		actual[25]=exp.uploadAttachement(filepath);
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

	@When("^attachment to testcase execution in word document format$")
	public void attachment_to_testcase_execution_in_word_document_format() throws Throwable {
		try
		{
		String filepath[]=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",3,1);
		actual[26]=exp.uploadAttachement(filepath);
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

	@When("^Attachment to testcase execution in image format \\(jpg/bmp/gif\\)$")
	public void attachment_to_testcase_execution_in_image_format_jpg_bmp_gif() throws Throwable {
		try
		{
		String filepath[]=new String[1];
		filepath[0]=Excel_Lib.getData(INPUT_PATH_2,"Files",4,1);
		actual[27]=exp.uploadAttachement(filepath);
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

	@Then("^attachement\\(text/Excel/word/jpg\\) should be attached to the testcase execution$")
	public void attachement_text_Excel_word_jpg_should_be_attached_to_the_testcase_execution() throws Throwable {
	  try
	  {
		String textFile=Excel_Lib.getData(INPUT_PATH_2,"Files",1,0);
	    String excelFile=Excel_Lib.getData(INPUT_PATH_2,"Files",2,0);
	    String wordFile=Excel_Lib.getData(INPUT_PATH_2,"Files",3,0);
	    String picFile=Excel_Lib.getData(INPUT_PATH_2,"Files",4,0);
	    actual[28]=exp.validateAttachement(textFile);
	    actual[29]=exp.validateAttachement(excelFile);
	    actual[30]=exp.validateAttachement(wordFile);
	    actual[31]=exp.validateAttachement(picFile);
	    
		bp.waitForElement();
		tp=new TestPlanningPage(driver);
		String [] Release=new String[1];
		Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		tr.clickOnList();
		tp.navigateToCycle(Release);
		bp.waitForElement();
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	System.out.println(actual[k]);
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
		
	
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
}