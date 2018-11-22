package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Export_Requirements_44 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	String fileName = "Exports_Requirements_44";

	boolean[] actual = new boolean[19];
	SoftAssert soft = new SoftAssert();

	@Given("^User is In the Requirements App page$")
	public void user_is_In_the_Requirements_App_page() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_REQ, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			actual[0] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[1] = pp.selectRelease(releaseName);
			bp.waitForElement();

			rp = new ReleasePage(driver);
			bp.waitForElement();
			actual[2] = rp.clickOnRequirements();
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

	@When("^User click on release and select the Export Requirements Option$")
	public void user_click_on_release_and_select_the_Export_Requirements_Option()
			throws Throwable {
		try {
			bp = new BasePage();
			ep = new ExportPage(driver);
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			tr.doubleClickOnRelease(releaseName);
			actual[3] = ep.clickOnNodeExport();
			bp.waitForElement();
			String exportType = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					2, 4);
			actual[4] = req.chooseExportType(exportType);

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

	@Then("^User perform export operation by filtering creator,priority and specific date with coverage with summary report to any format and export$")
	public void user_perform_export_operation_by_filtering_creator_priority_and_specific_date_with_coverage_with_summary_report_to_any_format_and_export()
			throws Throwable {
		try {
			req = new RequirementsPage(driver);
			ep = new ExportPage(driver);
			String[] priority = new String[2];
			priority[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 8);
			priority[1] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 8);
			String[] creator = new String[1];
			creator[0] = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"User2");
			System.out.println(creator[0]);
			//creator[1] = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"User2");
			// creator[1]=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,9);
			actual[5] = req.selectFilterBy(priority, creator);

			String syear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,
					22);
			String sday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12,
					25);
			String eday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 24));
			req.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth,
					eday);

			String coverage_Type = Excel_Lib.getData(INPUT_PATH_3,
					"Requirement", 3, 12);
			actual[6] = ep.coverageType(coverage_Type);
			String report_Type = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					1, 7);
			ep.reportType(report_Type);
			req = new RequirementsPage(driver);
			actual[7] = req.saveAndDownload();
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

	@Then("^User perform export operation by filtering creator,priority and specific date with coverage with detailed report to any format and export$")
	public void user_perform_export_operation_by_filtering_creator_priority_and_specific_date_with_coverage_with_detailed_report_to_any_format_and_export()
			throws Throwable {
		try {
			bp = new BasePage();
			ep = new ExportPage(driver);
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			tr.doubleClickOnRelease(releaseName);
			actual[8] = ep.clickOnNodeExport();
			bp.waitForElement();
			String exportType = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					2, 4);
			actual[9] = req.chooseExportType(exportType);

			String[] priority = new String[2];
			priority[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 8);
			priority[1] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 8);
			String[] creator = new String[1];
			creator[0] = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_REQ, "User2");
			// creator[1]=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,9);
			actual[10] = req.selectFilterBy(priority, creator);

			String syear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,
					22);
			String sday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12,
					25);
			String eday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 24));
			req.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth,
					eday);

			String coverage_Type = Excel_Lib.getData(INPUT_PATH_3,
					"Requirement", 3, 12);
			actual[11] = ep.coverageType(coverage_Type);
			String report_Type = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					2, 7);
			actual[12] = ep.reportType(report_Type);
			req = new RequirementsPage(driver);
			actual[13] = req.saveAndDownload();
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

	@Then("^User perform export operation by filtering creator,priority and specific date with coverage with data\\(excel\\) report to any format and export$")
	public void user_perform_export_operation_by_filtering_creator_priority_and_specific_date_with_coverage_with_data_excel_report_to_any_format_and_export()
			throws Throwable {
		try {
			bp = new BasePage();
			ep = new ExportPage(driver);
			tr = new TestRepositoryPage(driver);
			req = new RequirementsPage(driver);
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			tr.doubleClickOnRelease(releaseName);
			actual[14] = ep.clickOnNodeExport();
			bp.waitForElement();
			String exportType = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					2, 4);
			actual[15] = req.chooseExportType(exportType);

			String[] priority = new String[2];
			priority[0] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 1, 8);
			priority[1] = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 2, 8);
			String[] creator = new String[1];
			creator[0] = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_REQ, "User2");
			// creator[1]=Excel_Lib.getData(INPUT_PATH_3,"Requirement",2,9);
			actual[16] = req.selectFilterBy(priority, creator);

			String syear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 1,
					22);
			String sday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth = Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 12,
					25);
			String eday = Integer.toString(Excel_Lib.getNumberData(
					INPUT_PATH_3, "TestPlanning", 1, 24));
			req.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth,
					eday);

			String coverage_Type = Excel_Lib.getData(INPUT_PATH_3,
					"Requirement", 3, 12);
			actual[17] = ep.coverageType(coverage_Type);
			String report_Type = Excel_Lib.getData(INPUT_PATH_3, "Requirement",
					3, 7);
			ep.reportType(report_Type);
			req = new RequirementsPage(driver);
			actual[18] = req.saveAndDownload();
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
