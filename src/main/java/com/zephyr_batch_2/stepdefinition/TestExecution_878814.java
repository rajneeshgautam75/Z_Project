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

public class TestExecution_878814 extends LaunchBrowser
{

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
	String filename="TestExecution_878814";
	boolean[] actual=new boolean[29];
	 SoftAssert soft=new SoftAssert();
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
	 
	@When("^add a phase and add two system under phase$")
	public void add_a_phase_and_add_two_system_under_phase() throws Throwable {
		try
		{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution",22, 2);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 2);
		tr=new TestRepositoryPage(driver);
		bp=new BasePage();
		actual[0]=tr.doubleClickOnRelease(releaseName);
		actual[1]=tr.addNode(name, desc);
		 bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=name;
			bp.waitForElement();
		    tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
		actual[2]=tr.selectPhase(name);
		
		String sname1=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 3);
		String sdesc1=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 3);
		actual[3]=tr.addNode(sname1, sdesc1);
		actual[4]=tr.selectPhase(name);
		
		String sname2=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 4);
		String sdesc2=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 4);
		actual[5]=tr.addNode(sname2, sdesc2);
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

	@When("^Add testcases with test steps to phase$")
	public void add_testcases_with_test_steps_to_phase() throws Throwable {
	   
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 2);
			actual[6]=tr.selectPhase(name);
			actual[7]=tr.addTestCase();
		   
		   actual[8]=tr.clickDetailButton();
			String[] stepDetail = new String[3];
			int k=0;
			for(int i=19;i<=21;i++)
			{
				stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
				k++;
			}
			ctc=new CreateTestCasePage(driver);
			actual[9]=ctc.enterTestCaseStepDetail(stepDetail);
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

	@When("^create a new cycle, add phase to cycle and assign to lead$")
	public void create_a_new_cycle_add_phase_to_cycle_and_assign_to_lead() throws Throwable {
	    try
	    {

			   rp=new ReleasePage(driver);
			   actual[10]=rp.clickOnTestPlanning();
			   
			   tp=new TestPlanningPage(driver);
				
				String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 5);
				String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 6);
				   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 22, 7);
				   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
				   
				   
				   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 22, 8));
				    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 22, 9);
				    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 22, 10));
				    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",22, 11));
				    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 22, 12);
				    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 22, 13));		
				
				    actual[11]=tp.clickOnAddTestCycleSymbol();
				    
				    actual[12]=tp.CreateCycle(cycleName, build, environment, hide);
				    actual[13]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
				    actual[14]=tp.saveTestCycle();
				    bp.waitForElement();
				    
				    String[] cycle=new String[1];
				    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",22,5);
				    actual[15]=tp.navigateToCycle(cycle);
			       
				    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",22,2);
				       actual[16]=tp.addPhaseToCycle(phase);
				       actual[17]=tp.cancelBulkAssign();
				       
				       bp.waitForElement();
				       String[] cycle1=new String[1];
					    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",22,2);
					    actual[18]=tp.navigateToCycle(cycle1);
				        bp.waitForElement();
				       tp.selectallTestCase();
					    int[] testcase=new int[1];
					    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
				       String assign=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
				       actual[19]=tp.individualAssinTo(testcase, assign);
		 
		   
		   
	    	
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

	@Then("^testcase should be assign to lead$")
	public void testcase_should_be_assign_to_lead() throws Throwable {
		try
	    {
			int[] testcase=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			  
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
			  
			actual[20]=tp.validateAllAssigned(testcase, assignee);
			
			bp.waitForElement();
			
			tp.goBackToCycle();
	    	
	    	
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

	@When("^user Launch test execution module$")
	public void user_Launch_test_execution_module() throws Throwable {
		try
	    {
			rp=new ReleasePage(driver);
			actual[21]=rp.clickOnTestExecution();
	    	exp=new ExecutionPage(driver);
	    	
	    	
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

	@When("^execute teststep and testcases and change to custom status$")
	public void execute_teststep_and_testcases_and_change_to_custom_status() throws Throwable {
		try
	    {
			int[] stepNo=new int[1];
			stepNo[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			
			String[] cycle=new String[3];
		    cycle[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution",22, 5);
		    cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution",22, 2);
		    actual[22]=tp.navigateToCycle(cycle);
		    
		    exp=new ExecutionPage(driver);
		    bp.waitForElement();
		    String[] testCase=new String[1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			exp.selectMultipleTestCaseFromExecutionGrid(testCase);
			tr.clickDetailButton();
			bp.waitForElement();
		    String[] status= new String[1];
		    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",12,17);
		    //exp.stepDetailButton.click();
		    actual[23]= exp.changeStepDetailStatus(stepNo,status);	
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

	@When("^link a defect to testcase$")
	public void link_a_defect_to_testcase() throws Throwable {
		try
	    {
			
	    	int testcase=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
	    	actual[24]=exp.clickOnDefectButton(testcase);
	    	String defectId=Excel_Lib.getData(INPUT_PATH_2,"Defects",1,0);
	    	actual[25]=exp.linkDefect(defectId);
	    	actual[26]=exp.validateLinkedDefect(testcase, defectId);
	    	
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

	@When("^change the status of testcase to Fail$")
	public void change_the_status_of_testcase_to_Fail() throws Throwable {
		try
	    {
			String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",22,17);
			int[] testcase=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			actual[27]=exp.executeStatus(testcase[0], status);
	    	
	    	
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

	@Then("^status should be change to Fail$")
	public void status_should_be_change_to_Fail() throws Throwable {
		try
	    {
			String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",22,17);
			int[] testcase=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			actual[28]=exp.ValidateStatusOfTestCases(testcase, status);
			bp.waitForElement();
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
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
