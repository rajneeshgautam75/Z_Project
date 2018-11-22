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

public class Defect_Tracking_View_128 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_View_128";
	
	boolean[] actual=new boolean[8];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Projectpage$")
	public void user_is_in_the_Projectpage() throws Throwable {
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

	@When("^User select the release in the project page$")
	public void user_select_the_release_in_the_project_page() throws Throwable {
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

	@When("^User navigate to the DT page$")
	public void user_navigate_to_the_DT_page() throws Throwable {
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

	@Then("^Should be able to launch DT Page$")
	public void should_be_able_to_launch_DT_Page() throws Throwable {
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

	@When("^check the dropdown attributes of Issue type/Version/Priority after selecting the project$")
	public void check_the_dropdown_attributes_of_Issue_type_Version_Priority_after_selecting_the_project() throws Throwable {
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

	@Then("^all these dropdowns should show values after project and issuetype selection$")
	public void all_these_dropdowns_should_show_values_after_project_and_issuetype_selection() throws Throwable {
	try
	   {
		String statusName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,1); 
		String statusValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,3);
		String versionName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,1); 
		String versionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
		String priorityName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1); 
		String priorityValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,6);
		actual[5]=dt.viewDropdownFields(statusName,statusValue);
		actual[6]=dt.viewDropdownFields(versionName,versionValue);
		actual[7]=dt.viewDropdownFields(priorityName,priorityValue);
		
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
