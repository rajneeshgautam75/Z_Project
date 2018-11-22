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

public class Defect_tracking_124 extends LaunchBrowser{

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
	String fileName="Defect_Tracking_124";
	
	boolean[] actual=new boolean[21];
	SoftAssert soft=new SoftAssert();
	
	String internationalCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
	String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
	String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
	String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
	String alphaNumProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_10");
	
	String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,23));
	String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",7,22);
	String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,21));
	String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,26));
	String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",12,25);
	String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,24));
	String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
 	String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	@Given("^Manager is in a project page$")
	public void manager_is_in_a_project_page() throws Throwable {
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
	     actual[0]=lp.clickOnLogin();
		 actual[1]=pp.selectProject(uppercaseProject);
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

	@When("^create a different types of releases for the projects$")
	public void create_a_different_types_of_releases_for_the_projects() throws Throwable {
		try
	    {
	    	rp=new ReleasePage(driver);
	    	bp.waitForElement();
	    	actual[2]=rp.clickOnManageRelease();
			bp.waitForElement();
			String upperRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_5");
			boolean res1=rp.checkAvailableRelease(upperRelease);
			if(res1==false)
			{
	    	rp.addNewRelease(upperRelease, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			 }
			pp.selectProject(specialCharProject);
			rp.clickOnManageRelease();
			bp.waitForElement();
			String specialCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_4");
			boolean res2=rp.checkAvailableRelease(specialCharRelease);
			if(res2==false)
			{
	    	rp.addNewRelease(specialCharRelease, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			 }
			pp.selectProject(numberProject);
			rp.clickOnManageRelease();
			String numberRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_6");
			boolean res3=rp.checkAvailableRelease(numberRelease);
			if(res3==false)
			{
	    	rp.addNewRelease(numberRelease, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			 }
			pp.selectProject(alphaNumProject);
			rp.clickOnManageRelease();
			String alphaNumRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_7");
			boolean res4=rp.checkAvailableRelease(alphaNumRelease);
			if(res4==false)
			{
	    	rp.addNewRelease(alphaNumRelease,Desc,Hide,MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			 }
			pp.selectProject(internationalCharProject);
			rp.clickOnManageRelease();
			String internationalCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_6");
			boolean res5=rp.checkAvailableRelease(internationalCharRelease);
			if(res5==false)
			{
	    	rp.addNewRelease(internationalCharRelease, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
			 }
			
			
			String internationalCharRelease1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_3");
			boolean res6=rp.checkAvailableRelease(internationalCharRelease1);
			if(res6==false)
			{
	    	rp.addNewRelease(internationalCharRelease1, Desc, Hide, MapexternalDefect);
			rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
			rp.clickOnAdd();
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

	@When("^map the releaseName containing uppercase to Jira project$")
	public void map_the_releaseName_containing_uppercase_to_Jira_project() throws Throwable {
	try
    {	 
		actual[3]=pp.launchAdministration();
		actual[4]=pp.launchManageprojects();
		String uppercaseProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_8");
		String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		actual[5]=pp.selectProjectInProjectSetup(uppercaseProject);
		actual[6]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map releaseName containing uppercase to Jira project$")
	public void should_get_activity_stream_for_map_releaseName_containing_uppercase_to_Jira_project() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[7]=ejp.loginToExternalJira(Uname,Pwd);
		 //driver.navigate().to(jira_Url);
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

	@When("^map the releaseName containing lowercase to Jira project$")
	public void map_the_releaseName_containing_lowercase_to_Jira_project() throws Throwable {
	try
	   {
		 String specialCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_5");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 //bp.switchWindowTab(0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[9]=pp.selectProjectInProjectSetup(specialCharProject);
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

	@Then("^Should get activity stream for map releaseName containing lowercase to Jira project$")
	public void should_get_activity_stream_for_map_releaseName_containing_lowercase_to_Jira_project() throws Throwable {
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

	@When("^map the releaseName containing numbers to Jira project$")
	public void map_the_releaseName_containing_numbers_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_9");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 //bp.switchWindowTab(0);
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

	@Then("^Should get activity stream for map releaseName containing numbers to Jira project$")
	public void should_get_activity_stream_for_map_releaseName_containing_numbers_to_Jira_project() throws Throwable {
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

	@When("^map the releaseName containing alpha numberic to Jira project$")
	public void map_the_releaseName_containing_alpha_numberic_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_10");
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

	@Then("^Should get activity stream for map releaseName containing alpha numberic to Jira project$")
	public void should_get_activity_stream_for_map_releaseName_containing_alpha_numberic_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[17]=ejp.viewActivityStream();
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

	@When("^map the releaseName containing international chars to Jira project$")
	public void map_the_releaseName_containing_international_chars_to_Jira_project() throws Throwable {
	try
	   {
		 String numberProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_4");
		 String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		 driver.navigate().to(zephyr_Url);
		 pp.launchAdministration();
		 pp.launchManageprojects();
		 actual[18]=pp.selectProjectInProjectSetup(numberProject);
		 actual[19]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should get activity stream for map releaseName containing international chars to Jira project$")
	public void should_get_activity_stream_for_map_releaseName_containing_international_chars_to_Jira_project() throws Throwable {
	try
	   {
		 //bp.switchWindowTab(1);
		 driver.navigate().to(jira_Url);
	     bp.waitForElement();
		 actual[20]=ejp.viewActivityStream();
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
