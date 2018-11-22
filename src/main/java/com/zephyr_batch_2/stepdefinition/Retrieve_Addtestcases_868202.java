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

public class Retrieve_Addtestcases_868202 extends  LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	 String filename="Retrieve_Addtestcases_868202";
	@Given("^to create a phase and add testcases user in repository page$")
	public void to_create_a_phase_and_add_testcases_user_in_repository_page() throws Throwable 
	{
		 try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^create a phase and add test cases to phase$")
	public void create_a_phase_and_add_test_cases_to_phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 46, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 46, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 46, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
		   actual[7]=tr.addTestCase();
		   actual[9]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[10]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement(); 
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning create cycle add freeform one phase to cycle$")
	public void launch_testplanning_create_cycle_add_freeform_one_phase_to_cycle() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 4);
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^navigate to freeform One browse testcases select one testcase and save and assign to Anyone$")
	public void navigate_to_freeform_One_browse_testcases_select_one_testcase_and_save_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 4);
			actual[40]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
			
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			tl.clickOnBrowse();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String phaseName[]=new String[2];
			 phaseName[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			phaseName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 46, 0);
			tr.navigateToNode(phaseName[0],phaseName);
			
			String[] tcNo=new String[1];
			tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
			//tl.selectSingleMultipleTestcase(tcNo);
			tl.selectAllFreeFormTestCases();
			bp.waitForElement();
			
			tl.clickOnSaveAndOk();
			bp.waitForElement();
			
			tl.closeFreeFormPage();
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			
			String Anyone=Excel_Lib.getData(INPUT_PATH_4, "Assignee", 5, 0);
			tl.assignAllSelected(Anyone);
			bp.waitForElement();
			tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning navigate to cycle add freeform two phase to cycle$")
	public void launch_testplanning_navigate_to_cycle_add_freeform_two_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[35]=rp.clickOnTestPlanning();
	    bp.waitForElement();
	    
	    String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
		actual[40]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		
		String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 9);
		tl.createFreeFormPhase(freeFormName);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^navigate to freeform two browse testcases select same testcase and save and assign to Anyone$")
	public void navigate_to_freeform_two_browse_testcases_select_same_testcase_and_save_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 9);
			actual[40]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
			
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			tl.clickOnBrowse();
			bp.waitForElement();
			
			String phaseName[]=new String[2];
			 phaseName[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			phaseName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 46, 0);
			tl.navigateToCycle(phaseName);
			
//			int[] tcNo=new int[1];
//			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
//			tl.selectSingleMultipleTestcase(tcNo);
			String[] tcNo=new String[1];
			tcNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
			//tl.selectSingleMultipleTestcase(tcNo);
			tl.selectAllFreeFormTestCases();
			
			tl.clickOnSaveAndOk();
			bp.waitForElement();
			
			tl.closeFreeFormPage();
			bp.waitForElement();
			
			tl.selectallTestCase();
			bp.waitForElement();
			
			String Anyone=Excel_Lib.getData(INPUT_PATH_4, "", 5, 0);
			tl.assignAllSelected(Anyone);
			bp.waitForElement();
			tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning navigate to cycle add freeform three phase to cycle$")
	public void launch_testplanning_navigate_to_cycle_add_freeform_three_phase_to_cycle() throws Throwable 
	{
		try
		{
		actual[35]=rp.clickOnTestPlanning();
	    bp.waitForElement();
	    
	    String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
		actual[40]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		
		String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 14);
		tl.createFreeFormPhase(freeFormName);
		bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^navigate to freeform three browse select add testcases option launch other cycles$")
	public void navigate_to_freeform_three_browse_select_add_testcases_option_launch_other_cycles() throws Throwable 
	{
		try
		{
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 14);
			actual[40]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
			
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			tl.launchOtherCycles();
			bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Then("^select cycle and freeform phase one  and  deselect status and add to freeform phase$")
	public void select_cycle_and_freeform_phase_one_and_deselect_status_and_add_to_freeform_phase() throws Throwable 
	{
		try
		{
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.validateAddtestcaesToFreeForm();
		    bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Then("^launch addtestcases option launch other cycles$")
	public void launch_addtestcases_option_launch_other_cycles() throws Throwable 
	{
		try
		{
			tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			tl.launchOtherCycles();
			bp.waitForElement();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Then("^select cycle and freeform phase two and add to freeform phase$")
	public void select_cycle_and_freeform_phase_two_and_add_to_freeform_phase() throws Throwable 
	{

		try
		{
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 36, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 2, 0);
		    tl.selectPhasebyIndexInSearch(index);
	//	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	//	    tl.selectPhaseInSearch(PhaseName);
		   // System.out.println(index);
		    bp.waitForElement();
		    tl.clickOnGo();
		    bp.waitForElement();
		 	tl.validateRetrieveTestcases();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCasesPhase();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		 
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^Testcase testcase one should be added only once$")
	public void testcase_testcase_one_should_be_added_only_once() throws Throwable 
	{
	    try
	    {
	    	   tl.validateAddtestcaesToFreeForm();
			    bp.waitForElement();
			    tl.goBackToCycle();
				   bp.waitForElement();
	    }
	    catch (Exception e) 
		{
	    	lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}
}
