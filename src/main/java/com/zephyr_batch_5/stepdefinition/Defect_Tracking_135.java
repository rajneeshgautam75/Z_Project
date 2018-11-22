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

public class Defect_Tracking_135 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_135";
	
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the project age$")
	public void user_is_in_the_project_age() throws Throwable {
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

	@When("^User navigate to the External Jira page$")
	public void user_navigate_to_the_External_Jira_page() throws Throwable {
	try
	{
		 ejp=new ExternalJiraPage(driver);
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^User navigate to the component page and edit the component value$")
	public void user_navigate_to_the_component_page_and_edit_the_component_value() throws Throwable {
	try
	   {
		 String oldValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,19);
		 String optionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,52);
		 String value=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,19);
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,15);
		 actual[2]=ejp.defectProjectSettings(projectName);
		 actual[3]=ejp.editComponentValue(oldValue, optionValue, value);
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

	@Then("^Should be able to edit the component value$")
	public void should_be_able_to_edit_the_component_value() throws Throwable {
	try
	   {
		 String defectValue=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",11,19);
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

	@When("^Manager Launch the Defect Admin page$")
	public void manager_Launch_the_Defect_Admin_page() throws Throwable {
	try
    {	 
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     //pp.clickOnLogout();
	     actual[6]=lp.enterUname(Uname);
	     actual[7]=lp.enterPass(Pass);
	     actual[8]=lp.clickOnLogin();
		 bp.waitForElement();
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

	@Then("^Should be able to Launch Defect Admin$")
	public void should_be_able_to_Launch_Defect_Admin() throws Throwable {
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

	@When("^clear the cache of online project$")
	public void clear_the_cache_of_online_project() throws Throwable {
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

	@Then("^Should be able to clear the cache$")
	public void should_be_able_to_clear_the_cache() throws Throwable {
	try
	   {
		 actual[13]=dt.validateSuccessMsg();
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

	@When("^launch DefectTracking Page$")
	public void launch_DefectTracking_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
		 actual[14]=pp.selectProject(projectName);
		 actual[15]=pp.selectRelease(releaseName);
		 actual[16]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to Launch DT page$")
	public void should_be_able_to_Launch_DT_page() throws Throwable {
	try
	   {
		 actual[17]=dt.validateDefectTrackingPage();
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

	@When("^create a defect with edited component value$")
	public void create_a_defect_with_edited_component_value() throws Throwable {
	try
	   {
            String[] fields=new String[10];
            for(int i=0;i<=9;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String components=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,19);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[18]=dt.createDefect(project, issuetype);
			actual[19]=dt.fileNewDefect(summary, components,fields[0],desc,fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
		    actual[20]=dt.saveDefect();
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

	@Then("^Should be able to create defect with edited component value$")
	public void should_be_able_to_create_defect_with_edited_component_value() throws Throwable {
	try
	   {
		 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		 actual[21]=dt.validateDefect(project, issuetype);
		 bp.waitForElement();
		 actual[22]=dt.updateDefect();
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
