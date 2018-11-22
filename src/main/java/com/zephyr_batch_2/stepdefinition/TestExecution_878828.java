
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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878828 extends LaunchBrowser 
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
	LoginPage lp;

	boolean[] actual = new boolean[48];
	SoftAssert soft = new SoftAssert();
	
	
	LaunchBrowser lb=new LaunchBrowser();
    String fileName="TestExecution_878828";
	
	@When("^User add a phase and add two Systems to phase$")
	public void user_add_a_phase_and_add_two_Systems_to_phase() throws Throwable {
		try {
			tr = new TestRepositoryPage(driver);
			bp = new BasePage();

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
			String phaseDesc = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			actual[1]=tr.addNode(phaseName, phaseDesc);

			actual[2]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String[] navigation=new String[1];
			navigation[0]=phaseName;
			actual[3]=tr.navigateToNode(releaseName, navigation);
			//bp.waitForElement();

			//actual[2]=tr.selectPhase(phaseName);
			String sysName1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 3);
			String sysDesc1 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 3);
			actual[4]=tr.addNode(sysName1, sysDesc1);

			bp.waitForElement();
			//actual[5]=tr.selectPhase(phaseName);
			actual[5]=tr.navigateToNode(releaseName, navigation);
			String sysName2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 4);
			String sysDesc2 = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 4);
			actual[6]=tr.addNode(sysName2, sysDesc2);

			bp.waitForElement();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
		
	}

	@When("^add ten testcase with test step to each node$")
	public void add_ten_testcase_with_test_step_to_each_node() throws Throwable {
		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
			String phaseName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
			String[] navigation=new String[1];
			navigation[0]=phaseName;
			actual[7]=tr.navigateToNode(releaseName, navigation);
			//actual[7]=tr.selectPhase(phaseName);
			actual[8]=tr.addTestCase();
            bp.waitForElement();
            actual[9]=tr.clickDetailButton();
            bp.waitForElement();
			String[] stepDetail = new String[3];
			int k = 0;
			for (int i = 19; i <= 21; i++) {
				stepDetail[k] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, i);
				k++;
			}
			ctc = new CreateTestCasePage(driver);
			actual[10] = ctc.enterTestCaseStepDetail(stepDetail);

			bp.waitForElement();
			actual[11]=tr.clickOnList();
			bp.waitForElement();
			for (int i = 1; i <= 2; i++) {
				actual[12]=tr.selectallTestCase();
				actual[13]=tr.cloneTestCase();
			}
			for (int i = 1; i <= 3; i++) {
				actual[14]=tr.cloneTestCase();
			}
			
		    
			bp.waitForElement();

			actual[15]=tr.verifyPresentTestCase();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^Create a new cycle,add phase to cycle and assign testcases to tester$")
	public void create_a_new_cycle_add_phase_to_cycle_and_assign_testcases_to_tester() throws Throwable {
	  
		try {
			ep=new ExportPage(driver);
			tp = new TestPlanningPage(driver);

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 5);
			String build = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 6);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 7);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 38, 8));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 9);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 38, 10));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 38, 11));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 12);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 38, 13));

			actual[16] = tp.clickOnAddTestCycleSymbol();

			actual[17] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[18] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[19] = tp.saveTestCycle();
			bp.waitForElement();

			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 5);
			actual[20] = tp.navigateToCycle(cycle);
			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
			actual[21] = tp.addPhaseToCycle(phase);

			actual[22] = tp.cancelBulkAssign();

			String[] nodes = new String[1];
			nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
			actual[23] = tp.navigateToCycle(nodes);
			actual[24] = tp.selectallTestCase();
			String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
			actual[25] = tp.assignAllSelected(assignee);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^testcases should be assign to tester$")
	public void testcases_should_be_assign_to_tester() throws Throwable {
		try
		{
		int[] testcase = new int[10];
		for (int i = 1; i <= testcase.length; i++) {
			testcase[i - 1] = Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i, 27);
		}
		String assignee = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "User3");
		actual[26]=tp.validateAllAssigned(testcase, assignee);
		
		pp=new ProjectPage(driver);
		actual[27]=pp.clickOnLogout();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User login as tester role$")
	public void user_login_as_tester_role() throws Throwable {
	   
		try
		{
		lp=new LoginPage(driver);
		pp=new ProjectPage(driver);
		
	   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Username_1");
	   String password=Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Tester_Password_1");
	   actual[28]=lp.enterUnameAndPassword(Uname, password);
	   bp.waitForElement();
	   String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
		actual[29]=pp.selectProject(projectName);
		actual[30]=pp.selectRelease(releaseName);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^Launch test execution page$")
	public void launch_test_execution_page() throws Throwable {
	  
		try
		{
			bp=new BasePage();
		rp=new ReleasePage(driver);
	    actual[31]=rp.clickOnTestExecution();
	    bp.waitForElement();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^execute testcases to Pass/Fail$")
	public void execute_testcases_to_Pass_Fail() throws Throwable {
		try
		{
		exp=new ExecutionPage(driver);
		String[] cycle = new String[3];
		cycle[0] = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		cycle[1] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 5);
		cycle[2] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 38, 2);
		actual[32] = tp.navigateToCycle(cycle);
		
		int[] testcase=new int[4];
		String status=Excel_Lib.getData(INPUT_PATH_2, "TestExecution",1, 17);
		for(int i=0;i<=testcase.length-1;i++)
		{
		testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i+1, 27);
		actual[33]=exp.executeStatus(testcase[i], status);
		
		}
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

		
	}

	@When("^click on Defect button and link a defect$")
	public void click_on_Defect_button_and_link_a_defect() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution",1, 27);
		actual[34]=exp.clickOnDefectButton(testcase);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects",1, 0);
		actual[35]=exp.linkDefect(defectId);
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^export testcases execution from release level in Excel format$")
	public void export_testcases_execution_from_release_level_in_Excel_format() throws Throwable {
		try
		{
			ep=new ExportPage(driver);
		String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		 actual[36]=tr.clickOnRelease(releaseName);
		
		String report_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 1, 6);
		actual[37]=ep.clickOnNodeExport();
		actual[38]=ep.reportType(report_Type);
		actual[39]=ep.saveAndDownload();
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^able to export testcases in Excel format$")
	public void able_to_export_testcases_in_Excel_format() throws Throwable {
	  try
	  {
		log.info("Test Case exported in Excel Format");
		 bp.waitForElement();
		 bp.waitForElement();
	  }
	  catch (Exception e) {
		  lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^user export testcases execution from release level in Detailed format$")
	public void user_export_testcases_execution_from_release_level_in_Detailed_format() throws Throwable {
		try
		{
		String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		 actual[40]=tr.clickOnRelease(releaseName);
			
			String report_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 2, 6);
			actual[41]=ep.clickOnNodeExport();
			actual[42]=ep.reportType(report_Type);
			actual[43]=ep.saveAndDownload();
		}
		
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^able to export testcases in Detailed format$")
	public void able_to_export_testcases_in_Detailed_format() throws Throwable 
	{
	   log.info("Test Case Exported in Detailed Format");
	   bp.waitForElement();
	}
	@When("^user export testcases execution from release level in Summary format$")
	public void user_export_testcases_execution_from_release_level_in_Summary_format() throws Throwable {
		try
		{
		String releaseName = Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 1);
		 
		 actual[44]=tr.clickOnRelease(releaseName);
			
			String report_Type=Excel_Lib.getData(INPUT_PATH_2, "Export", 3, 6);
			actual[45]=ep.clickOnNodeExport();
			actual[46]=ep.reportType(report_Type);
			actual[47]=ep.saveAndDownload();
			 bp.waitForElement();
			
		}
		catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^able to export testcases in Summary format$")
	public void able_to_export_testcases_in_Summary_format() throws Throwable {
		try
		{
			
		log.info("Test Case Exported in Summary Format");
		 bp.waitForElement();
			
		 for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		}
		
		catch (Exception e) 
		{
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}


		 
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

