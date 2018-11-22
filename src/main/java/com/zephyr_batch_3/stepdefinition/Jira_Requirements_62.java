package com.zephyr_batch_3.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import bsh.This;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jira_Requirements_62 extends LaunchBrowser{
TestRepositoryPage tr;
	ImportPage ip;
	RequirementsPage req;;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	String fileName="Jira_Requirements_62";
	
	boolean[] actual=new boolean[9];
	SoftAssert soft=new SoftAssert();
	
	@Given("^user is on requirement app$")
	public void user_is_on_requirement_app() throws Throwable {
		try{
		bp=new BasePage();
		pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   rp= new ReleasePage(driver);
		   bp.waitForElement();
		   actual[2]=rp.clickOnRequirements();
		}
		catch(Exception e)
		 {
		  e.printStackTrace();
		  lb=new LaunchBrowser();
		  lb.getScreenShot(fileName);
		  driver.close();
		  Relogin_TPE rl=new Relogin_TPE();
		  rl.reLogin();
		  throw e;
		 }
	}

	@When("^user click on Import button and Select JIRA option$")
	public void user_click_on_Import_button_and_Select_JIRA_option() throws Throwable {
		try
	    {
			 req=new RequirementsPage(driver);
			 bp.waitForElement();
	         actual[3]=req.clickOnImport();
	         bp.waitForElement();
	        String importType=Excel_Lib.getData(INPUT_PATH_9, "Import",1,1);
		    actual[4]=req.chooseImportType(importType);
		   
	    }
	    catch(Exception e)
		{
			e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
	    	driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@And("^user search requirement by JQL/filter select sub-folder as Status click on Import all button$")
	public void user_search_requirement_by_JQL_filter_Select_sub_folder_as_Status_Click_on_Import_all_button() throws Throwable {
		 try
			{
				String selectQuerry=Excel_Lib.getData(INPUT_PATH_9, "Import",1,2 );
				String enterQuerry=Excel_Lib.getData(INPUT_PATH_9, "Import",1,0 );
				actual[5]=req.selectQuerry(selectQuerry, enterQuerry);
		     String accessType=Excel_Lib.getData(INPUT_PATH_9, "Import",8,3);
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_9, "Import",1 ,4 );
			actual[6]=req.selectAccessTypeAndFolderName(accessType,folderName);
			bp.waitForElement();
		     req.clickjiraSearchButton.click();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[7]=req.importAllJiraRequirements();
				bp.waitForElement();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				lb=new LaunchBrowser();
				lb.getScreenShot(fileName);
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@Then("^Check the sub_folders under imported node$")
	public void Check_the_sub_folders_under_imported_node() throws Throwable {
		try{
		     String [] phase=new String[2];
		     String importedName=Excel_Lib.getData(INPUT_PATH_9,"Releases",1,2);
		     phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_9,"phase1", 1,0);
		     phase[1]=Excel_Lib.getData(INPUT_PATH_9,"phase1" ,1,1);
		     tr=new TestRepositoryPage(driver);
			 actual[8]=tr.navigateToNode(importedName,phase);
		     bp.waitForElement();
		     pp.clickOnLogout();
		 for(int i=0;i<=actual.length-1;i++)
		 {
			 System.out.println(actual[i]);
			 soft.assertEquals(actual[i], true); 
		 }
		soft.assertAll(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}	
}

