package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_154 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_Search_154";
	
	boolean[] actual=new boolean[14];
	SoftAssert soft=new SoftAssert(); 	
	
	@Given("^User is in the Defect Tracking page$")
	public void user_is_in_the_Defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 dt=new DefectTracking(driver);
		 exep=new ExecutionPage(driver);
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[0]=rp.clickOnDefectTracking();
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

	@When("^User search a issue with ASC operator using JQL$")
	public void user_search_a_issue_with_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,36);
		 actual[1]=dt.advancedSearch(selectSearch, value);
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

	@Then("^Should be search issues with ASC operator using JQL$")
	public void should_be_search_issues_with_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,6);
		 actual[2]=dt.validateSearchedDefect(defectType, defectValue);
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

	@When("^User launch requirements and search issues with ASC operator using JQL$")
	public void user_launch_requirements_and_search_issues_with_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 bp.waitForElement();
		 String importType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,37);
		 req=new RequirementsPage(driver);
		 bp.waitForElement();
		 actual[3]=rp.clickOnRequirements();
		 bp.waitForElement();
		 bp.waitForElement();
		 actual[4]=req.clickOnImport();
		 actual[5]=req.chooseImportType(importType);
		 String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
		 String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,36 );
		 actual[6]=req.selectQuerry(selectQuerry, enterQuerry);
	     req.clickjiraSearchButton.click();
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

	@Then("^Should be able to Search issue ASC operator using JQL$")
	public void should_be_able_to_Search_issue_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,6);
		 actual[7]=req.validateSearchedDefect(defectType, defectValue);
		 bp.waitForElement();
		 bp.waitForElement();
		 dt.jiraCancelButton.click();
		 bp.waitForElement();
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

	@When("^User Launch the TestExecution to search The issues$")
	public void user_Launch_the_TestExecution_to_search_The_issues() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[7]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    bp.waitForElement();
			actual[8]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[9]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[10]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^search a issues with ASC operator using JQL$")
	public void search_a_issues_with_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,36);
		 actual[11]=exep.defectSearch(selectSearch, value);
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

	@Then("^Should be able to search a issue ASC operator using JQL$")
	public void should_be_able_to_search_a_issue_ASC_operator_using_JQL() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,6);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[12]=exep.validateSearchedDefect(defectType, defectValue);
		 
		 bp.waitForElement();
		 exep.cancelDefect.click();
		 bp.waitForElement();
		 tp=new TestPlanningPage(driver);
		 actual[13]=tp.doubleClickOnCycle(releaseName);
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
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
