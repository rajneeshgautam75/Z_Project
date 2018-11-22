package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_143 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_143";
	
	boolean[] actual=new boolean[25];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in Project_page Selection$")
	public void user_is_in_Project_page_Selection() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
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

	@When("^User navigate to the External_Jira page$")
	public void user_navigate_to_the_External_Jira_page() throws Throwable {
	try
	{
		 ejp=new ExternalJiraPage(driver);
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^User Navigate to the Version Fields Page$")
	public void user_Navigate_to_the_Version_Fields_Page() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,15);
		 String oldValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,5);
		 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,52);
		 String newValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,5);
		 actual[2]=ejp.defectProjectSettings(projectName);
		 actual[3]=ejp.editVersionValue(oldValue, optionValue, newValue);
		 ejp.closeNotificationMsg();
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

	@Then("^Should be able to edit the custom field multi version picker value$")
	public void should_be_able_to_edit_the_custom_field_multi_version_picker_value() throws Throwable {
	try
	   {
		 String defectValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,5);
		 actual[4]=ejp.validateEditedDefectValue(defectValue);
		 actual[5]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a manager,launch the defect admin page$")
	public void as_a_manager_launch_the_defect_admin_page() throws Throwable {
	try
    {	 
	     String managerUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String managerPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     actual[6]=lp.enterUname(managerUname);
	     actual[7]=lp.enterPass(managerPass);
	     bp.waitForElement();
	     actual[8]=lp.clickOnLogin();
		 actual[9]=pp.launchAdministration();
		 actual[10]=pp.launchDefectAdmin();
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

	@Then("^Should be able to Launch defect admin Page$")
	public void should_be_able_to_Launch_defect_admin_Page() throws Throwable {
	try
	   {
		 actual[11]=pp.validateDefectAdmin();
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

	@When("^clear the cache of an Online project$")
	public void clear_the_cache_of_an_Online_project() throws Throwable {
	try
	   {
		 actual[12]=pp.clearCache();
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

	@Then("^should be able to clear the Cache$")
	public void should_be_able_to_clear_the_Cache() throws Throwable {
	try
	   {
		 actual[13]=dt.validateSuccessMsg();
		 actual[14]=pp.clickOnLogout();
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

	@When("^As a Lead,Launch the Defect_Tracking page$")
	public void as_a_Lead_Launch_the_Defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String leadUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String leadPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(leadUname);
	     lp.enterPass(leadPass);
	     lp.clickOnLogin();
		 actual[15]=pp.selectProject(projectName);
		 actual[16]=pp.selectRelease(releaseName);
		 actual[17]=rp.clickOnDefectTracking();
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

	@Then("^Should Be able to launch defectTracking page$")
	public void should_Be_able_to_launch_defectTracking_page() throws Throwable {
	try
	   {
		 actual[18]=dt.validateDefectTrackingPage();
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

	@When("^create a defect with edited custom field multi version picker value$")
	public void create_a_defect_with_edited_custom_field_multi_version_picker_value() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String[] ze_Multiple_Select_Field=new String[2];
      	    ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
      	    ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
 
      	    String[] ze_Multi_Version_field=new String[2];
      	    ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,27);
      	    ze_Multi_Version_field[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,5);
      	   
      	    String[] ze_Multi_User_Picker=new String[2];
      	    ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	    ze_Multi_User_Picker[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
      	    actual[19]=dt.createDefect(project, issuetype);
      	    actual[20]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
			actual[21]=dt.enterDefectCustomFields(fields[0],fields[1],fields[2],fields[3],ze_Multiple_Select_Field,fields[4],ze_Multi_Version_field,fields[5],fields[6],fields[7],ze_Multi_User_Picker,fields[8]);
		    actual[22]=dt.saveDefect();
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

	@Then("^Should be able to create defect with edited custom field multi version picker value$")
	public void should_be_able_to_create_defect_with_edited_custom_field_multi_version_picker_value() throws Throwable {
	try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[23]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[24]=dt.updateDefect();
		 bp.waitForElement();
		 
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
