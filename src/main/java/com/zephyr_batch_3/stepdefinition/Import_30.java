package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Import_30 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	ImportPage ip;
	String fileName="Import_30";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[5];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in requiement Page$")
	public void user_in_requiement_Page() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			    rp.clickOnRequirements();
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

	@Given("^click on import create map with By empty Row$")
	public void click_on_import_create_map_with_By_empty_Row() throws Throwable 
	{
		try
		{
			req=new RequirementsPage(driver);
			String type=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 0);
			req.chooseImportType1(type);
			
			ip=new ImportPage(driver);
			ip.clickOnNextForMap();
			
			String mapname=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 1, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 9);
			actual[2]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
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
	@When("^create map with By ID Change$")
	public void create_map_with_By_ID_Change() throws Throwable 
	{
		try
		{
			String mapname=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 1, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 2, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 9);
			actual[3]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
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
	@Then("^create map with By Requirement Name Change$")
	public void create_map_with_By_Requirement_Name_Change() throws Throwable 
	{
		try
		{
			String mapname=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 2);
			int rownum=Excel_Lib.getNumberData(INPUT_PATH_4, "ImportType", 1, 3);
			String descrimi=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 3, 4);
			String desc=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 5);
			String name=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 6);
			String testSteps=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 7);
			String expResults=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 8);
			String extrID=Excel_Lib.getData(INPUT_PATH_4, "ImportType", 1, 9);
			actual[4]=ip.createMapForRequirement(mapname, rownum, descrimi, desc, name, testSteps, expResults, extrID);
			//ip.validateMap(mapname);
			ip.closeImportPage();
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

	@Then("^Should be able to save a map with all discriminators$")
	public void should_be_able_to_save_a_map_with_all_discriminators() throws Throwable 
	{
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
			
	      soft.assertEquals(actual[k], true);
	     }
	    soft.assertAll();
		}
		   catch (Exception e) 
				{
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}
}
