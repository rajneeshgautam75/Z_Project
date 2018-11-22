package com.zephyr_batch_5.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_162 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExternalJiraPage ejp;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_162";
	
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the External Jira page$")
	public void user_is_in_the_External_Jira_page() throws Throwable {
	try
    {
		bp=new BasePage();
		pp=new ProjectPage(driver);
		ejp=new ExternalJiraPage(driver);
		pp.clickOnLogout();
	 	 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[0]=ejp.loginToExternalJira(Uname,Pwd);
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

	@When("^User create the filter$")
	public void user_create_the_filter() throws Throwable {
	try
    {
	     String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,38);
	     String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,39);
	     Actions act=new Actions(driver);
	     
	     actual[1]=ejp.launchJiraAdministration(issueType);
	     bp.waitForElement();
	  
	     act.moveToElement(ejp.authenticationJiraPwd).sendKeys(Pwd).sendKeys(Keys.ENTER).perform();
	     bp.waitForElement();
	     
	     actual[2]=ejp.clickOnManageIssues();
		 bp.waitForElement();
		 boolean res=ejp.checkAvailableFilters(filterValue);
		 if(res==false)
		 {
		 ejp.createFilter(filterName,filterValue);
		 }
		 bp.waitForElement();
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

	@When("^User edit the filter name$")
	public void user_edit_the_filter_name() throws Throwable {
	try
	   { 
		 String filterNameValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,38);
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,41);
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
		 actual[3]=ejp.editFilter(filterNameValue, filterValue, filterNameValue);
		 actual[4]=ejp.logOutFromExternal_JIRA();
		 driver.navigate().to(zephyr_Url);
		 lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
		 bp.waitForElement();
		 
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

	@When("^User launch the Defect_Tracking$")
	public void user_launch_the_Defect_Tracking() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 dt=new DefectTracking(driver);
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[5]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to Launch the Defect_Tracking page$")
	public void should_be_able_to_Launch_the_Defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[6]=dt.validateDefectTrackingPage();
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

	@When("^User click on the Advance Link button$")
	public void user_click_on_the_Advance_Link_button() throws Throwable {
	try
	   {
		 Actions act=new Actions(driver);
		 bp.waitForElement();
		 act.moveToElement(dt.advance).click().perform();
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

	@Then("^Should be Able to navigate to the Advance Search page$")
	public void should_be_Able_to_navigate_to_the_Advance_Search_page() throws Throwable {
	try
	   {
		 actual[7]=dt.validateAdvanceSearchPage();
		 for(int i=0;i<=5;i++)
		 {
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

	@When("^User Select the Filter option as MyFilters$")
	public void user_Select_the_Filter_option_as_MyFilters() throws Throwable {
	try
	   {
		String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		Actions v1=new Actions(driver);
		List<WebElement> vle1=driver.findElements(By.xpath("//span[@id='select2-searchChoice-container']"));
		v1.pause(1500).moveToElement(vle1.get(vle1.size()-1)).click().perform();
		bp.waitForElement();
		WebElement vle2 = driver.findElement(By.xpath(dt.selectSearch1+selectSearch+dt.selectSearch2));
   	    vle2.click();
		System.out.println("sucessfully selected" +selectSearch );
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

	@Then("^Should be able to Select MyFilters$")
	public void should_be_able_to_Select_MyFilters() throws Throwable {
	try
	   {
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 for(int i=0;i<=3;i++)
		 {
		   bp.waitForElement();
		 }
		 actual[8]=dt.validateFilter(filterName);
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

	@When("^User select the edited filter$")
	public void user_select_the_edited_filter() throws Throwable {
	try
	   {
		 Actions act=new Actions(driver);
		 exep=new ExecutionPage(driver);
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,38);
		 act.moveToElement(exep.searchMyFilterID).click().sendKeys(filterName).sendKeys(Keys.ENTER).perform();
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

	@Then("^Should be able to select the edited filter$")
	public void should_be_able_to_select_the_edited_filter() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,38);
		 actual[9]=dt.validateSelectedFilter(filterValue);
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

	@When("^User click On the Search Button$")
	public void user_click_On_the_Search_Button() throws Throwable {
	try
	   {
		 Actions act=new Actions(driver);
		 act.moveToElement(dt.defectSearchButton).click().perform();
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

	@Then("^Should be able to search defects for the edited filter$")
	public void should_be_able_to_search_defects_for_the_edited_filter() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 actual[10]=dt.validateSearchedDefect(defectType, defectValue);
		 
		 for(int k=0;k<=actual.length-1;k++)
			{
				//System.out.println("Actual["+k+"]="+actual[k]);
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
