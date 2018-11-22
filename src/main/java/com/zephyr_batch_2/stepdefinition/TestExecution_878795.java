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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878795 extends LaunchBrowser {

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878795";
	boolean[] actual=new boolean[29];
	 SoftAssert soft=new SoftAssert();
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@When("^User Creates a phase and add testcase to the phase$")
	public void user_Creates_a_phase_and_add_testcase_to_the_phase() throws Throwable {
	   try
	   {
		tr=new TestRepositoryPage(driver);
	   bp=new BasePage();
	   String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	   actual[0]=tr.clickOnRelease(releaseName);
	   
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,2);
	   actual[1]=tr.addNode(name, name);
	   
	   actual[2]=tr.doubleClickOnRelease(releaseName);
	   bp.waitForElement();
	   String[] node1=new String[1];
	   node1[0]=name;
	   actual[3]=tr.navigateToNode(releaseName, node1);
	   actual[4]=tr.addTestCase();
	   }
	   catch(Exception e)
		{ lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^enter the step details$")
	public void enter_the_step_details() throws Throwable {
		
		try
		{
		actual[5]=tr.clickDetailButton();
	   ctc=new CreateTestCasePage(driver);
	   String testCaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,14);
	   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,15);
	   actual[6]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	   
	   String[] stepdetail=new String[3];
	   int l=0;
	   for(int i=19;i<=21;i++)
	   {
		   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
		   l++;
	   }
	  
	   actual[7]=ctc.enterTestCaseStepDetail(stepdetail);
	   bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch test planning module$")
	public void launch_test_planning_module() throws Throwable {
	   try
	   {
		rp=new ReleasePage(driver);
	   actual[8]=rp.clickOnTestPlanning();
	   }
	   catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		
	    
	    		
	}

	@When("^creates a cycle and add phase to cycle and assign to tester$")
	public void creates_a_cycle_and_add_phase_to_cycle_and_assign_to_tester() throws Throwable {
		
		try
		{
		tp=new TestPlanningPage(driver);
		 
	    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 5);
		String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 6);
		   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		   
		   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 1, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 1, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 1, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 1, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 1, 13));		
		
		    actual[9]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[10]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[11]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[12]=tp.saveTestCycle();
		    bp.waitForElement();
			
			
			
			
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,5);
		    tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,2);
	       actual[13]=tp.addPhaseToCycle(phase);
	       String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,22);
	       actual[14]=tp.bulkAssignment(bulkType);
	       
	       String[] node=new String[1];
	       node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,2);
	       actual[15]=tp.navigateToCycle(node);
	       bp.waitForElement();
	      
	       
	       String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
	       int[] testcase=new int[1];
	       testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
	       actual[16]=tp.individualAssinTo(testcase, assignee);
	     
	       actual[17]=bp.waitForElement();
	       
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	       
	}

	@Then("^test case should be assign to tester$")
	public void test_case_should_be_assign_to_tester() throws Throwable {
	   
		
		try
		{
			pp=new ProjectPage(driver);
			
			int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
		 actual[18]=tp.validateAllAssigned(testcase, assignee);
		 tp.goBackToCycle();
		 actual[19]=pp.clickOnLogout();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^login as lead$")
	public void login_as_lead() throws Throwable {
	   try
	   {
		lp=new LoginPage(driver);
	   
	   
	   String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
	   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
	   actual[20]=lp.enterUname(userName);
	   actual[21]=lp.enterPass(password);
	   actual[22]=lp.clickOnLogin();
	   }
	   catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch test execution module$")
	public void launch_test_execution_module() throws Throwable {
	
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		 actual[23]=pp.selectProject(projectName);
		 actual[24]= pp.selectRelease(releaseName);
		 actual[25]=rp.clickOnTestExecution();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^change the status of test case step to Pass$")
	public void change_the_status_of_test_case_step_to_Pass() throws Throwable {
	   
		try
		{
		String[] nodes=new String[2];
		String release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		 nodes[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 5);
		 nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,2);
		
		 actual[26]=tr.navigateToNode(release,nodes);
		
		exp=new ExecutionPage(driver);
		
		
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		
		String statusType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
		 actual[27]=exp.executeStatus(testcase, statusType);
		 bp.waitForElement();
		 
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		
	}

	@When("^add long test step notes with special/ numeric and space$")
	public void add_long_test_step_notes_with_special_numeric_and_space() throws Throwable {
	 try
	 {
		 tr.clickOnDetails();
		 String[] testCase=new String[1];
		   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
		   exp.selectMultipleTestCaseFromExecutionGrid(testCase);
		   bp.waitForElement();
		String notes=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,18);
	  actual[28]=exp.enterNotes(notes);
	 }
	 catch(Exception e)
		{lb.getScreenShot(filename);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^step notes should be added to the test case$")
	public void step_notes_should_be_added_to_the_test_case() throws Throwable {
	   try
	   {
		log.info("Step Notes Added Successfully");
		String notes=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,18);
		exp.validateNotes(notes);
		bp.waitForElement();
		tr.clickOnList();
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
	{lb.getScreenShot(filename);
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
	
	
}
}
