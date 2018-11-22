package com.zephyr_batch_3.stepdefinition;

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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Export_Precondition extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	String fileName = "Export_Precondition";

	boolean[] actual = new boolean[53];
	SoftAssert soft = new SoftAssert();

	@Given("^User is in a page of the testrepository$")
	public void user_is_in_a_page_of_the_testrepository() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_REQ, "Normal_Project_1");
			bp.waitForElement();
			actual[0] = pp.selectProject(projectName);
			actual[1] = pp.selectRelease(releaseName);

			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnTestRep();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User create a phase with testcases$")
	public void user_create_a_phase_with_testcases() throws Throwable {
		try {
			
			String releaseName =Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			String p_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 15);
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			bp = new BasePage();
			actual[3] = tr.clickOnRelease(releaseName);
			actual[4] = tr.addNode(p_Name1, p_Desc1);
			String[] phase1 = new String[1];
			phase1[0] = p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase1);
			for (int i = 0; i <= 4; i++) {
				actual[5] = tr.addTestCase();
			}
			String p_Name2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 14);
			String p_Desc2 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 15);
			actual[6] = tr.doubleClickOnRelease(releaseName);
			actual[7] = tr.addNode(p_Name2, p_Desc2);
			String[] phase2 = new String[1];
			phase2[0] = p_Name2;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase2);
			for (int i = 0; i <= 4; i++) {
				actual[8] = tr.addTestCase();
			}
		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Launch TestPlanning and creates a cycle,creates a phase by choosing an existing phase$")
	public void user_Launch_TestPlanning_and_creates_a_cycle_creates_a_phase_by_choosing_an_existing_phase()
			throws Throwable {
		try {
			bp.waitForElement();
			actual[9] = rp.clickOnTestPlanning();
			bp.waitForElement();

			tp = new TestPlanningPage(driver);
			// String[] str=new String[4];
			String cycle1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 13);
			String Build = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[10] = tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[11] = tp.CreateCycle(cycle1, Build, environ, hide);
			String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 22);
			String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[12] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[13] = tp.saveTestCycle();

			String[] cycle11 = new String[1];
			cycle11[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 13);
			actual[14] = tp.navigateToCycle(cycle11);

			bp.waitForElement();
			String Phase1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 14);
			actual[15] = tp.addPhaseToCycle(Phase1);
			bp.waitForElement();

			bp.waitForElement();
			String Bulk_Type1 = Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[16] = tp.bulkAssignment(Bulk_Type1);
			tp.goBackToCycle();
			
			bp.waitForElement();
			actual[17] = rp.clickOnTestPlanning();
			bp.waitForElement();

			tp = new TestPlanningPage(driver);
			// String[] str=new String[4];
			String cycle2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 13);
			actual[18] = tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[19] = tp.CreateCycle(cycle2, Build, environ, hide);
			actual[20] = tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[21] = tp.saveTestCycle();

			String[] cycle22 = new String[1];
			cycle22[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 13);
			actual[22] = tp.navigateToCycle(cycle22);

			bp.waitForElement();
			String Phase2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 14);
			actual[23] = tp.addPhaseToCycle(Phase2);
			bp.waitForElement();

			bp.waitForElement();
			String Bulk_Type2 = Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[24] = tp.bulkAssignment(Bulk_Type2);
			bp.waitForElement();
			tp.goBackToCycle();

		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^User Launch TestExecution and execute the testcases$")
	public void user_Launch_TestExecution_and_execute_the_testcases() throws Throwable {
		try {
			bp.waitForElement();
			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[25] = rp.clickOnTestExecution();

			String[] cycleName = new String[3];
			cycleName[0] = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			cycleName[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 13);
			cycleName[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 14);

			bp.waitForElement();
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[26] = tp.navigateToCycle(cycleName);
			bp.waitForElement();

			int[] tcNo1 = new int[1];
			tcNo1[0] = Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 19);
			String statusType1 = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1, 18);
			exep = new ExecutionPage(driver);
			actual[27] = exep.executeStatus(tcNo1[0], statusType1);

			int[] tcNo2 = new int[1];
			tcNo2[0] = Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 19);
			String statusType2 = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 18);
			actual[28] = exep.executeStatus(tcNo2[0], statusType2);

			int[] tcNo3 = new int[1];
			tcNo3[0] = Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3, 19);
			String statusType3 = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 18);
			actual[29] = exep.executeStatus(tcNo3[0], statusType3);

			int[] tcNo4 = new int[1];
			tcNo4[0] = Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4, 19);
			String statusType4 = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 18);
			actual[30] = exep.executeStatus(tcNo4[0], statusType4);
			
			int[] tcNo5 = new int[1];
			tcNo5[0] = Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 19);
			String statusType5 = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 18);
			actual[31] = exep.executeStatus(tcNo5[0], statusType5);

			bp.waitForElement();
			tp.doubleClickOnCycle(cycleName[0]);
			
			
			String[] cycleName2 = new String[3];
			cycleName2[0] = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			cycleName2[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 13);
			cycleName2[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 12, 14);

			bp.waitForElement();
			tp = new TestPlanningPage(driver);
			bp.waitForElement();
			bp.waitForElement();
			actual[32] = tp.navigateToCycle(cycleName2);
			bp.waitForElement();

		
			exep = new ExecutionPage(driver);
			actual[33] = exep.executeStatus(tcNo1[0], statusType1);


			actual[34] = exep.executeStatus(tcNo2[0], statusType2);

			actual[35] = exep.executeStatus(tcNo3[0], statusType3);

			actual[36] = exep.executeStatus(tcNo4[0], statusType4);
			
			actual[37] = exep.executeStatus(tcNo5[0], statusType5);

			bp.waitForElement();
			tp.doubleClickOnCycle(cycleName[0]);
		} catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
	
	@When("^User Launch Requirements and create a node$")
	public void user_Launch_Requirements_and_create_a_node() throws Throwable {
	    try
	    {
	    	rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[38] = rp.clickOnRequirements();
			bp.waitForElement();
			
			String reqp_Name1 = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 16, 14);
			String reqp_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 16, 15);
			String[] reqphase = new String[1];
			reqphase[0] = reqp_Name1;
			String releaseName =Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			tr.clickOnRelease(releaseName);
			actual[39] = req.addNode(reqp_Name1, reqp_Desc1);
			bp.waitForElement();
			tr.doubleClickOnRelease(releaseName);
			actual[40] = tr.navigateToNode(releaseName, reqphase);
			
	    }
	    catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User create a requirements with different priority values$")
	public void user_create_a_requirements_with_different_priority_values() throws Throwable {
	    try
	    {
	    	actual[41] = req.addRequirement();
	    	
	    	tr.clickDetailButton();
			String name=Excel_Lib.getData(INPUT_PATH_3,"Requirement",100,100);
	    	String altID=Excel_Lib.getData(INPUT_PATH_3,"Requirement",6,0);
	    	String link=Excel_Lib.getData(INPUT_PATH_3,"Requirement",6,0);
	    	String priority=Excel_Lib.getData(INPUT_PATH_3,"FreeForm",1,20);
	    	String Description=Excel_Lib.getData(INPUT_PATH_3,"Requirement",6,0);
	    	actual[42]=req.enterRequirementDetails(name, altID, link, priority, Description);
	    	
	    	actual[43] = req.addRequirement();
	    	String priority2=Excel_Lib.getData(INPUT_PATH_3,"FreeForm",2,20);
	    	actual[10]=req.enterRequirementDetails(name, altID, link, priority2, Description);
	    	
	    	actual[44] = req.addRequirement();
	    	String priority3=Excel_Lib.getData(INPUT_PATH_3,"FreeForm",1,20);
	    	actual[45]=req.enterRequirementDetails(name, altID, link, priority3, Description);
	    	
	    	actual[46] = req.addRequirement();
	    	String priority4=Excel_Lib.getData(INPUT_PATH_3,"FreeForm",2,20);
	    	actual[47]=req.enterRequirementDetails(name, altID, link, priority4, Description);
	    }
	    catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
	
	
	@Then("^User map testcases to the requirement$")
	public void user_map_testcases_to_the_requirement() throws Throwable {
	   try
	   {
		   actual[48] = req.MapTestCases();
			bp.waitForElement();
			String releaseName = Excel_Lib.getData(INPUT_PATH_3, "Releases", 2, 0);
			actual[49] = req.ExpandRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String[] fields = new String[1];
			fields[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_3, "Requirement", 11, 14);
			bp.waitForElement();
			bp.waitForElement();
			actual[50] = tr.navigateNode(fields);
			bp.waitForElement();

			String[] testCaseNo = new String[3];
			testCaseNo[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 4));
			testCaseNo[1] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 4));
			testCaseNo[2] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 4));
			actual[51] = req.mapTestCasesToRequirementsFromGrids(testCaseNo);
			bp.waitForElement();

			actual[52] = req.saveJiraRequirement();
			
			
			tr.clickOnList();
	   }
	   
	   catch (Exception e) {
			lb = new LaunchBrowser();
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
