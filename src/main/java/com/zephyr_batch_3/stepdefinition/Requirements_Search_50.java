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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Requirements_Search_50 extends LaunchBrowser {
	BasePage bp;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	RequirementsPage req;
	ExportPage ep;
	NavigationPage np;
	String fileName="Requirements_Search_50";
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	@Given("^user is in search window of requirement page$")
	public void user_is_in_search_window_of_requirement_page() throws Throwable {
		try{
			pp=new ProjectPage(driver);
		    rp=new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_2");
			  actual[0]=pp.selectProject(projectName);
			  actual[1]=pp.selectRelease(releaseName);
			  bp=new BasePage();
			  bp.waitForElement();
			  actual[2]=rp.clickOnRequirements();
			  bp.waitForElement();
			  tr=new TestRepositoryPage(driver);
			  bp.waitForElement();
			  actual[3]=tr.clickOnSearch();
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@When("^User Uncheck in this release option$")
	public void user_Uncheck_in_this_release_option() throws Throwable {
		try{
			ep= new ExportPage(driver);
			bp.waitForElement();
			actual[4]=ep.UnselectInTheseRelease();
		}
	   catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@And("^Click on export button in search window$")
	public void click_on_export_button_in_search_window() throws Throwable {
		try
		{
		
			req=new RequirementsPage(driver);
			actual[5]=req.exportRequirement();
	     
		}
		catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@Then("^user Should export all the search results$")
	public void user_should_export_all_the_search_results() throws Throwable {
		try{
			actual[6]=req.saveAndDownload();
		}
		catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@When("^Uncheck in this release and select multiple requirements from search requirements$")
	public void uncheck_in_this_release_and_select_multiple_requirements_from_search_requirements() throws Throwable {
		try
		{
		
			actual[7]=ep.UnselectInTheseRelease();
		String searchOption=Excel_Lib.getData(INPUT_PATH_9, "Requirement", 1, 2);
		np=new NavigationPage(driver);
		actual[8]=np.quiksearch(searchOption);
		String[] testCaseNo=new String[4];
		for(int j=0;j<4;j++)
		{
			testCaseNo[j]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_9, "Requirement", j, 3));
		}
			
			bp.waitForElement();
			actual[9]=req.selectMultipleRequirementFromGrids(testCaseNo);
		
		}
		catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}

	@And("^click on export from search window$")
	public void click_on_export_from_search_window() throws Throwable {
		try{
			bp.waitForElement();
			actual[10]=req.exportRequirement();
		}
		catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
		
		
	}
	@Then("^User should export all the search results$")
	public void User_should_export_all_the_search_results() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[11]=req.saveAndDownload();
		bp.waitForElement();
		actual[12]=tr.clickedOnFolder();
		for(int k=0;k<=actual.length-1;k++)
		  {
			   System.out.println(actual[k]);
			   soft.assertEquals(actual[k], true);
		   }
	   soft.assertAll();
		}
		catch(Exception e)
		{
		   e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE re=new Relogin_TPE();
			re.reLogin();
			throw e;
		}
	}
}
