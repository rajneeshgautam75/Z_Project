package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class External_JIRA_67 extends LaunchBrowser {

	LaunchBrowser lb=new LaunchBrowser();
	String fileName="External_JIRA_67";
		
	BasePage bp;
	ProjectPage pp;
	ReleasePage rrp;
	ExternalJiraPage ej;
	RequirementsPage rp;
	TestRepositoryPage tr;
	LoginPage lp;
	ExecutionPage ep;
		
	boolean actual[]=new boolean[22];	
	SoftAssert soft=new SoftAssert();
		
	String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
	String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 4);
	String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
	int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9 );
	int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );
	@Given("^user is in Requirement_Page$")
	public void user_is_in_Requirement_Page() throws Throwable {
		try
		{
			bp=new BasePage();
			pp=new ProjectPage(driver);
			rrp=new ReleasePage(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			actual[2]=rrp.clickOnRequirements();
			actual[3]=bp.waitForElement();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl= new Relogin_TPE();
			rl.reLogin();
			throw e;
		}   
	}

	@When("^User Import JIRA requirement$")
	public void user_Import_JIRA_requirement() throws Throwable {
		try
		{
			rp=new RequirementsPage(driver);
			String JIRA=Excel_Lib.getData(INPUT_PATH_5, "Req", 1,7);
			String JQL=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 1);
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 2);
			actual[4]=rp.clickOnImport();
			actual[5]=rp.chooseImportType(JIRA);
			actual[6]=rp.selectQuerry(JQL, enterQuerry);
			String accessName=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 3);
			actual[7]=rp.selectAccessTypeAndFolderName(accessName, requirementNode);
			bp.explicitWait(rp.clickjiraSearchButton);
			rp.clickjiraSearchButton.click();
			String testCaseNo1[]=new String[1];
			testCaseNo1[0]=testCaseNo;                                         //Excel_Lib.getData(INPUT_PATH_5,"Req", 3, 5);
			actual[8]=rp.selectMultipleTestCaseFromGrid(testCaseNo1);
			bp.explicitWait(rp.clickOnImportSelected);
			rp.clickOnImportSelected.click();
			bp.waitForElement();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl= new Relogin_TPE();
			rl.reLogin();
			throw e;
		}      
	}

	@Then("^Imported JIRA requirement should be present in imported Tree$")
	public void imported_JIRA_requirement_should_be_present_in_imported_Tree() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String phase[]=new String[1];
			phase[0]=requirementNode;
			actual[9]=tr.navigateToNode(importedTree, phase);
			bp.waitForElement();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl= new Relogin_TPE();
			rl.reLogin();
			throw e;
		}       
	}

	@When("^drag and drop Imported Jira requirement folder to local tree$")
	public void drag_and_drop_Imported_Jira_requirement_folder_to_local_tree() throws Throwable {
		try
		{
			actual[10]=tr.dragAndDropNode(requirementNode, release);
			bp.waitForElement();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl= new Relogin_TPE();
			rl.reLogin();
			throw e;
		}       
	}

	@Then("^requirement folder should be moved to local tree$")
	public void requirement_folder_should_be_moved_to_local_tree() throws Throwable {
		try
		{
			String[] node=new String[1];
			node[0]=requirementNode;
			actual[11]=tr.navigateToNode(release,node);
			actual[12]=bp.waitForElement();
			String[] testCaseNo1=new String[1];
			testCaseNo1[0]=testCaseNo;
			actual[13]=rp.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl= new Relogin_TPE();
			rl.reLogin();
			throw e;
		}      
	}

	@When("^Login into External_JIRA$")
	public void login_into_External_JIRA() throws Throwable {
	try
	{
		ep=new ExecutionPage(driver);
		ej=new ExternalJiraPage(driver);
		tr.clickOnDetails();
		actual[14]=rp.clickOnGo();
		bp.waitForElement();
		int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9);
		bp.switchWindowTab(tabNo1);
		bp.waitForElement();
		bp.waitForElement();
		String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Username");
	    String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Password");
		actual[15]=ej.loginToExternalJira(jiraUname, jiraPwd);
		bp.waitForElement();		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		lb.getScreenShot(fileName);
		driver.quit();
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
	}
	}

	@When("^In JIRA move that requirement to other project$")
	public void in_JIRA_move_that_requirement_to_other_project() throws Throwable {
		try
		{
		ej=new ExternalJiraPage(driver);
		String newProject=Excel_Lib.getData(INPUT_PATH_5, "Req",1,13);
		actual[16]=ej.MoveDefectToOtherProject(newProject);
		bp.waitForElement();
		actual[17]=ej.ValidateMoveDefectToOtherProject(newProject);
		bp.waitForElement();
		actual[18]=ej.logOutFromExternal_JIRA();
		bp.waitForElement();
		driver.close();
		bp.waitForElement();
		bp.switchWindowTab(tabNo0);
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}   
	}

	@When("^Apply Notification in Zephyr application$")
	public void apply_Notification_in_Zephyr_application() throws Throwable {
		try
		{
			tr.clickOnList();
			actual[19]=tr.applyNotification();
			bp.waitForElement();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}  
	}

	@Then("^Check the updated ALT-ID in grid$")
	public void check_the_updated_ALT_ID_in_grid() throws Throwable {
		try
		{
			String[]testCaseNo1=new String[1];
			testCaseNo1[0]=testCaseNo;
			actual[20]=rp.selectMultipleRequirementFromGrids(testCaseNo1);
		    bp.waitForElement();
		    String type=Excel_Lib.getData(INPUT_PATH_5, "Req",1 ,11 );
		    String typeValue=Excel_Lib.getData(INPUT_PATH_5, "Req",0 ,0 );
		    actual[21]=rp.validateDetailsInRequirementGrid(tabNo1, type, typeValue);
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
			e.printStackTrace();
			lb.getScreenShot(fileName);
			driver.quit();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}   
	}	
}
