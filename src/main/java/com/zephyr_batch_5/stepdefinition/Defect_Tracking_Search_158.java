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
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_158 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_158";
	
	boolean[] actual=new boolean[6];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in the page of Defect_Tracking$")
	public void user_is_in_the_page_of_Defect_Tracking() throws Throwable {
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
		 actual[0]=rp.clickOnDefectTracking();
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

	@Then("^Should be able to Launch DefectTracking$")
	public void should_be_able_to_Launch_DefectTracking() throws Throwable {
	try
	   {
		 actual[1]=dt.validateDefectTrackingPage();
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

	@When("^User Click on the advance link$")
	public void user_Click_on_the_advance_link() throws Throwable {
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

	@Then("^Should be able to go to the Advance search page$")
	public void should_be_able_to_go_to_the_Advance_search_page() throws Throwable {
	try
	   {
		 actual[2]=dt.validateAdvanceSearchPage();
		 for(int i=0;i<=3;i++)
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

	@When("^User Select the filter option as myfilter$")
	public void user_Select_the_filter_option_as_myfilter() throws Throwable {
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

	@Then("^Should be able to select the myFilter$")
	public void should_be_able_to_select_the_myFilter() throws Throwable {
	try
	   {
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 for(int i=0;i<=3;i++)
		 {
		   bp.waitForElement();
		 }
		 actual[3]=dt.validateFilter(filterName);
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

	@When("^User select the filter name contains special character$")
	public void user_select_the_filter_name_contains_special_character() throws Throwable {
	try
	   {
		 Actions act=new Actions(driver);
		 exep=new ExecutionPage(driver);
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,38);
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

	@Then("^Should be able to select special character filter$")
	public void should_be_able_to_select_special_character_filter() throws Throwable {
	try
	   {
		 String filterValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,38);
		 actual[4]=dt.validateSelectedFilter(filterValue);
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

	@When("^User Click on a search button$")
	public void user_Click_on_a_search_button() throws Throwable {
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

	@Then("^Should be able to search defects for special character filter$")
	public void should_be_able_to_search_defects_for_special_character_filter() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 actual[5]=dt.validateSearchedDefect(defectType, defectValue);
		 
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
