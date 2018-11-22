package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_65 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	ExecutionPage epp;
	DefectTracking dt;
	ProjectPage pp;
	boolean[] actual=new boolean[11];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_65";

	
	@Given("^User arrives to TestExecution page$")
	public void user_arrives_to_TestExecution_page() throws Throwable {
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

	@When("^user selects the related node and phase$")
	public void user_user_selects_the_related_node_and_phase() throws Throwable {
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

	@When("^user will select the testcase and change the status of that testcase by fail$")
	public void user_will_select_the_testcase_and_change_the_status_of_that_testcase_by_fail() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[4]=epp.changeStatusOfTestCases(tcNo, statusType);
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

	@Then("^the selected testcase has changed to fail status sucessfully$")
	public void the_selected_testcase_has_changed_to_fail_status_sucessfully() throws Throwable {
		try
		{
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
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

	@When("^user will click on the D icon button of the tescase which status has been changed$")
	public void user_will_click_on_the_D_icon_button_of_the_tescase_which_status_has_been_changed() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
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

	@When("^user will search for different defectid and links it to testcase$")
	public void user_will_search_for_different_defectid_and_links_it_to_testcase() throws Throwable {
		try
		{
			String[] defectId=new String[3];
			defectId[0]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 9);
			defectId[1]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 2, 9);
			defectId[2]=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 9);
			String selectSearch=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 6);
			for(int i=0;i<=defectId.length-1;i++)
			{
		    actual[7]=epp.defectSearch(selectSearch, defectId[i]);
			epp.linkDefects.click();
			}
			bp.waitForElement(); 
			epp.cancelDefect.click();
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

	@Then("^the multiple defect must link to testcase Sucessfully$")
	public void the_multiple_defect_must_link_to_testcase_Sucessfully() throws Throwable {
		try
		{
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 13, 0);
			actual[8]=epp.viewTooltip(tcno);
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

	@When("^user will now selects the project and goes to release page$")
	public void user_will_now_selects_the_project_and_goes_to_release_page() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[9]=pp.selectProject(projectName);
			bp.waitForElement();
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[10]=pp.selectRelease(releaseName);
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

	@Then("^should view the total linkeddefect count by status$")
	public void should_view_the_total_linkeddefect_count_by_status() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			String count=dt.dTcount1.getText();
			System.out.println(count);
			
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
