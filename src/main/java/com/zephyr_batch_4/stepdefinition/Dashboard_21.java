package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Dashboard_21 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestPlanningPage tp;
	DashBoardPage db;
	String fileName = "Dashboard_21";
	boolean[] actual = new boolean[11];
	SoftAssert soft = new SoftAssert();

	@Given("^user in project page and launch dashboard$")
	public void user_in_project_page_and_launch_dashboard() throws Throwable {
		try {
			bp = new BasePage();
			rp = new ReleasePage(driver);
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			actual[0] = pp.selectProject(projectName);
			db = new DashBoardPage(driver);

			//// releaese2
			rp.clickOnManageRelease();
			String release2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_2");
			String Desc1 = Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 9, 1);
			String Hide = Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100, 100);
			String MapexternalDefect = Excel_Lib.getData(INPUT_PATH_4, "AddReleases", 100, 100);
			boolean val = rp.checkAvailableRelease(release2);
			if (val == false) {
				rp.addNewRelease(release2, Desc1, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
			}
			/// release3
			String release3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_3");
			boolean val1 = rp.checkAvailableRelease(release3);
			if (val1 == false) {
				rp.addNewRelease(release3, Desc1, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
			}

			/// release4
			String release4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_4");
			boolean val2 = rp.checkAvailableRelease(release4);
			if (val2 == false) {
				rp.addNewRelease(release4, Desc1, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
			}
			/// release5
			String release5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
			boolean val3 = rp.checkAvailableRelease(release5);
			if (val3 == false) {
				rp.addNewRelease(release5, Desc1, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
			}
			/// release6
			String release6 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_6");
			boolean val4 = rp.checkAvailableRelease(release6);
			if (val4 == false) {
				rp.addNewRelease(release6, Desc1, Hide, MapexternalDefect);
				String syear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String smonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String sday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				String eyear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
				String emonth = Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
				String eday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
				rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
				rp.clickOnAdd();
			}
			db.clickOnManageDashboards();
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

	@When("^Add multiple Test Automation Status Gadget and change the Dashboard layouts from one to two$")
	public void add_multiple_Test_Automation_Status_Gadget_and_change_the_Dashboard_layouts_from_one_to_two()
			throws Throwable {
		try {
			db = new DashBoardPage(driver);
			bp = new BasePage();
			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 4, 0);
			String desc = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 4, 1);
			String layout = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 2);
			String shareType = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 3);
			actual[4] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[5] = db.validateDashBoard(dashboardName);

			actual[6] = db.selectDashboard(dashboardName);
			for (int i = 0; i < 10; i++) {
				actual[7] = db.clickOnAddGadgetSymbol();
				String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
				actual[8] = db.addGadget(gadgetName);
				bp.waitForElement();
				db.validateGadget(gadgetName);

				bp.waitForElement();
				bp.waitForElement();
				String release = "";
				String refreshRate = "";

				String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
				db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			}
			String layout1 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2, 2);
			db.layoutSelection(layout1);
		
			bp.waitForElement();
			db.closeNotification.click();
			bp.waitForElement();
			
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

	@When("^Add multiple Test Automation Status Gadget with different projects in same dashabord$")
	public void add_multiple_Test_Automation_Status_Gadget_with_different_projects_in_same_dashabord()
			throws Throwable {
		try {

			//////////// crete releases
			actual[7] = db.clickOnAddGadgetSymbol();
			String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
			actual[8] = db.addGadget(gadgetName);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName2, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Restricted_Project_1");
			actual[9] = db.configureTestAutomationStatusGadget(projectName3, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Restricted_Project_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName4, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Isolated_Project_1");
			actual[9] = db.configureTestAutomationStatusGadget(projectName5, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName6 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName6, release, refreshRate);

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

	@When("^Add multiple Test Automation Status Gadget with same projects but different releases in same dashabord$")
	public void add_multiple_Test_Automation_Status_Gadget_with_same_projects_but_different_releases_in_same_dashabord()
			throws Throwable {
		try {
			actual[7] = db.clickOnAddGadgetSymbol();
			String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
			actual[8] = db.addGadget(gadgetName);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String release2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release2, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String release3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_3");
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release3, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String release4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_4");
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release4, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String release5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release5, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String release6 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_6");
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release6, refreshRate);
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

	@When("^Add multiple Test Automation Status Gadget with same project release but different refresh intervals$")
	public void add_multiple_Test_Automation_Status_Gadget_with_same_project_release_but_different_refresh_intervals()
			throws Throwable {
		try {
			actual[7] = db.clickOnAddGadgetSymbol();
			String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
			actual[8] = db.addGadget(gadgetName);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String refreshRate2 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 2, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate2);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String refreshRate3 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate3);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String refreshRate4 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 4, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate4);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String refreshRate5 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 5, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate5);

			bp.waitForElement();
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String refreshRate6 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 6, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate6);
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

	@When("^Add Test Automation Status Gadget in multiple Dashboards atleast five Dashboards with same project and release$")
	public void add_Test_Automation_Status_Gadget_in_multiple_Dashboards_atleast_five_Dashboards_with_same_project_and_release()
			throws Throwable {
		try {
			db.clickOnManageDashboards();
			bp = new BasePage();
			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 4, 0);
			String desc = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 4, 1);
			String layout = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 2);
			String shareType = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 3);
			actual[4] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 5, 0);
			String desc2 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 5, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName2, desc2, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName3 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 6, 0);
			String desc3 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 6, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName3, desc3, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName4 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 7, 0);
			String desc4 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 7, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName4, desc4, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName5 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 8, 0);
			String desc5 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 8, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName5, desc5, layout, shareType);

			db.searchDashboard(dashboardName);
			actual[6] = db.selectDashboard(dashboardName);
			actual[7] = db.clickOnAddGadgetSymbol();
			String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
			actual[8] = db.addGadget(gadgetName);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName2);
			actual[6] = db.selectDashboard(dashboardName2);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName3);
			actual[6] = db.selectDashboard(dashboardName3);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName4);
			actual[6] = db.selectDashboard(dashboardName4);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName5);
			actual[6] = db.selectDashboard(dashboardName5);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

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

	@Then("^Add Test Automation Status Gadget in multiple Dashboards atleast five Dashboards with different project and release$")
	public void add_Test_Automation_Status_Gadget_in_multiple_Dashboards_atleast_five_Dashboards_with_different_project_and_release()
			throws Throwable {
		try {
			db.clickOnManageDashboards();
			bp = new BasePage();
			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 9, 0);
			String desc = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 1);
			String layout = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 2);
			String shareType = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 3);
			actual[4] = db.enterDashBoardDetails(dashboardName, desc, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName2 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 10, 0);
			String desc2 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName2, desc2, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName3 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 11, 0);
			String desc3 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName3, desc3, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName4 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 12, 0);
			String desc4 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName4, desc4, layout, shareType);

			actual[3] = db.clickOnAddDashBoardSymbol();
			String dashboardName5 = UNIQUE + Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 13, 0);
			String desc5 = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 3, 1);
			actual[4] = db.enterDashBoardDetails(dashboardName5, desc5, layout, shareType);

			db.searchDashboard(dashboardName);
			actual[6] = db.selectDashboard(dashboardName);
			actual[7] = db.clickOnAddGadgetSymbol();
			String gadgetName = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 4);
			actual[8] = db.addGadget(gadgetName);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_1");
			String release = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			String refreshRate = Excel_Lib.getData(INPUT_PATH_4, "Dashboard", 1, 5);
			actual[9] = db.configureTestAutomationStatusGadget(projectName, release, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName2);
			actual[6] = db.selectDashboard(dashboardName2);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Normal_Project_2");
			String release2 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName2, release2, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName3);
			actual[6] = db.selectDashboard(dashboardName3);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Restricted_Project_1");
			String release3 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			actual[9] = db.configureTestAutomationStatusGadget(projectName3, release3, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName4);
			actual[6] = db.selectDashboard(dashboardName4);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Restricted_Project_2");
			String release4 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_2");
			actual[9] = db.configureTestAutomationStatusGadget(projectName4, release4, refreshRate);

			db.clickOnManageDashboards();
			db.searchDashboard(dashboardName5);
			actual[6] = db.selectDashboard(dashboardName5);
			actual[7] = db.clickOnAddGadgetSymbol();
			actual[8] = db.addGadget(gadgetName);
			String projectName5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Isolated_Project_1");
			String release5 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_1");
			actual[9] = db.configureTestAutomationStatusGadget(projectName5, release5, refreshRate);

			
			pp.backToProjectPage();
			actual[10] = pp.selectProject(projectName);
			rp.clickOnManageRelease();
//			pp.deleteRelease(release2);
//			pp.deleteRelease(release3);
//			pp.deleteRelease(release4);
//			pp.deleteRelease(release5);
			String release6 = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_DASH, "Release_5");
//			pp.deleteRelease(release6);

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
}
