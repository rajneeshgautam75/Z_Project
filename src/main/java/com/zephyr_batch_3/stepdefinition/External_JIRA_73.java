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

public class External_JIRA_73 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="External_JIRA_73";
		
	BasePage bp;
	ProjectPage pp;
	ReleasePage rrp;
	ExternalJiraPage ej;
	RequirementsPage rp;
	TestRepositoryPage tr;
	LoginPage lp;
	ExecutionPage ep;
	CreateCustomFieldsPage ccf;
		
	boolean actual[]=new boolean[36];	
	SoftAssert soft=new SoftAssert();
		
	String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
	String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 9, 4);
	String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
	int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9 );
	int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );

	@Given("^User is in Requirementpage$")
	public void user_is_in_Requirementpage() throws Throwable {
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
	@When("^User Import's JIRA Requirements$")
	public void user_Import_s_JIRA_Requirements() throws Throwable {
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
			testCaseNo1[0]=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
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

	@Then("^Imported JIRA Requiremnt should be present in Imported Tree$")
	public void imported_JIRA_Requiremnt_should_be_present_in_Imported_Tree() throws Throwable {
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

	@When("^User Drag and drop the Requirement folder to local Tree$")
	public void user_Drag_and_drop_the_Requirement_folder_to_local_Tree() throws Throwable {
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

	@Then("^requirement folder Should be present in local tree$")
	public void requirement_folder_Should_be_present_in_local_tree() throws Throwable {
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

	@When("^Login as Manager, enable req-tc flag and Logout from application$")
	public void login_as_Manager_enable_req_tc_flag_and_Logout_from_application() throws Throwable {
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
		    String linkType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 12);
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

	@When("^Login as Lead, navigate to requirementPage and navigate to Requirement folder$")
	public void login_as_Lead_navigate_to_requirementPage_and_navigate_to_Requirement_folder() throws Throwable {
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

	@When("^Select requirement, click on Map testcase and map single/multiple testcase$")
	public void select_requirement_click_on_Map_testcase_and_map_single_multiple_testcase() throws Throwable {
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

	@Then("^Testcases should be mapped to requirement$")
	public void testcases_should_be_mapped_to_requirement() throws Throwable {
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

	@When("^Login into external JIRa$")
	public void login_into_external_JIRa() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			actual[28]=rp.clickOnGo();
			bp.waitForElement();
			bp.switchWindowTab(tabNo1);
			bp.waitForElement();
			bp.waitForElement();
//			String username=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,0 );
//			String password=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,1 );
			
			String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Username");
		     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Password");
		     
			actual[29]=ej.loginToExternalJira(jiraUname, jiraPwd);
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

	@Then("^check req-testcase mapping remote link$")
	public void check_req_testcase_mapping_remote_link() throws Throwable {
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

	@When("^De-allocate that requirement in ZE$")
	public void de_allocate_that_requirement_in_ZE() throws Throwable {
		try
		{
			tr.clickOnList();
			String phase[]=new String[1];
			phase[0]=requirementNode;
			actual[31]=tr.navigateToNode(release, phase);
			bp.waitForElement();
			String testcaseNo1[]=new String[1];
			testcaseNo1[0]=testCaseNo;
			actual[32]=rp.selectMultipleRequirementFromGrids(testcaseNo1);
			String deallocate=Excel_Lib.getData(INPUT_PATH_5, "Req", 2, 10);
			actual[33]=rp.deleteOrDeallocateRequirements(deallocate);
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

	@Then("^Remote link should be deleted from External_JIRA$")
	public void remote_link_should_be_deleted_from_External_JIRA() throws Throwable {
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
			 actual[34]=ej.validateLinkInExternalJira(testCaseNo);
			 bp.waitForElement();
			 actual[35]=ej.logOutFromExternal_JIRA();
			 bp.waitForElement();
			 driver.close();
			 bp.waitForElement();
			 bp.switchWindowTab(tabNo0);
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
