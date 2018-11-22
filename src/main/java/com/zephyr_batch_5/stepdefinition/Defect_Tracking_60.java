package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_60 extends LaunchBrowser {
	
	LaunchBrowser lb;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	ExecutionPage epp;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[12];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_60";
	
	public String idd;
	
	@Given("^User will be in a testExecution page$")
	public void user_will_be_in_a_testExecution_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			actual[2]=rp.clickOnTestExecution();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}
	   
	}

	@When("^user will navigate to the node$")
	public void user_will_navigate_to_the_node() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String cyclename1[]=new String[3];
			cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
		    cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			actual[3]=tr.navigateToNode(releaseName,cyclename1);
			bp.waitForElement();  
			bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		} 
	    
	}

	@When("^user will select the testcase and change the status$")
	public void user_will_select_the_testcase_and_change_the_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 8, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    String tcno=Integer.toString(tcNo[0]);
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		//    WebElement aa=driver.findElement(By.xpath("//*[@id='grid-table-tce']/div[2]/div[8]/div[3]/div/div"));
		    idd=epp.retrieveTestCaseId(tcno);
		    System.out.println(idd);
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^the selected status must be sucessfully changed$")
	public void the_selected_status_must_be_sucessfully_changed() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 8, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[5]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@When("^user will clicks on the changed status D button$")
	public void user_will_clicks_on_the_changed_status_D_button() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 8, 0);
			actual[6]=epp.clickOnDefectButton(tcno);
		    bp.waitForElement(); 
		    bp.waitForElement(); 
				
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}    
	   	}

	@When("^user searches for the defectId and link the id to testcase$")
	public void user_searches_for_the_defectId_and_link_the_id_to_testcase() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			actual[7]=epp.defectSearch(selectSearch, defectId);
			bp.waitForElement(); 
			epp.linkDefects.click();
			bp.waitForElement(); 
	        bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	     
	}

	@When("^user will click on the defectID in linksdefect grid$")
	public void user_will_click_on_the_defectID_in_linksdefect_grid() throws Throwable {
		try
		{
			epp.clickOnLinkDefectID.click();
			bp.waitForElement(); 
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}   
	  
	}

	@Then("^jira page will open$")
	public void jira_page_will_open() throws Throwable {
		try
		{	
			driver.close();
	int switchtcJiraNo=Excel_Lib.getNumberData(INPUT_PATH_8, "Jira", 1, 5);
	bp.switchWindowTab(switchtcJiraNo);
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}

	@When("^user will fill the credentials in jira page and click on login button$")
	public void user_will_fill_the_credentials_in_jira_page_and_click_on_login_button() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			actual[8]=ejp.loginToExternalJira(username, password);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	 
	}

	@When("^user will click on the testcase ID$")
	public void user_will_click_on_the_testcase_ID() throws Throwable {
		try
		{
			actual[9]=ejp.validateLinkInExternalJira(idd);
			bp.waitForElement();
			bp.waitForElement();
			actual[10]=ejp.clickOnTestCaseIdInJira(idd);
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}  
	    
	}

	@Then("^Should navigate to ZE test repository search window and search for that testcase$")
	public void should_navigate_to_ZE_test_repository_search_window_and_search_for_that_testcase() throws Throwable {
		try{
			actual[11]=ejp.verifySearchedId(idd);
			bp.waitForElement();
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
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		} 
	    
	}



}
