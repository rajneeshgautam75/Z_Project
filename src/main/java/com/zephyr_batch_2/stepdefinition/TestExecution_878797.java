package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878797 extends LaunchBrowser 
{
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LoginPage lp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878797";
	boolean[] actual=new boolean[22];
	 SoftAssert soft=new SoftAssert();
	
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	 
	@Given("^User is in the test repository Module$")
	public void user_is_in_the_test_repository_Module() throws Throwable {
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
		{ lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User creates a phase and add testcase with test steps$")
	public void user_creates_a_phase_and_add_testcase_with_test_steps() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		tr=new TestRepositoryPage(driver);
	actual[3]=tr.doubleClickOnRelease(releaseName);
     String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,2);
     String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,2);
     actual[4]=tr.addNode(name, desc);
     bp.waitForElement();
		tr.doubleClickOnRelease(releaseName);
		String[] phase=new String[1];
		phase[0]=name;
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
     actual[6]=tr.addTestCase();
     bp.waitForElement();
     actual[7]=tr.clickDetailButton();
     bp.waitForElement();
     ctc=new CreateTestCasePage(driver);
     
     String testCaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,14);
     String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,15);
     actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
     
     String[] stepdetail=new String[3];
	   int l=0;
	   for(int i=19;i<=21;i++)
	   {
		   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
		   l++;
	   }
	  
	   actual[9]=ctc.enterTestCaseStepDetail(stepdetail);
	   bp.waitForElement();
	   tr.clickOnList();
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

	@When("^creates a new cycle and add created phase to the cycle and assign to lead$")
	public void creates_a_new_cycle_and_add_created_phase_to_the_cycle_and_assign_to_lead() throws Throwable {
		try
		{
		tp=new TestPlanningPage(driver);
		 
    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 11, 5);
	String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 11, 6);
	   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 11, 7);
	   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
	   
	   
	   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 11, 8));
	    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 11, 9);
	    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 11, 10));
	    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",11, 11));
	    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 11, 12);
	    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 11, 13));		
	
	    actual[10]=tp.clickOnAddTestCycleSymbol();
	    
	    actual[11]=tp.CreateCycle(cycleName, build, environment, hide);
	    actual[12]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
	    actual[13]=tp.saveTestCycle();
	    bp.waitForElement();
		
		
		
		
	    String[] cycle=new String[1];
	    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,5);
	    actual[14]=tp.navigateToCycle(cycle);
       
       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,2);
       actual[15]=tp.addPhaseToCycle(phase);
       String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",11,22);
       actual[16]=tp.bulkAssignment(bulkType);
       
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

	@When("^Launch test Execution module and view executions assigned by lead$")
	public void launch_test_Execution_module_and_view_executions_assigned_by_lead() throws Throwable {
	  
		try
		{
		rp.clickOnTestExecution();
		bp.waitForElement();
	   String[] cycleName=new String[2];
	   String release =Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
	   cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 11, 5);
	   cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 11, 2);
	   actual[17]=tr.navigateToNode(release,cycleName);
	   bp.waitForElement();
	   exp=new ExecutionPage(driver);
	   int[] testcase= new int[1];
	   testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
	   
	   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
	   actual[18]=exp.validateAssignedTestCase(testcase, assignee);
	   String[] testCase=new String[1];
	   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
	   exp.selectMultipleTestCaseFromExecutionGrid(testCase);
	   bp.waitForElement();
	   tr.clickDetailButton();
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

	@When("^Upload attachement to step and save it$")
	public void upload_attachement_to_step_and_save_it() throws Throwable {
      try
      {
    	  
		String[] filepath=new String[1];
       filepath[0]=Excel_Lib.getData(INPUT_PATH_2, "Files", 1, 1);
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

	@When("^delete the uploaded attachement$")
	public void delete_the_uploaded_attachement() throws Throwable {
	  try
	  {
		String[] fileName=new String[1];
	  fileName[0]=Excel_Lib.getData(INPUT_PATH_2, "Files", 1, 0);
	  actual[20]=exp.deleteAttachement(fileName);
	  bp.waitForElement();
	  tr.clickOnList();
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

	@Then("^uploaded attachement should be deleted successfully$")
	public void uploaded_attachement_should_be_deleted_successfully() throws Throwable {
	    try
	    {
	    	actual[21]=exp.ValidateDeletedAttachement();
	    	
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
