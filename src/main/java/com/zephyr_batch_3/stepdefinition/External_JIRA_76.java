package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class External_JIRA_76 extends LaunchBrowser{
	
	    LaunchBrowser lb=new LaunchBrowser();
	    String fileName="External_JIRA_76";
		
	    BasePage bp;
		ProjectPage pp;
		ReleasePage rrp;
		ExternalJiraPage ej;
		RequirementsPage rp;
		TestRepositoryPage tr;
		ExecutionPage ep;
		LoginPage lp;
		ExportPage epp;
		CreateCustomFieldsPage ccf;
		
		
		boolean actual[]=new boolean[36];
		SoftAssert soft=new SoftAssert();
		
		String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
		String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
		String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 12, 4);
		String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);	
	
	
	@Given("^User is in Requirement page$")
	public void user_is_in_Requirement_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
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
		Relogin_TPE rl=new Relogin_TPE();
		rl.reLogin();
		throw e;
		}          
	}

	@When("^Import JIRa requirement$")
	public void import_JIRa_requirement() throws Throwable {
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

	@Then("^Imported JIRa Requirement should be present in Imported Tree$")
	public void imported_JIRa_Requirement_should_be_present_in_Imported_Tree() throws Throwable {
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

	@When("^User drag and drops the Requirement folder to local Tree$")
	public void user_drag_and_drops_the_Requirement_folder_to_local_Tree() throws Throwable {
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

	@Then("^Requirement Folder should be present in local tree$")
	public void requirement_Folder_should_be_present_in_local_tree() throws Throwable {
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

	@When("^login as manager, enable req-tc flag and Logout$")
	public void login_as_manager_enable_req_tc_flag_and_Logout() throws Throwable {
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
	

	
	    
	    @When("^login as Lead, navigate to TestRepository and navigate to phase$")
		public void login_as_Lead_navigate_to_TestRepository_and_navigate_to_phase() throws Throwable {
		   
		
		try
		{
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			actual[17]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			actual[18]=pp.selectProject(project);
			actual[19]=pp.selectRelease(release);
			actual[20]=rrp.clickOnTestRep();
			String [] navigation=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 2,8);
			actual[21]=tr.navigateToNode(release, navigation);
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

	    @When("^Select testcase and map to JIRA Requirement$")
		public void select_testcase_and_map_to_JIRA_Requirement() throws Throwable {
		try
		{
			epp=new ExportPage(driver);
			String []testCase1=new String[1];
			testCase1[0]=testCaseNo;
			actual[22]=epp.selectMultipleTestCaseFromGrid(testCase1);
			bp.waitForElement();
			tr.clickOnDetails();
			bp.waitForElement();
			actual[23]=rp.MapRequirements();
			bp.waitForElement();
			actual[24]=rp.ExpandRelease(release);
			String node[]=new String[1];
			node[0]=requirementNode;
			actual[25]=tr.navigateNode(node);
			bp.waitForElement();
			actual[26]=tr.selectRequirementFromGrids(testCase1);
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

	@Then("^testcase should be mapped to Requirement$")
	public void testcase_should_be_mapped_to_Requirement() throws Throwable {
		try
		{
			actual[27]=tr.validateRequirement();
			bp.waitForElement();	
			tr.clickOnList();
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

	@When("^login into external JIRa$")
	public void login_into_external_JIRa() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			rrp.clickOnRequirements();
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=requirementNode;
			tr.navigateToNode(release, phase);
			bp.waitForElement();
			String []testCase1=new String[1];
			testCase1[0]=testCaseNo;
			rp.selectMultipleRequirementFromGrids(testCase1);
			tr.clickOnDetails();
			actual[28]=rp.clickOnGo();
			bp.waitForElement();
			int tabNo=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9);
			bp.switchWindowTab(tabNo);
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

	@Then("^check req-testcase mapping Remote Link$")
	public void check_req_testcase_mapping_Remote_Link() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			actual[30]=ej.validateLinkInExternalJira(testCaseNo);
			bp.waitForElement();
			int tabNo=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9);
			bp.switchWindowTab(tabNo);
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

	@When("^Navigate to TestRepository and Delete the testcase which is mapped to JIRA requirement$")
	public void navigate_to_TestRepository_and_Delete_the_testcase_which_is_mapped_to_JIRA_requirement() throws Throwable {
		try
		{
			epp=new ExportPage(driver);
			int tabNo=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1, 9);
			bp.switchWindowTab(tabNo);
			bp.waitForElement();
			tr.clickOnList();
			rrp.clickOnTestRep();
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 2, 8);
			actual[31]=tr.navigateToNode(release, phase);
			bp.waitForElement();
			String testCase1[]=new String[1];
			testCase1[0]=testCaseNo;
			actual[32]=epp.selectMultipleTestCaseFromGrid(testCase1);
			bp.waitForElement();
			actual[33]=tr.deleteTestCase();
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

	@Then("^Remote link should be Deleted from JIRA$")
	public void remote_link_should_be_Deleted_from_JIRA() throws Throwable {
		try
		{
			 int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9 );
			 int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );
			 bp.switchWindowTab(tabNo1);
			for(int i=0;i<=3;i++)
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
