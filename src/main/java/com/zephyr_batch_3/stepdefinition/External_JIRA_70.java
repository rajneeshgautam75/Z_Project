package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
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

public class External_JIRA_70 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="External_JIRA_70";
		
	BasePage bp;
	ProjectPage pp;
	ReleasePage rrp;
	ExternalJiraPage ej;
	RequirementsPage rp;
	TestRepositoryPage tr;
	LoginPage lp;
	ExecutionPage ep;
	CreateCustomFieldsPage ccf;
		
	boolean actual[]=new boolean[37];	
	SoftAssert soft=new SoftAssert();
		
	String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
	String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 6, 4);
	String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
	int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9 );
	int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );
	
	@Given("^User is in RequirementPage$")
	public void user_is_in_RequirementPage() throws Throwable {
	try
	{
		pp=new ProjectPage(driver);
		rrp=new ReleasePage(driver);
		bp=new BasePage();
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
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
	}
	}

	@When("^user Import JIRA requirement$")
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
		testCaseNo1[0]=testCaseNo;
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
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}    
	}

	@Then("^Imported JIRA requirement should be present in Imported tree$")
	public void imported_JIRA_requirement_should_be_present_in_Imported_tree() throws Throwable {
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
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}   
	}

	@When("^user Drag and Drops the requirement folder to local tree$")
	public void user_Drag_and_Drops_the_requirement_folder_to_local_tree() throws Throwable {
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
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;	
		    } 	    
	}

	@Then("^requirement folder should be present in local tree$")
	public void requirement_folder_should_be_present_in_local_tree() throws Throwable {
		try
		{
		    String[] node=new String[1];
			node[0]=requirementNode;
			actual[11]=tr.navigateToNode(release,node);
			pp.selectProject(project);
			actual[12]=pp.clickOnLogout(); 
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

	@When("^Login as manager and enable the req-tc flag in defect admin app and Logout$")
	public void login_as_manager_and_enable_the_req_tc_flag_in_defect_admin_app_and_Logout() throws Throwable {
		try
		{
			lp=new LoginPage(driver);
			ep=new ExecutionPage(driver);
			ccf=new CreateCustomFieldsPage(driver);
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			actual[13]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			actual[14]=ccf.navigatingToGeneralConfigurationTab();
		    String linkType=Excel_Lib.getData(INPUT_PATH_5, "Execution",1, 12);
		    actual[15]=ccf.enableCustomFields(linkType);
		    bp.waitForElement();
		    actual[16]=pp.clickOnLogout();
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

	@When("^Login as Lead, navigate to Requirement Page and navigate to requirement folder$")
	public void login_as_Lead_navigate_to_Requirement_Page_and_navigate_to_requirement_folder() throws Throwable {
		try
		{
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			actual[17]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			actual[18]=pp.selectProject(project);
			actual[19]=pp.selectRelease(release);
			actual[20]=rrp.clickOnRequirements();
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=requirementNode;
			actual[21]=tr.navigateToNode(release, phase);
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

	@When("^Select requirement, Click on Map button and Map a single/multiple testcase$")
	public void select_requirement_Click_on_Map_button_and_Map_a_single_multiple_testcase() throws Throwable {
		try
		{
			String []testCase1=new String[1];
			testCase1[0]=testCaseNo;
			actual[22]=rp.selectMultipleRequirementFromGrids(testCase1);
			tr.clickOnDetails();
			actual[23]=rp.MapTestCases();
			bp.waitForElement();
			actual[24]=rp.ExpandRelease(release);
			bp.waitForElement();
			String node[]=new String[1];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 1,8);
			actual[25]=tr.navigateNode(node);
			bp.waitForElement();
			actual[26]=rp.mapTestCasesToRequirementsFromGrids(testCase1);
			bp.explicitWait(rp.clickOnSavejirareq);
			rp.clickOnSavejirareq.click();
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

	@Then("^Testcase should be mapped to Requirement$")
	public void testcase_should_be_mapped_to_Requirement() throws Throwable {
		try
		{
			actual[27]=rp.validateMapedTestcase();
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

	@When("^Login into external JIRA$")
	public void login_into_external_JIRA() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			ej=new ExternalJiraPage(driver);
			actual[28]=rp.clickOnGo();
			bp.waitForElement();
			bp.switchWindowTab(tabNo1);
			bp.waitForElement();
//			String username=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,0 );
//			String password=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,1 );
			
			 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Username");
		     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Password");
		     
			actual[29]=ej.loginToExternalJira(jiraUname, jiraPwd);
			bp.waitForElement();
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

	@Then("^In JIRA check the req-testcase mapping remote link$")
	public void in_JIRA_check_the_req_testcase_mapping_remote_link() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			actual[30]=ej.validateLinkInExternalJira(testCaseNo);
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

	@When("^Navigate to Zephyr application and unmap testcase from Requirement$")
	public void navigate_to_Zephyr_application_and_unmap_testcase_from_Requirement() throws Throwable {
		try
		{
		  String []testCase1=new String[1];
		  testCase1[0]=testCaseNo;
		 // rp.clickOnMappedTestCases.click();
		  bp.waitForElement();
		  actual[31]=rp.MapTestCases();
		  bp.waitForElement();
		  actual[32]=rp.ExpandRelease(release);
		  bp.waitForElement();
		  String node[]=new String[1];
		  node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 1,8);
		  actual[33]=tr.navigateNode(node);
		  bp.waitForElement();
		  actual[34]=rp.mapTestCasesToRequirementsFromGrids(testCase1);
		  bp.explicitWait(rp.clickOnSavejirareq);
		  rp.clickOnSavejirareq.click();
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
	@Then("^In JIRa check the req-testcase mapping remote link$")
	public void in_JIRa_check_the_req_testcase_mapping_remote_link() throws Throwable {
 try
	{
	 bp.switchWindowTab(tabNo1);
	for(int i=0;i<=4;i++)
	{
	 bp.waitForElement();
     driver.navigate().refresh();
     bp.waitForElement();
	}
     bp.waitForElement();
	 actual[35]=ej.validateLinkInExternalJira(testCaseNo);
	 bp.waitForElement();
	 actual[36]=ej.logOutFromExternal_JIRA();
	 bp.waitForElement();
	 driver.close();
	 bp.waitForElement();
	 bp.switchWindowTab(tabNo0);
	 bp.waitForElement();
	 tr.clickOnList();
	 
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
