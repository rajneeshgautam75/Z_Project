package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jira_Requirements_64 extends LaunchBrowser {
	TestRepositoryPage tr;
	ImportPage ip;
	RequirementsPage req;
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	String fileName="Jira_Requirements_64";
	
	boolean[] actual=new boolean[10];
	SoftAssert soft=new SoftAssert();
	
	@Given("^user must in requriment page$")
	public void user_must_in_requriment_page() throws Throwable {
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

	@When("^user has to click on import and click on jira$")
	public void user_as_to_click_on_import_and_click_on_jira() throws Throwable {
		try
	    {
			req=new RequirementsPage(driver);
	    req.import_Requirement.click();
		String importType=Excel_Lib.getData(INPUT_PATH_9, "Import",1,1);
		actual[3]=req.chooseImportType(importType);
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

	@And("^user search for poject using JQL and click on import all$")
	public void user_search_for_poject_using_JQL_and_click_on_import_all() throws Throwable {
		 try
			{
				String selectQuerry=Excel_Lib.getData(INPUT_PATH_9, "Import",1,2 );
				String enterQuerry=Excel_Lib.getData(INPUT_PATH_9, "Import",1,0 );
				actual[4]=req.selectQuerry(selectQuerry, enterQuerry);
		     String accessType=Excel_Lib.getData(INPUT_PATH_9, "Import",8,3);
			String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_9, "Import",1 ,4 );
			actual[5]=req.selectAccessTypeAndFolderName(accessType,folderName);
			bp.waitForElement();
		     req.clickjiraSearchButton.click();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[6]=req.importAllJiraRequirements();
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

	@Then("^Check the imported node$")
	public void check_the_imported_node() throws Throwable {
		try
		{
		 String importedName=Excel_Lib.getData(INPUT_PATH_9,"Releases",1,2);
		 tr=new TestRepositoryPage(driver);
		 tr.doubleClickOnRelease(importedName);
		 String [] phase=new String[2];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_9,"phase1", 1,0);
		 phase[1]=Excel_Lib.getData(INPUT_PATH_9,"phase1" ,1,1);
		 
		 actual[7]=tr.navigateToNode(importedName,phase);
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

	@When("^user drag and drop the requirment$")
	public void user_has_to_drag_and_drop_the_requirment() throws Throwable {
		try
		{
		String importedPhase=UNIQUE+Excel_Lib.getData(INPUT_PATH_9,"DragAndDrop",1,0);
		String releaseName=Excel_Lib.getData(INPUT_PATH_9,"DragAndDrop",1,1);
		actual[8]=tr.dragAndDropNode(importedPhase,releaseName);
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
	@Then("^imported node successfully copied to local node$")
	public void imported_node_successfully_copied_to_local_node() throws Throwable {
		try{
	   String releaseName=Excel_Lib.getData(INPUT_PATH_9, "Releases",1,0 );
	   String[] ph=new String[2];
	   ph[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_9,"phase1", 1,0);
		 ph[1]=Excel_Lib.getData(INPUT_PATH_9,"phase1" ,1,1);
		 actual[9]=tr.navigateToNode(releaseName, ph);
		 
		 for(int k=0;k<=actual.length-1;k++)
		    {
		    	System.out.println(actual[k]);
		    	soft.assertEquals(actual[k], true);
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
