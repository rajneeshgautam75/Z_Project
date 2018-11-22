package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCyclePhase_868100 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;

	TestPlanningPage tp;
	TestRepositoryPage tr;
	CreateTestCasePage ctc;

	boolean[] actual = new boolean[68];
	SoftAssert soft = new SoftAssert();

	 String fileName="CreateCyclePhase_868100";
	 
	@Given("^User is in project page$")
	public void user_is_in_project_page() throws Throwable {
		try {

            lb=new LaunchBrowser();
			pp = new ProjectPage(driver);

			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			actual[0] = pp.selectProject(projectName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user selects the release$")
	public void user_selects_the_release() throws Throwable {
		try {
			pp = new ProjectPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[1] = pp.selectRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on test repository$")
	public void click_on_test_repository() throws Throwable {
		try {
			rp = new ReleasePage(driver);
			actual[2] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on context menu across release and create a phase with name and description$")
	public void click_on_context_menu_across_release_and_create_a_phase_with_name_and_description() throws Throwable {

		try {
			bp = new BasePage();
			tr = new TestRepositoryPage(driver);
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[3] = tr.clickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 12);
			actual[4] = tr.addNode(name, desc);

			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to created phase and add a test case with name and description$")
	public void navigate_to_created_phase_and_add_a_test_case_with_name_and_description() throws Throwable {

		try {
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);

			String[] node1 = new String[1];
			node1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 12);

			actual[5] = tr.navigateToNode(releaseName,node1);

			actual[6] = tr.addTestCase();
			tr.clickDetailButton();
			
			ctc = new CreateTestCasePage(driver);

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 13);
			actual[7] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^test case should be added to the Phase$")
	public void test_case_should_be_added_to_the_Phase() throws Throwable {

		try {
			actual[8] = tr.verifyPresentTestCase();

		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^user click on test planning module$")
	public void user_click_on_test_planning_module() throws Throwable {

		try {
			actual[9] = rp.clickOnTestPlanning();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^create a test cycle with all fields and save it$")
	public void create_a_test_cycle_with_all_fields_and_save_it() throws Throwable {
		try {
			tp = new TestPlanningPage(driver);
			actual[10] = tp.clickOnAddTestCycleSymbol();

			String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			String build = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 3);
			String environment = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 4);
			String hide = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 11);

			String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 16, 5));
			String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 6);
			String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 16, 7));
			String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 16, 8));
			String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 9);
			String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 16, 10));

			actual[11] = tp.CreateCycle(cycleName, build, environment, hide);
			actual[12] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
					endDateMonth, endDateDay);
			actual[13] = tp.saveTestCycle();
			bp.waitForElement();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

		// tp.CreateCycle(cycle, Build, environ, hide)
	}

	@When("^navigate to created cycle and Add a phase by choosing existing phase and save it$")
	public void navigate_to_created_cycle_and_Add_a_phase_by_choosing_existing_phase_and_save_it() throws Throwable {
		try {
			String[] cycle_name1 = new String[1];
			cycle_name1[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);

			actual[14] = tp.navigateToCycle(cycle_name1);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 12);

			actual[15] = tp.addPhaseToCycle(phase);
			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[16] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase should be created under cycle$")
	public void phase_should_be_created_under_cycle() throws Throwable {

		try {
			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 12);
			actual[17] = tp.navigateToCycle(phaseName);
			bp.waitForElement();
			actual[18]=tp.goBackToCycle();
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on option across release and create a phase with long name and description$")
	public void click_on_option_across_release_and_create_a_phase_with_long_name_and_description() throws Throwable {
		try {
			actual[18] = rp.clickOnTestRep();
			tr.clickOnList();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[19] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 12);

			actual[20] = tr.addNode(name, desc);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@When("^navigate to the created long name phase and add a test case with name and description$")
	public void navigate_to_the_created_long_name_phase_and_add_a_test_case_with_name_and_description()
			throws Throwable {

		try {

			String[] node = new String[1];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 12);

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);

			actual[21] = tr.navigateToNode(releaseName,node);
			actual[22] = tr.addTestCase();
			tr.clickOnDetails();
			

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 13);
			actual[23] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
			bp.waitForElement();
			tr.clickOnList();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the created test cycle and Add a phase by choosing existing long name phase and save it$")
	public void select_the_created_test_cycle_and_Add_a_phase_by_choosing_existing_long_name_phase_and_save_it()
			throws Throwable {
		try {
			// tp.goBackToCycle();
			 
			 
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			actual[24] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 12);
			actual[25] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[26] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase with long name should be added to the test cycle$")
	public void phase_with_long_name_should_be_added_to_the_test_cycle() throws Throwable {
		try {

			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 17, 12);
			actual[27] = tp.navigateToCycle(phaseName);
			
			
			
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on option across release and create a phase with special character and save it$")
	public void click_on_option_across_release_and_create_a_phase_with_special_character_and_save_it()
			throws Throwable {
		try {
			actual[28] = rp.clickOnTestRep();
			bp.waitForElement();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[29] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 12);

			actual[30] = tr.addNode(name, desc);
			bp.waitForElement();
			//tr.doubleClickOnRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the Created special character phase and add a test case with name and description$")
	public void navigate_to_the_Created_special_character_phase_and_add_a_test_case_with_name_and_description()
			throws Throwable {
		try {
			String[] node = new String[1];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 12);

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);

			actual[31] = tr.navigateToNode(releaseName,node);
			actual[32] = tr.addTestCase();
			tr.clickOnDetails();
			

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 13);
			actual[33] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
			tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the created test cycle and Add a phase by choosing existing special character phase name and save it$")
	public void select_the_created_test_cycle_and_Add_a_phase_by_choosing_existing_special_character_phase_name_and_save_it()
			throws Throwable {

		try {
			 rp.clickOnTestPlanning();
			 bp.waitForElement();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			actual[34] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 12);
			actual[35] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[36] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^special character phase should be added to the test cycle$")
	public void special_character_phase_should_be_added_to_the_test_cycle() throws Throwable {
		try {
			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 18, 12);
			actual[37] = tp.navigateToCycle(phaseName);
			
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on option across release and create a phase with alphanumeric character and save it$")
	public void click_on_option_across_release_and_create_a_phase_with_alphanumeric_character_and_save_it()
			throws Throwable {
		try {
			bp.waitForElement();
			actual[38] = rp.clickOnTestRep();
  
			bp.waitForElement();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[39] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 12);
			String desc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 12);

			actual[40] = tr.addNode(name, desc);
			bp.waitForElement();
			//tr.doubleClickOnRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the created alphanumeric phase and Add a test case with name and description$")
	public void navigate_to_the_created_alphanumeric_phase_and_Add_a_test_case_with_name_and_description()
			throws Throwable {
		try {
			String[] node = new String[1];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 12);

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);

			actual[41] = tr.navigateToNode(releaseName,node);
			actual[42] = tr.addTestCase();
			tr.clickOnDetails();
			 bp.waitForElement();
			 

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 13);
			actual[43] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
			tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the created test cycle and Add a phase by choosing existing alphanumeric character phase name and save it$")
	public void select_the_created_test_cycle_and_Add_a_phase_by_choosing_existing_alphanumeric_character_phase_name_and_save_it()
			throws Throwable {
		try {
			rp.clickOnTestPlanning();
			 bp.waitForElement();
			 
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			actual[44] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 12);
			actual[45] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[46] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

	}

	@Then("^alphanumeric phase should be added to the test cycle$")
	public void alphanumeric_phase_should_be_added_to_the_test_cycle() throws Throwable {
		try {
			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 19, 12);
			actual[47] = tp.navigateToCycle(phaseName);
			
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on option across release and create a phase with numbers character and save it$")
	public void click_on_option_across_release_and_create_a_phase_with_numbers_character_and_save_it()
			throws Throwable {
		try {
			actual[48] = rp.clickOnTestRep();
			bp.waitForElement();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[49] = tr.doubleClickOnRelease(releaseName);
			String name = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 20, 12));
			String desc = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 20, 12));

			actual[50] = tr.addNode(name, desc);
			bp.waitForElement();
			//tr.doubleClickOnRelease(releaseName);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the created numbers character phase and Add a test case with name and description$")
	public void navigate_to_the_created_numbers_character_phase_and_Add_a_test_case_with_name_and_description()
			throws Throwable {
		try {
			String[] node = new String[1];
			node[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 20, 12));

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);

			actual[51] = tr.navigateToNode(releaseName,node);
			actual[52] = tr.addTestCase();
			tr.clickOnDetails();
			

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 20, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 20, 13);
			actual[53] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
		tr.clickOnList();			
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the created test cycle and Add a phase by choosing existing numbers character phase name and save it$")
	public void select_the_created_test_cycle_and_Add_a_phase_by_choosing_existing_numbers_character_phase_name_and_save_it()
			throws Throwable {
		try {
			rp.clickOnTestPlanning();
			 bp.waitForElement();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			actual[54] = tp.navigateToCycle(cycle);

			String phase = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 20, 12));
			actual[55] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[56] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase\\(numbers\\) should be added to the test cycle$")
	public void phase_numbers_should_be_added_to_the_test_cycle() throws Throwable {
		try {
			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "CreateTestCycle", 20, 12));
			actual[57] = tp.navigateToCycle(phaseName);
			
			tp.goBackToCycle();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^click on option across release and create a phase with Capital letters and save it$")
	public void click_on_option_across_release_and_create_a_phase_with_Capital_letters_and_save_it() throws Throwable {
		try {
			actual[58] = rp.clickOnTestRep();
			bp.waitForElement();
			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
			actual[59] = tr.doubleClickOnRelease(releaseName);
			String name = UNIQUE + (Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 12));
			String desc = (Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 12));

			actual[60] = tr.addNode(name, desc);
			bp.waitForElement();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^navigate to the created capital letters phase and Add a test case with name and description$")
	public void navigate_to_the_created_capital_letters_phase_and_Add_a_test_case_with_name_and_description()
			throws Throwable {

		try {
			String[] node = new String[1];
			node[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 12);

			String releaseName = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 1, 1);
            bp.waitForElement();
			actual[61] = tr.navigateToNode(releaseName,node);
			actual[62] = tr.addTestCase();
			tr.clickOnDetails();

			String testname = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 13);
			String testdesc = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 13);
			actual[63] = ctc.enterTestCaseNameAndDesc(testname, testdesc);
			tr.clickOnList();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@When("^select the created test cycle and Add a phase by choosing existing Capital letters phase name and save it$")
	public void select_the_created_test_cycle_and_Add_a_phase_by_choosing_existing_Capital_letters_phase_name_and_save_it()
			throws Throwable {
		try {
			rp.clickOnTestPlanning();
			
			 bp.waitForElement();
			String[] cycle = new String[1];
			cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 2);
			actual[64] = tp.navigateToCycle(cycle);

			String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 12);
			actual[65] = tp.addPhaseToCycle(phase);

			String bulkType = Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 16, 15);
			actual[66] = tp.bulkAssignment(bulkType);
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^phase\\(Capital letters\\) should be added to the test cycle$")
	public void phase_Capital_letters_should_be_added_to_the_test_cycle() throws Throwable {
		try {
			String[] phaseName = new String[1];
			// phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,
			// "CreateTestCycle", 16, 2);
			phaseName[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "CreateTestCycle", 21, 12);
			actual[67] = tp.navigateToCycle(phaseName);
			
			tp.goBackToCycle();

			for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
}
