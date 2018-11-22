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

public class TestExecution_878821 extends LaunchBrowser {
	
        ProjectPage pp;
        ReleasePage rp;
        BasePage bp;
        TestRepositoryPage tr;
        CreateTestCasePage ctc;
        ExportPage epp;
        TestPlanningPage tp;
        ExecutionPage ep;
        LaunchBrowser lb=new LaunchBrowser();
        String filename="TestExecution_878821";
        boolean actual[]=new boolean[39];
        SoftAssert soft=new SoftAssert();
	
	
	@Given("^Lead is in TestRepository page of Normal_Project$")
	public void lead_is_in_TestRepository_page_of_Normal_Project() throws Throwable {
		try 
		{   
			pp=new ProjectPage(driver);
		    rp=new ReleasePage(driver);
		    bp=new BasePage();
			String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			actual[0]=pp.selectProject(Project);
			actual[1]=pp.selectRelease(Release);
			 bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
		    bp.waitForElement();
		}
		catch(Exception e)
		{ lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	   
	}

	@When("^Add Phase and add two systems to phase$")
	public void add_Phase_and_add_two_systems_to_phase() throws Throwable {
		try 
		{
			tr=new TestRepositoryPage(driver);
			String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 1);
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.addNode(Phase, Desc);
			 bp.waitForElement();
			    String[] phase=new String[1];
				phase[0]=Phase;
				bp.waitForElement();
			actual[5]=tr.navigateToNode(Release, phase);
				bp.waitForElement();
			actual[6]=tr.selectPhase(Phase);
			bp.waitForElement();
			bp.waitForElement();
			String system1=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 4);
			String s1_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 5);
			bp.waitForElement();
			actual[7]=tr.addNode(system1, s1_Desc);
			bp.waitForElement();
			actual[8]=tr.selectPhase(Phase);
			bp.waitForElement();
			bp.waitForElement();
			String system2=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 4);
			String s2_Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 20, 5);
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.addNode(system2, s2_Desc);
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	  
	}

	@When("^Add few testcases with stepdetails and few testcases without stepdetails to phase$")
	public void add_few_testcases_with_stepdetails_and_few_testcases_without_stepdetails_to_phase() throws Throwable {
		try 
		{   String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			ctc=new CreateTestCasePage(driver);
		    epp=new ExportPage(driver);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 0);
			 String[] phase=new String[1];
				phase[0]=Phase;
				bp.waitForElement();
			actual[10]=tr.navigateToNode(Release, phase);
			//actual[10]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[11]=tr.addTestCase();
			bp.waitForElement();
			actual[12]=tr.clickOnDetails();
			bp.waitForElement();
			String stepDetails1[]=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 0);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 1);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, 2);
			actual[13]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[14]=tr.clickOnList();
			bp.waitForElement();
			actual[15]=tr.addTestCase();
			bp.waitForElement();
			String testcase[]=new String[1];
			testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "TestRepository", 2, 0));
			actual[16]=epp.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			actual[17]=tr.clickOnDetails();
			bp.waitForElement();
			String stepDetails2[]=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 0);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 1);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, 2);
			actual[18]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			actual[19]=tr.clickOnList();
			bp.waitForElement();
			actual[20]=epp.selectMultipleTestCaseFromGrid(testcase);
			bp.waitForElement();
			actual[21]=tr.addTestCase();
			bp.waitForElement();
			actual[22]=tr.addTestCase();
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch TestPlanning and Create new cycle$")
	public void launch_TestPlanning_and_Create_new_cycle() throws Throwable {
		try 
		{
			tp=new TestPlanningPage(driver);
			actual[23]=rp.clickOnTestPlanning();
			actual[24]=tp.clickOnAddTestCycleSymbol();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 14, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[25]=tp.CreateCycle(cycle, Build, environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[26]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[27]=tp.saveTestCycle();
			bp.waitForElement();
			}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Add phase to cycle and select Assign individually in Bulk Assignment$")
	public void add_phase_to_cycle_and_select_Assign_individually_in_Bulk_Assignment() throws Throwable {
		try 
		{
		    tp=new TestPlanningPage(driver);
			actual[28]=rp.clickOnTestPlanning();
			String cycle[]=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 14, 0);
			actual[29]=tp.navigateToCycle(cycle);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 0);
			actual[30]=tp.addPhaseToCycle(Phase);
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 3, 0);
			actual[31]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
			
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Assign testcases to lead using individual Assignment$")
	public void assign_testcases_to_lead_using_individual_Assignment() throws Throwable {
		try 
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 0);
			actual[32]=tp.navigateToCycle(phase);
			int tcno[]=new int[4];
			String Assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2" );
			for (int i=0;i<=tcno.length-1;i++)
			    {    
				  int j=i+1;
				  tcno[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", j, 0);
			     }
			actual[33]=tp.individualAssinTo(tcno, Assignee);
			bp.waitForElement();
			//rp.clickOnTestPlanning();
			tp.goBackToCycle();
			  bp.waitForElement();
		       }
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Launch TestExecution and Enable the version in datagrid$")
	public void launch_TestExecution_and_Enable_the_version_in_datagrid() throws Throwable {
		try 
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			actual[34]=rp.clickOnTestExecution();
			String cycle[]=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 14, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 19, 0);
			bp.waitForElement();
			actual[35]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			//String []sortName=new String[1];
			//sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 3,7);
		//	actual[36]=ep.sort(sortName);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
	@Then("^Version should be enabled in datagrid of TestExecution$")
	public void version_should_be_enabled_in_datagrid_of_TestExecution() throws Throwable {
		try 
		{
			String []sortName=new String[1];
			sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1,7);
			actual[36]=ep.validateSort(sortName);
			bp.waitForElement();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Execute status of testcases and check the version$")
	public void execute_status_of_testcases_and_check_the_version() throws Throwable {
		try 
		{ 
			int testcase[]=new int[4];
		   for(int i=0;i<=testcase.length-1;i++)
		   {
		     testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",i+1, 0);
		   }
		   String status=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
		  actual[37]=ep.changeStatusOfTestCases(testcase, status);
		  bp.waitForElement();
		  
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Version of Executed testcases with stepdetails should be visible$")
	public void version_of_Executed_testcases_with_stepdetails_should_be_visible() throws Throwable {
		try 
		{  
			int testcase[]=new int[4];
			   for(int i=0;i<=testcase.length-1;i++)
			   {    
			     testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution",i+1, 0);
			   }
			   String version=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 8);
			actual[38]=ep.checkVersionInList(testcase, version);
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		}
		catch(Exception e)
		{lb.getScreenShot(filename);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

}
