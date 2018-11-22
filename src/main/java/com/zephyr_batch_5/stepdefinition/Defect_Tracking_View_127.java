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

public class Defect_Tracking_View_127 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_View_127";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the projectPage$")
	public void user_is_in_the_projectPage() throws Throwable {
	try
	   {
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 dt=new DefectTracking(driver);
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
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

	@When("^User select the release to launch defect tracking$")
	public void user_select_the_release_to_launch_defect_tracking() throws Throwable {
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

	@When("^User navigate to the defect tracking page$")
	public void user_navigate_to_the_defect_tracking_page() throws Throwable {
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

	@Then("^Should be able to launch DT app$")
	public void should_be_able_to_launch_DT_app() throws Throwable {
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

	@When("^check the dropdown attributes of Issuetype/priority/status/version without selecting the project$")
	public void check_the_dropdown_attributes_of_Issuetype_priority_status_version_without_selecting_the_project() throws Throwable {
	try
	   {
		 Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,1000);
		 String[] fields=new String[7];
		 for(int i=0;i<=6;i++)
		 {
			 fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100); 
		 }
		 actual[4]=dt.defectSearch(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
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

	@Then("^Should show all these dropdown should be empty if project is not selected$")
	public void should_show_all_these_dropdown_should_be_empty_if_project_is_not_selected() throws Throwable {
	try
	   {
		String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1); 
		String statusValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1); 
		String versionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,1);
		String priorityValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1);
		String fieldValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,15); 
		actual[5]=dt.viewDropdownFields(issueType, fieldValue);
		actual[6]=dt.viewDropdownFields(statusValue, fieldValue);
		actual[7]=dt.viewDropdownFields(versionValue, fieldValue);
		actual[8]=dt.viewDropdownFields(priorityValue, fieldValue);
		
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
