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

public class External_JIRA_69 extends LaunchBrowser {
	
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="External_JIRA_69";
	BasePage bp;
	ProjectPage pp;
	ReleasePage rrp;
	ExternalJiraPage ej;
	RequirementsPage rp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	LoginPage lp;
	CreateCustomFieldsPage ccf;
	
	boolean actual[]=new boolean[33];
	SoftAssert soft=new SoftAssert();
	
	String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Normal_Project_1");
	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	String importedTree=Excel_Lib.getData(INPUT_PATH_5, "Req", 1, 6);
	String requirementNode=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 5, 4);
	String testCaseNo=Excel_Lib.getData(INPUT_PATH_5,"Req", 1, 5);
	
	@Given("^User is in Requirement Page$")
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
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;	
		    }
	   
	}

	@When("^User clicks on Import option, chooses JIRA, search JIRA requirements and clicks ImportSelected$")
	public void user_clicks_on_Import_option_chooses_JIRA_search_JIRA_requirements_and_clicks_ImportSelected() throws Throwable {
	  
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

	@Then("^Imported JIRA Requirements should be present in Imported tree$")
	public void imported_JIRA_Requirements_should_be_present_in_Imported_tree() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);	
			String phase[]=new String[1];
			phase[0]=requirementNode;
			System.out.println(requirementNode);
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

	@When("^Drag and Drop the Imported JIRA node to local tree$")
	public void drag_and_Drop_the_Imported_JIRA_node_to_local_tree() throws Throwable {
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

	@Then("^Imported JIRA Requirements should be present in local tree$")
	public void imported_JIRA_Requirements_should_be_present_in_local_tree() throws Throwable {
		try
		{
			String[] node=new String[1];
			node[0]=requirementNode;
			actual[11]=tr.navigateToNode(release,node);
			actual[12]=pp.selectProject(project);
			actual[13]=pp.clickOnLogout(); 
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

	@When("^Login as Manager and enable req-tc flag and logout$")
	public void login_as_Manager_and_enable_req_tc_flag_and_logout() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			ej=new ExternalJiraPage(driver);
			ccf=new CreateCustomFieldsPage(driver);
			lp=new LoginPage(driver);
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Manager_Username_1");
			actual[14]=lp.enterUnameAndPassword(name, passWord);
			actual[15]=ccf.navigatingToGeneralConfigurationTab();
		    String linkType=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 12);
		    actual[16]=ccf.enableCustomFields(linkType);
		    bp.waitForElement();
		    actual[17]=pp.clickOnLogout();
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

	@When("^Login as lead, navigate to RequirementPage and navigate to Requirement node$")
	public void login_as_lead_navigate_to_RequirementPage_and_navigate_to_Requirement_node() throws Throwable {
		try
		{
			
			String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Lead_Username_1");
			actual[18]=lp.enterUnameAndPassword(name, passWord);
			bp.waitForElement();
			actual[19]=pp.selectProject(project);
			actual[20]=pp.selectRelease(release);
			actual[21]=rrp.clickOnRequirements();
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=requirementNode;
			actual[22]=tr.navigateToNode(release, phase);
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

	@When("^Select requirement, click on Map button and Map a single/multiple testcase$")
	public void select_requirement_click_on_Map_button_and_Map_a_single_multiple_testcase() throws Throwable {
		try
		{
			String []testCase1=new String[1];
			testCase1[0]=testCaseNo;
			actual[23]=rp.selectMultipleRequirementFromGrids(testCase1);
			
			tr.clickOnDetails();
			actual[24]=rp.MapTestCases();
			bp.waitForElement();
			bp.waitForElement();
			actual[25]=rp.ExpandRelease(release);
			bp.waitForElement();
			String node[]=new String[1];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Req", 1,8);
			actual[26]=tr.navigateNode(node);
			bp.waitForElement();
			actual[27]=rp.mapTestCasesToRequirementsFromGrids(testCase1); 
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

	@Then("^Testcase should be mapped to selected requirement$")
	public void testcase_should_be_mapped_to_selected_requirement() throws Throwable {
		try
		{
			actual[28]=rp.validateMapedTestcase();
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

	@When("^Login into External JIRA$")
	public void login_into_External_JIRA() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		ej=new ExternalJiraPage(driver);
		actual[29]=rp.clickOnGo();
		bp.waitForElement();
		int tabNo=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 2,9);
		System.out.println(tabNo);
		bp.switchWindowTab(tabNo);
		bp.waitForElement();
//		String username=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,0 );
//		String password=Excel_Lib.getData(INPUT_PATH_5, "LogIn",1 ,1 );
		
		String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ,"Jira_Password");
	     
		actual[30]=ej.loginToExternalJira(jiraUname, jiraPwd);
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

	@Then("^check the req-testcase mapping remote link$")
	public void check_the_req_testcase_mapping_remote_link() throws Throwable {
		try
		{
			lp=new LoginPage(driver);
			ej=new ExternalJiraPage(driver);
			 int tabNo0=Excel_Lib.getNumberData(INPUT_PATH_5, "Req", 1,9 );
			for(int i=0;i<=4;i++)
			{
			 bp.waitForElement();
		     driver.navigate().refresh();
		     bp.waitForElement();
			}
		     bp.waitForElement();
			 actual[31]=ej.validateLinkInExternalJira(testCaseNo);
			 bp.waitForElement();
			 actual[32]=ej.logOutFromExternal_JIRA();
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
