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

public class External_JIRA_79 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="External_JIRA_79";
		
	BasePage bp;
	ProjectPage pp;
	ReleasePage rrp;
	ExternalJiraPage ej;
	RequirementsPage rp;
	TestRepositoryPage tr;
	LoginPage lp;
	ExecutionPage ep;
	ExportPage epp;
	CreateCustomFieldsPage cfc;
	
	boolean actual[]=new boolean[41];	
	SoftAssert soft=new SoftAssert();
		
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_3");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	private String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
	private String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 15, 4);
	private String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
	private int tabNo1=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9 );
	private int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );
	
	
	@Given("^user is in requirementpage$")
	public void user_is_in_requirementpage() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rrp=new ReleasePage(driver);
			bp=new BasePage();
			tr=new TestRepositoryPage(driver);
			pp.clickOnLogout();
			ep=new ExecutionPage(driver);
			lp=new LoginPage(driver);
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Password_1");
			lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			bp.waitForElement();
			pp.launchAdministration();
			pp.launchManageprojects();
			cfc=new CreateCustomFieldsPage(driver);
			String description=Excel_Lib.getData(INPUT_PATH_5, "Projects", 0, 1);
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"User2");
			String mapDefectProject=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);
			String [] startDate = new String[3];
			startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects", 1, 2));
			startDate[1]=Excel_Lib.getData(INPUT_PATH_5,"Projects",1,3);
			startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects",1,4));
			String [] endDate = new String[3];
			endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects",1, 5));
			endDate[1]=Excel_Lib.getData(INPUT_PATH_5, "Projects",1, 6);
			endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Projects",1, 7));		
			String shareCheckbox=Excel_Lib.getData(INPUT_PATH_5, "Projects", 100, 100);	
			
			String type="Normal";
			pp.createProject(project, description, type,lead, mapDefectProject, startDate, endDate, shareCheckbox);
			bp.waitForElement();
			pp.clickOnLogout();
			bp.waitForElement();
			String leadName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String leadPassWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Password_1");
			lp.enterUnameAndPassword(leadName, leadPassWord);
			bp.waitForElement();
			
			
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			rrp.clickOnTestRep();
			bp.waitForElement();
			String pName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Req", 3, 8);
		  	String pDesc2=Excel_Lib.getData(INPUT_PATH_5, "Req", 3, 8);
		  	tr.clickOnRelease(release);
			tr.addNode(pName2, pDesc2);
			bp.waitForElement();
			String node[]=new String[1];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Req", 3, 8);
			tr.navigateToNode(release, node);
			tr.addTestCase();
			tr.addTestCase();
			bp.waitForElement();
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

	@When("^import jira requirement$")
	public void import_jira_requirement() throws Throwable {
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

	@Then("^imported jira Requirement should be present in Imported Tree$")
	public void imported_jira_Requirement_should_be_present_in_Imported_Tree() throws Throwable {
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

	@When("^User drag and drops the requirement Folder to local Tree$")
	public void user_drag_and_drops_the_requirement_Folder_to_local_Tree() throws Throwable {
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

	@Then("^requirement Folder should be present in Local tree$")
	public void requirement_Folder_should_be_present_in_Local_tree() throws Throwable {
		try
		{
			 String[] node=new String[1];
			 node[0]=requirementNode;
			 actual[11]=tr.navigateToNode(release,node);
			 bp.waitForElement();
			 pp.selectProject(project);
			 bp.waitForElement();
			 actual[12]=pp.clickOnLogout(); 
				
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

	@When("^login as Manager, Enable req-tc flag and logout$")
	public void login_as_Manager_Enable_req_tc_flag_and_logout() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			lp=new LoginPage(driver);
			cfc=new CreateCustomFieldsPage(driver);
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			actual[13]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			actual[14]=cfc.navigatingToGeneralConfigurationTab();
		    String linkType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 12);
		    actual[15]=cfc.enableCustomFields(linkType);
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

	@When("^Login as lead, navigate to requirementPage and navigate to requirement folder$")
	public void login_as_lead_navigate_to_requirementPage_and_navigate_to_requirement_folder() throws Throwable {
		try
		{
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			actual[17]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			bp.waitForElement();
		    actual[18]=pp.selectProject(project);
			actual[19]=pp.selectRelease(release);
			bp.waitForElement();
			actual[20]=rrp.clickOnTestRep();
			bp.waitForElement();
			String [] navigation=new String[1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 3,8);
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

	@When("^select Requirement, click on map testcase and map single/multiple Testcases$")
	public void select_Requirement_click_on_map_testcase_and_map_single_multiple_Testcases() throws Throwable {
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

	@Then("^Testcase should be Mapped to requirement$")
	public void testcase_should_be_Mapped_to_requirement() throws Throwable {
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

	@When("^login into external jira$")
	public void login_into_external_jira() throws Throwable {
		try
		{
			lp=new LoginPage(driver);
			ep=new ExecutionPage(driver);
			ej=new ExternalJiraPage(driver);
			actual[28]=rrp.clickOnRequirements();
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=requirementNode;
			actual[29]=tr.navigateToNode(release, phase);
			bp.waitForElement();
			String []testCase1=new String[1];
			testCase1[0]=testCaseNo;
			actual[30]=rp.selectMultipleRequirementFromGrids(testCase1);
			bp.waitForElement();
			tr.clickOnDetails();
			actual[31]=rp.clickOnGo();
			bp.waitForElement();
			int tabNo=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9);
			bp.switchWindowTab(tabNo);
			bp.waitForElement();
			bp.waitForElement();
//			String username=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,0 );
//			String password=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,1 );
			
			String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Username");
		     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Password");
		     
			actual[32]=ej.loginToExternalJira(jiraUname, jiraPwd);
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

	@Then("^check req-testcase Mapping remote Link$")
	public void check_req_testcase_Mapping_remote_Link() throws Throwable {
		try
		{
			ej=new ExternalJiraPage(driver);
			actual[33]=ej.validateLinkInExternalJira(testCaseNo);
			bp.waitForElement();
			bp.switchWindowTab(tabNo0);
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

	@When("^Delete the Project$")
	public void delete_the_Project() throws Throwable {
		try
		{
			
			bp.waitForElement();
			actual[34]=pp.clickOnLogout();
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			actual[35]=lp.enterUnameAndPassword(name, passWord);
			pp.launchAdministration();
			pp.launchManageprojects();
			bp.waitForElement();
			actual[36]=pp.DeleteProject(project);
			bp.waitForElement();
			bp.waitForElement();
			actual[37]=pp.clickOnLogout();
			String name1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String passWord1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			actual[38]=lp.enterUnameAndPassword(name1, passWord1);
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

	@Then("^Remote Link should be Deleted from JIRA$")
	public void remote_Link_should_be_Deleted_from_JIRA() throws Throwable {
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
			 actual[39]=ej.validateLinkInExternalJira(testCaseNo);
			 bp.waitForElement();
			 actual[40]=ej.logOutFromExternal_JIRA();
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
