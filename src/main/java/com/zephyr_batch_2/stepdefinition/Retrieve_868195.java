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

public class Retrieve_868195 extends LaunchBrowser
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
	 String filename="Retrieve_868195";
	@Given("^user launched test Repository page$")
	public void user_launched_test_Repository_page() throws Throwable 
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

	@Given("^create phase add testcases to phase$")
	public void create_phase_add_testcases_to_phase() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 41, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   tr.addTestCase();
			   bp.waitForElement();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement(); 
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
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

	@When("^launch test planning create cycle C one add phase to cycle assign to Anyone$")
	public void launch_test_planning_create_cycle_C_one_add_phase_to_cycle_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 2);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
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

	@When("^launch test planning create cycle as same as previously created C one add phase to cycle assign to Anyone$")
	public void launch_test_planning_create_cycle_as_same_as_previously_created_C_one_add_phase_to_cycle_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    ///creating duplicate cycle
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 6);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 7);
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
			//navigating to duplicate cycle
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			String no=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "index", 2, 0));
			System.out.println(no);
			tl.navigateToCycle(cyclename1);
			//tl.navigateToClonedCycle(cyclename1, no);//
			//bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
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

	@When("^navigate to cycle which previously created create freeform$")
	public void navigate_to_cycle_which_previously_created_create_freeform() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
			
				String cyclename1[]=new String[1];
				cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
				String no=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "index", 2, 0));
			    tl.navigateToCycle(cyclename1);
				//tl.navigateToClonedCycle(cyclename1, no);//
				bp.waitForElement();
			//freeform1
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 4);
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
			
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 4);
			actual[40]=tl.navigateToCycle(freeFormName1);
			bp.waitForElement();
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

	@Then("^launch testcase window search for testcases save and assign to Anyone$")
	public void launch_testcase_window_search_for_testcases_save_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
		tl.clickOnAddTestcasesToFreeForm();
		bp.waitForElement();
		
		 tl.launchOtherCycles();
		   bp.waitForElement();
		   
		   //dupcycle
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
//		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
//		    tl.selectPhasebyIndexInSearch(index);
		    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
		    tl.selectPhaseInSearch(PhaseName);
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

	@Then("^create cycle two add freeform phase select freeform phase$")
	public void create_cycle_two_add_freeform_phase_select_freeform_phase() throws Throwable 
	{
		try
		{
			actual[35]=rp.clickOnTestPlanning();
			bp.waitForElement();
		
			   tl=new TestPlanningPage(driver);
			   actual[36]=tl.clickOnAddTestCycleSymbol();
			   bp.waitForElement();
			   //create cycle 3
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 5);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 6);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 7);
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
			  String cyclename2[]=new String[1];
				cyclename2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 5);
			tl.navigateToCycle(cyclename2);
			//FreeForm2
				String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 14);
				tl.createFreeFormPhase(freeFormName);
				bp.waitForElement();
				
				//select freeform phase
			String freeFormName1[]=new String[1];
			freeFormName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 14);
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

	@Then("^launch add testcase window launch other cycles select first created cycle select phase select all testcases and save$")
	public void launch_add_testcase_window_launch_other_cycles_select_first_created_cycle_select_phase_select_all_testcases_and_save() throws Throwable 
	{
		try
		{
		tl.clickOnAddTestcasesToFreeForm();
		bp.waitForElement();
		
		 tl.launchOtherCycles();
		   bp.waitForElement();
		   
		   //select first created cycle

			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 2);
		    tl.selectCycleInSearch(cyclename, Build, Environment);
		    bp.waitForElement();
//		    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
//		    tl.selectPhasebyIndexInSearch(index);
		    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
		    tl.selectPhaseInSearch(PhaseName);
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

	@Then("^select second created cycle select normal phase select all testcases and save$")
	public void select_second_created_cycle_select_normal_phase_select_all_testcases_and_save() throws Throwable 
	{
		try
		{
		 //select second created cycle
		String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 31, 2);
	    tl.selectCycleInSearch(cyclename, Build, Environment);
	    bp.waitForElement();
//	    int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
//	    tl.selectPhasebyIndexInSearch(index);
	    String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 41, 0);
	    tl.selectPhaseInSearch(PhaseName);
	    bp.waitForElement();
	    tl.clickOnGo();
	    bp.waitForElement();
	   
//	    tl.clickOnAddTestcasesToFreeForm();
//	    bp.waitForElement();
//	    tl.launchOtherCycles();
//	    bp.waitForElement();
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
	@Then("^select free formphase select all testcases and save$")
	public void select_free_formphase_select_all_testcases_and_save() throws Throwable 
	{
		try
		{
//				int index=Excel_Lib.getNumberData(INPUT_PATH_4, "index", 1, 0);
//			    tl.selectPhasebyIndexInSearch(index);
//			 	String PhaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 31, 4);
//			    tl.selectPhaseInSearch(PhaseName);
//			    bp.waitForElement();
//			    tl.clickOnGo();
//			    bp.waitForElement();
//			    tl.validateRetrieveTestcases();
//			    bp.waitForElement();
//			    tl.selectAllFreeFormTestCases();
//			    bp.waitForElement();
//			    tl.clickOnSaveAndOk();
//			    bp.waitForElement();
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

	@Then("^Should be able to switch the cycle and add both normal and free form phases in the cycle to free form phase$")
	public void should_be_able_to_switch_the_cycle_and_add_both_normal_and_free_form_phases_in_the_cycle_to_free_form_phase() throws Throwable 
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
