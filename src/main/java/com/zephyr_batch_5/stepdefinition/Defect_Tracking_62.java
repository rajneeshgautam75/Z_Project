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

public class Defect_Tracking_62 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	ExecutionPage epp;
	ExternalJiraPage ejp;
	ProjectPage pp;
	boolean[] actual=new boolean[17];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_62";
	
	public String idd;
	
	@Given("^user is in testExecution page$")
	public void user_is_in_testExecution_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			lp.enterUnameAndPassword(Uname, pass);
			actual[0]=pp.selectProject(projectName);
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

	@When("^user naviagtes to node$")
	public void user_naviagtes_to_node() throws Throwable {
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

	@When("^user will change the status$")
	public void user_will_change_the_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 10, 0);
			String tcno=Integer.toString(tcNo[0]);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		   // WebElement aa=driver.findElement(By.xpath("//*[@id='grid-table-tce']/div[2]/div[10]/div[3]/div/div"));
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

	@Then("^sucessfully status changed of the testcase$")
	public void sucessfully_status_changed_of_the_testcase() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 10, 0);
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

	@When("^user clicks on D icon and naviagtes to linkwindow page$")
	public void user_clicks_on_D_icon_and_naviagtes_to_linkwindow_page() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 10, 0);
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

	@When("^user will search for the defectId and link it to testcase$")
	public void user_will_search_for_the_defectId_and_link_it_to_testcase() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			actual[7]=epp.defectSearch(selectSearch, defectId);
			bp.waitForElement(); 
			epp.linkDefects.click();
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
	
	@Then("^defect must be sucessfully linked to testcase$")
	public void defect_must_be_sucessfully_linked_to_testcase() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[8]=epp.validateLinkedDefectInLinkedDefectPage(defectId);
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
	

	@When("^user will click on the defectID in grid$")
	public void user_will_clisk_on_the_defectID_in_grid() throws Throwable {
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

	@Then("^jira will open and user will switch to that window$")
	public void jira_will_open_and_user_will_switch_to_that_window() throws Throwable {
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

	@When("^user will enter the username and password$")
	public void user_will_enter_the_username_and_password() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
//			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
//			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
//			actual[8]=ejp.logOutFromExternal_JIRA();
//			bp.waitForElement();
//			actual[9]=ejp.ClickOnLogIn();
//			bp.waitForElement();
//			actual[10]=ejp.loginToExternalJira(username, password);
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

	@Then("^user will validate the link of the testcase$")
	public void user_will_validate_the_link_of_the_testcase() throws Throwable {
		try
		{
			actual[9]=ejp.validateLinkInExternalJira(idd);
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

	@When("^user clicks on logout button$")
	public void user_clicks_on_logout_button() throws Throwable {
		try
		{
			actual[10]=ejp.logOutFromExternal_JIRA();
		    driver.close();
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

	@Then("^user will comes to ZE application page$")
	public void user_will_comes_to_ZE_application_page() throws Throwable {
		try
		{
			int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
			bp.switchWindowTab(switchbacktcNo);
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

	@When("^user selects the DefectId and clicks on Delete button$")
	public void user_selects_the_DefectId_and_clicks_on_Delete_button() throws Throwable {
		try
		{
			int [] deltetcno=new int[1];
			deltetcno[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 8);
			actual[11]=epp.deleteDefect(deltetcno);
			epp.clickOnCancelDefectWindow();
			
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

	@When("^user again Search for the defectId and clicks on that ID$")
	public void user_again_Search_for_the_defectId_and_clicks_on_ID() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 10, 0);
			actual[12]=epp.clickOnDefectButton(tcno);
			bp.waitForElement();
			bp.waitForElement();
			actual[13]=epp.defectSearch(selectSearch, defectId);
			bp.waitForElement();
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

	@Then("^jira page will appear in new tab$")
	public void jira_page_will_appear_in_new_tab() throws Throwable {
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

	@When("^user enters correct valid username and password and click on login button$")
	public void user_enters_correct_valid_username_and_password_and_click_on_login_button() throws Throwable {
		try
		{
			ejp=new ExternalJiraPage(driver);
			String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
			actual[14]=ejp.loginToExternalJira(username, password);
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

	@Then("^Execution remote link should be removed from external JIRA after de-linking the defect$")
	public void execution_remote_link_should_be_removed_from_external_JIRA_after_de_linking_the_defect() throws Throwable {
		try
		{
			int switchbacktcNo=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 5);
			actual[15]=ejp.validateLinkInExternalJira(idd);
			bp.waitForElement();
			actual[16]=ejp.logOutFromExternal_JIRA();
		    driver.close();
			bp.waitForElement();
			bp.switchWindowTab(switchbacktcNo);
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
