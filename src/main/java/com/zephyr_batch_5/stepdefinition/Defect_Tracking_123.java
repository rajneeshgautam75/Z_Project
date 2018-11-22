package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_123 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	DefectTracking dt;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_123";
	
	boolean[] actual=new boolean[18];
	SoftAssert soft=new SoftAssert();
	
    String description=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
	String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	String mapDefectProject=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
	String shareCheckbox=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
	String [] startDate=new String [3];
	 	{
	 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 18));
	 	startDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 19);
	 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 20));
	 	}
	 	
	 	String [] endDate=new String [3];
	 	{
	 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 21));
	 	endDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 22);
	 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 23));
	 	}
	 	String typeName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 27);
	 	String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	 	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	@Given("^Manager is in the Project Page$")
	public void manager_is_in_the_Project_Page() throws Throwable {
	try
    {	 
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 lp=new LoginPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 bp=new BasePage();
	     String Mname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Mpass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     pp.clickOnLogout();
	     lp.enterUname(Mname);
	     lp.enterPass(Mpass);
	     bp.waitForElement();
	     lp.clickOnLogin();
	     actual[0]=pp.launchAdministration();
	     //Actions a1=new Actions(driver);
	      //pp.launchadministration.sendKeys(Keys.CONTROL + "\t");
	     //String newTab=Keys.chord(Keys.CONTROL,"t");
	     //Keys.chord(Keys.CONTROL,"t");

	     //a1.sendKeys(newTab).perform();
		 actual[1]=pp.launchManageprojects();
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

	@When("^manager create a different types of project by different specification$")
	public void manager_create_a_different_types_of_project_by_different_specification() throws Throwable {
		try
		{
		String internationalCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
 	 	boolean result1=pp.validateProject(internationalCharProject);
	  if(result1==false)
	   {
	   pp.createProject(internationalCharProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
	   bp.waitForElement();
		}
	  String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
	  boolean result2=pp.validateProject(uppercaseProject);
	  if(result2==false)
	   {
	   pp.createProject(uppercaseProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
	   bp.waitForElement();
		}
	  String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
	  boolean result3=pp.validateProject(specialCharProject);
	  if(result3==false)
	   {
	   pp.createProject(specialCharProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
	   bp.waitForElement();
		}
	  String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
	  boolean result4=pp.validateProject(numberProject);
	  if(result4==false)
	   {
	   pp.createProject(numberProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
	   bp.waitForElement();
		}
	  String alphaNumProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_10");
	  boolean result5=pp.validateProject(alphaNumProject);
	  if(result5==false)
	   {
	   pp.createProject(alphaNumProject, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
	   bp.waitForElement();
		}
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

	@When("^map the projectName containing uppercase to Jira project$")
	public void map_the_projectName_containing_uppercase_to_Jira_project() throws Throwable {
	try
	   {
		 String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 actual[2]=pp.selectProjectInProjectSetup(uppercaseProject);
		 actual[3]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map projectName containing uppercase to Jira project$")
	public void should_get_activity_stream_for_map_projectName_containing_uppercase_to_Jira_project() throws Throwable {
	try
	   {
//		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
//		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 //String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
//	     Actions a1=new Actions(driver);
//	     a1.sendKeys(Keys.CONTROL+"\t").perform();
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[4]=ejp.loginToExternalJira(Uname,Pwd);
		 actual[5]=ejp.viewActivityStream();
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

	@When("^map the projectName containing specialChars to Jira project$")
	public void map_the_projectName_containing_specialChars_to_Jira_project() throws Throwable {
	try
	   {
		 String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 //bp.switchWindowTab(0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[6]=pp.selectProjectInProjectSetup(specialCharProject);
		 actual[7]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map projectName containing specialChars to Jira project$")
	public void should_get_activity_stream_for_map_projectName_containing_specialChars_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[8]=ejp.viewActivityStream();
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

	@When("^map the projectName containing numbers to Jira project$")
	public void map_the_projectName_containing_numbers_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 //bp.switchWindowTab(0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[9]=pp.selectProjectInProjectSetup(numberProject);
		 actual[10]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map projectName containing numbers to Jira project$")
	public void should_get_activity_stream_for_map_projectName_containing_numbers_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		 driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[11]=ejp.viewActivityStream();
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

	@When("^map the projectName containing alpha numberic to Jira project$")
	public void map_the_projectName_containing_alpha_numberic_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_10");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[12]=pp.selectProjectInProjectSetup(numberProject);
		 actual[13]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map projectName containing alpha numberic to Jira project$")
	public void should_get_activity_stream_for_map_projectName_containing_alpha_numberic_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[14]=ejp.viewActivityStream();
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

	@When("^map the projectName containing international chars to Jira project$")
	public void map_the_projectName_containing_international_chars_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[15]=pp.selectProjectInProjectSetup(numberProject);
		 actual[16]=pp.mapJiraProject(jiraProjectName);
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
	
	@Then("^Should get activity stream for map projectName containing international chars to Jira project$")
	public void should_get_activity_stream_for_map_projectName_containing_international_chars_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		 driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[17]=ejp.viewActivityStream();
		 driver.navigate().refresh();
		 ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
		 
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
