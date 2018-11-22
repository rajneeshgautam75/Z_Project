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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_163 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	TestRepositoryPage tr;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_163";
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the test execution page$")
	public void user_is_in_the_test_execution_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 dt=new DefectTracking(driver);
		 actual[0]=pp.selectProject(projectName);
		 actual[1]=pp.selectRelease(releaseName);
	
		 actual[2]=rp.clickOnTestExecution(); 
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

	@When("^User navigate to the search page$")
	public void user_navigate_to_the_search_page() throws Throwable {
	try
	   {
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	    String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
	    bp.waitForElement();
		actual[3]=tr.navigateToNode(releaseName, cycleName);
		bp.waitForElement();
	
		int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    actual[4]=exep.executeStatus(tcNo1[0], statusType1);
	    actual[5]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^search the defect by wrong defect id$")
	public void search_the_defect_by_wrong_defect_id() throws Throwable {
	try
	   {
		String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,10);
	    actual[6]=exep.defectSearch(selectSearch, value);
	    actual[7]=exep.clickOnDefectSearchButton();
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

	@Then("^should get Issue does not exist$")
	public void should_get_Issue_does_not_exist() throws Throwable {
	try
	   {
		String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,42);
	    actual[8]=dt.viewDefectIssueMsg(filterValue);
		bp.waitForElement();
		actual[9]=exep.clickOnCancelDefectWindow();
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

	@When("^User launch the defect tracking page$")
	public void user_launch_the_defect_tracking_page() throws Throwable {
	try
	   {
		 actual[10]=rp.clickOnDefectTracking();
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

	@When("^search the wrong defect id$")
	public void search_the_wrong_defect_id() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,8);
		 actual[11]=dt.searchDefect(defectID);
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

	@Then("^Should get the message Issue does not exist$")
	public void should_get_the_message_Issue_does_not_exist() throws Throwable {
	try
	   {
		String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,42);
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	    actual[12]=dt.viewDefectIssueMsg(filterValue);
	    bp.waitForElement();
	    pp.selectProject(projectName);
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
