package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Attachment_28 extends LaunchBrowser{
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	String fileName = "Attachment_28";

	boolean[] actual = new boolean[13];
	SoftAssert soft = new SoftAssert();


	@Given("^User is in the Requirements app$")
	public void user_is_in_the_Requirements_app() throws Throwable {
		try {
			bp = new BasePage();
			pp = new ProjectPage(driver);
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH
					+ CONFIG_FILE_REQ, "Normal_Project_1");
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
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

	@When("^User create the Phase$")
	public void user_create_the_Phase() throws Throwable {
		try {
			String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
			String p_Name1 = UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 14, 14);
			String p_Desc1 = Excel_Lib.getData(INPUT_PATH_3, "Requirement", 14,
					15);

			req = new RequirementsPage(driver);
			actual[3] = req.doubleClickOnRelease(releaseName);

			actual[4] = req.addNode(p_Name1, p_Desc1);
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

	@When("^User add more than hundred requirements to the phase$")
	public void user_add_more_than_hundred_requirements_to_the_phase() throws Throwable {
		 try
			{
				String releaseName = Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
				String p_Name1 = UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Requirement", 14, 14);
				String[] phase = new String[1];
				phase[0] = p_Name1;
				tr = new TestRepositoryPage(driver);
				bp.waitForElement();
				actual[5] = tr.navigateToNode(releaseName, phase);
				for(int i=1;i<=5;i++)
				{
					actual[6]=req.addRequirement();
				}
				for(int i=1;i<=5;i++)
				{
					req.selectAllRequirements();
					actual[6]=req.cloneRequirement();
					bp.waitForElement();
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

	@Then("^User able to change default page size of fifty to ten and select page number three$")
	public void user_able_to_change_default_page_size_of_fifty_to_ten_and_select_page_number_three() throws Throwable {
	   try
	   {
		   
		    tr=new TestRepositoryPage(driver);
		    String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 1, 5));
			actual[7]=req.selectTestCasesPerPage(pageNumber);
			bp.waitForElement();
			int pageNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 6);
			actual[8]=req.selectPageNumbers(pageNo);
			bp.waitForElement();
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

	@Then("^User able to change the page size from ten to twenty five and select page number three$")
	public void user_able_to_change_the_page_size_from_ten_to_twenty_five_and_select_page_number_three() throws Throwable {
		try
		   {
			    tr=new TestRepositoryPage(driver);
			    req=new RequirementsPage(driver);
			    String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 5));
				actual[9]=req.selectTestCasesPerPage(pageNumber);
				bp.waitForElement();
				int pageNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 3, 6);
				actual[10]=req.selectPageNumbers(pageNo);
				bp.waitForElement();  
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

	@Then("^User able to change the page size from twenty five to hunderd and select page number two$")
	public void user_able_to_change_the_page_size_from_twenty_five_to_hunderd_and_select_page_number_two() throws Throwable {
		try
		   {
			tr=new TestRepositoryPage(driver);
		    req=new RequirementsPage(driver);
		    String pageNumber=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 4, 5));
			actual[11]=req.selectTestCasesPerPage(pageNumber);
			bp.waitForElement();
			int pageNo=Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases", 2, 6);
			actual[12]=req.selectPageNumbers(pageNo);
			bp.waitForElement();  
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
