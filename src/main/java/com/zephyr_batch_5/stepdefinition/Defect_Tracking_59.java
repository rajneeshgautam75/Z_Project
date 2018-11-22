package com.zephyr_batch_5.stepdefinition;

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
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_59 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage epp;
	TestRepositoryPage tr;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_59";
    

	 public String id;
	
	@Given("^User shall be in Main_Page$")
	public void user_shall_be_in_Main_Page() throws Throwable {
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

	@When("^user clicks testExceution button and goes to testExecution page$")
	public void user_clicks_testExceution_button_and_goes_to_testExecution_page() throws Throwable {
		try
		{
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

	@When("^user will search for the related node$")
	public void user_will_search_for_the_related_node() throws Throwable {
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

	@When("^user will select the TestCase and change the status$")
	public void user_will_select_the_TestCase_and_change_the_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 7, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    String tcno=Integer.toString(tcNo[0]);
		   
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
//		     WebElement aa=driver.findElement(By.xpath("//*[@id='grid-table-tce']/div[2]/div[7]/div[3]/div/div"));
		     id=epp.retrieveTestCaseId(tcno);
		    bp.waitForElement();
		    System.out.println(id);
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

	@Then("^status of the testcase has been sucessfully Changed$")
	public void status_of_the_testcase_has_been_sucessfully_Changed() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 7, 0);
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

	@When("^user clicks on the Deffect D button of the related testcase$")
	public void user_clicks_on_the_Deffect_D_button_of_the_related_testcase() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 7, 0);
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

	@When("^user search for the Defect ID and links that id to test execution$")
	public void user_search_for_the_Defect_ID_and_links_that_id_to_test_execution() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			actual[7]=epp.defectSearch(selectSearch, defectId);
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

	@Then("^Defect Id must linked sucessfully$")
	public void defect_Id_must_linked_sucessfully() throws Throwable {
		try
		{
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

	@When("^user will click on links defect id$")
	public void user_will_click_on_links_defect_id() throws Throwable {
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

	@Then("^A new JIRA page will open$")
	public void a_new_JIRA_page_will_open() throws Throwable {
		try
		{
		int switchtcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 2, 5);
		bp.switchWindowTab(switchtcNo);
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

	@When("^user will fill the credentials and login$")
	public void user_will_fill_the_credentials_and_login() throws Throwable {
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

	@Then("^should view remote link in jira$")
	public void should_view_remote_link_in_jira() throws Throwable {
		try
		{
			int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
			actual[9]=ejp.validateLinkInExternalJira(id);
			bp.waitForElement();
			actual[10]=ejp.logOutFromExternal_JIRA();
			driver.close();
			
			bp.switchWindowTab(switchbacktcNo);
			bp.waitForElement();
			epp.cancelDefect.click();
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
