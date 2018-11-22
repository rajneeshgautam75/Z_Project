package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_View_129 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_View_129";
	
	boolean[] actual=new boolean[6];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the project selection page$")
	public void user_is_in_the_project_selection_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 dt=new DefectTracking(driver);
		 actual[0]=pp.selectProject(projectName);
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

	@When("^User select the release in a project page$")
	public void user_select_the_release_in_a_project_page() throws Throwable {
	try
	   {
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
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

	@When("^User navigate to the DefectTracking page$")
	public void user_navigate_to_the_DefectTracking_page() throws Throwable {
	try
	   {
		 actual[2]=pp.clickOnDefectTracking();
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

	@Then("^Should be able to launch DefectTracking$")
	public void should_be_able_to_launch_DefectTracking() throws Throwable {
	try
	   {
		 actual[3]=dt.validateDefectTrackingPage();
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

	@When("^check the dropdown attributes of status after selecting the project and issuetype$")
	public void check_the_dropdown_attributes_of_status_after_selecting_the_project_and_issuetype() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,0);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 String[] fields=new String[5];
		 for(int i=0;i<=4;i++)
		 {
			 fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100); 
		 }
		 actual[4]=dt.defectSearch(projectName,issueType,fields[0],fields[1],fields[2],fields[3],fields[4]);
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

	@Then("^status dropdown should show values after project and issue type selection$")
	public void status_dropdown_should_show_values_after_project_and_issue_type_selection() throws Throwable {
	try
	   {
		String statusName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1);
		String statusValue1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,3);
		actual[5]=dt.viewDropdownFields(statusName,statusValue1);
		
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
