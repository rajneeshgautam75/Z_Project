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
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878806 extends LaunchBrowser
{

	LoginPage lp;
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
	String filename="TestExecution_878806";
	
	boolean[] actual=new boolean[38];
	SoftAssert soft=new SoftAssert();
	 
	String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@Given("^User is in the test repository page$")
	public void user_is_in_the_test_repository_page() throws Throwable 
	{
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		
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

	@When("^User creates a phase and adds multiple testcases$")
	public void user_creates_a_phase_and_adds_multiple_testcases() throws Throwable 
	{
		try
		{
		
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,2);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,2);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		actual[4]=tr.addNode(name, desc);
		bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=name;
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
	   
	   for(int i=1;i<=5;i++)
	   {
	   tr.addTestCase();
	   }
	   
	   
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

	@When("^enters the test step details$")
	public void enters_the_test_step_details() throws Throwable {
	   try
	   {
		ep=new ExportPage(driver);
		String[] testcase= new String[1];
		testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14));
		actual[6]=ep.selectMultipleTestCaseFromGrid(testcase);
		bp.waitForElement();
		tr.clickDetailButton();
		String[] stepDetail = new String[3];
		int k=0;
		for(int i=19;i<=21;i++)
		{
			stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
			k++;
		}
		ctc=new CreateTestCasePage(driver);
		actual[7]=ctc.enterTestCaseStepDetail(stepDetail);
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

	@When("^Launch Test Planning module$")
	public void launch_Test_Planning_module() throws Throwable {
	  try
	  {
		rp=new ReleasePage(driver);
		actual[8]=rp.clickOnTestPlanning();
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

	@When("^creats a cycle and add phase to the cycle$")
	public void creats_a_cycle_and_add_phase_to_the_cycle() throws Throwable {
	    try
	    {
		tp=new TestPlanningPage(driver);
	    //tp.clickOnAddTestCycleSymbol();
	    
	    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 3, 5);
		String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 3, 6);
		  String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 3, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		   
		   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 3, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 3, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 3, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",3, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 3, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 3, 13));		
		
		    actual[9]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[10]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[11]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[12]=tp.saveTestCycle();
		    bp.waitForElement();
		    
		    
		    
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,5);
		    tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,2);
	       actual[13]=tp.addPhaseToCycle(phase);
	       String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,22);
	       actual[14]=tp.bulkAssignment(bulkType);
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

	@When("^assign some testcase to tester and some testcase to Anyone$")
	public void assign_some_testcase_to_tester_and_some_testcase_to_Anyone() throws Throwable {
	   try
	   {
		   String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,2);
		    tp.navigateToCycle(cycle);
		    bp.waitForElement();
	       
		int[] testcase=new int[3];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		
		
		String asignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
		
		actual[15]=tp.individualAssinTo(testcase, asignee);
		 
		    int[] testcase1=new int[2];
			testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",4,14);
			testcase1[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",5,14);
			String asignee1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",4,16);
			
			actual[16]= tp.individualAssinTo(testcase1, asignee1);
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

	@Then("^test cases should be assigned to tester and Anyone$")
	public void test_cases_should_be_assigned_to_tester_and_Anyone() throws Throwable {
	   
		try
		{
		int[] testcase=new int[3];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		
		
		String asignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
		
		actual[17]=tp.validateAllAssigned(testcase, asignee);
		
		
		int[] testcase1=new int[2];
		testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",4,14);
		testcase1[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",5,14);
		String asignee1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",4,16);
		actual[18]=tp.validateAllAssigned(testcase1, asignee1);
		
		bp.waitForElement();
		//rp.clickOnTestPlanning();
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

	@When("^User logout from the application$")
	public void user_logout_from_the_application() throws Throwable {
	 
		try
		{
			actual[19]=pp.clickOnLogout();
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

	@When("^login as Tester role$")
	public void login_as_Tester_role() throws Throwable {

		try
		{
         lp=new LoginPage(driver);
         String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
         String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
         actual[20]=lp.enterUnameAndPassword(uname, password);
         
     	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		actual[21]=pp.selectProject(projectName);
		actual[22]=pp.selectRelease(releaseName);
		actual[23]= rp.clickOnTestExecution();
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

	@When("^change the status of testcase to Pass by using bulk edit$")
	public void change_the_status_of_testcase_to_Pass_by_using_bulk_edit() throws Throwable {
	    
		try
		{
		String[] cycle=new String[3];
		cycle[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,5);
	    cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",3,2);
	    actual[24]=tp.navigateToCycle(cycle);
	    bp.waitForElement();
	    exp=new ExecutionPage(driver);
	    actual[25]=exp.selectAndDeselectAllTestCase();
	    
	    String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
	    actual[26]= exp.changeMultiSelectedStatus(status);
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

	@Then("^status of test cases should be changed to Pass$")
	public void status_of_test_cases_should_be_changed_to_Pass() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[4]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
				
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
		actual[27]=exp.ValidateStatusOfTestCases(testcase, status);
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


	@When("^user change the status of testcase to Fail by using bulk edit$")
	public void user_change_the_status_of_testcase_to_Fail_by_using_bulk_edit() throws Throwable {
       try
       {
    	   actual[28]=exp.selectAndDeselectAllTestCase();
	    
	    String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",5,17);
	    actual[29]=exp.changeMultiSelectedStatus(status);
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

	@Then("^status of test cases should be changed to Fail$")
	public void status_of_test_cases_should_be_changed_to_Fail() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[4]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
				
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",5,17);
		actual[30]=exp.ValidateStatusOfTestCases(testcase, status);
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

	@When("^user change the status of testcase to WIP by using bulk edit$")
	public void user_change_the_status_of_testcase_to_WIP_by_using_bulk_edit() throws Throwable {
		try
		{
			actual[31]=exp.selectAndDeselectAllTestCase();
		    
		    String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,17);
		    actual[32]=exp.changeMultiSelectedStatus(status);
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

	@Then("^status of test cases should be changed to WIP$")
	public void status_of_test_cases_should_be_changed_to_WIP() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[4]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
				
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",6,17);
		actual[33]=exp.ValidateStatusOfTestCases(testcase, status);
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

	@When("^user change the status of testcase to Blocked by using bulk edit$")
	public void user_change_the_status_of_testcase_to_Blocked_by_using_bulk_edit() throws Throwable {
		try
		{
		exp.selectAndDeselectAllTestCase();
		    
		    String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,17);
		    actual[34]= exp.changeMultiSelectedStatus(status);
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

	@Then("^status of test cases should be changed to Blocked$")
	public void status_of_test_cases_should_be_changed_to_Blocked() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[4]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
				
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",7,17);
		actual[35]=exp.ValidateStatusOfTestCases(testcase, status);
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

	@When("^user change the status of testcase to Custom status by using bulk edit$")
	public void user_change_the_status_of_testcase_to_Custom_status_by_using_bulk_edit() throws Throwable {
		
		try
		{
		exp.selectAndDeselectAllTestCase();
		    
		    String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",8,17);
		    actual[36]=exp.changeMultiSelectedStatus(status);
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

	@Then("^status of test cases should be changed to Changed status$")
	public void status_of_test_cases_should_be_changed_to_Changed_status() throws Throwable {
		try
		{
		int[] testcase=new int[5];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",1,14);
		testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
		testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",2,14);
		testcase[4]=Excel_Lib.getNumberData(INPUT_PATH_2,"CreateTestCycle",3,14);
				
		String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",8,17);
		actual[37]=exp.ValidateStatusOfTestCases(testcase, status);
		
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
