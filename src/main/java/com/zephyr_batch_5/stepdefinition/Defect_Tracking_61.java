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

public class Defect_Tracking_61 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	ExecutionPage epp;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[13];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_61";
	
	public String idd;
	
	@Given("^User shall be in testExecution page$")
	public void user_shall_be_in_testExecution_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			lp.enterUnameAndPassword(Uname, pass);
			bp.waitForElement();
			bp.waitForElement();
			actual[0]=pp.selectProject(projectName);
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			actual[2]=rp.clickOnTestExecution();
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

	@When("^user will navigates to related phase$")
	public void user_will_navigates_to_related_phase() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Release_1");
			String cyclename1[]=new String[3];
			cyclename1[0]=Excel_Lib.getData(INPUT_PATH_8,"TestExec",1,1);
		    cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 0);
			actual[3]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.navigateToNode(releaseName,cyclename1);
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

	@When("^user will change the status by selecting the testcase$")
	public void user_will_change_the_status_by_selecting_the_testcase() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 9, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    String tcno=Integer.toString(tcNo[0]);
		    actual[5]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		//    WebElement aa=driver.findElement(By.xpath("//*[@id='grid-table-tce']/div[2]/div[9]/div[3]/div/div"));
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

	@Then("^selected testcase status is changed$")
	public void selected_testcase_is_changed() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 9, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[6]=epp.ValidateStatusOfTestCases(tcNo, statusType);
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

	@When("^user clicks on the D button which the status has been changed$")
	public void user_clicks_on_the_D_button_which_the_status_has_been_changed() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 9, 0);
			actual[7]=epp.clickOnDefectButton(tcno);
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

	@When("^user will search the defectID and links it to the testcase$")
	public void user_will_search_the_defectID_and_links_it_to_the_testcase() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			actual[8]=epp.defectSearch(selectSearch, defectId);
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
	
	@Then("^defect must be sucessfully linked$")
	public void defect_must_be_sucessfully_linked() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[9]=epp.validateLinkedDefectInLinkedDefectPage(defectId);
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

	@When("^user will clicks on the ID in linksdefect grid$")
	public void user_will_clicks_on_the_ID_in_linksdefect_grid() throws Throwable {
		try
		{
			epp.clickOnLinkDefectID.click();
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

	@Then("^a jira page will appear$")
	public void a_jira_page_will_appear() throws Throwable {
		try
		{
			driver.close();
			int switchtcJiraNo=Excel_Lib.getNumberData(INPUT_PATH_8, "Jira", 1, 5);
			bp.switchWindowTab(switchtcJiraNo);
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

	@When("^user will enter correct username and password and click on login$")
	public void user_will_enter_correct_username_and_password_and_click_on_login() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
//			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Username");
//			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Jira_Password");
//			actual[8]=ejp.logOutFromExternal_JIRA();
//			bp.waitForElement();
//			actual[9]=ejp.ClickOnLogIn();
//			bp.waitForElement();
//			actual[10]=ejp.loginToExternalJira(username, password);
//			bp.waitForElement();
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

	@When("^user will click on the testcase Execution Status icon button$")
	public void user_will_click_on_thr_testcase_Execution_Status_icon_button() throws Throwable {
		try
		{
			
			actual[10]=ejp.validateLinkInExternalJira(idd);
			bp.waitForElement();
			bp.waitForElement();
			actual[11]=ejp.clickOnTestcaseExecutionJira(idd);
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

	@Then("^Should navigate to ZE test execution search window and search for that testcase$")
	public void should_navigate_to_ZE_test_execution_search_window_and_search_for_that_testcase() throws Throwable {
		try{
			actual[12]=ejp.verifySearchedExecutionJira(idd);
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
