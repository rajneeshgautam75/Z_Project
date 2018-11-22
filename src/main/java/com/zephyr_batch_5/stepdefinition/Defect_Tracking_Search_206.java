package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_206 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_Search_206";
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User is in a Page Of DefectTracking$")
	public void user_is_in_a_Page_Of_DefectTracking() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);	
			bp.waitForElement();
			actual[2]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	    
	}

	@When("^user search defects by project with long project name using JQL$")
	public void user_search_defects_by_project_with_long_project_name_using_JQL() throws Throwable {
	    try
	    {
	    	String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 19, 2);
			bp.waitForElement();
			actual[3]=dt.advancedSearch(jql, value);
	    }
	    catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@Then("^should search defects by project with long project name using JQL$")
	public void should_search_defects_by_project_with_long_project_name_using_JQL() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[4]=req.verifySearchRequirementCount();	
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	    
	}

	@When("^user searches defects by project with project name having numbers using JQL$")
	public void user_searches_defects_by_project_with_project_name_having_numbers_using_JQL() throws Throwable {
		 try
		    {
		    	String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
				String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 22, 2);
				actual[5]=dt.clickOnBasicSearch();
				bp.waitForElement();
				actual[6]=dt.advancedSearch(jql, value);
		    }
		    catch(Exception e)
		    {
				 lb=new LaunchBrowser();
				 lb.getScreenShot(fileName);
				 e.printStackTrace();
				 driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				 rl.reLogin();
				 throw e;	
		    } 
	}

	@Then("^should search defects by project with project name having numbers using JQL$")
	public void should_search_defects_by_project_with_project_name_having_numbers_using_JQL() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[7]=req.verifySearchRequirementCount();
			bp.waitForElement();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	      
	}

	@When("^user searches defects by project with project name having special chars using JQL$")
	public void user_searches_defects_by_project_with_project_name_having_special_chars_using_JQL() throws Throwable {
		 try
		    {
		    	String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
				String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 21, 2);
				actual[8]=dt.clickOnBasicSearch();
				bp.waitForElement();
				actual[9]=dt.advancedSearch(jql, value);
		    }
		    catch(Exception e)
		    {
				 lb=new LaunchBrowser();
				 lb.getScreenShot(fileName);
				 e.printStackTrace();
				 driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				 rl.reLogin();
				 throw e;	
		    }  
	}

	@Then("^should able to search defects by project with project name having special chars$")
	public void should_able_to_search_defects_by_project_with_project_name_having_special_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[10]=req.verifySearchRequirementCount();
			bp.waitForElement();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^user searches defects by project with project name having apha numeric chars using JQL$")
	public void user_searches_defects_by_project_with_project_name_having_apha_numeric_chars_using_JQL() throws Throwable {
		 try
		    {
		    	String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
				String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 20, 2);
				actual[11]=dt.clickOnBasicSearch();
				bp.waitForElement();
				actual[12]=dt.advancedSearch(jql, value);
		    }
		    catch(Exception e)
		    {
				 lb=new LaunchBrowser();
				 lb.getScreenShot(fileName);
				 e.printStackTrace();
				 driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				 rl.reLogin();
				 throw e;	
		    } 
	}

	@Then("^should search defects by project with project name having apha numeric chars$")
	public void should_search_defects_by_project_with_project_name_having_apha_numeric_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[13]=req.verifySearchRequirementCount();
			bp.waitForElement();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^user search defects by project with project name having international chars using JQL$")
	public void user_search_defects_by_project_with_project_name_having_international_chars_using_JQL() throws Throwable {
		 try
		    {
		    	String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
				String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 23, 2);
				actual[14]=dt.clickOnBasicSearch();
				bp.waitForElement();
				actual[15]=dt.advancedSearch(jql, value);
		    }
		    catch(Exception e)
		    {
				 lb=new LaunchBrowser();
				 lb.getScreenShot(fileName);
				 e.printStackTrace();
				 driver.close();
				 Relogin_TPE rl=new Relogin_TPE();
				 rl.reLogin();
				 throw e;	
		    }
	}

	@Then("^should able to search defects by project with project name having international chars$")
	public void should_able_to_search_defects_by_project_with_project_name_having_international_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[16]=req.verifySearchRequirementCount();
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}
}
