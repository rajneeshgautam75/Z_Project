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

public class Retrieve_868196 extends LaunchBrowser
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
	 String filename="Retrieve_868196";
	 @Given("^user in repository page to create phase and system$")
	 public void user_in_repository_page_to_create_phase_and_system() throws Throwable 
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
	@Given("^Launch test repository create a phase add testcases to phase create system to phase add testcases to phase$")
	public void launch_test_repository_create_a_phase_add_testcases_to_phase_create_system_to_phase_add_testcases_to_phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
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

		    actual[13]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase/////////////////////////////////////////////////////////////////////
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			actual[14]=tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			bp.waitForElement();
			String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 2);
			String systemDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 3);
			actual[15]=tr.addNode(systemName, systemDesc1);
			//navigate to system
			actual[16]=tr.doubleClickOnRelease(releaseName);
			String system[]=new String[2];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 2);
			actual[17]=tr.navigateToNode(releaseName, system);
			
			   //add testcases	
			   actual[18]=tr.addTestCase();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[20]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[21]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[22]=tr.cloneTestCase();
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

	@Given("^launch testplanning create cycle assign phase to cycle and assign to Anyone$")
	public void launch_testplanning_create_cycle_assign_phase_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
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

	@When("^launch test repository delete system and delete some testcases from phase$")
	public void launch_test_repository_delete_system_and_delete_some_testcases_from_phase() throws Throwable 
	{
		try
		{
		 actual[2]=rp.clickOnTestRep();
		   bp.waitForElement();
		   
			//navigate to system
		   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[16]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			//actual[16]=tr.doubleClickOnRelease(releaseName);
			String system[]=new String[2];
			system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			system[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 2);
			actual[17]=tr.navigateToNode(releaseName, system);
			tr.deleteNode();
			bp.waitForElement();
			
			//navigate to phase//
			actual[5]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 42, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
			String testCaseNo[]=new String[2];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
			testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			tr.deleteTestCase();
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

	@When("^navigate to cycle add freeform phase select freefoem phase$")
	public void navigate_to_cycle_add_freeform_phase_select_freefoem_phase() throws Throwable 
	{
		try
		{
			rp.clickOnTestPlanning();
			bp.waitForElement();
			
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 4);
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
			
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 4);
			actual[40]=tl.navigateToCycle(freeFormName1);
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

	@When("^launch add testcase button launch other cycles$")
	public void launch_add_testcase_button_launch_other_cycles() throws Throwable 
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

	@When("^select cycle select phase and searh and add to freeform phase$")
	public void select_cycle_select_phase_and_searh_and_add_to_freeform_phase() throws Throwable 
	{
		try
		{
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 32, 0);
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

	@Then("^Should retrieve testcases from another cycle if some phases/nodes/testcases no longer exist in test repository$")
	public void should_retrieve_testcases_from_another_cycle_if_some_phases_nodes_testcases_no_longer_exist_in_test_repository() throws Throwable 
	{
		try
		{
			 	tl.validateRetrieveTestcases();
			    bp.waitForElement();
			    tl.selectAllFreeFormTestCasesPhase();
			    bp.waitForElement();
			    tl.clickOnSaveAndOk();
			    bp.waitForElement();
			    tl.closeFreeFormPage();
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
