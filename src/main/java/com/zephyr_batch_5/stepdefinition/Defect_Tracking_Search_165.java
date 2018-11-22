package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_165 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_165";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in the project page$")
	public void manager_is_in_the_project_page() throws Throwable {
	try
    {
		bp=new BasePage();
		lp=new LoginPage(driver);
		pp=new ProjectPage(driver);
		dt=new DefectTracking(driver);
		rp=new ReleasePage(driver);
		pp.clickOnLogout();
	 	 
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
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

	@When("^launch administration to set DTS$")
	public void launch_administration_to_set_DTS() throws Throwable {
	try
    {
	  actual[0]=pp.launchAdministration();
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

	@When("^set DTS to JIRA$")
	public void set_DTS_to_JIRA() throws Throwable {
	try
    {
	  String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	  String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	  String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	
	  actual[1]=pp.clickOnDefectTracking();
	  actual[2]=pp.setDTS(DTS, jira_Url, Uname, Pwd);
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

	@Then("^Should be able to set the DTS$")
	public void should_be_able_to_set_the_DTS() throws Throwable {
	try
    {
	  actual[3]=pp.validateSetDTS();
	  pp.clickOnLogout();
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

	@When("^User is in Defect_Tracking page$")
	public void user_is_in_Defect_Tracking_page() throws Throwable {
	try
    {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[4]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to launch defect_tracking$")
	public void should_be_able_to_launch_defect_tracking() throws Throwable {
	try
    {
	  actual[5]=dt.validateDefectTrackingPage();
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

	@When("^User search the defect subtask in defect tracking$")
	public void user_search_the_defect_subtask_in_defect_tracking() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,31);
		 actual[6]=dt.searchDefect(defectID);
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

	@Then("^Should search subtask$")
	public void should_search_subtask() throws Throwable {
	try
	   {
		 String defectname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,31);
		 actual[7]=dt.validateDefect(defectname);
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

	@When("^select the defect and click on create subtask$")
	public void select_the_defect_and_click_on_create_subtask() throws Throwable {
	try
	   {
		 actual[8]=dt.selectAllDefects();
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

	@Then("^create subtask button should be disabled if searched defect is of type subtask$")
	public void create_subtask_button_should_be_disabled_if_searched_defect_is_of_type_subtask() throws Throwable {
	try
	   {
		String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		WebElement ele=driver.findElement(By.xpath(dt.defectValue1+defectValue+dt.defectValue2));
		boolean res=ele.isEnabled();
		System.out.println(res);
		if(res==false)
		{
		System.out.println("Pass-Create Sub-task button is disabled");
		}
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
