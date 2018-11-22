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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878791 extends LaunchBrowser 
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
	String filename="TestExecution_878791";
	
	
	String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	boolean[] actual=new boolean[22];
	 SoftAssert soft=new SoftAssert();
	 
	@When("^User Creates a Phase and Add testcase to the phase$")
	public void user_Creates_a_Phase_and_Add_testcase_to_the_phase() throws Throwable {
	  try
	  {
		bp=new BasePage();
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		
		tr=new TestRepositoryPage(driver);
		actual[0]=tr.doubleClickOnRelease(releaseName);
		
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,2);
		 actual[1]=tr.addNode(name, name);
		 bp.waitForElement();
			String [] Phase =new String[1];
			Phase[0]=name;
			actual[2]=tr.navigateToNode(releaseName, Phase);
			bp.waitForElement();
		
		  actual[3]=tr.addTestCase();
		  bp.waitForElement();
		  }
		//tr.addNode(Name, Desc)}
		  catch(Exception e)
		  {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		  }
	}

	
	
	
	@When("^enters the step details$")
	public void enters_the_step_details() throws Throwable {
		  try
		  {
			  actual[4]=tr.clickDetailButton();
		   ctc=new CreateTestCasePage(driver);
		   String testCaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,14);
		   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,15);
		   actual[5]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
		   
		   String[] stepdetail=new String[3];
		   int l=0;
		   for(int i=19;i<=21;i++)
		   {
			   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
			   l++;
		   }
		  
		   actual[6]=ctc.enterTestCaseStepDetail(stepdetail);
		   bp.waitForElement();
		   
		   
		   tr.clickOnList();
		   bp.waitForElement();
		   tr.doubleClickOnRelease(Release);
		   bp.waitForElement();   }
		   
		   catch(Exception e)
			  {
				lb.getScreenShot(filename);
				e.printStackTrace();
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			  }
		   
	}

	@When("^creates a cycle and add phase to cycle and assign to lead$")
	public void creates_a_cycle_and_add_phase_to_cycle_and_assign_to_lead() throws Throwable {
		  try
		  {
		tp=new TestPlanningPage(driver);
		 
	    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 2, 5);
		String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 2, 6);
		   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 2, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		   
		   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 2, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 2, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 2, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",2, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 2, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 2, 13));		
		
		    actual[7]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[8]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[9]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[10]=tp.saveTestCycle();
		    bp.waitForElement();
		    
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,5);
		    tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,2);
	       actual[11]=tp.addPhaseToCycle(phase);
	       String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,22);
	       actual[12]=tp.bulkAssignment(bulkType);
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
			  }
	      
	       
	}
	@Then("^test case should be assign to lead$")
	public void test_case_should_be_assign_to_lead() throws Throwable {
		  try
		  { 
	       String[] node=new String[1];
	       node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,2);
	       actual[13]=tp.navigateToCycle(node);
	      
	       
	       String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	       int[] testcase=new int[1];
	       testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
	       exp=new ExecutionPage(driver);
	       actual[14]=tp.validateAllAssigned(testcase, assignee);
	       
	       rp=new ReleasePage(driver);
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
			  }
	}


	@When("^Launch test execution Module$")
	public void launch_test_execution_Module() throws Throwable {
		  try
		  {	
		rp=new ReleasePage(driver);
		
		actual[15]=rp.clickOnTestExecution();
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
		  }
	}

		@When("^navigates to the phase and check the executions assigned by lead$")
	public void navigates_to_the_phase_and_check_the_executions_assigned_by_lead() throws Throwable {
		  try
		  {
		String[] cycle=new String[3];
	    cycle[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,5);
	    cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,2);
	    actual[16]=tp.navigateToCycle(cycle);
		
		
		 String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
	       int[] testcase=new int[1];
	       testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
	      
		actual[17]=exp.validateAssignedTestCase(testcase, assignee);
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
		  }
		 
	}

	@When("^change the execution status to Pass$")
	public void change_the_execution_status_to_Pass() throws Throwable {
		  try
		  { 
		 int testcase=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		 String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,17);
		 actual[18]=exp.executeStatus(testcase, status);
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
		  }
	}

	@Then("^check the actual time$")
	public void check_the_actual_time() throws Throwable {
		  try
		  {  
			  String[] testCase=new String[1];
			   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			   exp.selectMultipleTestCaseFromExecutionGrid(testCase);
			   bp.waitForElement();
		String day=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,23);
		
		String hr=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,24);
		String mn=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",2,25);
		tr.clickOnDetails();
		actual[19]=exp.validateActualTime(day, hr, mn);
		bp.waitForElement();
		tr.clickOnList();
		  }
		 catch(Exception e)
		  {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		  }
	}

	@When("^user change the status of testcase to Not Executed$")
	public void user_change_the_status_of_testcase_to_Not_Executed() throws Throwable {
		  try
		  { int testcase=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		 String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,17);
		 actual[20]=exp.executeStatus(testcase, status);
		 bp.waitForElement();}
		 catch(Exception e)
		  {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		  }
	}

	@Then("^actual time should be reset$")
	public void actual_time_should_be_reset() throws Throwable {
		  try
		  {
		String day=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,23);
		
		String hr=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,24);
		String mn=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,25);
		tr.clickOnDetails();
		actual[21]=exp.validateActualTime(day, hr, mn);
		tr.clickOnList();
		
		bp.waitForElement();
		tp=new TestPlanningPage(driver);
		String [] Release=new String[1];
		Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		tp.navigateToCycle(Release);
		bp.waitForElement();
		
		
		for(int k=0;k<=actual.length-1;k++)
	    {
	    	System.out.println(actual[k]);
	    	soft.assertEquals(actual[k], true);
	    }
		soft.assertAll();
		  }
		 catch(Exception e)
		  {
			lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		  }
	}
}
