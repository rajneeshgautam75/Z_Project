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

public class Defect_Tracking_Search_169 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_Search_169";
	
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the Project_page$")
	public void user_is_in_the_Project_page() throws Throwable {
	try
    {
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
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

	@When("^User navigate to the Defect Tracking$")
	public void user_navigate_to_the_Defect_Tracking() throws Throwable {
	try
    {
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnDefectTracking();
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

	@When("^search a creators by partial username using single character$")
	public void search_a_creators_by_partial_username_using_single_character() throws Throwable {
	try
    {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,44);
		 actual[3]=dt.filterDefectCreator(assignee);
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

	@Then("^Dropdown menu should populate the matching users with partial username$")
	public void dropdown_menu_should_populate_the_matching_users_with_partial_username() throws Throwable {
	try
    {
	     actual[4]=dt.filterCreatorValues();
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

	@When("^User filter a creators by partial first name$")
	public void user_filter_a_creators_by_partial_first_name() throws Throwable {
	try
    {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,44);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 rp.clickOnDefectTracking();
		 actual[5]=dt.filterDefectCreator(assignee);
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

	@Then("^Dropdown menu should populate the matching users with partial first name$")
	public void dropdown_menu_should_populate_the_matching_users_with_partial_first_name() throws Throwable {
	try
    {
	    actual[6]=dt.filterCreatorValues();
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

	@When("^filter a creators by partial middle name using single character$")
	public void filter_a_creators_by_partial_middle_name_using_single_character() throws Throwable {
	try
    {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,44);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 rp.clickOnDefectTracking();
		 actual[7]=dt.filterDefectCreator(assignee);
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

	@Then("^Dropdown menu should populate the matching users with partial middle name$")
	public void dropdown_menu_should_populate_the_matching_users_with_partial_middle_name() throws Throwable {
	try
    {
	     actual[8]=dt.filterCreatorValues();
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

	@When("^filter a creators by partial last name using single character$")
	public void filter_a_creators_by_partial_last_name_using_single_character() throws Throwable {
	try
    {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,44);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 rp.clickOnDefectTracking();
		 actual[9]=dt.filterDefectCreator(assignee);
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

	@Then("^Dropdown menu should populate the matching users with partial last name$")
	public void dropdown_menu_should_populate_the_matching_users_with_partial_last_name() throws Throwable {
	try
    {
	     actual[10]=dt.filterCreatorValues();
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

	@When("^filter a creator by partial email using single character$")
	public void filter_a_creator_by_partial_email_using_single_character() throws Throwable {
	try
    {
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,44);
		 rp.clickOnTestRep();
		 bp.waitForElement();
		 rp.clickOnDefectTracking();
		 actual[11]=dt.filterDefectCreator(assignee);
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

	@Then("^Dropdown menu should populate the matching users with partial email$")
	public void dropdown_menu_should_populate_the_matching_users_with_partial_email() throws Throwable {
	try
    {
	     actual[12]=dt.filterCreatorValues();
	     
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
