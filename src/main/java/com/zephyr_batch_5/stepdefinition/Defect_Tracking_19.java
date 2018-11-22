package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Defect_Tracking_19 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_19";
	
	boolean[] actual=new boolean[23];
	SoftAssert soft=new SoftAssert();
	 
	@Given("^User is in defect tracking page$")
	public void user_is_in_defect_tracking_page() throws Throwable {
		try
		   {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 pp.selectProject(projectName);
			 pp.selectRelease(releaseName);
			 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User search a defect and update the summary of the defect$")
	public void user_search_a_defect_and_update_the_summary_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			actual[1]=dt.searchDefect(defectID);
			//dt.selectAllDefects();
			dt.selectSingleOrMultipleDefects(defectNo1);
			actual[2]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update summary$")
	public void should_be_able_to_update_summary() throws Throwable {
		try
		   {
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			actual[3]=dt.validateDefectSummary(summary);
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

	@When("^User search a defect and update the priority of the defect$")
	public void user_search_a_defect_and_update_the_priority_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,6);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			actual[4]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			//dt.selectAllDefects();
			actual[5]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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
	

	@Then("^Should be able to update priority$")
	public void should_be_able_to_update_priority() throws Throwable {
		try
		   {
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,6);
			actual[6]=dt.validateDefectPriority(priority);
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

	@When("^User search a defect and update the component of the defect$")
	public void user_search_a_defect_and_update_the_component_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,19);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			bp.waitForElement();
			actual[7]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			actual[8]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update component$")
	public void should_be_able_to_update_component() throws Throwable {
		try
		   {
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,19);
			bp.waitForElement();
			actual[9]=dt.validateDefectComponent(component);
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

	@When("^User search a defect and update the version of the defect$")
	public void user_search_a_defect_and_update_the_version_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			 int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
//			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
//			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
//			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
//			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			bp.waitForElement();
			actual[10]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			actual[11]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update version$")
	public void should_be_able_to_update_version() throws Throwable {
		try
		   {
			String versions=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			actual[12]=dt.validateDefectVersions(versions);
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

	@When("^User search a defect and update the fixversion of the defect$")
	public void user_search_a_defect_and_update_the_fixversion_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			 int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			actual[13]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			//dt.selectAllDefects();
			actual[14]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update fixversion$")
	public void should_be_able_to_update_fixversion() throws Throwable {
		try
		   {
			String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			actual[15]=dt.validateDefectFixVersion(fixVersion);
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

	@When("^User search a defect and update the environment of the defect$")
	public void user_search_a_defect_and_update_the_environment_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,22);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			actual[16]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			actual[17]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			//
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update environment$")
	public void should_be_able_to_update_environment() throws Throwable {
		try
		   {
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,22);
			actual[18]=dt.validateDefectEnvironment(environment);
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

	@When("^User search a defect and update the status and resolution of the defect$")
	public void user_search_a_defect_and_update_the_status_and_resolution_of_the_defect() throws Throwable {
		try
		   {
			String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,7);
			int[] defectNo1=new int[1];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String component=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String fixversion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String comment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String assignedTo=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String environment=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,3);
			String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			actual[19]=dt.searchDefect(defectID);
			dt.selectSingleOrMultipleDefects(defectNo1);
			actual[20]=dt.updateDefectDetailsInSearchView(summary, component, priority, version, fixversion, comment, assignedTo, environment, status, resolution);
			actual[21]=dt.updateDefectStatusAndResolution(status, resolution);
			WebElement ele=driver.findElement(By.xpath("//div[@title='ID']"));
			 Actions act=new Actions(driver);
			 act.moveToElement(ele).pause(EXPLICIT).click();
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

	@Then("^Should be able to update status and resolution$")
	public void should_be_able_to_update_status_and_resolution() throws Throwable {
		try
		   {
			String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,3);
			//String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,21);
			actual[22]=dt.validateDefectStatus(status);
			bp.waitForElement();
			driver.navigate().refresh();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			//pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				//soft.assertEquals(actual[k], true);
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
