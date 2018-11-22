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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_192 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	DefectTracking dt;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_192";
	
	boolean[] actual=new boolean[58];
	SoftAssert soft=new SoftAssert();
	
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
 	String sampleProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
 	String jiraProjectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
 	@Given("^manager is in the project page$")
	public void manager_is_in_the_project_page() throws Throwable {
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
		 actual[1]=pp.selectProject(sampleProject);
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

	@When("^User creates a new release with special character$")
	public void user_creates_a_new_release_with_special_character() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	bp.waitForElement();
		actual[2]=pp.selectProject(sampleProject);
		rp.clickOnManageRelease();
		bp.waitForElement();
		String specialCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_4");
		boolean res1=rp.checkAvailableRelease(specialCharRelease);
		if(res1==false)
		{
    	rp.addNewRelease(specialCharRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map special character release created in sample project to JIRA project$")
	public void map_special_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[3]=pp.launchAdministration();
		actual[4]=pp.launchManageprojects();
		actual[5]=pp.selectProjectInProjectSetup(sampleProject);
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

	@When("^User launch external jira page to view activity stream$")
	public void user_launch_external_jira_page_to_view_activity_stream() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[7]=ejp.loginToExternalJira(Uname,Pwd);
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

	@Then("^Should be able to view JIRA activity stream for special character release$")
	public void should_be_able_to_view_JIRA_activity_stream_for_special_character_release() throws Throwable {
	try
	   {
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

	@When("^select the sample project to create a new release with alphanumeric characters$")
	public void select_the_sample_project_to_create_a_new_release_with_alphanumeric_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	bp.waitForElement();
    	driver.navigate().to(zephyr_Url);
//		pp.launchAdministration();
//		pp.launchManageprojects();
		actual[9]=pp.selectProject(sampleProject);
		actual[10]=rp.clickOnManageRelease();
		String alphaNumRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_7");
		boolean res2=rp.checkAvailableRelease(alphaNumRelease);
		if(res2==false)
		{
    	rp.addNewRelease(alphaNumRelease,Desc,Hide,MapexternalDefect);
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

	@When("^map alphanumeric character release created in sample project to JIRA project$")
	public void map_alphanumeric_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[11]=pp.launchAdministration();
		actual[12]=pp.launchManageprojects();
		actual[13]=pp.selectProjectInProjectSetup(sampleProject);
		actual[14]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the alphanumeric character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_alphanumeric_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[15]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with only number characters$")
	public void select_the_sample_project_to_create_a_new_release_with_only_number_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[16]=pp.selectProject(sampleProject);
		actual[17]=rp.clickOnManageRelease();
		String numberRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_6");
		boolean res3=rp.checkAvailableRelease(numberRelease);
		if(res3==false)
		{
    	rp.addNewRelease(numberRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map number character release created in sample project to JIRA project$")
	public void map_number_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[18]=pp.launchAdministration();
		actual[19]=pp.launchManageprojects();
		actual[20]=pp.selectProjectInProjectSetup(sampleProject);
		actual[21]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the number character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_number_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[22]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with capital characters$")
	public void select_the_sample_project_to_create_a_new_release_with_capital_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[23]=pp.selectProject(sampleProject);
		actual[24]=rp.clickOnManageRelease();
		bp.waitForElement();
		String upperRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_5");
		boolean res4=rp.checkAvailableRelease(upperRelease);
		if(res4==false)
		{
    	rp.addNewRelease(upperRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map capital character release created in sample project to JIRA project$")
	public void map_capital_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[25]=pp.launchAdministration();
		actual[26]=pp.launchManageprojects();
		actual[27]=pp.selectProjectInProjectSetup(sampleProject);
		actual[28]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the capital character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_capital_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[29]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with international characters$")
	public void select_the_sample_project_to_create_a_new_release_with_international_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[30]=pp.selectProject(sampleProject);
		actual[31]=rp.clickOnManageRelease();
		String internationalCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_3");
		boolean res5=rp.checkAvailableRelease(internationalCharRelease);
		if(res5==false)
		{
    	rp.addNewRelease(internationalCharRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map international character release created in sample project to JIRA project$")
	public void map_international_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[32]=pp.launchAdministration();
		actual[33]=pp.launchManageprojects();
		actual[34]=pp.selectProjectInProjectSetup(sampleProject);
		actual[35]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the international character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_international_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[36]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with minimum characters$")
	public void select_the_sample_project_to_create_a_new_release_with_minimum_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[37]=pp.selectProject(sampleProject);
		actual[38]=rp.clickOnManageRelease();
		String minCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_8");
		boolean res6=rp.checkAvailableRelease(minCharRelease);
		if(res6==false)
		{
    	rp.addNewRelease(minCharRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map minimum character release created in sample project to JIRA project$")
	public void map_minimum_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[39]=pp.launchAdministration();
		actual[40]=pp.launchManageprojects();
		actual[41]=pp.selectProjectInProjectSetup(sampleProject);
		actual[42]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the minimum character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_minimum_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[43]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with maximum characters$")
	public void select_the_sample_project_to_create_a_new_release_with_maximum_characters() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[44]=pp.selectProject(sampleProject);
		actual[45]=rp.clickOnManageRelease();
		String maxCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_9");
		boolean res7=rp.checkAvailableRelease(maxCharRelease);
		if(res7==false)
		{
    	rp.addNewRelease(maxCharRelease,Desc, Hide, MapexternalDefect);
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

	@When("^map maximum character release created in sample project to JIRA project$")
	public void map_maximum_character_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[46]=pp.launchAdministration();
		actual[47]=pp.launchManageprojects();
		actual[48]=pp.selectProjectInProjectSetup(sampleProject);
		actual[49]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the maximum character release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_maximum_character_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 actual[50]=ejp.viewActivityStream();
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

	@When("^select the sample project to create a new release with duplicate name$")
	public void select_the_sample_project_to_create_a_new_release_with_duplicate_name() throws Throwable {
	try
    {
    	rp=new ReleasePage(driver);
    	driver.navigate().to(zephyr_Url);
    	bp.waitForElement();
		actual[51]=pp.selectProject(sampleProject);
		actual[52]=rp.clickOnManageRelease();
		String internationalCharRelease=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_3");
		boolean res8=rp.checkAvailableRelease(internationalCharRelease);
		if(res8==false)
		{
    	rp.addNewRelease(internationalCharRelease, Desc, Hide, MapexternalDefect);
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

	@When("^map duplicate name release created in sample project to JIRA project$")
	public void map_duplicate_name_release_created_in_sample_project_to_JIRA_project() throws Throwable {
	try
    {	 
		actual[53]=pp.launchAdministration();
		actual[54]=pp.launchManageprojects();
		actual[55]=pp.selectProjectInProjectSetup(sampleProject);
		actual[56]=pp.mapJiraProject(jiraProjectName);
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

	@Then("^Should be able to view JIRA Activity stream for the duplicate name release$")
	public void should_be_able_to_view_JIRA_Activity_stream_for_the_duplicate_name_release() throws Throwable {
	try
	   {
		 driver.navigate().to(jira_Url);
		 bp.waitForElement();
		 actual[57]=ejp.viewActivityStream();
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
